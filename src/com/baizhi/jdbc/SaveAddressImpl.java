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
			// �������ݿ������ ����Mysql
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306?useUnicode=true&characterEncoding=utf8";
			conn = DriverManager.getConnection(dburl, "root", "1234");
			System.out.println(" �����Ѿ������� ");

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
			// ��if�����ж� �鿴�����Ƿ��Ѿ������ͬ��Url �����url�Ѿ����������
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

