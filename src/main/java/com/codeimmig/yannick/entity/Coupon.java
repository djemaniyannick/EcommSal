package com.codeimmig.yannick.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

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
	
	@Column(name = "coupon_expdate_col")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@Temporal(TemporalType.DATE)
	private Date  expDate;
	
	
	@Column(name = "coupon_totalAllowed_col")
	private Integer totalAllowed;

}
