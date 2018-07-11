package io.github.burningdzire.testing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Called when the cookie should be eaten.
     */
    boolean flag = true;
    public void eatCookie(View view) {
        TextView textview = (TextView) findViewById(R.id.status_text_view);
        ImageView imageview = (ImageView) findViewById(R.id.android_cookie_image_view);
        if (flag) {
            textview.setText("I'm so full");
            imageview.setImageResource(R.drawable.after_cookie);
        }
        else
        {
            textview.setText("I'm so hungry");
            imageview.setImageResource(R.drawable.before_cookie);
        }
        flag = !flag;
    }
}
