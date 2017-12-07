package com.hpugs.main.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.hpugs.main.db.DB_Mysql;
import com.hpugs.mian.po.User;
import com.mysql.jdbc.Statement;

/**
 * @Description 用户对象
 * @author 高尚
 * @version 1.0
 * @date 创建时间：2017年12月7日 上午10:40:49
 */
public class UserData {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/**
	 * @Description 添加用户
	 * @return
	 *
	 * @author 高尚
	 * @version 1.0
	 * @throws SQLException 
	 * @date 创建时间：2017年12月7日 上午10:48:10
	 */
	public static boolean addObject(final User user) throws SQLException{
		boolean flag = false;
		Connection connection = DB_Mysql.getConnection();
		String sql = "INSERT INTO user (name, mobile, pwd, birthday, state) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, user.getName());
		preparedStatement.setString(2, user.getMobile());
		preparedStatement.setString(3, user.getPwd());
		preparedStatement.setString(4, sdf.format(user.getBirthday()));
		preparedStatement.setInt(5, user.getState());
		int n = preparedStatement.executeUpdate();
		DB_Mysql.close(preparedStatement, connection);
		if(0 < n){
			flag = true;
		}
		return flag;
	}
	
	/**
	 * @Description 批量添加用户
	 * @return
	 *
	 * @author 高尚
	 * @version 1.0
	 * @throws SQLException 
	 * @date 创建时间：2017年12月7日 上午10:48:26
	 */
	public static boolean addMoreObject(final List<User> users) throws SQLException{
		boolean flag = true;
		Connection connection = DB_Mysql.getConnection();
		String sql = "INSERT INTO user (name, mobile, pwd, birthday, state) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		connection.setAutoCommit(false);
		for (User user : users) {
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getMobile());
			preparedStatement.setString(3, user.getPwd());
			preparedStatement.setString(4, sdf.format(user.getBirthday()));
			preparedStatement.setInt(5, user.getState());
			preparedStatement.addBatch();
		}
		int [] ns = preparedStatement.executeBatch();
		connection.commit();
		connection.setAutoCommit(true);
		DB_Mysql.close(preparedStatement, connection);
		for (int n : ns) {
			if(0 > n){
				flag = false;
				break;
			}
		}
		return flag;
	}
	
	/**
	 * @Description 根据Id删除用户
	 * @return
	 *
	 * @author 高尚
	 * @version 1.0
	 * @throws SQLException 
	 * @date 创建时间：2017年12月7日 上午10:48:49
	 */
	public static boolean delObjectById(final Integer id) throws SQLException{
		boolean flag = false;
		Connection connection = DB_Mysql.getConnection();
		Statement statement = (Statement) connection.createStatement();
		String sql = "DELETE FROM user WHERE id = " + id;
		int n = statement.executeUpdate(sql);
		if(0 < n){
			flag = true;
		}
		DB_Mysql.close(statement, connection);
		return flag;
	}
	
	/**
	 * @Description 更新用户
	 * @return
	 *
	 * @author 高尚
	 * @version 1.0
	 * @throws SQLException 
	 * @date 创建时间：2017年12月7日 上午10:49:16
	 */
	public static boolean updateObject(final User user) throws SQLException{
		boolean flag = false;
		Connection connection = DB_Mysql.getConnection();
		String sql = "UPDATE user SET name=?, mobile=?, pwd=?, birthday=?, state=? WHERE id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, user.getName());
		preparedStatement.setString(2, user.getMobile());
		preparedStatement.setString(3, user.getPwd());
		preparedStatement.setString(4, sdf.format(user.getBirthday()));
		preparedStatement.setInt(5, user.getState());
		preparedStatement.setInt(6, user.getId());
		int n = preparedStatement.executeUpdate();
		DB_Mysql.close(preparedStatement, connection);
		if(0 < n){
			flag = true;
		}
		return flag;
	}
	
	/**
	 * @Description 根据Id查询对象
	 * @return
	 *
	 * @author 高尚
	 * @version 1.0
	 * @throws SQLException 
	 * @date 创建时间：2017年12月7日 上午10:49:36
	 */
	public static User getObjectById(final Integer id) throws SQLException{
		User user = null;
		Connection connection = DB_Mysql.getConnection();
		Statement statement = (Statement) connection.createStatement();
		String sql = "SELECT * FROM user WHERE id = " + id;
		ResultSet resultSet = statement.executeQuery(sql);
		while(resultSet.next()){
			user = new User();
			user.setId(resultSet.getInt("id"));
			user.setName(resultSet.getString("name"));
			user.setMobile(resultSet.getString("mobile"));
			user.setPwd(resultSet.getString("pwd"));
			user.setBirthday(resultSet.getDate("birthday"));
			user.setState(resultSet.getInt("state"));
		}
		DB_Mysql.close(resultSet, statement, connection);
		return user;
	}
	
	/**
	 * @Description 查询记录总数
	 * @return
	 *
	 * @author 高尚
	 * @version 1.0
	 * @throws SQLException 
	 * @date 创建时间：2017年12月7日 上午10:49:57
	 */
	public static Integer getObjectCount(final String whereParam) throws SQLException{
		Integer count = 0;
		Connection connection = DB_Mysql.getConnection();
		Statement statement = (Statement) connection.createStatement();
		String sql = "SELECT count(1) AS count FROM user " + whereParam;
		ResultSet resultSet = statement.executeQuery(sql);
		while(resultSet.next()){
			count = resultSet.getInt("count");
		}
		DB_Mysql.close(resultSet, statement, connection);
		return count;
	}
	
	/**
	 * @Description 分页加载用户数据
	 * @return
	 *
	 * @author 高尚
	 * @version 1.0
	 * @throws SQLException 
	 * @date 创建时间：2017年12月7日 上午10:50:25
	 */
	public static List<User> getSomeObject(final String whereParam, final Integer firstIndex, final Integer maxResult) throws SQLException{
		List<User> userList = new ArrayList<User>();
		Connection connection = DB_Mysql.getConnection();
		Statement statement = (Statement) connection.createStatement();
		String sql = "SELECT * FROM user ";
		if(null != whereParam){
			sql += whereParam + "LIMIT " + firstIndex + "," + maxResult;
		}else{
			sql += "LIMIT " + firstIndex + "," + maxResult;
		}
		ResultSet resultSet = statement.executeQuery(sql);
		while(resultSet.next()){
			User user = new User();
			user.setId(resultSet.getInt("id"));
			user.setName(resultSet.getString("name"));
			user.setMobile(resultSet.getString("mobile"));
			user.setPwd(resultSet.getString("pwd"));
			user.setBirthday(resultSet.getDate("birthday"));
			user.setState(resultSet.getInt("state"));
			userList.add(user);
		}
		DB_Mysql.close(resultSet, statement, connection);
		return userList;
	}

}
