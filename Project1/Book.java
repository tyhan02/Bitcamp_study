
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
class Book{
    private String num;   //도서번호
    private String title; //도서제목
    private String name;  //저자
    private String publi; //출판사



    public Book(String num,String title,String name,String publi){
        this.num=num;
        this.title=title;
        this.name=name;
        this.publi=publi;
    }
    public String getNum(){
        return num;
    }
    public String getTitle(){
        return title;
    }
    public String getName(){
        return name;
    }
    public String getPubli(){
        return publi;
    }
    public void print(){
        System.out.println("도서번호: "+num);
        System.out.println("도서제목: "+title);
        System.out.println("저자: "+name);
        System.out.println("출판사: "+publi);
    }

}