package com.clound.sacrifice.dao;

import com.clound.sacrifice.module.HeroPic;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zxs
 * @version 1.0
 * @date 2020/3/30 19:20
 */
@Repository
public interface Picmapper {

	List<HeroPic> getLastPic();

	List<HeroPic> getFirstPic();
}