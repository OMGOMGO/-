package movie;

public class userInformation {
    String id,username,userRank,time,money,phone,email,code;

    userInformation(String id,String username,String userRank,String time,String money,String phone,String email,String code){
      this.id=id;
      this.username=username;
      this.userRank=userRank;
      this.time=time;
      this.money=money;
       this.phone=phone;
       this.email=email;
       this.code=code;
    }
    void outprint(){
        System.out.println("id；"+id+"  用户名："+username+"  用户等级："+userRank+"  注册时间："+time+
                "  累积消费金额："+money+"  电话："+phone+ "  邮箱："+email);
    }
    void reset(){
      code="123456";
    }
    void setCode(String code){
        this.code=code;
    }
    void sendVerificationCode(){

    }
    void sendRandomPassword(){

    }
}
