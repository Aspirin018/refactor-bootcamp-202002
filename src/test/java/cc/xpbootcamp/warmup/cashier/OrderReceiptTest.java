package cc.xpbootcamp.warmup.cashier;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.*;

class OrderReceiptTest {

    private List<LineItem> lineItems = new ArrayList<LineItem>() {{
        add(new LineItem("巧克力", 21.5, 2));
        add(new LineItem("小白菜", 10.00, 1));
    }};


    @Test
    public void shouldPrintLineItemAndSalesTaxInformation() {
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, lineItems));

        String output = receipt.printReceipt();

        assertThat(output, containsString("巧克力, 21.50 x 2, 43.00"));
        assertThat(output, containsString("小白菜, 10.00 x 1, 10.00"));
        assertThat(output, containsString("税额: 5.30"));
    }

    @Test
    void shouldPrintTitle() {
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, lineItems));

        String output = receipt.printReceipt();

        assertThat(output, containsString("====老王超市，值得信赖===="));
    }

    @Test
    void shouldPrintDiscountAndTotalAmountWhenIsWednesday() throws ParseException {
        Order order = spy(new Order(null, null, lineItems));
        when(order.getCurrentDay()).thenReturn(new SimpleDateFormat("yyyy-MM-dd").parse("2020-02-19"));

        OrderReceipt receipt = new OrderReceipt(order);
        String output = receipt.printReceipt();

        assertThat(output, containsString("折扣: 1.17"));
        assertThat(output, containsString("总价: 57.13"));
    }

    @Test
    void shouldPrintTotalAmountWithoutDiscountWhenIsNotWednesday() throws ParseException {
        Order order = spy(new Order(null, null, lineItems));
        when(order.getCurrentDay()).thenReturn(new SimpleDateFormat("yyyy-MM-dd").parse("2020-02-18"));

        OrderReceipt receipt = new OrderReceipt(new Order(null, null, lineItems));
        String output = receipt.printReceipt();

        Assert.assertFalse(output.contains("折扣: 1.17"));
        assertThat(output, containsString("总价: 58.30"));
    }

}