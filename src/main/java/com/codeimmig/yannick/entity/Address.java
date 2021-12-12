package com.codeimmig.yannick.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="addr_id_col")
	private Long id;

	@Column(name="addr_line1_col")
	private String line1;
	
	@Column(name="addr_line2_col")
	private String line2;
	
	@Column(name="addr_city_col")
	private String city;
	
	@Column(name="addr_state_col")
	private String state;
	
	@Column(name="addr_country_col")
	private String country;
	
	@Column(name="addr_pincode_col")
	private String pincode;

	@Override
	public String toString() {
		return line1+", "+line2+", "+city+", "+state+", "+country+", "+pincode;
	}

}
