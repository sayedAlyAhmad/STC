package com.stc.service;

import com.stc.PlayLoad.ListResponse;
import com.stc.dto.RoleAppDto;

public interface RoleAppService {
	ListResponse<RoleAppDto> getAll();
	RoleAppDto getById(Long id);
	RoleAppDto save(RoleAppDto roleAppDto);
	void delete(Long id);
	RoleAppDto update(RoleAppDto roleAppDto, Long id) throws Exception;
}
