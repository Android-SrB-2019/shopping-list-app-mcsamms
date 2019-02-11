package ca.nbcc.shoppinglist;

import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private ShoppingList shoppingList = new ShoppingList();
    public static final int TEXT_REQUEST = 1;
    public static final String EXTRA_MESSAGE =
            "com.nbcc.shoppinglist.extra.MESSAGE";
    ArrayAdapter<String> adapter;
    private ArrayList<String> itemTotals = new ArrayList<>();
    private ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setAdapter();
    }

    private void setAdapter() {
        adapter=new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                itemTotals);
        listView = findViewById(R.id.myShoppingList);
        listView.setAdapter(adapter);
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

    private void showList(){

        List<ShoppingList.Item> list = shoppingList.getList();
        itemTotals.clear();

        for(ShoppingList.Item item : list){
            itemTotals.add(item.name + " " + item.count.toString());
        }
        adapter.notifyDataSetChanged();
    }

    public void launchShoppingItems(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, ShoppingItems.class);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }
}
