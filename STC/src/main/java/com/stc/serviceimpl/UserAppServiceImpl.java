package com.stc.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stc.PlayLoad.ListResponse;
import com.stc.dao.RoleAppDao;
import com.stc.dao.UserAppDao;
import com.stc.dto.UserAppDto;
import com.stc.entity.RoleApp;
import com.stc.entity.UserApp;
import com.stc.exception.NotFoundException;
import com.stc.mapper.UserAppMapper;
import com.stc.service.UserAppService;

@Service
public class UserAppServiceImpl implements UserAppService {
	@Autowired
	UserAppDao userAppDao;
	@Autowired
	UserAppMapper userAppMapper;
	@Autowired
	RoleAppDao roleAppDao;

	@Override
	public ListResponse<UserAppDto> getAll() {
		// TODO Auto-generated method stub
		return new ListResponse<>(userAppMapper.listToDto(userAppDao.findAll()));
	}
 	public UserApp getId(Long Id) {
		return userAppDao.findById(Id).orElseThrow(() -> new NotFoundException("no id founded", "user-01"));
	}

	@Override
	public UserAppDto getById(Long id) {
		// TODO Auto-generated method stub
		return userAppMapper.entityToDto(
				userAppDao.findById(id).orElseThrow(() -> new NotFoundException("no id founded", "user-01")));
	}

	@Override
	public UserAppDto save(UserAppDto userAppDto) {
		// TODO Auto-generated method stub
		UserApp user = userAppMapper.dtoToEntity(userAppDto);
		List<UserApp> u = new ArrayList<>();
		String roleName = null;
		for (int i = 0; i < u.size(); i++) {
			roleName = user.getRoleApp().get(i).getName();
		}
		System.out.println("Role name:: " + roleName);
		RoleApp role = roleAppDao.findByName(roleName);
		findAll().forEach(us -> {
			us.AddRole(role);
			userAppDao.save(us);

		});
		user = userAppDao.save(user);
		return userAppMapper.entityToDto(user);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		userAppDao.deleteById(id);
	}

	@Override
	public UserAppDto update(UserAppDto userAppDto, Long id) throws Exception {
		// TODO Auto-generated method stub
		UserApp user = userAppDao.findById(id).orElseThrow(() -> new NotFoundException("no id founded", "user-01"));
		userAppMapper.updateEntityFromDto(userAppDto, user);
		user = userAppDao.save(user);
		return userAppMapper.entityToDto(user);
	}

	public List<UserApp> findAll() {

		return userAppDao.findAll();
	}

	@Transactional
	public void addRoleForAllUsers(String roleName) {

		RoleApp role = roleAppDao.findByName(roleName);
		findAll().forEach(user -> {
			user.AddRole(role);
			userAppDao.save(user);

		});
	}

}
