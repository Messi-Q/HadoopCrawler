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
			// �������ݿ������ ����Mysql
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/crawler";
			conn = DriverManager.getConnection(dburl, "root", "1234");
			stmt = conn.createStatement();
			System.out.println(" �����Ѿ������� ");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}	
	@Test
	public void test() {
		sql = "insert into cra (url,date,address,status) values ('123123',now(),'asdsad',2)";

			// ��if�����ж� �鿴�����Ƿ��Ѿ������ͬ��Url �����url�Ѿ����������
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
