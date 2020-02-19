package cc.xpbootcamp.warmup.cashier;

import cc.xpbootcamp.warmup.cashier.utils.DateUtil;
import java.util.List;

public class Order {
    private static final String WEDNESDAY = "星期三";

    private String cName;
    private String addr;
    private List<LineItem> lineItemList;

    public Order(String cName, String addr, List<LineItem> lineItemList) {
        this.cName = cName;
        this.addr = addr;
        this.lineItemList = lineItemList;
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

    double getTotalSalesTax(){
        double result = 0d;
        for(LineItem lineItem : getLineItems()) {
            result += lineItem.getItemSaleTax();
        }
        return result;
    }

    double getTotalAmount(){
        double result = 0d;
        for(LineItem lineItem : getLineItems()) {
            result += lineItem.amount() + lineItem.getItemSaleTax();
        }
        return result;
    }

    double getDiscount(){
        return WEDNESDAY.equals(DateUtil.getWeedDay()) ? getTotalAmount() - getTotalAmount() * 0.98 : 0d;
    }
}
