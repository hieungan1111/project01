package com.javaweb.api;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.model.BuildingDTO;
import com.javaweb.model.ErrorResponseDTO;
import com.javaweb.service.BuildingService;

import customexception.FieldRequiredException;

@RestController
public class BuildingAPI {
	@Autowired
	private BuildingService buildingservice;
	@GetMapping(value = "/api/building")
	public List<BuildingDTO> getBuilding(@RequestParam(name = "name", required = false) String name,
										@RequestParam(name = "districtid", required = false) Long districtid,
										@RequestParam(name = "typecodeXuanHieu", required = false) List<String> typeCode) {
		List<BuildingDTO> result = buildingservice.findAll(name,districtid);
		return result;
	}

//	@RequestMapping(value="/api/building", method = RequestMethod.POST)
//	public void building2(@RequestParam Map<String, String> params) {
//		System.out.println("ok");
//	}
//	@GetMapping(value = "/api/building")
//	public void building(@RequestParam(value = "name", required = false) String name,
//			@RequestParam(value = "number", required = false) Integer number) {
//		System.out.println(name + " " + number);
//	}
//	@PostMapping(value = "/api/building")
//	public Map<String, String> building3(@RequestBody Map<String, String> mapp) {
//		return mapp;
//	}
//	@DeleteMapping(value = "/api/building/{id}")
//	public void deleteBuilding(@PathVariable Integer id) {
//		System.out.println("Da xoa toa nha " + id);
//	}
//	@GetMapping(value = "/api/building")
//	public Object searchBuilding(@RequestBody BuildingDTO BuildingDTO) {
//		valiDate(BuildingDTO);
//		BuildingDTO result = new BuildingDTO();
//		result.setName(BuildingDTO.getName());
//		return result;
//	}
//	public void valiDate(BuildingDTO BuildingDTO) throws FieldRequiredException{
//		if(BuildingDTO.getName() == null || BuildingDTO.getName().isEmpty() || BuildingDTO.getNumber() == null) {
//			throw new FieldRequiredException("name or number is null");
//		}
//	}

}
