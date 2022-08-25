package com.changke.coursemanagementsystem.tools;

import java.sql.*;

/**
 * 使用单例模式创建DBUtils
 */
public class DBUtils {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String NAME = "changke";
	private static final String URL = "jdbc:mysql://localhost:3306/" + NAME
			+ "?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "898721";

	private DBUtils() {
	}

	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("驱动未找到或版本错误");
		}
	}

	public static DBUtils getInstence() {
		return new DBUtils();
	}

	private Connection getConntion() {
		try {
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
		}
	}

	/**
	 * 增加、删除、更改
	 */
	public int updata(String sql, Object... args) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConntion();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			return ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(conn, ps);
		}
	}

	public ResultSet query(String sql) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConntion();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			return rs;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
		}
	}

	public ResultSet query(String sql, Object... args) {
		PreparedStatement ps = null;
		try {
			ps = getConntion().prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			return ps.executeQuery();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
		}
	}

	private void close(Connection conn, PreparedStatement ps) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

}
