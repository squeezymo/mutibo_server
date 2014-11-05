package com.squeezymo.mutibo.repository;

import java.util.*;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.google.gson.annotations.Expose;

@Entity(name="questionSet")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class QuestionSet {	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	//@JsonBackReference("questionSet") 
	//@JoinColumn(name = "domain_id")
	//@Expose(serialize = false)
	private Domain domain;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	//@JoinColumn(name = "question_id")
	private Question question;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Answer> correctAnswers;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Answer> incorrectAnswers;
	
	//@OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	//private Stats stats;
	
	private String explanation;
	
	public QuestionSet() {}
	
	public QuestionSet(Domain domain, Question question, String explanation, Set<Answer> correctAnswers, Set<Answer> incorrectAnswers) {
		setDomain(domain);
		 //this.domain = domain;
		//this.question = question;
		this.explanation = explanation;
		this.correctAnswers = correctAnswers;
		this.incorrectAnswers = incorrectAnswers;
	}
	
	public void setDomain(Domain domain) { setDomain(domain, true); }
    void setDomain(Domain domain, boolean add) {
        this.domain = domain;
   //     if (domain != null && add) {
  //      	domain.addQuestionSet(this, false);
  //      }
    }
	
	public long getId() { return id; }
	public Domain getDomain() { return domain; }
	//public Question getQuestion() { return question; }
	public String getExplanation() { return explanation; }
	public Set<Answer> getCorrectAnswers() { return correctAnswers; }
	public Set<Answer> getIncorrectAnswers() { return incorrectAnswers; }
	
	//public void setQuestion(Question question) {this.question = question;}
	public void setExplanation(String explanation) { this.explanation = explanation; }
	public void setCorrectAnswers(Set<Answer> correctAnswers) { this.correctAnswers = correctAnswers; }
	public void setIncorrectAnswers(Set<Answer> incorrectAnswers) { this.incorrectAnswers = incorrectAnswers; }
	
	@Override
	public boolean equals(Object o) {
		if (o == null || !(o instanceof QuestionSet))
			return false;
		
	    return getId() == ((QuestionSet) o).getId();
	}
	
	@Override
	public int hashCode() {
		return (int) getId();
	}
}
