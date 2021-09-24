package me.appz4.beacon.model.model


import java.io.Serializable
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "beacon_locations")
class BeaconLocation : Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null
    @Column(name = "beaconId")
    var beaconId: Long? = null
    @Column(name = "latitude")
    var latitude: Double? = null
    @Column(name = "longitude")
    var longitude: Double? = null
    @Column(name = "userId")
    var userId: Long? = null
    @Column(name = "created")
    var created: Timestamp? = null

    override fun toString(): String {
        return "BeaconLocation [id=" + this.id + ", beaconId=" + this.beaconId + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ", userId=" + this.userId + ", created=" + this.created + "]"
    }

    companion object {
        private const val serialVersionUID = -7631849913758958722L
        val BEACONID = "beaconId"
        val CREATED = "created"
        val LATITUDE = "latitude"
        val LONGITUDE = "longitude"

        val serialversionuid: Long
            get() = -7631849913758958722L
    }
}