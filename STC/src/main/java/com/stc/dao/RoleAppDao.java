package com.stc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stc.entity.RoleApp;

public interface RoleAppDao extends JpaRepository<RoleApp, Long>{

	RoleApp findByName(String name);
}
