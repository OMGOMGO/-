package movie;

import java.util.LinkedList;
import java.util.List;

public class database {
  public static List<userInformation> customer=new LinkedList<userInformation>();
  public static List<movieInformation> movieTotal=new LinkedList<movieInformation>();
  database(){
    customer.add(new userInformation("122","lucky","铜牌","20230709","2300","9807098712","234568@qq.com","433218Ac*"));
    customer.add(new userInformation("123","Lihua","金牌","20220903","1000","4562134411","237801@qq.com","zasA123$"));
    customer.add(new userInformation("124","john","银牌","20221101","3000","1324564512","214567@qq.com","dzxxL3456&"));
    movieTotal.add(new movieInformation("活着","张艺谋","葛优","平凡人在逆境中成长","132"));
    movieTotal.add(new movieInformation("流浪地球","郭帆","吴京","人类带地球逃离太阳系","125"));
  }


}
