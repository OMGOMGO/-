package movie;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static movie.database.customer;

public class administrator {
public  String userName="admin";
public  String password="ynufo#777";
public boolean login=true;
void out(){
    login=false;
}
boolean enter(String userName,String password){
    if(userName.equals(this.userName)&&password.equals(this.password))
        return true;
    else
        return false;
  }
 void changeCode(){
     Scanner scanner=new Scanner(System.in);
     System.out.println("输入新密码：");
     password=scanner.nextLine();
     System.out.println("密码已修改");
 }
 void resetCode(){
     Iterator<userInformation> iter= customer.iterator();
     while (iter.hasNext()){
         iter.next().reset();
     }
     System.out.println("密码已重置");
 }
  void listUserInformation(){
      Iterator<userInformation> iter= customer.iterator();
      while (iter.hasNext()){
          iter.next().outprint();
      }
  }
  void deleteUserInformation(){
    System.out.println("删除第几个");
    Scanner scanner=new Scanner(System.in);
    int op=scanner.nextInt();
    System.out.println("是否确认删除 1.是 2.否");
    int op1=scanner.nextInt();
    if(op1==1) {
        if (op <= customer.size())
            customer.remove(op - 1);
        else
            System.out.println("输入错误");
    }
  }
  void findUserInformation(){
      Scanner scanner=new Scanner(System.in);
      System.out.println("输入用户名或ID");
      String str=scanner.nextLine();
    Iterator<userInformation> iter= customer.iterator();
    while (iter.hasNext()){
        userInformation user1=iter.next();
        if(str.equals(user1.id)||str.equals(user1.username)){
            System.out.println("以下是查找的信息：" );
            user1.outprint();
        }
    }

  }

}
