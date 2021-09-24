package me.appz4.beacon.resources;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.web.bind.annotation.RestController;

import me.appz4.beacon.model.api.ApiResponse;
import me.appz4.beacon.resources.annotations.JsonRequest;

@RestController
@Path("/status")
public class StatusResource {
	
	@JsonRequest
	@Path("/status")
	@POST
	public ApiResponse getStatus() throws Exception {
		return new ApiResponse();
	}
	
}
