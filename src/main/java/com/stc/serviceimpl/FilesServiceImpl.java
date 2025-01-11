package com.stc.serviceimpl;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.stc.PlayLoad.ListResponse;
import com.stc.dao.FilesDao;
import com.stc.dto.FilesDto;
import com.stc.entity.Files;
import com.stc.mapper.FilesMapper;
import com.stc.service.FilesService;

@Service
public class FilesServiceImpl  implements FilesService{
	@Autowired 
	FilesMapper filesMapper;
	@Autowired
	FilesDao filesDao;

	@Override
	public FilesDto save(FilesDto dto) throws IOException {
		
		Files files = filesMapper.dtoToEntity(dto);
		
		files = filesDao.save(files);
		return filesMapper.entityToDto(files);
 	}

	@Override
	public FilesDto store(MultipartFile file) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		Files dto = new Files();
		dto.setName(fileName);
		dto.setType(file.getContentType());
 		dto.setData(file.getBytes());
		
 	    dto = filesDao.save(dto);
 		return filesMapper.entityToDto(dto);
	}

	@Override
	public ListResponse<FilesDto> getAll() {
		// TODO Auto-generated method stub
 		return new ListResponse<>(filesMapper.listToDto(filesDao.findAll()));
	}

	@Override
	public FilesDto getById(Long id) {
		// TODO Auto-generated method stub
		return filesMapper
				.entityToDto(filesDao.findById(id).orElseThrow(() -> new com.stc.exception.NotFoundException("no id founded", "file-01")));	}

	@Override
	public Stream<Files> getAllFiles() {
		// TODO Auto-generated method stub
		return filesDao.findAll().stream();
	}

}
