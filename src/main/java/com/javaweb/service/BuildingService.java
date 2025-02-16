package com.javaweb.service;

import java.util.List;

import com.javaweb.model.BuildingDTO;

public interface BuildingService {
	public List<BuildingDTO> findAll(String name,Long districtid);
	void deleteById(int id);
}
