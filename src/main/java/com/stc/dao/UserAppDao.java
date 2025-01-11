package com.stc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.stc.entity.UserApp;
import java.util.*;
public interface UserAppDao extends JpaRepository<UserApp, Long> {

	@Override
	@Transactional(readOnly = false)
	List<UserApp> findAll();
}
