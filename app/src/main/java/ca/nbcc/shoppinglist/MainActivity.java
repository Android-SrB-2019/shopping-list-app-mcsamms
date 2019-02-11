package ca.nbcc.shoppinglist;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private ShoppingList shoppingList = new ShoppingList();
    public static final int TEXT_REQUEST = 1;
    public static final String EXTRA_MESSAGE =
            "com.nbcc.shoppinglist.extra.MESSAGE";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, ShoppingItems.class);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == TEXT_REQUEST){
            if(resultCode == RESULT_OK){
                String item = data.getStringExtra(ShoppingItems.EXTRA_REPLY);
                shoppingList.addItem(item);
                showList();
            }
        }
    }

    private void showList() {
        
    }

    public void launchShoppingItems(View view) {
        Log.d(LOG_TAG, "Button clicked!");
    }
}
