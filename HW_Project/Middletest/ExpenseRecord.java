package Middletest;

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
