package com.baizhi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class SaveAddressImpl implements SaveAddressDAO {
	private static Connection conn;
	private static String sql;
	private static Statement stmt;
	static {
		try {
			// 建立数据库的连接 连接Mysql
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306?useUnicode=true&characterEncoding=utf8";
			conn = DriverManager.getConnection(dburl, "root", "1234");
			System.out.println(" 连接已经建立！ ");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	@Override
	public void save(String address) {
		// TODO Auto-generated method stub
		sql = "select * from url where status = '0'";

		try {
			// 做if条件判断 查看表中是否已经添加相同的Url 假设该url已经存在则不添加
			ResultSet rs = stmt.executeQuery(sql);
			if (!rs.next()) {
				sql = "insert into url (url,status) values";
				Statement stmt = conn.createStatement();
				stmt.execute(sql);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

