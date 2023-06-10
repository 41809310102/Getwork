package controller;

import Menu.Menu1;
import service.UserService;
import vo.User;

import java.sql.SQLException;
import java.util.Scanner;

public class loginController {

    public static void login() throws SQLException {
        Menu1 menu1 = new Menu1();
        menu1.loginAndSig();
        UserService userService = new UserService();
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        if(a==1){
            System.out.println("请输入你的个人信息:姓名");
            String username = scanner.next();
            System.out.println("请输入你的个人信息:学校");
            String schoolname  = scanner.next();
            User user = new User();
            user.setSchoolName(schoolname);
            user.setUsername(username);
            System.out.println("请设置你的密码");
            String password = scanner.next();
            System.out.println("请确认你的密码");
            String password1 = scanner.next();
            while (!password.equals(password1)){
                if(!password.equals(password1)){
                    System.out.println("两次密码不一致");
                    System.out.println("请重新确认");
                    password1 = scanner.next();
                }
            }
            user.setPassword(password);
            userService.addUser(user);
        }else if(a==2){
            System.out.println("请输入你的姓名");
            String username = scanner.next();
            System.out.println("请输入你的密码");
            String password = scanner.next();
            User user = new User();
            user.setUsername("'"+username+"'");
            user.setPassword("'"+password+"'");
            userService.selectUser(user);
        }
    }


    public static void main(String[] args) throws SQLException {
        login();
    }
}
