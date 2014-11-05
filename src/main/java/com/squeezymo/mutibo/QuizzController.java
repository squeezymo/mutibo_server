package com.squeezymo.mutibo;

import java.io.IOException;
import java.util.*;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.squeezymo.mutibo.client.QuizzSvcApi;
import com.squeezymo.mutibo.repository.*;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

@Controller
public class QuizzController {
	
	@Autowired private QuestionSetRepo questionSetRepo;

	@RequestMapping(value=QuizzSvcApi.QSET_PTH, method=RequestMethod.POST)
	@ResponseBody
	public QuestionSet addQuestionSet(@RequestBody QuestionSet qset) {
		return questionSetRepo.save(qset);
	}
	
	@RequestMapping(value=QuizzSvcApi.QSET_PTH + "/{id}", method=RequestMethod.GET)
	@ResponseBody
	public QuestionSet getQuestionSetByID(@PathVariable("id") long id) {
		QuestionSet qset = questionSetRepo.findOne(id);
		if ( qset == null ) throw new ResourceNotFoundException("QuestionSet::id == " + id);
		
		return qset;
	}
	
	@RequestMapping(value=QuizzSvcApi.QSET_BY_DOMAIN_ID_ALL_PTH, method=RequestMethod.GET)
	@ResponseBody
	public Collection<QuestionSet> findByDomainID(@Param(QuizzSvcApi.DOMAIN_ID_PARAMETER) long domainId) {
		return questionSetRepo.findByDomainId(domainId);
	}

	/* EXCEPTION HANDLERS */
	
	@ExceptionHandler(ResourceNotFoundException.class)
	private void handle404(ResourceNotFoundException ex, HttpServletResponse response) {
		try {
			response.sendError(HttpServletResponse.SC_NOT_FOUND, ex.getMessage());
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@ExceptionHandler(IllegalStateException.class)
	private void handle400(IllegalStateException ex, HttpServletResponse response) {
		try {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
