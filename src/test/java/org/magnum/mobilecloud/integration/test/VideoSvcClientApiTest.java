package org.magnum.mobilecloud.integration.test;

import java.util.*;

//import org.magnum.mobilecloud.video.TestData;
import com.squeezymo.mutibo.client.*;
import com.squeezymo.mutibo.repository.*;

import retrofit.RestAdapter;
import retrofit.RestAdapter.LogLevel;

public class VideoSvcClientApiTest {

	private final String TEST_URL = "http://localhost:8080";

	private QuizzSvcApi quizzService = new RestAdapter.Builder()
			.setEndpoint(TEST_URL)
			.setLogLevel(LogLevel.FULL)
			.build()
			.create(QuizzSvcApi.class);
	

	
	
	public void testVideoAddAndList() throws Exception {
		/*
		QuestionSet qset1 = quizzService.addQuestionSet( new QuestionSet(
				new Domain("Movies"),
				new Question("Mark the odd one out"),
				"Not a superhero movie",
				new HashSet<Answer>() {{
				    add(new Answer("Casablanca"));
				}},
				new HashSet<Answer>() {{
				    add(new Answer("Batman"));
				    add(new Answer("X-Men"));
				    add(new Answer("Wolverine"));
				}}
			)
		);
		
		QuestionSet qset2 = quizzService.addQuestionSet( new QuestionSet(
				new Domain("Movies"),
				new Question("Mark the odd one out"),
				"Did not feature Arnold Schwarzenegger",
				new HashSet<Answer>() {{
				    add(new Answer("Rambo"));
				}},
				new HashSet<Answer>() {{
				    add(new Answer("True Lies"));
				    add(new Answer("Terminator"));
				    add(new Answer("Red Heat"));
				}}
			)
		);
		*/
		QuestionSet qset3 = quizzService.addQuestionSet( new QuestionSet(
				new Domain("Movies"),
				new Question("Mark the odd one out"),
				"Was not directed by Ingmar Bergman",
				new HashSet<Answer>() {{
				    add(new Answer("Night on Earth"));
				}},
				new HashSet<Answer>() {{
				    add(new Answer("The Seventh Seal"));
				    add(new Answer("Hour of the Wolf"));
				    add(new Answer("Winter Light"));
				}}
			)
		);
		
		
		//System.out.println(qset.getId() + "; domain " + qset.getDomain().getTextContent() + "; domain_id = " + qset.getDomain().getId());
	}
	
	public static void main(String[] args) throws Exception {
		VideoSvcClientApiTest test = new VideoSvcClientApiTest();
		test.testVideoAddAndList();
	}

}
