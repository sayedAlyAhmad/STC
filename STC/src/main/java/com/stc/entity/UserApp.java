package com.stc.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Data
@Entity
@Table(name = "user_app")
public class UserApp implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "FULL_NAME")
    private String fullName;
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "PASSWORD")
    private String password;
	@ManyToMany
	@ToString.Exclude
	@JsonManagedReference
 	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID"))
	List<RoleApp> roleApp =  new ArrayList<RoleApp>();;
	
	public void AddRole(RoleApp role) {
		roleApp.add(role);
	}

}
