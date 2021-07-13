package com.fish.hongma.fish.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fish.hongma.fish.service.FishInfoVO;

@Mapper
public interface FishInfoDAO {
	
	public List<FishInfoVO> getFishInfos();
	
	public FishInfoVO getFishInfo(FishInfoVO vo);
}
