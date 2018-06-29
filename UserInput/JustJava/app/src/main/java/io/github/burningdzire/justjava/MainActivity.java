package io.github.burningdzire.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * This method is called when the order button is clicked.
     */
    int numberOfCoffees = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {
        display(numberOfCoffees);
        displayPrice(numberOfCoffees * 5);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String str) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(str);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        String priceMessage = "Total Amount Due: " + "$" + number + "\nThanks for the order!!";
        priceTextView.setText(priceMessage);
    }

    public void decrementCoffee(View view) {
        if (numberOfCoffees > 0) {
            numberOfCoffees--;
        }
        display(numberOfCoffees);
    }

    public void incrementCoffee(View view) {
        numberOfCoffees++;
        display(numberOfCoffees);
    }
}