package movie;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;


import static movie.database.customer;
import static movie.database.movieTotal;

public class client {
    public boolean login=true;
    public static int  choseSeat[][]=new int[20][5];
    public static long startTime[]=new long[20];
   public static int i=0;
    void out(){
        login=false;
    }
    void register(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username=scanner.nextLine();
        while (username.length()<5){
            System.out.println("用户名长度应大于5");
            username=scanner.nextLine();
        }
        System.out.println("请输入密码:");
         String password=scanner.nextLine();
         while (!isPassword(password)){
             System.out.println("密码长度应大于8，且要包含大小写字母、数字和标点符号");
             password=scanner.nextLine();
         }
         customer.add(new userInformation("",username,"铜牌","","","","",password));
         System.out.println("注册成功");

    }

    private static boolean isPassword(String password) {
        if (password.length() <= 8) {
            return false;
        }

        boolean hasLowerCase = false;
        boolean hasUpperCase = false;
        boolean hasDigit = false;
        boolean hasPunctuation = false;

        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (isPunctuation(c)) {
                hasPunctuation = true;
            }
        }

        return hasLowerCase && hasUpperCase && hasDigit && hasPunctuation;
    }
    private static boolean isPunctuation(char c) {
        String punctuation = " .,!@#$%^&*()-=_+[]{}|;':\"<>/";
        return punctuation.contains(String.valueOf(c));
    }
   boolean enter(){
        Scanner scanner=new Scanner(System.in);
        String userName1=null;
        String password1=null;
        boolean try1=false;
        for(int i=0;i<5;i++) {
            System.out.println("请输入用户名：");
             userName1=scanner.nextLine();
            System.out.println("请输入密码：");
             password1=scanner.nextLine();
            Iterator<userInformation> iter=customer.iterator();
            while (iter.hasNext()) {
              userInformation uesr1=iter.next();
                if (userName1.equals(uesr1.username) && password1.equals(uesr1.code)) {
                    try1=true;
                    break;
                }
            }
            if(try1){
                System.out.println("登录成功");
                break;
            }
            else {
                System.out.println("用户名或密码不正确");
            }
        }
        if(try1){
            return true;
        }
        else {
            System.out.println("五次输入错误密码已锁定");
            return false;
        }
    }
    void changePassword(){
        boolean try1=false;
           Scanner scanner=new Scanner(System.in);
        System.out.println("请输入用户名：");
        String userName1=scanner.nextLine();
        System.out.println("请输入旧密码：");
        String password1=scanner.nextLine();
            System.out.println("请输入新密码");
            String password=scanner.nextLine();
            while (!isPassword(password)){
                System.out.println("密码长度应大于8，且要包含大小写字母、数字和标点符号");
                password=scanner.nextLine();
            }
            Iterator<userInformation> iter=customer.iterator();
            while (iter.hasNext()){
                userInformation user1=iter.next();
               if(userName1.equals(user1.username)&&password1.equals(user1.code)){
                   user1.setCode(password1);
                   System.out.println("密码修改完成");
                   try1=true;
                   break;
               }
            }
        if(!try1)  System.out.println("用户名或密码不正确");
    }
   void  forgetPassword(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入用户名：");
        String username1=scanner.nextLine();
        System.out.println("输入接下来的操作：1.发送验证码到邮箱   2.随机发送初始密码到邮箱");
        int option=scanner.nextInt();
        if(option==1){
            Iterator<userInformation> iter=customer.iterator();
            while (iter.hasNext()){
                userInformation use1=iter.next();
                if(username1.equals(use1.username)){
                   use1.sendVerificationCode();
                    break;
                }
            }

        }
        else if(option==2){
            Iterator<userInformation> iter=customer.iterator();
            while (iter.hasNext()){
                userInformation use1=iter.next();
                if(username1.equals(use1.username)){
                    use1.sendRandomPassword();
                    break;
                }
            }
        }
        else ;
   }
  void  listMovieInformation(){
      Iterator<movieInformation> iter=movieTotal.iterator();
      while (iter.hasNext()){
          iter.next().outprint();
      }
  }
  void listMovieChangci(){
      Scanner scanner=new Scanner(System.in);
      System.out.println("输入要罗列场次的为第几个电影：");
      int op=scanner.nextInt();
      movieTotal.get(op-1).outprintChangci();
  }
  void buyTicket(){
        Scanner scanner=new Scanner(System.in);
      int op2=1;
      while (op2==1) {

          Timer timer=new Timer();
          System.out.println("要查找第几个电影");
          int op = scanner.nextInt();
          System.out.println("电影场次为多少：");
          int op1 = scanner.nextInt();
          String money=movieTotal.get(op-1).changci[op1-1][2];
          long endTime=System.currentTimeMillis();
          for (int j=0;j<7;j++) {
              if(choseSeat[j][4]==0&&startTime[j]!=0) {
                  System.out.println((endTime - startTime[j]) / 1000);
                  if ((endTime - startTime[j]) / 1000 > 30) {
                      movieTotal.get(choseSeat[j][0]-1).seat[choseSeat[j][1]-1][choseSeat[j][2]-1][choseSeat[j][3]-1]="O";
                  }
              }
          }
          movieTotal.get(op-1).outprintSeat(op1);
          System.out.println("要买的座位是第几列(1~11)：");
          int column = scanner.nextInt();
          System.out.println("要买的座位是第几行(1~7)：");
          int row = scanner.nextInt();
          if(movieTotal.get(op-1).suoDing[op1-1][row-1][column-1]){
              System.out.println("座位已被锁定,重新输入");
              continue;
          }
          startTime[i]=System.currentTimeMillis();
          movieTotal.get(op-1).suoDing[op1-1][row-1][column-1]=true;
          movieTotal.get(op - 1).sellTicket(op1, row, column, "");
          System.out.println("已锁定座位");
          if (payTicket(money)) {
                  movieTotal.get(op - 1).makeMovieId(op1, row, column);
                  movieTotal.get(op - 1).getMovieId(op1, row, column);
                  choseSeat[i][4]=1;
              }
          choseSeat[i][0]=op;
          choseSeat[i][1]=op1;
          choseSeat[i][2]=row;
          choseSeat[i][3]=column;

          System.out.println("是否要继续购票：1.是 2.否");
          op2 = scanner.nextInt();
          i=i+1;
      }
  }
  boolean payTicket(String money){
        int money1=Integer.parseInt(money);
        Scanner scanner=new Scanner(System.in);
        String rank1 = null;
        System.out.println("请输入用户名：");
        String username1=scanner.nextLine();
      Iterator<userInformation> iter=customer.iterator();
      while (iter.hasNext()){
          userInformation use1=iter.next();
          if(username1.equals(use1.username)){
              rank1=use1.userRank;
              break;
          }
      }
      if(rank1.equals("金牌")){
          System.out.println("价钱为："+money1*0.7);
      }
      else if(rank1.equals("银牌")){
          System.out.println("价钱为："+money1*0.8);
      }
      else if(rank1.equals("铜牌")){
          System.out.println("价钱为："+money1*0.9);
      }
      else System.out.println("用户名输入错误");
      System.out.println("是否购买：1.是 2.否");
      int option=scanner.nextInt();
      if(option==1) {return true;}
      else {return false;}
  }
  void getTicket(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入电影ID：");
        String moiveid=scanner.nextLine();
      System.out.println("要查找第几个电影");
      int op = scanner.nextInt();
      System.out.println("电影场次为多少：");
      int op1 = scanner.nextInt();
      System.out.println("要买的座位是第几列(0~11)：");
      int column = scanner.nextInt();
      System.out.println("要买的座位是第几行(0~9)：");
      int row = scanner.nextInt();
      if(movieTotal.get(op-1).movieId[op1-1][row-1][column-1]==null){
          System.out.println("票已被取走");
      }
      else if(moiveid.equals(movieTotal.get(op-1).movieId[op1-1][row-1][column-1])){
          movieTotal.get(op-1).takeTicket(op1,row,column);
          System.out.println("取票成功");
      }
      else System.out.println("电影ID输入错误");

  }
}
