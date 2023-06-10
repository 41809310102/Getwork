package utils;

import com.mysql.cj.jdbc.ConnectionImpl;

import java.sql.*;

public class configDb {
    public String password = "318422";
    public String username = "root";
    public String driver = "com.mysql.cj.jdbc.Driver";
    public String port = "3306";
    public String host = "127.0.0.1";
    public String database = "getWork";

    public Connection connection = null;

    public Connection connectionMysql(){

        try {
            Class.forName(this.driver);
            this.connection = DriverManager.getConnection("jdbc:mysql://"+this.host+":"+this.port+"/"+this.database+"?characterEncoding=utf-8&serverTimezone=UTC",
                    this.username,this.password);
            System.out.println("数据库连接成功");
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return this.connection;
    }

    // 关闭资源
    public static void close(Connection con, Statement stat, ResultSet rs) throws SQLException {

        if (con != null && !con.isClosed()) {
            con.close();
        }
        if (stat != null && !stat.isClosed()) {
            stat.close();
        }
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }

    }

    public static void main(String[] args) {
        configDb configDb = new configDb();
        configDb.connectionMysql();
    }


}
