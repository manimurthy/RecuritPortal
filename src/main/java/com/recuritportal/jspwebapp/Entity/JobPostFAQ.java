package com.recuritportal.jspwebapp.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class JobPostFAQ {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer faqid;

    private String question;
    private String answer;

    @ManyToOne
    @JoinColumn(name = "job_post_id")
    private JobPost jobPost;

    // getters and setters    	
    public Integer getFaqid() {
		return faqid;
	}

	public void setFaqid(Integer faqid) {
		this.faqid = faqid;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public JobPost getJobPost() {
		return jobPost;
	}

	public void setJobPost(JobPost jobPost) {
		this.jobPost = jobPost;
	}
}