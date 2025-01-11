package com.stc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.stc.PlayLoad.ListResponse;
import com.stc.dto.FilesDto;
import com.stc.entity.Files;
import com.stc.serviceimpl.FilesServiceImpl;

@RestController
@RequestMapping("${api.prefix.stc}" + "/file")
public class FilesController {

	@Autowired
	FilesServiceImpl filesServiceImpl;

	@PostMapping("/upload")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
		String message = "";
		try {
			filesServiceImpl.store(file);

			message = "Uploaded the file successfully: " + file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(message);
		} catch (Exception e) {
			message = "Could not upload the file: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}
	}

	@GetMapping("/files")
	public ResponseEntity<List<Files>> getListFiles() {
		List<Files> files = new ArrayList<>();
		files = filesServiceImpl.getAllFiles().collect(Collectors.toList());
		System.out.println("after :: " + files);
		return ResponseEntity.status(HttpStatus.OK).body(files);
	}

	@GetMapping("/files/{id}")
	public FilesDto getById(@PathVariable(value = "id") Long id) {
		return filesServiceImpl.getById(id);
	}

	@GetMapping
	public ListResponse<FilesDto> getAll() {
		return filesServiceImpl.getAll();
	}

}
