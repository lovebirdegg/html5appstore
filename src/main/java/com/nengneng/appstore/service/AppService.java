package com.nengneng.appstore.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nengneng.appstore.mapper.AppMapper;
import com.nengneng.appstore.model.App;
@Service
public class AppService {
	@Autowired
	private AppMapper appMapper;

	public App getAppInfo() {

		App app = appMapper.findAppInfo();
		return app;
	}
	
	public ArrayList<App> getAllApp(){
		ArrayList<App> apps = appMapper.findAllApp();
		return apps;
	}
}
