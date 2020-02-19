package cc.xpbootcamp.warmup.cashier;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 *
 */
public class OrderReceipt {

    private static final String TITLE = "====老王超市，值得信赖====";
    private static final String TAX = "税额: ";
    private static final String DISCOUNT = "折扣: ";
    private static final String TOTAL_AMOUNT = "总价: ";
    private static final String WEDNESDAY = "星期三";

    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder(TITLE + "\n\n");

        output.append(generateDateLine());

        output.append(generateDetailLines() + "\n");

        output.append(generateFooterLines());

        return output.toString();
    }

    private String generateDateLine(){
        return getDate() + "," + getWeedDay() + "\n\n";
    }

    private String generateDetailLines() {
        StringBuilder result = new StringBuilder();
        for(LineItem item : order.getLineItems()){
            result.append(item.getDescription()).append(", ");
            result.append(setDecimal(item.getPrice())).append(" x ");
            result.append(item.getQuantity()).append(", ");
            result.append(setDecimal(item.amount())).append("\n");
        }
        return result.toString();
    }

    private String generateFooterLines() {
        return getTotalTaxLine() + "\n" +  getDiscountLine() + getTotalAmountLine() + "\n";
    }

    private String getTotalTaxLine(){
        return TAX + setDecimal(order.getTotalSalesTax());
    }

    private String getDiscountLine(){
        double discount = order.getDiscount(getWeedDay());
        return discount > 0 ? DISCOUNT + setDecimal(discount) + "\n" : "";
    }

    private String getTotalAmountLine(){
        double discount = order.getDiscount(getWeedDay());
        return discount > 0 ? TOTAL_AMOUNT + setDecimal(order.getTotalAmount() - discount) : setDecimal(order.getTotalAmount());
    }

    private String getDate(){
        return new SimpleDateFormat("y年M月d日").format(new Date());
    }

    public String getWeedDay(){
        return new SimpleDateFormat("EEEE").format(new Date());
    }

    private String setDecimal(double value){
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        return decimalFormat.format(value);
    }

}