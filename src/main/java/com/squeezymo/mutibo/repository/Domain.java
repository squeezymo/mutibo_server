package com.squeezymo.mutibo.repository;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.google.gson.annotations.Expose;

import java.util.*;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Domain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(unique = true, nullable = false)
	private String textContent;
	
	//@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, orphanRemoval = true)
	//@Column(nullable = true)
	//@JsonManagedReference("questionSet")
	//@Expose(serialize = false)
	//private Set<QuestionSet> questionSets;

	public Domain() {
		//questionSets = new HashSet<QuestionSet>();
	}
	
	public Domain(String textContent) {
		this();
		this.textContent = textContent;
	}
	
	public void addQuestionSet(QuestionSet questionSet) {
		//addQuestionSet(questionSet, true);
	}
/*
	void addQuestionSet(QuestionSet questionSet, boolean set) {
		if (questionSet != null) {
			
			if ( !getQuestionSets().contains(questionSet) ) {
				getQuestionSets().add(questionSet); 
			}
			
			if (set) {
				questionSet.setDomain(this, false); 
			}
			
		}
	}
	
   // public void removeQuestionSet(QuestionSet questionSet) {
   // 	getQuestionSets().remove(questionSet);
   // 	questionSet.setDomain(null);
   // }   
 */
	public long getId() { return id; }
	public String getTextContent() { return textContent; }
	//public Set<QuestionSet> getQuestionSets() { return questionSets; }

	public void setTextContent(String textContent) { this.textContent = textContent; }
	//public void setQuestionSets(Set<QuestionSet> questionSets) { this.questionSets = questionSets; }
	
	@Override
	public boolean equals(Object o) {
		if (o == null || !(o instanceof Domain))
			return false;
		
	    return getTextContent().equals( ((Domain) o).getTextContent() );
	}
	
	@Override
	public int hashCode() {
		return getTextContent().hashCode();
	}
}
