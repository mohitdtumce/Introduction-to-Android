package io.github.burningdzire.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /**
     * This method is called when the order button is clicked.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int quantity = 0;

    private void displayQuantity() {
        TextView t = (TextView) findViewById(R.id.quantity_text_view);
        t.setText(String.valueOf(quantity));
    }

    public void decrementCoffee(View view) {
        if (quantity > 0) {
            quantity--;
        }
        displayQuantity();
    }

    public void incrementCoffee(View view) {
        quantity++;
        displayQuantity();
    }

    private int calculatePrice() {
        return quantity * 5;
    }

    private void createOrderSummary(int total) {
        String orderSummary = "Name: Kaptain Kunal\nQuantity: " + quantity + "\nTotal: $" + total + "\nThank you!!";
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(orderSummary);
    }

    public void submitOrder(View view) {
        int price = calculatePrice();
        createOrderSummary(price);
    }
}