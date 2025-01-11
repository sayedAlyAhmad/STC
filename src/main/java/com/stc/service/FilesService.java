package com.stc.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.web.multipart.MultipartFile;

import com.stc.PlayLoad.ListResponse;
import com.stc.dto.FilesDto;
import com.stc.entity.Files;

public interface FilesService {
	ListResponse<FilesDto> getAll();
	FilesDto getById(Long id);
	FilesDto save(FilesDto  file) throws IOException;
	FilesDto store(MultipartFile file) throws IOException;
	public Stream<Files> getAllFiles();
 
 
}
