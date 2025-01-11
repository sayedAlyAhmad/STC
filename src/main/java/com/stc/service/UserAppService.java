package com.stc.service;

import com.stc.PlayLoad.ListResponse;
import com.stc.dto.UserAppDto;

public interface UserAppService {
	ListResponse<UserAppDto> getAll();
	UserAppDto getById(Long id);
	UserAppDto save(UserAppDto userAppDto);
	void delete(Long id);
	UserAppDto update(UserAppDto userAppDto, Long id) throws Exception;
}
