package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.BinDAO;
import com.project.entity.BinBean;

@Service
public class BinServiceImpl implements BinService{

	@Autowired
	public BinDAO binDAO;
	
	@Override
	public void saveBIN(String name, BinBean binBean) {
		binDAO.saveBIN(name, binBean);
	}

}
