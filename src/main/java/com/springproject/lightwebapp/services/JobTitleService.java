package com.springproject.lightwebapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.lightwebapp.models.JobTitle;
import com.springproject.lightwebapp.repositories.JobTitleRepository;

@Service
public class JobTitleService {

	private JobTitleRepository jobTitleRepository;
	
	@Autowired
	public JobTitleService(JobTitleRepository jobTitleRepository) {
		this.jobTitleRepository = jobTitleRepository;
	}


	public List<JobTitle> findAll() {
		return jobTitleRepository.findAll();
	}

}
