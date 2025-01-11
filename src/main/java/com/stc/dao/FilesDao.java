package com.stc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stc.entity.Files;

public interface FilesDao extends JpaRepository<Files, Long>{

}
