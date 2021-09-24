package me.appz4.beacon.dao

import me.appz4.beacon.dao.base.BaseDao
import me.appz4.beacon.model.model.BeaconLocation
import me.appz4.beacon.model.model.Position

interface BeaconLocationDao : BaseDao<BeaconLocation> {

    fun findAllMostRecent(ne: Position, sw: Position, nw: Position, beaconIds: List<Long>): MutableList<BeaconLocation>?
}
