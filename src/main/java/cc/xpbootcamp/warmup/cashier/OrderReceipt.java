package cc.xpbootcamp.warmup.cashier;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 *
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        // print headers
        output.append("======Printing Orders======\n");

        // print date, bill no, customer name
//        output.append("Date - " + order.getDate();
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());
//        output.append(order.getCustomerLoyaltyNumber());

        // prints lineItems
        double totSalesTx = 0d;
        double tot = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            output.append(lineItem.getDescription());
            output.append('\t');
            output.append(lineItem.getPrice());
            output.append('\t');
            output.append(lineItem.getQuantity());
            output.append('\t');
            output.append(lineItem.totalAmount());
            output.append('\n');

        }

        // prints the state tax
        output.append("Sales Tax").append('\t').append(getTotalSalesTax(order));

        // print total amount
        output.append("Total Amount").append('\t').append(getTotalAmount(order));
        return output.toString();
    }

    private double getItemSaleTax(LineItem alineItem){
        return alineItem.totalAmount() * .10;
    }

    private double getTotalSalesTax(Order anOrder){
        double result = 0d;
        for(LineItem lineItem : order.getLineItems()) {
            result += getItemSaleTax(lineItem);
        }
        return result;
    }

    private double getTotalAmount(Order anOrder){
        double result = 0d;
        for(LineItem lineItem : order.getLineItems()) {
            result += lineItem.totalAmount() + getItemSaleTax(lineItem);
        }
        return result;
    }
}