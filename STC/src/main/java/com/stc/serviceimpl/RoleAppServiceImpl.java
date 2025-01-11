package com.stc.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stc.PlayLoad.ListResponse;
import com.stc.dao.RoleAppDao;
import com.stc.dto.RoleAppDto;
import com.stc.entity.RoleApp;
import com.stc.exception.NotFoundException;
import com.stc.mapper.RoleAppMapper;
import com.stc.service.RoleAppService;

@Service
public class RoleAppServiceImpl implements RoleAppService {

	@Autowired
	RoleAppMapper roleAppMapper;
	@Autowired
	RoleAppDao roleAppDao;
	@Override
	public ListResponse<RoleAppDto> getAll() {
		// TODO Auto-generated method stub
		return new ListResponse<>(roleAppMapper.listToDto(roleAppDao.findAll()));	}

	@Override
	public RoleAppDto getById(Long id) {
		// TODO Auto-generated method stub
		return roleAppMapper
				.entityToDto(roleAppDao.findById(id).orElseThrow(() -> new NotFoundException("no id founded", "role-01")));
	}

	@Override
	public RoleAppDto save(RoleAppDto roleAppDto) {
		// TODO Auto-generated method stub
		RoleApp role = roleAppMapper.dtoToEntity(roleAppDto);
		role = roleAppDao.save(role);
		return roleAppMapper.entityToDto(role);	
		}
	

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		roleAppDao.deleteById(id);	

	}

	@Override
	public RoleAppDto update(RoleAppDto roleAppDto, Long id) throws Exception {
		// TODO Auto-generated method stub
		RoleApp role=roleAppDao.findById(id).orElseThrow(() -> new NotFoundException("no id founded", "role-01"));
		roleAppMapper.updateEntityFromDto(roleAppDto, role);
		role = roleAppDao.save(role);
		return roleAppMapper.entityToDto(role);	
		}

}
