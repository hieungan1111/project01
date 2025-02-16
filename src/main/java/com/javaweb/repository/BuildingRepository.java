package com.javaweb.repository;

import java.util.ArrayList;
import java.util.List;

import com.javaweb.repository.Entity.BuildingEntity;

public interface BuildingRepository {
	 public List<BuildingEntity> findAll(String name, Long districtId);
}
