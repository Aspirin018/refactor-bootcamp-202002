package cc.xpbootcamp.warmup.cashier;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

class OrderReceiptTest {

    @Test
    public void shouldPrintLineItemAndSalesTaxInformation() {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("巧克力", 21.5, 2));
            add(new LineItem("小白菜", 10.00, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, lineItems));

        String output = receipt.printReceipt();

        assertThat(output, containsString("巧克力, 21.50 x 2, 43.00"));
        assertThat(output, containsString("小白菜, 10.00 x 1, 10.00"));
        assertThat(output, containsString("税额: 5.30"));
    }

    @Test
    void shouldPrintTitle() {
        Order order = new Order(null, null, new ArrayList<LineItem>());
        OrderReceipt receipt = new OrderReceipt(order);

        String output = receipt.printReceipt();

        assertThat(output, containsString("====老王超市，值得信赖===="));
    }

}