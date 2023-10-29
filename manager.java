package movie;

import java.util.Iterator;
import java.util.Scanner;

import static movie.database.movieTotal;

public class manager {
    public  String userName="manager" ;
    public  String password="ynufo#778";
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
    void addMovieInformation(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("影片名为：");
        String movieName=scanner.nextLine();
        System.out.println("影片导演为：");
        String director=scanner.nextLine();
        System.out.println("影片主演为：");
        String actor=scanner.nextLine();
        System.out.println("影片介绍：");
        String story=scanner.nextLine();
        System.out.println("影片时间为：");
        String time=scanner.nextLine();
        movieTotal.add(new movieInformation(movieName,director,actor,story,time));
    }
    void changeMovieInformation(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("修改第几个信息");
        int op=scanner.nextInt();
        String a=scanner.nextLine();
        movieTotal.remove(op-1);
        System.out.println("输入修改后信息");
        System.out.println("影片名为：");
        String movieName=scanner.nextLine();
        System.out.println("影片导演为：");
        String director=scanner.nextLine();
        System.out.println("影片主演为：");
        String actor=scanner.nextLine();
        System.out.println("影片介绍：");
        String story=scanner.nextLine();
        System.out.println("影片时间为：");
        String time=scanner.nextLine();
        movieTotal.add(new movieInformation(movieName,director,actor,story,time));
    }
    void  deleteMovieInformation(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("删除第几个信息");
        int op=scanner.nextInt();
        movieTotal.remove(op-1);
    }
    void findMovieInformation(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入影片名、导演或主演：");
        String str=scanner.nextLine();
        Iterator<movieInformation> iter=movieTotal.iterator();
        while (iter.hasNext()){
            movieInformation movie1=iter.next();
            if(str.equals(movie1.name)||str.equals(movie1.director)||str.equals(movie1.actor)){
                System.out.println("以下是查找的信息：");
                movie1.outprint();
            }
        }

    }
    void addChangciInformation(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入要增加场次的为第几个电影：");
        int op=scanner.nextInt();
        String a=scanner.nextLine();
        System.out.println("输入放映厅为几号：");
        String place=scanner.nextLine();
        System.out.println("输入放映时间：");
        String scheduleTime=scanner.nextLine();
        System.out.println("输入此场次的金额：");
        String movieMoney=scanner.nextLine();
        movieTotal.get(op-1).addChangci(place,scheduleTime,movieMoney);
    }
    void changeChangciInformation(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入要修改场次的为第几个电影：");
        int op=scanner.nextInt();
        System.out.println("输入要修改第几个场次的信息：");
        int op1=scanner.nextInt();
        String a=scanner.nextLine();
        System.out.println("输入放映厅为几号：");
        String place=scanner.nextLine();
        System.out.println("输入放映时间：");
        String scheduleTime=scanner.nextLine();
        System.out.println("输入此场次的金额：");
        String movieMoney=scanner.nextLine();
        movieTotal.get(op-1).changeChangci(op1,place,scheduleTime,movieMoney);
    }
    void  deleteChangciInformation(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入要删除场次的为第几个电影：");
        int op=scanner.nextInt();
        System.out.println("输入要删除第几个场次的信息：");
        int op1=scanner.nextInt();
        movieTotal.get(op-1).deleteChangci(op1);
    }
    void listChangciInformation(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入要罗列场次的为第几个电影：");
        int op=scanner.nextInt();
        movieTotal.get(op-1).outprintChangci();
    }
}
