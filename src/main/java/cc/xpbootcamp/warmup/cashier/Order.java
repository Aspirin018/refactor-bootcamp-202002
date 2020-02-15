package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class Order {
    String cName;
    String addr;
    List<LineItem> lineItemList;

    public Order(String cName, String addr, List<LineItem> lineItemList) {
        this.cName = cName;
        this.addr = addr;
        this.lineItemList = lineItemList;
    }

    public String getCustomerName() {
        return cName;
    }

    public String getCustomerAddress() {
        return addr;
    }

    public List<LineItem> getLineItems() {
        return lineItemList;
    }

    public double getTotalSalesTax(){
        double result = 0d;
        for(LineItem lineItem : getLineItems()) {
            result += lineItem.getItemSaleTax();
        }
        return result;
    }

    public double getTotalAmount(){
        double result = 0d;
        for(LineItem lineItem : getLineItems()) {
            result += lineItem.totalAmount() + lineItem.getItemSaleTax();
        }
        return result;
    }

    public void printItems(StringBuilder output){
        for(LineItem lineItem : getLineItems()){
            lineItem.printItem(output);
        }
    }

    public void printOrderInfo(StringBuilder output){
        output.append(getCustomerName());
        output.append(getCustomerAddress());
    }
}
