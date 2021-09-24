package me.appz4.beacon.test.api.beacon;

import java.io.File;

import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.RandomStringUtils;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

import de.svenjacobs.loremipsum.LoremIpsum;
import me.appz4.beacon.model.api.request.beacon.CreateBeaconRequest;
import me.appz4.beacon.model.api.request.beacon.EditBeaconRequest;
import me.appz4.beacon.model.api.request.beacon.GetBeaconRequest;
import me.appz4.beacon.model.api.request.beacon.GetBeaconStatusRequest;
import me.appz4.beacon.model.api.response.beacon.AddImageResponse;
import me.appz4.beacon.model.api.response.beacon.CreateBeaconResponse;
import me.appz4.beacon.model.api.response.beacon.EditBeaconResponse;
import me.appz4.beacon.model.api.response.beacon.GetBeaconResponse;
import me.appz4.beacon.model.api.response.beacon.GetBeaconStatusResponse;
import me.appz4.beacon.model.model.Beacon;
import me.appz4.beacon.model.model.BeaconStatus;
import me.appz4.beacon.model.model.Position;
import me.appz4.beacon.test.api.ApiBaseTest;

public class BeaconTests extends ApiBaseTest {

	private final String email = "JnK1UcLc3P@mailinator.com";
	
	private final String password = "2gmxAcmecLRPI4hT";

	private final String factoryId = RandomStringUtils.randomAlphabetic(20);
	
	private final String picturePath = "D:\\Work\\Projects\\beacon\\mockup_v2.0.png";
	
	private Long beaconId;
	
	public BeaconTests() {
		super(ApiBaseTest.BASEURL, ApiBaseTest.CLIENTID);
	}
	
	@Test(priority=-1)
	public void login() throws Exception {
		login(email, password);
	}
	
	@Test(priority=1)
	public void createBeacon() throws Exception {
		LoremIpsum lipsum = new LoremIpsum();
		CreateBeaconRequest request = new CreateBeaconRequest();
		request.setFactoryId(factoryId);
		request.setName(RandomStringUtils.randomAlphabetic(20));
		request.setDesc(lipsum.getWords(10));
		request.setType("Car");
		request.setPhone("06-300");
		request.setPosition(new Position(47.0, 19.0));
		CreateBeaconResponse response = post("beacons/add", request, CreateBeaconResponse.class);
		assertEquals(response.isError(), false);
		assertNotNull(response.getBeaconId());
		beaconId = response.getBeaconId();
	}
	
	@Test(priority=2)
	public void addPicture() throws Exception {
		MultiPart multiPart = new MultiPart(MediaType.MULTIPART_FORM_DATA_TYPE);
		FileDataBodyPart fileDataBodyPart = new FileDataBodyPart("file", new File(picturePath), MediaType.APPLICATION_OCTET_STREAM_TYPE);
	    multiPart.bodyPart(fileDataBodyPart);
	    addBodyPart(multiPart, "clientId", getClientId());
	    addBodyPart(multiPart, "tokenId", getToken().getToken());
	    addBodyPart(multiPart, "beaconId", Long.toString(beaconId));
	    AddImageResponse response = postMultiPart("beacons/add/picture", multiPart, AddImageResponse.class);
	    hasError(response);
	}

	@Test(priority=3)
	public void editBeacon() throws Exception {
		String newName = RandomStringUtils.randomAlphabetic(20);
		String newDesc = RandomStringUtils.randomAlphabetic(20);
		String newType = "Bike";
		String newPhone = RandomStringUtils.randomNumeric(6);
		EditBeaconRequest request = new EditBeaconRequest();
		request.setBeaconId(beaconId);
		request.setName(newName);
		request.setDesc(newDesc);
		request.setType(newType);
		request.setPhone(newPhone);
		EditBeaconResponse response = post("beacons/edit", request, EditBeaconResponse.class);
		hasError(response);
		Beacon edited = getBeacon(beaconId);
		assertEquals(edited.getName(), newName);
		assertEquals(edited.getDescription(), newDesc);
		assertEquals(edited.getType(), newType);
		assertEquals(edited.getPhone(), newPhone);
	}
	
	private Beacon getBeacon(Long id) throws Exception {
		GetBeaconRequest request = new GetBeaconRequest();
		request.setBeaconId(id);
		GetBeaconResponse response = post("beacons/get", request, GetBeaconResponse.class);
		hasError(response);
		assertNotNull(response.getBeacon());
		return response.getBeacon();
	}
	
	@Test(priority=4)
	public void checkBeaconStatus() throws Exception {
		GetBeaconStatusRequest request = new GetBeaconStatusRequest();
		request.setFactoryId(factoryId);
		GetBeaconStatusResponse response = post("beacons/status", request, GetBeaconStatusResponse.class);
		hasError(response);
		assertEquals(response.getStatus(), BeaconStatus.OK);
		assertEquals(response.getUserId(), getToken().getUserId());
	}
	
}
