package movie;

import java.util.InputMismatchException;
import java.util.Scanner;

public class use {
    public static void main(String args[]) {
        database data = new database();
        int op2 = 1;
        while (op2 == 1){
            System.out.println("输入你的身份：");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if (str.equals("administrator")) {
            administrator admin = new administrator();
            System.out.println("输入用户名：");
            String userName1 = scanner.nextLine();
            System.out.println("输入密码：");
            String password1 = scanner.nextLine();
            if (admin.enter(userName1, password1)) {
                while (admin.login) {
                    System.out.println("输入接下来的操作：1.修改密码  2.重置用户密码  3.罗列用户信息  4.删除用户信息  5.查询用户信息  6.退出登入");
                    boolean flag=true;
                    int option = 0;
                    while (flag){
                        try {
                             option = scanner.nextInt();
                            flag=false;
                        }
                        catch (InputMismatchException e){
                            System.out.println("输入只能为整数,请再次输入：");
                        }
                    }

                    switch (option) {
                        case 1:
                            admin.changeCode();
                            break;
                        case 2:
                            admin.resetCode();
                            break;
                        case 3:
                            admin.listUserInformation();
                            break;
                        case 4:
                            admin.deleteUserInformation();
                            break;
                        case 5:
                            admin.findUserInformation();
                            break;
                        case 6:
                            admin.out();
                            break;
                    }
                }
                System.out.println("已退出登录");
            } else System.out.println("用户名或密码不正确");
        }
        if (str.equals("proscenium")) {
            proscenium pros = new proscenium();
            System.out.println("输入用户名：");
            String userName1 = scanner.nextLine();
            System.out.println("输入密码：");
            String password1 = scanner.nextLine();
            if (pros.enter(userName1, password1)) {
                while (pros.login) {
                    System.out.println("输入接下来的操作：1.列出所有影片信息 2.列出未来上映的的场次计划  3.列出场次信息  4.售票  5.退出登入");
                    boolean flag=true;
                    int option = 0;
                    while (flag){
                        try {
                            option = scanner.nextInt();
                            flag=false;
                        }
                        catch (InputMismatchException e){
                            System.out.println("输入只能为整数,请再次输入：");
                        }
                    }
                    switch (option) {
                        case 1:
                            pros.listMovieInformation();

                            break;
                        case 2:
                            pros.listChangciInformation();
                            break;
                        case 3:
                            pros.listMovieSeat();
                            break;
                        case 4:
                            pros.sellaTicket();
                            break;
                        case 5:
                            pros.out();
                            break;

                    }
                }
                System.out.println("已退出登录");
            } else System.out.println("用户名或密码不正确");

        }


        if (str.equals("manager")) {
            manager man = new manager();
            System.out.println("输入用户名：");
            String userName1 = scanner.nextLine();
            System.out.println("输入密码：");
            String password1 = scanner.nextLine();
            if (man.enter(userName1, password1)) {
                while (man.login) {
                    System.out.println("输入接下来的操作：1.列出正在上映的影片信息 2.添加影片信息 3.修改影片信息 4.删除影片信息 5.查询影片信息 " +
                            "6.增加场次 7.修改场次 8.删除场次 9.列出场次信息 10退出登录");
                    boolean flag=true;
                    int option = 0;
                    while (flag){
                        try {
                            option = scanner.nextInt();
                            flag=false;
                        }
                        catch (InputMismatchException e){
                            System.out.println("输入只能为整数,请再次输入：");
                        }
                    }
                    switch (option) {
                        case 1:
                            man.listMovieInformation();
                            break;
                        case 2:
                            man.addMovieInformation();
                            break;
                        case 3:
                            man.changeMovieInformation();
                            break;
                        case 4:
                            man.deleteMovieInformation();
                            break;
                        case 5:
                            man.findMovieInformation();
                            break;
                        case 6:
                            man.addChangciInformation();
                            break;
                        case 7:
                            man.changeChangciInformation();
                            break;
                        case 8:
                            man.deleteChangciInformation();
                            break;
                        case 9:
                            man.listChangciInformation();
                            break;
                        case 10:
                            man.out();
                            break;
                    }

                }
                System.out.println("已退出登录");
            }
        }


        if (str.equals("client")) {
            client cl = new client();
            System.out.println("输入接下来的操作：1.注册 2.登录  3.忘记密码");
            boolean flag=true;
            int option = 0;
            while (flag){
                try {
                    option = scanner.nextInt();
                    flag=false;
                }
                catch (InputMismatchException e){
                    System.out.println("输入只能为整数,请再次输入：");
                }
            }
            switch (option) {
                case 1:
                    cl.register();
                    break;
                case 2:
                    break;
                case 3:
                    cl.forgetPassword();
                    break;
            }
            if (cl.enter()) {
                while (cl.login) {
                    System.out.println("输入接下来的操作：1.修改密码  2.查看电影放映信息 3.查看指定电影放映信息 4.购票和付账  5.取票 6.退出登录");
                    boolean flag1=true;
                    int op1 = 0;
                    while (flag1){
                        try {
                            op1 = scanner.nextInt();
                            flag1=false;
                        }
                        catch (InputMismatchException e){
                            System.out.println("输入只能为整数,请再次输入：");
                        }
                    }
                    switch (op1) {
                        case 1:
                            cl.changePassword();
                            break;
                        case 2:
                            cl.listMovieInformation();
                            break;
                        case 3:
                            cl.listMovieChangci();
                            break;
                        case 4:
                            cl.buyTicket();
                            break;
                        case 5:
                            cl.getTicket();
                            break;
                        case 6:
                            cl.out();
                            break;
                    }

                }
            }

         }
        System.out.println("是否要继续操作：1.是 2.否");
            boolean flag=true;
            while (flag){
                try {
                    op2= scanner.nextInt();
                    flag=false;
                }
                catch (InputMismatchException e){
                    System.out.println("输入只能为整数,请再次输入：");
                }
            }
       }
    }
}

