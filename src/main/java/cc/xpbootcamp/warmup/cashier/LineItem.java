package cc.xpbootcamp.warmup.cashier;

public class LineItem {
    private String desc;
    private double price;
    private int qty;

    public LineItem(String desc, double price, int qty) {
        super();
        this.desc = desc;
        this.price = price;
        this.qty = qty;
    }

    String getDescription() {
        return desc;
    }

    double getPrice() {
        return price;
    }

    int getQuantity() {
        return qty;
    }

    double amount() {
        return price * qty;
    }

    double getItemSaleTax() {
        return amount() * .10;
    }
}