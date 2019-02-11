package ca.nbcc.shoppinglist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ShoppingItems extends AppCompatActivity {
    public static final String EXTRA_REPLY =
            "ca.nbcc.shoppinglist.extra.REPLY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_items);
    }

    public void selectItem(View view) {
        Button button = (Button) view;
        String reply = button.getText().toString();
        Intent intent = new Intent();
        intent.putExtra(EXTRA_REPLY,reply);
        setResult(RESULT_OK, intent);
        finish();
    }
}
