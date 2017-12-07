package com.hpugs.main.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Description mysql数据库连接类
 * @author 高尚
 * @version 1.0
 * @date 创建时间：2017年12月7日 上午10:21:55
 */
public class DB_Mysql {

	//数据库连接参数
	private static final String DBDRIVER="org.gjt.mm.mysql.Driver";//数据库驱动地址
	private static final String DBURL="jdbc:mysql://localhost:3306/hpugs";//数据库连接地址
    private static final String DBNAME="root";//数据库账户
    private static final String DBPAW="root";//数据库密码
    
    //加载数据库驱动
    static{
        try {
            Class.forName(DBDRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    //获得数据库连接
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = (Connection) DriverManager.getConnection(DBURL, DBNAME, DBPAW);//获得数据库连接对象
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    //关闭数据库操作
    public static void close(ResultSet rs, Statement st, Connection conn){
        try {
            if(rs!=null){
                rs.close();
            }
            if(st!=null){
            	st.close();
            }
            if(conn!=null){
            	conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //关闭数据库操作方法重载
    public static void close(Statement st, Connection conn){
        close(null, st, conn);
    }
	
}
