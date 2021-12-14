package com.codeimmig.yannick.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Data
@Entity
@Table(name="app_user_tab")
public class AppUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id_col")
	private Long id;
	
	@Column(name="user_name_col")
	private String name;
	@Column(name="user_email_col")
	private String email;
	
	@Column(name="user_mob_col")
	private String mobile;
	
	@Column(name="user_gen_col")
	private String gender;
	
	@Column(name="user_dob_col")
	@DateTimeFormat(iso = ISO.DATE)
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	@OneToMany(
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER)
	@JoinColumn(name="user_id_fk_col")
	private List<Address> address; 


}
