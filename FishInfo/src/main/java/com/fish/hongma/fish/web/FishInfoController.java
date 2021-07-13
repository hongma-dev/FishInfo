package com.fish.hongma.fish.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fish.hongma.fish.service.FishInfoVO;
import com.fish.hongma.fish.service.impl.FishInfoServiceImpl;

@RestController
@RequestMapping(path="/fish")
public class FishInfoController {

	@Autowired
	FishInfoServiceImpl fishInfoServiceImpl;
	
	@GetMapping(path="/getFishInfos")
	public @ResponseBody List<FishInfoVO> getFishInfos() {
		
		List<FishInfoVO> result = fishInfoServiceImpl.getFishInfos();
		
		return result;
	}
	
}
