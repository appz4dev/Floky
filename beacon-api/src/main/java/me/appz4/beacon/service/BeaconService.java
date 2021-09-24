package me.appz4.beacon.service;

import java.util.List;

import org.hibernate.criterion.SimpleExpression;

import me.appz4.beacon.model.model.Beacon;
import me.appz4.beacon.model.model.BeaconLocation;
import me.appz4.beacon.model.model.BeaconManufacturer;
import me.appz4.beacon.model.model.BeaconStatus;
import me.appz4.beacon.model.model.Image;
import me.appz4.beacon.model.model.ImageType;
import me.appz4.beacon.model.model.Position;
import me.appz4.beacon.service.base.AbstractService;

public interface BeaconService extends AbstractService<Beacon> {
	
	Beacon getBeaconBy(Long userId, Long beaconId) throws Exception;
	
	Beacon createBeacon(Long userId, String factoryId, String name, String desc, Position pos, String type, String phone, String iconType, Long manufacturerId) throws Exception;
	
	Beacon findByFactoryId(String factoryId) throws Exception;
	
	BeaconLocation createLocation(Long beaconId, Position pos, Long userId) throws Exception;

	List<BeaconLocation> getBeaconLocations(Long beaconId) throws Exception;
	
	Beacon editBeacon(Long beaconId, Long userId, String name, String desc, String type, String phone, String iconType) throws Exception;
	
	void changeBeaconStatus(Long userId, Long beaconId, BeaconStatus status) throws Exception;

	void deleteBeacon(Long userId, Long beaconId) throws Exception;

	List<Beacon> findAll(SimpleExpression eq) throws Exception;
	
	List<Beacon> findAll(SimpleExpression... eq) throws Exception;

	List<BeaconManufacturer> getManufacturers() throws Exception;
	
	BeaconManufacturer getManufacturer(Long id) throws Exception;

	Image getBeaconImage(Long beaconId, ImageType type) throws Exception;

	List<BeaconLocation> getNearBeaconLocationsForBeaconIds(Position ne, Position sw, List<Long> beaconIds) throws Exception;

	Beacon getLostBeaconByLocationForUserId(BeaconLocation loc, long ownerBeaconId) throws Exception;

	BeaconLocation getLastLocation(Long beaconId) throws Exception;

	Beacon getBeaconBy(Long beaconId) throws Exception;

}
