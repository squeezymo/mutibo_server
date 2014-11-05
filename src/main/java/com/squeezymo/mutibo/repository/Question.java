package com.squeezymo.mutibo.repository;

import java.util.*;
import javax.persistence.*;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(unique=true, nullable=false)
	private String textContent;

	//@OneToMany(fetch = FetchType.LAZY, mappedBy = "question")
	//private Set<QuestionSet> questionSets;
	
	public Question() {}
	
	public Question(String textContent) {
		this.textContent = textContent;
	}
	
	public long getId() { return id; }
	public String getTextContent() { return textContent; }
	//public Set<QuestionSet> getQuestionSets() { return questionSets; }
	
	public void setTextContent(String textContent) { this.textContent = textContent; }
	//public void setQuestionSets(Set<QuestionSet> questionSets) { this.questionSets = questionSets; }
	
	@Override
	public boolean equals(Object o) {
		if(o == null) return false;
	    if( !(o instanceof Question) ) return false;
	    
	    return getTextContent().equals( ((Question) o).getTextContent() );
	}
	
	@Override
	public int hashCode() {
		return getTextContent().hashCode();
	}
	
}
