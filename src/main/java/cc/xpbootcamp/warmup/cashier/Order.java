package cc.xpbootcamp.warmup.cashier;

import cc.xpbootcamp.warmup.cashier.utils.DateUtil;

import java.util.Date;
import java.util.List;

public class Order {
    private static final String WEDNESDAY = "星期三";

    private String cName;
    private String addr;
    private List<LineItem> lineItemList;
    private Date currentDay;

    public Order(String cName, String addr, List<LineItem> lineItemList) {
        this.cName = cName;
        this.addr = addr;
        this.lineItemList = lineItemList;
        this.currentDay = new Date();
    }

    Date getCurrentDay() {
        return this.currentDay;
    }

    String getCustomerName() {
        return cName;
    }

    String getCustomerAddress() {
        return addr;
    }

    List<LineItem> getLineItems() {
        return lineItemList;
    }

    double calculateTotalSalesTax(){
        double result = 0d;
        for(LineItem lineItem : getLineItems()) {
            result += lineItem.getItemSaleTax();
        }
        return result;
    }

    double calculateTotalAmount() {
        return calculateDiscount() > 0 ? calculateFullTotalAmount() - calculateDiscount() : calculateFullTotalAmount();
    }

    private double calculateFullTotalAmount(){
        double result = 0d;
        for(LineItem lineItem : getLineItems()) {
            result += lineItem.amount() + lineItem.getItemSaleTax();
        }
        return result;
    }

    double calculateDiscount(){
        return WEDNESDAY.equals(DateUtil.getWeekDay(getCurrentDay())) ?
                calculateFullTotalAmount() - calculateFullTotalAmount() * 0.98 : 0d;
    }
}
