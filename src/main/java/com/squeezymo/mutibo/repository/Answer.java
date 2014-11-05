package com.squeezymo.mutibo.repository;

import javax.persistence.*;

@Entity
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(unique=true, nullable=false) 
	private String textContent;

	public Answer() {}
	
	public Answer(String textContent) {
		this.textContent = textContent;
	}
	
	public long getId() { return id; }
	public String getTextContent() { return textContent; }
	
	public void setTextContent(String textContent) { this.textContent = textContent; }
	
}
