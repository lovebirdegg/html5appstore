package com.nengneng.appstore.mapper;

import java.util.ArrayList;

import com.nengneng.appstore.model.App;

public interface AppMapper {
	public App findAppInfo();
	public ArrayList<App> findAllApp();
}
