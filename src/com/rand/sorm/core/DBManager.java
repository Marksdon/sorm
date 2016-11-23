package com.rand.sorm.core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.rand.sorm.bean.Configuration;

/**
 * 根据配置信息,维持管理数据库连接
 * @author randall
 *
 */
public class DBManager {

	/**
	 * 配置资源对象
	 */
	private static Configuration conf;

	static {
		Properties pros = new Properties();
		try {
			//1.加载资源配置文件进来
			pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
			//2载入配置信息
			conf.setDriver(pros.getProperty("driver"));
			conf.setUrl(pros.getProperty("url"));
			conf.setUser(pros.getProperty("user"));
			conf.setPwd(pros.getProperty("pwd"));
			conf.setUsingDB(pros.getProperty("usingDB"));
			conf.setSrcPath(pros.getProperty("srcPath"));
			conf.setPoPackage(pros.getProperty("poPackage"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * 获取{@link Connection}对象,建立数据连接
	 * @return {@link Connection}对象
	 */
	public static Connection getConn(){
		//加载驱动类
		try {
			Class.forName(conf.getDriver());
			//获取连接并且返回
			return DriverManager.getConnection(conf.getUrl(), 
					conf.getUser(), conf.getPwd());

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 关闭若干个{@link Connection}对象
	 * @param conn {@link Connection}对象
	 */
	public static void close(Connection ...conn){
		for (Connection c : conn) {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				c = null;
			}
		}
	}
	
	
	/**
	 * 关闭若干个结果集对象
	 * @param rs {@link ResultSet}对象
	 */
	public static void close(ResultSet ...rs){
		for (ResultSet r : rs) {
			try {
				r.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				r = null;
			}
		}
	}
	
	/**
	 * 关闭若干个{@link Statement}对象
	 * @param stmt
	 */
	public static void close(Statement ...stmt){
		for (Statement s : stmt) {
			try {
				s.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				s = null;
			}
		}
	}
	
	
}
