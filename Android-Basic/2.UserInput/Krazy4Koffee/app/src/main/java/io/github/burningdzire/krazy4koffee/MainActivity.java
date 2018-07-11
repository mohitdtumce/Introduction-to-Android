package io.github.burningdzire.krazy4koffee;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int quantity = 1;

    public void increment(View view) {
        if (quantity < 100)
            quantity ++;

        displayQuantity();
    }
    public void decrement(View view) {
        if (quantity > 1)
            quantity --;
        displayQuantity();
    }

    private void displayQuantity() {
        TextView numberOfCoffee  = (TextView) findViewById(R.id.quantityCoffee);
        numberOfCoffee.setText("" + quantity);
    }

    private int calculatePrice() {
        CheckBox whippedCreamCheckBox =(CheckBox) findViewById(R.id.whippedCreamCheckBox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolateCheckBox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        return (quantity*(5 + (hasWhippedCream?1:0) + (hasChocolate?2:0)));
    }

    private String createOrderSummary(String name, String email, boolean hasWhippedCream, boolean hasChocolate, int price) {
        String orderSummary = "Name :" + name + "\n"
                + "Email :" + email + "\n"
                + "Whipped Cream: " + hasWhippedCream + "\n"
                + "Chocolate: " + hasChocolate + "\n"
                + "Amount Due: " + price;
        return orderSummary;
    }

    public void submitOrder(View view) {
        EditText customerName = (EditText) findViewById(R.id.customerName);
        String name = customerName.getText().toString();
        EditText customerEmail = (EditText) findViewById(R.id.customerEmail);
        String email = customerEmail.getText().toString();

        CheckBox whippedCreamCheckBox =(CheckBox) findViewById(R.id.whippedCreamCheckBox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolateCheckBox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        int price = calculatePrice();
        String message = createOrderSummary(name, email, hasWhippedCream, hasChocolate, price);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
//        intent.putExtra(Intent.EXTRA_EMAIL, email);
        intent.putExtra(Intent.EXTRA_SUBJECT, "E-Bill | Thank You!");
        intent.putExtra(Intent.EXTRA_TEXT, message);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
