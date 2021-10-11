package com.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.entity.Corso;
import com.hibernate.service.CorsoService;

@RestController
@RequestMapping("/corso")
public class CorsoController {
	
	@Autowired
	private CorsoService corsoService;

	@GetMapping()
	public List<Corso> getCorsiList(){
		
		return corsoService.getCorsiList();
	}
}
