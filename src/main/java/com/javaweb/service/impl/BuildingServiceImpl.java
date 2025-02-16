package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.Entity.BuildingEntity;
import com.javaweb.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService{
	@Autowired
	private BuildingRepository buildingrepository;
	@Override
	public List<BuildingDTO> findAll(String name,Long districtid) {
		List<BuildingEntity> buildingEmtities = buildingrepository.findAll(name,districtid);
		List<BuildingDTO> result = new ArrayList<BuildingDTO>();
		for(BuildingEntity item : buildingEmtities) {
			BuildingDTO building = new BuildingDTO();
			building.setName(item.getName());
			building.setAddress(item.getStreet() + ", " + item.getWard());
			building.setNumberofbasement(item.getNumberofbasement());
			result.add(building);
		}
		return result;
	}
	@Override
	public void deleteById(int id) {
		
	}

}
