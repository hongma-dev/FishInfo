package com.fish.hongma.fish.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fish.hongma.fish.service.FishInfoService;
import com.fish.hongma.fish.service.FishInfoVO;

@Service
public class FishInfoServiceImpl implements FishInfoService{

	

	@Autowired
	FishInfoDAO fishInfoDAO;
	
	@Override
	public List<FishInfoVO> getFishInfos()  {
		List<FishInfoVO> result = null;
		
		
		try {
			result = fishInfoDAO.getFishInfos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	
}
