package com.project.entity;

import javax.inject.Named;

import org.springframework.stereotype.Component;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Component(value = "binBean")
public class BinBean {
	
	private Integer issuerID;
	private Integer bin;
	private String binStart;
	private String binEnd;
	
	public BinBean() { }
	
	public BinBean(Integer issuerID, Integer bin, String binStart, String binEnd) {
		super();
		this.issuerID = issuerID;
		this.bin = bin;
		this.binStart = binStart;
		this.binEnd = binEnd;
	}


	public Integer getIssuerID() {
		return issuerID;
	}


	public void setIssuerID(Integer issuerID) {
		this.issuerID = issuerID;
	}


	public Integer getBin() {
		return bin;
	}


	public void setBin(Integer bin) {
		this.bin = bin;
	}


	public String getBinStart() {
		return binStart;
	}


	public void setBinStart(String binStart) {
		this.binStart = binStart;
	}


	public String getBinEnd() {
		return binEnd;
	}


	public void setBinEnd(String binEnd) {
		this.binEnd = binEnd;
	}


	public void saveBIN(String name) {
		this.issuerID = this.getIssuerIDFromTable(name);

		  try {
			  
			  Sql2o sql2o = new Sql2o("jdbc:h2:mem:testdb", "admin", "");
			  Connection con = sql2o.open();
			  final String query = "INSERT INTO INFORMATION_SCHEMA.BIN "
			  		+ "(issuer_id,bin,bin_start,bin_end) "
			  		+ "values (:issuer_id,:bin,:bin_start,:bin_end)";
			    
			  con.createQuery(query).addParameter("issuer_id", this.issuerID)
					  	   .addParameter("bin", this.bin)
					  	   .addParameter("bin_start", this.binStart)
					  	   .addParameter("bin_end", this.binEnd)
					       .executeUpdate();
			 
					 
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
	}
	
	
	public Integer getIssuerIDFromTable(String name) {
		  try {
			  
			  Sql2o sql2o = new Sql2o("jdbc:h2:mem:testdb", "admin", "");
			  Connection con = sql2o.open();
			  final String query = "SELECT id FROM INFORMATION_SCHEMA.ISSUER where name = :name";
			    
			  Integer id = con.createQuery(query).addParameter("name", name)
					       .executeAndFetch(Integer.class)
					       .get(0);
			 
			  return id;
					 
		  }catch(Exception e) {
			  e.printStackTrace();
			  return null;
		  }
	}
	
}
