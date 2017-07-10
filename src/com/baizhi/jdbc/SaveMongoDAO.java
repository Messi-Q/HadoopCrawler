package com.baizhi.jdbc;

import java.util.List;

import com.mongodb.DBObject;

public interface SaveMongoDAO {
	public void save(String address,String url,String type);
	public List<DBObject> findAll(Integer page);
	public List<DBObject> findAllUrl();
	public void queyAll(DBObject obj);
}
