package com.project.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Repository
public class IssuerDAOImpl implements IssuerDAO {

	@Override
	public List<String> getAllBanks() {

		try {
			Sql2o sql2o = new Sql2o("jdbc:h2:mem:testdb", "admin", "");
			Connection con = sql2o.open();
			final String query = "SELECT name FROM INFORMATION_SCHEMA.ISSUER" + " where status = 'A'";

			List<String> issuerList = con.createQuery(query).executeAndFetch(String.class);

			return issuerList;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
