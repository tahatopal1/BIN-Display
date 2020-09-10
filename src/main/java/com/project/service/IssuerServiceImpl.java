package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.IssuerDAO;

@Service
public class IssuerServiceImpl implements IssuerService {
	
	@Autowired
	public IssuerDAO issuerDAO; 
	
	@Override
	public List<String> getAllBanks() {
		return issuerDAO.getAllBanks();
	}

}
