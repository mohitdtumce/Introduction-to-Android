package io.github.burningdzire.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    /**
     * This method is called when the order button is clicked.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void displayQuantity() {
        TextView t = (TextView) findViewById(R.id.quantity_text_view);
        t.setText(String.valueOf(quantity));
    }

    public void decrementCoffee(View view) {
        if (quantity > 1) {
            quantity--;
        }
        displayQuantity();
    }

    public void incrementCoffee(View view) {
        if (quantity < 100) {
            quantity++;
        }
        displayQuantity();
    }

    private int calculatePrice() {
        CheckBox cream = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        CheckBox chocolate = (CheckBox) findViewById(R.id.chocolate_checkbox);
        return (quantity * (5 + (cream.isChecked()?1:0) + (chocolate.isChecked()?2:0)));
    }

    private void createOrderSummary(int total) {
        EditText customerName = (EditText) findViewById(R.id.customer_name);
        CheckBox cream = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        CheckBox chocolate = (CheckBox) findViewById(R.id.chocolate_checkbox);
        String orderSummary = "Name: " + customerName.getText()
                + "\nAdd Whipped cream?" + cream.isChecked()
                + "\nAdd Chocolate?" + chocolate.isChecked()
                + "\nQuantity: " + quantity + "\nTotal: $" + total + "\nThank you!!";
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(orderSummary);
    }

    public void submitOrder(View view) {
        int price = calculatePrice();
        Log.v("MainActivity", "The value of price is " + price);
        createOrderSummary(price);
    }
}