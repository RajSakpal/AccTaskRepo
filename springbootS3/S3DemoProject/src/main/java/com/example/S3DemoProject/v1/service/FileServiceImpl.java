package com.example.S3DemoProject.v1.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface FileServiceImpl {

	String saveFile(MultipartFile file);
	
	byte[] downloadFile(String filename);
	
	String deleteFile(String filename);
	
	List<String> listAllFiles();
}
