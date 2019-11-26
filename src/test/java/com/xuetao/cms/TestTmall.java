package com.xuetao.cms;
  
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestTmall {
  
    public static void main(String args[]){
        //准备分类测试数据：
  
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
  
        try (
                Connection c = DriverManager.getConnection("jdbc:mysql://47.101.196.193:3306/tmall_springboot?useUnicode=true&characterEncoding=utf8",
                        "root", "123456");
                Statement s = c.createStatement();
        )
        {
            for (int i = 1; i <=100 ; i++) {
                String sqlFormat = "insert into user values (null, '测试用户%d','123456' , null)";
                String sql = String.format(sqlFormat, i);
                s.execute(sql);
            }
             
            System.out.println("已经成功创建100条测试数据");
  
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
  
    }
  
}