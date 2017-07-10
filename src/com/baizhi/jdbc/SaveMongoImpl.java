package com.baizhi.jdbc;

import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

import com.baizhi.pc.UtilCra;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

public class SaveMongoImpl implements SaveMongoDAO {
	private static Mongo mongo;
	private static DB db;
	private static DBCollection dbCollection;
	
	static{
		// TODO Auto-generated method stub
		try {
			mongo = new Mongo("127.0.0.1",27017);
			db = mongo.getDB("hadoop");
			dbCollection=db.getCollection("add");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
		}
	}
	
	@Override
	public void save(String address,String url,String type) {
		// TODO Auto-generated method stub
		DBObject db = new BasicDBObject();
		if(url.length()<100){
			db.put("url", url);
			db.put("address", address);
			if("one".equals(type)){
				db.put("type", UtilCra.loc);
			}
			else{
				db.put("type", UtilCra.loc_hs);
			}
			db.put("date", new Date());
			db.put("status", 1);
			dbCollection.save(db);
		}
	}
	@Override
	public List<DBObject> findAll(Integer page) {
		// TODO Auto-generated method stub
		DBCursor find = dbCollection.find().skip(page).limit(20).sort(new BasicDBObject("date",-1));
		List<DBObject> array = find.toArray();
		return array;
	}
	@Override
	public void queyAll(DBObject obj) {
		// TODO Auto-generated method stub
		DBObject dbObject = new BasicDBObject();
		dbObject.put("url", obj.get("url"));
		DBObject set1 = new BasicDBObject();
		set1.put("status",2);
		DBObject set2 = new BasicDBObject();
		set2.put("$set", set1);
		dbCollection.update(dbObject, set2, false, true);
	}
	@Override
	public List<DBObject> findAllUrl() {
		// TODO Auto-generated method stub
		DBCursor find = dbCollection.find();
		List<DBObject> array = find.toArray();
		return array;
	}

}
