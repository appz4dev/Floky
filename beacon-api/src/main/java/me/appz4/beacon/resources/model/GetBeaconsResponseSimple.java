package me.appz4.beacon.resources.model;

import java.util.ArrayList;
import java.util.List;

import me.appz4.beacon.model.api.ApiResponse;

public class GetBeaconsResponseSimple extends ApiResponse {
	
	private List<SimpleBeacon> beacons = new ArrayList<>();

	public List<SimpleBeacon> getBeacons() {
		return beacons;
	}

	public void setBeacons(List<SimpleBeacon> beacons) {
		this.beacons = beacons;
	}
	
	
	
}
