package com.baizhi.jdbc;

import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

public class SaveDetailsMongo {
	private static Mongo mongo;
	private static DB db;
	private static DBCollection dbCollection;
	static{
		// TODO Auto-generated method stub
		try {
			mongo = new Mongo("127.0.0.1",27017);
			db = mongo.getDB("hadoop");
			dbCollection=db.getCollection("hs");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
		}
	}
	public static void save(String number,String name){
		DBObject dbObject = new BasicDBObject();
		dbObject.put("phone", number);
		dbObject.put("name", name);
		dbObject.put("date", new Date());
		dbObject.put("status", "1");
		dbCollection.save(dbObject);
	}
	public static List<DBObject> find(){
		DBCursor find = dbCollection.find();
		return find.toArray();
	}	
}
