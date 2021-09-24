package me.appz4.beacon.model.model


class Position {
    var latitude: Double? = null

    var longitude: Double? = null
    var distance: Double? = null
    var created: Long? = null

    constructor()

    @JvmOverloads
    constructor(lat: Double?, lng: Double?, distance: Double? = null, created: Long? = null) {
        this.latitude = lat
        this.longitude = lng
        this.distance = distance
        this.created = created
    }

    override fun toString(): String {
        return "Position [latitude=" + this.latitude + ", longitude=" + this.longitude + ", distance=" + this.distance + ", created=" + this.created + "]"
    }
}