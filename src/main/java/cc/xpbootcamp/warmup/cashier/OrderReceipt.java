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
        StringBuilder output = new StringBuilder("======Printing Orders======\n");

        output.append(generateDetailLines());

        output.append(generateFooterLines());

        return output.toString();
    }

    private String generateDetailLines() {
        StringBuilder result = new StringBuilder();
        result.append(order.getCustomerName()).append(order.getCustomerAddress());
        for(LineItem item : order.getLineItems()){
            result.append(item.getDescription()).append('\t');
            result.append(item.getPrice()).append('\t');
            result.append(item.getQuantity()).append('\t');
            result.append(item.amount()).append('\n');
        }
        return result.toString();
    }

    private String generateFooterLines() {
        StringBuilder result = new StringBuilder();
        result.append("Sales Tax").append('\t').append(order.getTotalSalesTax());
        result.append("Total Amount").append('\t').append(order.getTotalAmount());
        return result.toString();
    }
}