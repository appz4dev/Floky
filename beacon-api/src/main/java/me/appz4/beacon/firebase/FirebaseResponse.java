package me.appz4.beacon.firebase;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FirebaseResponse {
	
	private int success;
	
	private int failure;

	public int getSuccess() {
		return success;
	}

	public void setSuccess(int success) {
		this.success = success;
	}

	public int getFailure() {
		return failure;
	}

	public void setFailure(int failure) {
		this.failure = failure;
	}

	@Override
	public String toString() {
		return "FirebaseResponse [success=" + success + ", failure=" + failure + "]";
	}
	
}
