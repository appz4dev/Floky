package me.appz4.beacon.amazon;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;

import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.transfer.Transfer.TransferState;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.Upload;

import me.appz4.beacon.model.exception.Errors;
import me.appz4.beacon.model.exception.ServiceException;

public class AwsFileManager {
	
	@Autowired
	private AmazonS3 amazonClient;
	
	private String amazonBucket;
	
	private String amazonBucketUrl;
	
	private String tmpDir;
	
	public AwsFileManager(String amazonBucket, String tmpDir, String amazonBucketUrl) {
		this.amazonBucket = amazonBucket;
		this.tmpDir = tmpDir;
		this.amazonBucketUrl = amazonBucketUrl;
	}
	
	public String write(String fileName, BufferedImage image, String extension) throws Exception {
		try {
			TransferManager tx = new TransferManager(amazonClient);
			boolean doesBucketExist = tx.getAmazonS3Client().doesBucketExist(amazonBucket);
			if(!doesBucketExist) throw new ServiceException(Errors.ERROR_GENERAL);
			File tmpFile = new File(tmpDir+fileName+"."+extension);
			getLocalFile(image, tmpFile);
			if(!tmpFile.exists()) throw new ServiceException(Errors.ERROR_GENERAL);
			String key = fileName+"."+extension;
			PutObjectRequest request = new PutObjectRequest(amazonBucket, key, tmpFile);
			request.setCannedAcl(CannedAccessControlList.BucketOwnerFullControl);
			Upload up = tx.upload(request);
			up.waitForCompletion();
			TransferState state = up.getState();
			if(tmpFile.exists()) tmpFile.delete();
			tx.shutdownNow(false);
			if(state.equals(TransferState.Completed)) {
				/*Asset desc = new ListyAssetDescriptor();
				desc.setName(key);
				desc.setLocation(amazonBucketUrl);*/
				return amazonBucketUrl+key;
			}
			throw new ServiceException(Errors.ERROR_GENERAL);
		}
		catch(AmazonClientException e) {
			throw new ServiceException(Errors.ERROR_GENERAL);
		}
	}

	private void getLocalFile(BufferedImage img, File tmpFile) throws FileNotFoundException, IOException {
		Iterator<?> iter = ImageIO.getImageWritersByFormatName("jpeg");
		ImageWriter writer = (ImageWriter)iter.next();
		ImageWriteParam iwp = writer.getDefaultWriteParam();
		iwp.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
		iwp.setCompressionQuality(0.85f);
		FileImageOutputStream output = new FileImageOutputStream(tmpFile);
		writer.setOutput(output);
		IIOImage outp = new IIOImage(img, null, null);
		writer.write(null, outp, iwp);
		writer.dispose();
	}

	public void delete(String name) throws Exception {
		try {
			boolean doesBucketExist = amazonClient.doesBucketExist(amazonBucket);
			if(!doesBucketExist) throw new ServiceException(Errors.ERROR_GENERAL);
			amazonClient.deleteObject(amazonBucket, name);
		}
		catch(AmazonClientException e) {
			throw new ServiceException(Errors.ERROR_GENERAL);
		}
	}

	public boolean isFile(String name) throws Exception {
		try {
			boolean doesBucketExist = amazonClient.doesBucketExist(amazonBucket);
			if(!doesBucketExist) throw new ServiceException(Errors.ERROR_GENERAL);
			amazonClient.getObjectMetadata(amazonBucket, name);
			return true;
		}
		catch(AmazonClientException e) {
			throw new ServiceException(Errors.ERROR_GENERAL);
		}
	}
	
}
