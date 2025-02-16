package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.Entity.BuildingEntity;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository{
	
	static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
	static final String USER = "root";
	static final String PASS = "123456";
	@Override
	public List<BuildingEntity> findAll(String name,Long districId) {
		StringBuilder sql = new StringBuilder("select * from building where  1 = 1");
		if(name != null && !name.equals("")) {
			sql.append(" and name like '%" + name + "%' ");
		}
		if(districId != null) {
			sql.append(" and districtid = " + districId + " ");
		}
		List<BuildingEntity> result = new ArrayList<BuildingEntity>();
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				java.sql.Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql.toString());) {
			
			while(rs.next()) {
				BuildingEntity building = new BuildingEntity();
				building.setName(rs.getString("name"));
				building.setStreet(rs.getString("street"));
				building.setWard(rs.getString("ward"));
				building.setNumberofbasement(rs.getInt("numberofbasement"));
				result.add(building);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Kết nối database thất bại...");
		}
		return result;
	}
	
}
