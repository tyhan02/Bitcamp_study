import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Song{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ArrayList<Book> list=new ArrayList<>();
        loop:
        while(true){
            System.out.println("1.도서추가 2.도서검색 3.도서삭제 4.도서수정 5.전체도서정보출력 6.종료");
            int selec=sc.nextInt();
            switch(selec){
                case 1: System.out.print("도서번호: ");
                    String num=sc.next();
                    System.out.print("도서제목: ");
                    String title=sc.next();
                    System.out.print("저자: ");
                    String name=sc.next();
                    System.out.print("출판사: ");
                    String publi=sc.next();
                    Book book=new Book(num,title,name,publi);
                    list.add(book);
                    break;
                case 2: System.out.print("찾고싶은 책의 도서 번호를 입력하세요: ");
                    String bookNum1=sc.next();
                    for(int i=0; i<list.size(); i++){
                        Book b1=list.get(i);
                        String num1=b1.getNum(); //ArrayList에 있는 도서번호
                        if(bookNum1.equals(num1)){
                            b1.print();
                            break;
                        }else if(i==list.size()-1){
                            System.out.println("찾고싶은 도서가 없습니다.");
                        }
                    }
                    break;
                case 3: System.out.print("삭제하고싶은 책의 도서 번호를 입력하세요: ");
                    String bookNum2=sc.next();
                    for(int i=0; i<list.size(); i++){
                        Book b2=list.get(i);
                        String num2=b2.getNum();
                        if(bookNum2.equals(num2)){
                            Book b3=list.remove(i);
                            System.out.println(b3.getTitle()+" 책이 삭제되었습니다.");
                        }
                    }
                    break;

                case 4: System.out.print("수정하고싶은 책의 도서 번호를 입력하세요: ");
                    String bookNum3=sc.next();
                    for(int i=0; i<list.size(); i++){
                        Book b3=list.get(i);
                        String num3=b3.getNum();
                        if(bookNum3.equals(num3)){
                            System.out.print("도서번호: ");
                            String setNum=sc.next();
                            System.out.print("도서제목: ");
                            String setTitle=sc.next();
                            System.out.print("저자: ");
                            String setName=sc.next();
                            System.out.print("출판사: ");
                            String setPubli=sc.next();
                            Book b4=list.set(i,new Book(setNum,setTitle,setName,setPubli));
                        }
                    }
                    break;
                case 5: Iterator<Book> it=list.iterator();
                    while(it.hasNext()){
                        Book result=it.next();
                        result.print();
                        System.out.println();
                    }
                    break;
                case 6: System.out.println("종료되었습니다."); break loop;
            }
        }
    }
}
