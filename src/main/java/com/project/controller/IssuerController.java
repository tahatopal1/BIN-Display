package com.project.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.project.service.IssuerService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Controller
@NoArgsConstructor
@AllArgsConstructor
public class IssuerController {
	
	@Autowired
	public IssuerService issuerService;
	
	private List<String> bankList;
	
	@PostConstruct
	public void getAllBanks(){
		bankList = issuerService.getAllBanks();
	}

	public IssuerService getIssuerService() {
		return issuerService;
	}

	public void setIssuerService(IssuerService issuerService) {
		this.issuerService = issuerService;
	}
	
	public void setBankList(List<String> bankList) {
		this.bankList = bankList;
	}

	public List<String> getBankList() {
		return bankList;
	}
	
}
