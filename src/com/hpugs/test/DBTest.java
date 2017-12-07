package com.hpugs.test;

import java.sql.Connection;

import org.junit.Test;

import com.hpugs.main.db.DB_Mysql;
import com.hpugs.main.db.DB_SqlServer;

/**
 * @Description 数据库连接测试
 * @author 高尚
 * @version 1.0
 * @date 创建时间：2017年12月7日 上午10:22:21
 */
public class DBTest {
	
	@Test
	public void mysqlConnectTest(){
		Connection connection = DB_Mysql.getConnection();
		if(null != connection){
			System.out.println("mysql数据库连接正常");
		}else{
			System.err.println("mysql数据库连接异常");
		}
	}
	
	@Test
	public void sqlServerConnectTest(){
		Connection connection = DB_SqlServer.getConnection();
		if(null != connection){
			System.out.println("sqlServer数据库连接正常");
		}else{
			System.err.println("sqlServer数据库连接异常");
		}
	}

}
