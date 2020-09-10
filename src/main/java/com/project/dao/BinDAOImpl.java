package com.project.dao;

import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import com.project.entity.BinBean;

@Repository
public class BinDAOImpl implements BinDAO {

	@Override
	public void saveBIN(String name, BinBean binBean) {
		// this.issuerID = this.getIssuerIDFromTable(name);
		binBean.setIssuerID(this.getIssuerIDFromTable(name));

		try {

			Sql2o sql2o = new Sql2o("jdbc:h2:mem:testdb", "admin", "");
			Connection con = sql2o.open();
			final String query = "INSERT INTO INFORMATION_SCHEMA.BIN " + "(issuer_id,bin,bin_start,bin_end) "
					+ "values (:issuer_id,:bin,:bin_start,:bin_end)";

			con.createQuery(query).addParameter("issuer_id", binBean.getIssuerID())
					.addParameter("bin", binBean.getBin()).addParameter("bin_start", binBean.getBinStart())
					.addParameter("bin_end", binBean.getBinEnd()).executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Integer getIssuerIDFromTable(String name) {
		try {

			Sql2o sql2o = new Sql2o("jdbc:h2:mem:testdb", "admin", "");
			Connection con = sql2o.open();
			final String query = "SELECT id FROM INFORMATION_SCHEMA.ISSUER where name = :name";

			Integer id = con.createQuery(query).addParameter("name", name).executeAndFetch(Integer.class).get(0);

			return id;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
