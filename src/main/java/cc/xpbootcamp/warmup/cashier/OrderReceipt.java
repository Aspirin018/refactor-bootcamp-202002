package cc.xpbootcamp.warmup.cashier;

import cc.xpbootcamp.warmup.cashier.utils.DateUtil;
import java.text.DecimalFormat;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 *
 */
public class OrderReceipt {

    private static final String TITLE = "====老王超市，值得信赖====\n\n";
    private static final String DATE_FORMATTER = "%s,%s\n\n";
    private static final String LINE_ITEM_FORMATTER = "%s, %.2f x %d, %.2f\n";
    private static final String FOOTER_FORMATTER = "%s: %.2f\n";
    private static final String TAX = "税额";
    private static final String DISCOUNT = "折扣";
    private static final String TOTAL_AMOUNT = "总价";

    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        output.append(generateHeaderLine());

        output.append(generateDetailLines()).append("\n");

        output.append(generateFooterLines());

        return output.toString();
    }

    private String generateHeaderLine() {
        return TITLE + String.format(DATE_FORMATTER, DateUtil.getFormattedDate(order.getCurrentDay()),
                DateUtil.getWeekDay(order.getCurrentDay()));
    }

    private String generateDetailLines() {
        StringBuilder result = new StringBuilder();
        for(LineItem item : order.getLineItems()){
            result.append(String.format(LINE_ITEM_FORMATTER, item.getDescription(), item.getPrice(),
                    item.getQuantity(), item.amount()));
        }
        return result.toString();
    }

    private String generateFooterLines() {
        return getTotalTaxLine() + getDiscountLine() + getTotalAmountLine();
    }

    private String getTotalTaxLine() {
        return String.format(FOOTER_FORMATTER, TAX, order.getTotalSalesTax());
    }

    private String getDiscountLine() {
        return order.getDiscount() > 0 ?  String.format(FOOTER_FORMATTER, DISCOUNT, order.getDiscount()) : "";
    }

    private String getTotalAmountLine() {
        return String.format(FOOTER_FORMATTER, TOTAL_AMOUNT, order.getTotalAmount());
    }

}