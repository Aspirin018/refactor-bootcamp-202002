package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class Order {
    private static final String WEDNESDAY = "星期三";

    String cName;
    String addr;
    List<LineItem> lineItemList;

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

    double getDiscount(String weekDay){
        if(WEDNESDAY.equals(weekDay)) {
            return getTotalAmount() - getTotalAmount() * 0.98;
        }
        return 0d;
    }
}
