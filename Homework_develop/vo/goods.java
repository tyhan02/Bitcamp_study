package vo;

import java.io.Serializable;

public class goods implements Serializable, CsvObject {
  private static final long serialVersionUID = 1L;

  public static int userId = 1;

  public static final char CASH = 'S';
  public static final char CARD = 'R';

  private int no;
  private String name;
  private int price;
  private String password;
  private char gender;

  public goods() {
    this.no = userId++;
  }

  public goods(int no) {
    this.no = no;
  }

  public static goods fromCsv(String csv) {
    String[] values = csv.split(",");

    goods member = new goods(Integer.parseInt(values[0]));
    member.setName(values[1]);
    member.setEmail(values[2]);
    member.setPassword(values[3]);
    member.setGender(values[4].charAt(0));

    if (goods.userId <= member.getNo()) {
      goods.userId = member.getNo() + 1;
    }

    return member;
  }

  @Override
  public String toCsvString() {
    return String.format("%d,%s,%s,%s,%c",
        this.getNo(),
        this.getName(),
        this.getPrice(),
        this.getPassword(),
        this.getGender());
  }

  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (this.getClass() != obj.getClass()) {
      return false;
    }
    goods m = (goods) obj;
    if (this.getNo() != m.getNo()) {
      return false;
    }
    return true;
  }

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public char getGender() {
    return gender;
  }
  public void setGender(char gender) {
    this.gender = gender;
  }

}
