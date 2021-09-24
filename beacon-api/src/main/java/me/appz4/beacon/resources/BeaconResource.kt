package me.appz4.beacon.resources

import me.appz4.beacon.ApplicationContextProvider
import me.appz4.beacon.firebase.FirebaseService
import me.appz4.beacon.model.api.ApiResponse
import me.appz4.beacon.model.api.request.beacon.*
import me.appz4.beacon.model.api.response.beacon.*
import me.appz4.beacon.model.exception.Errors
import me.appz4.beacon.model.exception.ServiceException
import me.appz4.beacon.model.model.*
import me.appz4.beacon.resources.annotations.JsonRequest
import me.appz4.beacon.resources.model.GetBeaconsResponseSimple
import me.appz4.beacon.resources.model.SimpleBeacon
import me.appz4.beacon.service.BeaconService
import me.appz4.beacon.service.ImageService
import me.appz4.beacon.service.MessageService
import org.apache.commons.lang3.RandomStringUtils
import org.glassfish.jersey.media.multipart.FormDataMultiPart
import org.hibernate.criterion.Restrictions
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController
import java.io.InputStream
import java.util.*
import javax.ws.rs.Consumes
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@RestController
@Path("/beacons")
open class BeaconResource @Autowired constructor(
        private val beaconService: BeaconService,
        private val imageService: ImageService,
        private val messageService: MessageService,
        private val firebaseService: FirebaseService
) : BaseResource() {

    @JsonRequest
    @Path("/get")
    @POST
    @Throws(Exception::class)
    fun getBeacon(request: GetBeaconRequest): GetBeaconResponse {
        val response = GetBeaconResponse()
        val user = getUser(request)
        isValid(request)
        val beacon = beaconService.getBeaconBy(user.user.id, request.beaconId)
        response.beacon = beacon
        return response
    }

    @JsonRequest
    @Path("/list")
    @POST
    @Throws(Exception::class)
    fun getBeacons(request: GetBeaconsRequest): GetBeaconsResponse {
        val response = GetBeaconsResponse()
        val user = getUser(request)
        val beacons = beaconService.findAll(Restrictions.eq(Beacon.USERID, user.user.id))
        beacons.stream().peek { b: Beacon -> println(b) }
        for (i in beacons) {
            val manufacturerId = i.manufacturerId
            i.beaconType = beaconService.getManufacturer(manufacturerId)
            val lastLocation = beaconService.getLastLocation(i.id)
            if (lastLocation != null) {
                val pos = Position(lastLocation.latitude, lastLocation.longitude)
                pos.created = lastLocation.created!!.time
                i.location = pos
            }
        }
        response.beacons = beacons
        return response
    }

    @JsonRequest
    @Path("/list/near")
    @POST
    @Throws(Exception::class)
    fun getNearBeacons(request: GetNearBeaconsRequest): GetBeaconsResponse {
        val response = GetBeaconsResponse()
        isValid(request)
        val userWithToken = getUser(request)
        val beaconIds: List<Long> = beaconService.findAll(Restrictions.eq(Beacon.USERID, userWithToken.user.id)).map { it.id }
        val closeBeaconLocations: List<BeaconLocation> = beaconService.getNearBeaconLocationsForBeaconIds(request.northEast, request.southWest, beaconIds) ?: arrayListOf()
        val result = ArrayList<Beacon>()
        for (beaconLocation in closeBeaconLocations) {
            val beaconUserId = beaconService.getBeaconBy(beaconLocation.beaconId).userId
            val item = beaconService.getLostBeaconByLocationForUserId(beaconLocation, beaconUserId)
            if (item != null) {
                val position = Position()
                position.latitude = beaconLocation.latitude
                position.longitude = beaconLocation.longitude
                position.created = beaconLocation.created!!.time
                item.location = position
                val user = userService.getUser(item.userId)
                item.user = user
                result.add(item)
            }
        }
        result.stream().peek { b: Beacon -> println(b) }
        response.beacons = result
        return response
    }

    @JsonRequest
    @Path("/list/lost")
    @POST
    @Throws(Exception::class)
    fun getLostBeacons(request: GetBeaconsRequest): GetBeaconsResponseSimple {
        val response = GetBeaconsResponseSimple()
        val user = getUser(request)
        val beacons = beaconService.findAll(*arrayOf())
        val simpleBeacons = ArrayList<SimpleBeacon>()
        for (i in beacons) {
            val j = SimpleBeacon()
            j.factoryId = i.factoryId
            j.id = i.id
            simpleBeacons.add(j)
        }
        response.beacons = simpleBeacons
        return response
    }

    @JsonRequest
    @Path("/status/get")
    @POST
    @Throws(Exception::class)
    fun getBeaconStatus(request: GetBeaconStatusRequest): GetBeaconStatusResponse {
        val response = GetBeaconStatusResponse()
        getUser(request)
        isValid(request)
        val beacon = beaconService.findByFactoryId(request.factoryId)
        response.status = beacon.status
        response.userId = beacon.userId
        return response
    }

    @JsonRequest
    @Path("/status/update")
    @POST
    @Throws(Exception::class)
    fun changeStatus(request: ChangeBeaconStatusRequest): ChangeBeaconStatusResponse {
        val response = ChangeBeaconStatusResponse()
        val user = getUser(request)
        isValid(request)
        beaconService.changeBeaconStatus(user.user.id, request.beaconId, request.status)
        return response
    }

    @JsonRequest
    @Path("/found")
    @POST
    @Throws(Exception::class)
    fun foundLostBeacon(request: FoundLostBeaconRequest): FoundLostBeaconResponse {
        val response = FoundLostBeaconResponse()
        val user = getUser(request)
        isValid(request)
        val beacon = beaconService.findByFactoryId(request.factoryId)
        if (beacon.status != BeaconStatus.LOST) {
            throw ServiceException(Errors.ERROR_BEACON_NOT_FOUND, request.factoryId)
        }
        beaconService.createLocation(beacon.id, request.position, user.user.id)
        val owner = beacon.userId
        //Sajat beacon
        if (owner == user.user.id) {
            val activeToken = userService.getActiveMessagingToken(user.user.id)
            if (activeToken != null) {
                val data = firebaseService.foundOwnBeacon(ApplicationContextProvider.getApplicationContext(), Locale.ENGLISH, beacon)
                firebaseService.sendNotification(user.user.id, user.user.id, beacon.id, activeToken.token, data)
            }
        } else {
            val ownerToken = userService.getActiveMessagingToken(owner)
            val senderToken = userService.getActiveMessagingToken(user.user.id)
            val thread = messageService.getOrCreateThreadFor(beacon.id, user.user.id, beacon.userId)
            if (ownerToken != null) {
                val data = firebaseService.spottedBeacon(ApplicationContextProvider.getApplicationContext(), Locale.ENGLISH, beacon, thread)
                firebaseService.sendNotification(user.user.id, owner, beacon.id, ownerToken.token, data)
            }
            if (senderToken != null) {
                val data = firebaseService.foundLostBeacon(ApplicationContextProvider.getApplicationContext(), Locale.ENGLISH, beacon, thread)
                firebaseService.sendNotification(owner, user.user.id, beacon.id, senderToken.token, data)
            }
        }
        return response
    }

    @JsonRequest
    @Path("/found/location")
    @POST
    @Throws(Exception::class)
    fun addLostLocation(request: AddBeaconLocationRequest): FoundLostBeaconResponse {
        val response = FoundLostBeaconResponse()
        val user = getUser(request)
        isValid(request)
        val item = firebaseService.getNotification(user.user.id, request.eventId)
        if (item.beaconId != null) {
            val beacon = beaconService.getBeaconBy(item.beaconId)
            if (beacon.status != BeaconStatus.LOST) {
                throw ServiceException(Errors.ERROR_BEACON_NOT_FOUND, beacon.factoryId)
            }
            beaconService.createLocation(beacon.id, request.position, user.user.id)
        }
        return response
    }

    @JsonRequest
    @Path("/add")
    @POST
    @Throws(Exception::class)
    fun addBeacon(request: CreateBeaconRequest): CreateBeaconResponse {
        val response = CreateBeaconResponse()
        val user = getUser(request)
        isValid(request)
        val beacon = beaconService.createBeacon(user.user.id, request.factoryId, request.name, request.desc, request.position, request.type, request.phone, request.iconType, request.beaconFactoryTypeId)
                ?: throw ServiceException(Errors.ERROR_GENERAL)
        response.beaconId = beacon.id
        return response
    }

    @Path("/add/picture")
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    @Throws(Exception::class)
    fun addImage(request: FormDataMultiPart): AddImageResponse {
        val response = AddImageResponse()
        val clientIdPart = request.getField("clientId")
        val tokenPart = request.getField("token")
        val beaconIdPart = request.getField("beaconId")
        val filePart = request.getField("file")
        val user = getUser(clientIdPart.getValueAs(String::class.java), tokenPart.getValueAs(String::class.java))
        val beaconId = beaconIdPart.getValueAs(Long::class.java)
        val beacon = beaconService.getBeaconBy(user.user.id, beaconId)
        val fileInputStream = filePart.getValueAs(InputStream::class.java)
        val image = imageService.getImageFrom(fileInputStream)
        val resized = imageService.createResizedFrom(image, ImageType.LARGE.width, ImageType.LARGE.height)
        val thumb = imageService.createSquareCroppedFrom(resized, ImageType.THUMBNAIL.width)
        val generatedName = RandomStringUtils.randomAlphabetic(20)
        val generatedThumbName = generatedName + "_thumb"
        imageService.deleteImages(beacon.id, ImageConnectionType.BEACON)
        val large = imageService.createImage(ImageType.LARGE, resized, beacon.id, ImageConnectionType.BEACON, generatedName, "png")
        if (large != null) {
            response.fullUrl = large.url
        }
        val thumbPic = imageService.createImage(ImageType.THUMBNAIL, thumb, beacon.id, ImageConnectionType.BEACON, generatedThumbName, "png")
        if (thumbPic != null) {
            response.thumbnailUrl = thumbPic.url
        }
        return response
    }

    @JsonRequest
    @Path("/get/picture")
    @POST
    @Throws(Exception::class)
    fun getPicture(request: GetBeaconPictureRequest): GetBeaconPictureResponse {
        val response = GetBeaconPictureResponse()
        val user = getUser(request)
        isValid(request)
        val large = beaconService.getBeaconImage(request.beaconId, ImageType.LARGE)
        if (large != null) {
            response.fullUrl = large.url
        }
        val thumb = beaconService.getBeaconImage(request.beaconId, ImageType.THUMBNAIL)
        if (thumb != null) {
            response.thumbUrl = thumb.url
        }
        return response
    }

    @JsonRequest
    @Path("/edit")
    @POST
    @Throws(Exception::class)
    fun editBeacon(request: EditBeaconRequest): EditBeaconResponse {
        val response = EditBeaconResponse()
        val user = getUser(request)
        beaconService.editBeacon(request.beaconId, user.user.id, request.name, request.desc, request.type, request.phone, request.iconType)
        return response
    }

    @JsonRequest
    @Path("/location/add")
    @POST
    @Throws(Exception::class)
    fun addLocation(request: CreateBeaconLocationRequest): CreateBeaconLocationResponse {
        val response = CreateBeaconLocationResponse()
        val user = getUser(request)
        isValid(request)
        val beacon = beaconService.getBeaconBy(user.user.id, request.beaconId)
        val location = beaconService.createLocation(beacon.id, request.position, user.user.id)
        response.locationId = location.id
        return response
    }

    @JsonRequest
    @Path("/location/list")
    @POST
    @Throws(Exception::class)
    fun listLocations(request: ListBeaconLocationsRequest): ListBeaconLocationsResponse {
        val response = ListBeaconLocationsResponse()
        val user = getUser(request)
        isValid(request)
        val beacon = beaconService.getBeaconBy(user.user.id, request.beaconId)
        val locations = beaconService.getBeaconLocations(beacon.id)
        response.locations = locations
        return response
    }

    @JsonRequest
    @Path("/delete")
    @POST
    @Throws(Exception::class)
    fun deleteBeacon(request: DeleteBeaconRequest): DeleteBeaconResponse {
        val response = DeleteBeaconResponse()
        val user = getUser(request)
        isValid(request)
        beaconService.deleteBeacon(user.user.id, request.beaconId)
        imageService.deleteImages(request.beaconId, ImageConnectionType.BEACON)
        return response
    }

    @JsonRequest
    @Path("/delete/picture")
    @POST
    @Throws(Exception::class)
    fun deleteBeaconPicture(request: GetBeaconPictureRequest): ApiResponse {
        val user = getUser(request)
        isValid(request)
        imageService.deleteImages(request.beaconId, ImageConnectionType.BEACON)
        return ApiResponse()
    }

    @JsonRequest
    @Path("/types")
    @POST
    @Throws(Exception::class)
    fun getManufacturers(request: GetBeaconManufacturersRequest): GetBeaconManufacturersResponse {
        val response = GetBeaconManufacturersResponse()
        response.types = beaconService.manufacturers
        return response
    }
}
