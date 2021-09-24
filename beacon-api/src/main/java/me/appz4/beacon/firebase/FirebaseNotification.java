package me.appz4.beacon.firebase;

import java.util.Map;

public class FirebaseNotification {

	private Map<String, String> data;
	
	private String to;

	public Map<String, String> getData() {
		return data;
	}

	public void setData(Map<String, String> data) {
		this.data = data;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	@Override
	public String toString() {
		return "FirebaseNotification [data=" + data + ", to=" + to + "]";
	}

	
}
