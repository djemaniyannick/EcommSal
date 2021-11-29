package com.codeimmig.yannick.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "coupon_tab")
public class Coupon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="coupon_id_col")
	private Long id;
	
	@Column(name = "coupon_code_col")
	private String code;
	
	@Column(name = "coupon_note_col")
	private Integer note;
	
	@Column(name = "coupon_percentage_col")
	private String percentage;
	
	@Column(name = "coupon_available_col")
	private String available;


}
