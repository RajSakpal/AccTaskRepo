package com.example.S3DemoProject.v1.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.amazonaws.util.IOUtils;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.model.S3ObjectSummary;

@Service
public class FileService implements FileServiceImpl {

	private final AmazonS3 s3;//Creating an instance of the s3 bucket
	
	@Value("${bucketName}")
	private String bucketName;
		
	public FileService(AmazonS3 s3) {
		super();
		this.s3 = s3;
	}

	@Override
	public String saveFile(MultipartFile file) {
		String originalFilename=file.getOriginalFilename();
		
		try {
			File file1 = convertMultiPartToFile(file);
			 s3.putObject(bucketName,originalFilename,file1);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "File Uploaded Successfully";
	}

	@Override
	public byte[] downloadFile(String filename) {
		
		S3Object object = s3.getObject(bucketName,filename);
		S3ObjectInputStream objectContent = object.getObjectContent();
		try {
			return IOUtils.toByteArray(objectContent);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public String deleteFile(String filename) {
		s3.deleteObject(bucketName,filename);
		return "File has been deleted!";
	}

	@Override
	public List<String> listAllFiles() {
		ListObjectsV2Result listObjectsV2 = s3.listObjectsV2(bucketName);
		// Retrieves information about the objects in an Amazon S3 bucket convert to stream then to List
		return listObjectsV2.getObjectSummaries().stream().map(S3ObjectSummary::getKey).collect(Collectors.toList());
		
	}
	
	public static File convertMultiPartToFile(MultipartFile file) throws IOException {
	    File convFile = new File(file.getOriginalFilename());
	    FileOutputStream fos=new FileOutputStream(convFile);
	    fos.write(file.getBytes());
	    fos.close();
	    return convFile;
	}

}
