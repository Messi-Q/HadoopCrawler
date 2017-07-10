package com.baizhi.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class TestHadoop {
	private static Connection conn;
	private static String sql;
	private static Statement stmt;
	static {
		try {
			// 建立数据库的连接 连接Mysql
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/crawler";
			conn = DriverManager.getConnection(dburl, "root", "1234");
			stmt = conn.createStatement();
			System.out.println(" 连接已经建立！ ");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}	
	@Test
	public void test() {
		sql = "insert into cra (url,date,address,status) values ('123123',now(),'asdsad',2)";

			// 做if条件判断 查看表中是否已经添加相同的Url 假设该url已经存在则不添加
			try {
				//ResultSet rs = stmt.executeQuery(sql);
				stmt.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// TODO Auto-generated catch block
		}
}
