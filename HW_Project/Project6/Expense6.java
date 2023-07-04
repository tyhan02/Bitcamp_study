package Project6;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class Expense6 {
    public static void main(String[] args) {
        ExpenseRecord[] expenses = {
                new ExpenseRecord("식사", "CASH", 10000),
                new ExpenseRecord("술", "CARD", 20000),
                new ExpenseRecord("쇼핑", "CARD", 50000),
                new ExpenseRecord("교통", "CASH", 15000),
                new ExpenseRecord("생활", "CARD", 30000),
                new ExpenseRecord("기타", "CASH", 10000)
        };

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(expenses);

        try (FileWriter writer = new FileWriter("expense_6.json")) {
            writer.write(json);
            System.out.println("expense_6.json 파일이 생성되었습니다.");
        } catch (IOException e) {
            System.out.println("파일 생성 중 오류가 발생하였습니다.");
            e.printStackTrace();
        }
    }
}

class ExpenseRecord {
    private String category;
    private String method;
    private int price;

    public ExpenseRecord(String category, String method, int price) {
        this.category = category;
        this.method = method;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public String getMethod() {
        return method;
    }

    public int getPrice() {
        return price;
    }
}
