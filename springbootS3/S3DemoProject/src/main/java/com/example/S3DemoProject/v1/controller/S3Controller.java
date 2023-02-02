package com.example.S3DemoProject.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.S3DemoProject.v1.service.FileServiceImpl;

import static java.net.HttpURLConnection.HTTP_OK;

@RestController
public class S3Controller {
	
	@Autowired
	private FileServiceImpl fileService;
	
	@PostMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile file) {
		return fileService.saveFile(file);
	}
	
//	@GetMapping("/download/{filename}")
//    public byte[] download(@PathVariable("filename") String filename){
//        return fileService.downloadFile(filename);
//           }
	@GetMapping("download/{filename}")
    public ResponseEntity<byte[]> download(@PathVariable("filename") String filename){
        HttpHeaders headers=new HttpHeaders();
        headers.add("Content-type", MediaType.ALL_VALUE);
        headers.add("Content-Disposition", "attachment; filename="+filename);
        byte[] bytes = fileService.downloadFile(filename);
        return  ResponseEntity.status(HTTP_OK).headers(headers).body(bytes);
    }

    @DeleteMapping("{filename}")
    public  String deleteFile(@PathVariable("filename") String filename){
       return fileService.deleteFile(filename);
    }

    @GetMapping("list")
    public List<String> getAllFiles(){

        return fileService.listAllFiles();

    }
	
}
