package movie;

public class movieInformation {

    String name,director,actor,story,time;
    String [][]changci=new String[7][3];
    String [][][]seat=new String[7][7][11];
    String [][][]people=new String[7][7][11];
    String [][][]movieId=new String[7][7][11];
    boolean [][][]suoDing=new boolean[7][7][11];
    movieInformation(String name,String director,String actor,String story,String time){
        this.name=name;
        this.director=director;
        this.actor=actor;
        this.story=story;
        this.time=time;
        changci[0][0]="A";changci[0][1]="20221003";changci[0][2]="20";
        for(int i=0;i<7;i++)
            for(int j=0;j<7;j++)
                for (int t=0;t<11;t++)
                    seat[i][j][t]="O";
    }
    void outprint(){
        System.out.println("片名："+name+" 导演："+director+" 主演："+actor+" 剧情简介："+story+" 影片时长（分钟）："+time);
    }
    void addChangci(String place,String scheduleTime,String movieMoney){
        for(int i=0;i<7;i++){
            if (changci[i][0]==null){
                changci[i][0]=place;
                changci[i][1]=scheduleTime;
                changci[i][2]=movieMoney;
                break;
            }
        }
    }
    void changeChangci(int op,String place,String scheduleTime,String movieMoney){
        changci[op-1][0]=place;
        changci[op-1][1]=scheduleTime;
        changci[op-1][2]=movieMoney;
    }
    void  deleteChangci(int op){
        changci[op-1][0]=null;
        changci[op-1][1]=null;
        changci[op-1][2]=null;
    }
    void outprintChangci(){
        for(int i=0;i<7;i++){
            System.out.println("放映厅为："+changci[i][0]+" 安排时间段为："+changci[i][1]+" 价格为"+changci[i][2]);
        }

    }
    void outprintSeat(int option){
        for(int i=0;i<7;i++){
            for(int j=0;j<11;j++)
                System.out.print(seat[option-1][i][j]+" ");
           System.out.print("\n");
        }
    }
    void sellTicket(int op,int row,int column,String phone){
        seat[op-1][row-1][column-1]="X";
        people[op-1][row-1][column-1]=phone;
    }
    void makeMovieId(int op,int row,int column){
        String row1=String.valueOf(row);
        String column1=String.valueOf(column);
      movieId[op-1][row-1][column-1]=changci[op-1][0]+changci[op-1][1]+row1+column1;
    }
    void getMovieId(int op,int row,int column){
        System.out.println("电影ID是:"+movieId[op-1][row-1][column-1]);
    }

    void takeTicket(int op,int row,int column){
        movieId[op-1][row-1][column-1]=null;

    }
}
