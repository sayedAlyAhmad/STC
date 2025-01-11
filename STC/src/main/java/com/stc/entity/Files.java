package com.stc.entity;

import java.io.Serializable;

import jakarta.persistence.*;

import lombok.*;

@Data
@Entity
@Table(name = "files")
public class Files implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "TYPE")
	private String type;
	@Lob
	@Column(name = "DATA",length = 4294967)
	private byte[] data;
}
