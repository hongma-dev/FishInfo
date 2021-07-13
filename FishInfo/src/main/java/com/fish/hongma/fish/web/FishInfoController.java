package com.fish.hongma.fish.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fish.hongma.fish.service.FishInfoService;
import com.fish.hongma.fish.service.FishInfoVO;
import com.fish.hongma.fish.service.FishKey;

@RestController
@RequestMapping(path="/fish")
public class FishInfoController {

	@Autowired
	FishInfoService fishInfoService;
	
	@GetMapping(path="/getFishInfos")
	public @ResponseBody List<FishInfoVO> getFishInfos() {
		
		List<FishInfoVO> result = fishInfoService.getFishInfos();
		
		return result;
	}
	
	
	@GetMapping(path="/getFishInfo/{fshlcNm}/{latitude}/{longitude}")
	public @ResponseBody FishInfoVO getFishInfo(@PathVariable String fshlcNm, @PathVariable String latitude, 
			@PathVariable String longitude) {
		
		FishInfoVO searchVO = new FishInfoVO();
		searchVO.setFshlcNm(fshlcNm);
		searchVO.setLatitude(latitude);
		searchVO.setLongitude(longitude);
		
		FishInfoVO result = fishInfoService.getFishInfo(searchVO);
		
		return result;
	}
	
}
