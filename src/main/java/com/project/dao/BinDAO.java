package com.project.dao;

import com.project.entity.BinBean;

public interface BinDAO {	
	public void saveBIN(String name, BinBean binBean);
	public Integer getIssuerIDFromTable(String name);
}
