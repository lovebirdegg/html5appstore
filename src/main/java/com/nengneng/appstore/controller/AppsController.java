package com.nengneng.appstore.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nengneng.appstore.model.App;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/apps") // 通过这里配置使下面的映射都在/apps下，可去除
public class AppsController {

	static Map<Integer, App> apps = Collections.synchronizedMap(new HashMap<Integer, App>());

	@ApiOperation(value = "获取app列表", notes = "")
	@RequestMapping(value = { "" }, method = RequestMethod.GET)
	public List<App> getappList() {
		List<App> r = new ArrayList<App>(apps.values());
		return r;
	}
	
	@ApiOperation(value = "创建app", notes = "根据app对象创建app")
	@ApiImplicitParam(name = "app", value = "app详细实体app", required = true, dataType = "App")
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String postapp(@RequestBody App app) {
		apps.put(app.getId(), app);
		return "success";
	}

	@ApiOperation(value = "获取app详细信息", notes = "根据url的id来获取app详细信息")
	@ApiImplicitParam(name = "id", value = "appID", required = true, dataType = "Integer")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public App getapp(@PathVariable Integer id) {
		return apps.get(id);
	}

	@ApiOperation(value = "更新app详细信息", notes = "根据url的id来指定更新对象，并根据传过来的app信息来更新app详细信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "appID", required = true, dataType = "Integer"),
			@ApiImplicitParam(name = "app", value = "app详细实体app", required = true, dataType = "App") })
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String putapp(@PathVariable int id, @RequestBody App app) {
		App u = apps.get(id);
		u.setName(app.getName());
		apps.put(id, u);
		return "success";
	}

	@ApiOperation(value = "删除app", notes = "根据url的id来指定删除对象")
	@ApiImplicitParam(name = "id", value = "appID", required = true, dataType = "Integer")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteapp(@PathVariable int id) {
		apps.remove(id);
		return "success";
	}

}
