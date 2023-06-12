package handler;


public class Member {

    private  static int userId=1;

    //GRASP 패턴: information Expert
    // => 정보를 다룰 때는 그 정보를 갖고 있는 클래스에 그 기능을 둔다
    // => 필드도 마찬가지
    public static final char MALE = 'M';
    public static final char FEMALE = 'W';

    private int no;
    private String name;
    private String email;
    private String password;
    private char gender;

    public Member(){
        this.no = userId++;
    }

    public int getNo(){
        return no;
    }
    public void setNo(int no){
        this.no =no;
    }

    public String getName(String s){
        return name;
    }
    public void setName(String name){
        this.name= name;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email= email;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password= password;
    }
    public char getGender(){
        return gender;
    }
    public void setGender(char gender){
        this.gender= gender;
    }

}
