package com.hpugs.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.hpugs.main.data.UserData;
import com.hpugs.mian.po.User;

/**
 * @Description 类描述
 * @author 高尚
 * @version 1.0
 * @date 创建时间：2017年12月7日 下午12:00:20
 */
public class UserTest {

	@Test
	public void addUser() throws SQLException{
		User user = new User();
		user.setName("hpugs");
		user.setMobile("18300602558");
		user.setPwd("123456");
		user.setBirthday(new Date());
		user.setState(1);
		boolean flag = UserData.addObject(user);
		if(flag){
			System.out.println("添加成功");
		}else{
			System.err.println("添加失败");
		}
	}
	
	@Test
	public void addMoreUser() throws SQLException{
		List<User> users = new ArrayList<User>();
		for (int i=0; i<10; i++) {
			User user = new User();
			user.setName("hpugs"+i);
			user.setMobile("1830060255"+i);
			user.setPwd("123456");
			user.setBirthday(new Date());
			if(0 != i && 0 == i%4){
				user.setState(2);
			}else{
				user.setState(1);
			}
			users.add(user);
		}
		boolean flag = UserData.addMoreObject(users);
		if(flag){
			System.out.println("添加成功");
		}else{
			System.err.println("添加失败");
		}
	}
	
	@Test
	public void getObjectTest() throws SQLException{
		User user = UserData.getObjectById(20);
		if(null != user){
			System.out.println(user.toString());
		}else{
			System.err.println("数据库查询错误");
		}
	}
	
	@Test
	public void updateObjectTest() throws SQLException{
		User user = UserData.getObjectById(20);
		if(null != user){
			user.setState(2);
			boolean flag = UserData.updateObject(user);
			if(flag){
				System.out.println("数据库修改成功");
			}else{
				System.err.println("数据库修改错误");
			}
		}else{
			System.err.println("数据库查询错误");
		}
	}
	
	@Test
	public void deleteObjectTest() throws SQLException{
		boolean flag = UserData.delObjectById(23);
		if(flag){
			System.out.println("数据库删除成功");
		}else{
			System.err.println("数据库删除错误");
		}
	}
	
	@Test
	public void getUserCountTest() throws SQLException{
		Integer count = UserData.getObjectCount("");
		System.out.println("数据总数：" + count);
	}
	
	@Test
	public void getUserListTest() throws SQLException{
		List<User> users = UserData.getSomeObject("WHERE state = 1 ", 3, 3);
		System.out.println(users.toString());
	}
	
}
