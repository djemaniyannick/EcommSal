package com.codeimmig.yannick.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "categorytype_tab")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class CategoryType {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	@Column(name = "cat_type_name_col")
	private String name;
	@Column(name = "cat_type_note_col")
	private String note;

}
