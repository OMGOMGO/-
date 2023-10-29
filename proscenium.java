package movie;

import java.util.Iterator;
import java.util.Scanner;

import static movie.client.choseSeat;
import static movie.client.startTime;
import static movie.database.movieTotal;

public class proscenium {
    public String userName="proscenium";
    public  String password="ynufo#776";
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
    void listMovieInformation(){
        Iterator<movieInformation> iter=movieTotal.iterator();
        while (iter.hasNext()){
            iter.next().outprint();
        }
    }
    void listChangciInformation(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入要罗列场次的为第几个电影：");
        int op=scanner.nextInt();
        movieTotal.get(op-1).outprintChangci();
    }
    void  listMovieSeat(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("要查找第几个电影");
        int op=scanner.nextInt();
        System.out.println("电影场次为多少：");
        int op1=scanner.nextInt();
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
    }
   void sellaTicket(){
       Scanner scanner=new Scanner(System.in);
       System.out.println("要查找第几个电影");
       int op=scanner.nextInt();
       System.out.println("电影场次为多少：");
       int op1=scanner.nextInt();
       System.out.println("要买的座位是第几列(0~11)：");
       int column=scanner.nextInt();
       System.out.println("要买的座位是第几行(0~9)：");
       int row=scanner.nextInt();
       String a=scanner.nextLine();
       System.out.println("手机号为多少：");
       String phone=scanner.nextLine();
       System.out.println("支付金额为：");
       String money=scanner.nextLine();
      movieTotal.get(op-1).sellTicket(op1,column,row,phone);
   }

}
