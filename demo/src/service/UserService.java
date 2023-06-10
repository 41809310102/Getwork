package service;

import utils.configDb;
import vo.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    configDb  configDb = new configDb();

    private Connection DB = configDb.connectionMysql();


    //用户信息添加
    public int addUser(User user) throws SQLException {

        //sql脚本编写
        String sql = "INSERT INTO user(age,username,password,sex,project,shcoolname,sfz) VALUES (?,?,?,?,?,?,?);";

        //预编译
        PreparedStatement ptmt = this.DB.prepareStatement(sql); //预编译SQL，减少sql执行

        //传参
        ptmt.setInt(1,user.getAge());
        ptmt.setString(2,user.getUsername());
        ptmt.setString(3,user.getPassword());
        ptmt.setString(4,user.getSex());
        ptmt.setInt(5,user.getProject());
        ptmt.setString(6,user.getSchoolName());
        ptmt.setString(7,user.getSfz());

        //执行
        boolean res = ptmt.execute();
        System.out.println(res);
        if(res){
            System.out.println("用户信息添加成功");
            return 1;
        }else{
            System.out.println("用户信息添加失败");
            return -1;
        }
    }

    //用户信息查找
    public int selectUser(User user) throws SQLException {

        //sql脚本编写
        String sql = "select * from user where username="+user.getUsername()+" and password="+user.getPassword();

        //数据库链接
        Statement stmt = this.DB.createStatement();

        //预编译
        ResultSet res = stmt.executeQuery(sql);
        List<User> userList = new ArrayList<>();
        while (res.next()){
            User user1 = new User();
            user1.setId(res.getInt("id"));
            user1.setSex(res.getString("sex"));
            user1.setSfz(res.getString("sfz"));
            user1.setAge(res.getInt("age"));
            user1.setSchoolName(res.getString("shcoolname"));
            user1.setPassword(res.getString("password"));
            user1.setUsername(res.getString("username"));
            System.out.println(user1.toString());
            userList.add(user1);
        }
        if(userList.size()==1){
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }
        return 0;
    }


    public static void main(String[] args) throws SQLException {
        UserService userService = new UserService();
        User user = new User();
        user.setUsername("'胡俊杰'");
        user.setPassword("'123456'");
        userService.selectUser(user);
    }
}
