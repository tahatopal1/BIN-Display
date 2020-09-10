package com.project.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.project.entity.BinBean;
import com.project.service.BinService;
import com.project.service.IssuerService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Controller(value = "binController")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BinContoller {
		
	@Autowired
	public BinBean binBean;
	
	
	@Autowired
	public BinService binService;
	
	@PostConstruct
	public void poost() {
		System.out.println("Post process");
	}
	
	public void saveBIN(String str) {
		binService.saveBIN(str, this.binBean);
	}
	
}
