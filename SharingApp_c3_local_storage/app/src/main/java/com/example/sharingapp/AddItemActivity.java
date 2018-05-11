package com.example.sharingapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Add a new item
 */
public class AddItemActivity extends AppCompatActivity {

    private EditText title;
    private EditText maker;
    private EditText description;
    private EditText length;
    private EditText width;
    private EditText height;
    private EditText min_bid;

    private String user_id;
    private ImageView photo;
    private Bitmap image;
    private int REQUEST_CODE = 1;

    private ItemList item_list = new ItemList();
    private ItemListController item_list_controller = new ItemListController(item_list);

    private Context context;

    private String title_str;
    private String maker_str;
    private String description_str;
    private String length_str;
    private String width_str;
    private String height_str;
    private String min_bid_str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_item);

        Intent intent = getIntent(); // Get intent from MainActivity
        user_id = intent.getStringExtra("user_id");

        title = (EditText) findViewById(R.id.title);
        maker = (EditText) findViewById(R.id.maker);
        description = (EditText) findViewById(R.id.description);
        length = (EditText) findViewById(R.id.length);
        width = (EditText) findViewById(R.id.width);
        height = (EditText) findViewById(R.id.height);
        photo = (ImageView) findViewById(R.id.image_view);
        min_bid = (EditText) findViewById(R.id.minimum_bid);

        photo.setImageResource(android.R.drawable.ic_menu_gallery);

        context = getApplicationContext();
        item_list_controller.loadItems(context);
    }

    public void saveItem (View view) {

        title_str = title.getText().toString();
        maker_str = maker.getText().toString();
        description_str = description.getText().toString();
        length_str = length.getText().toString();
        width_str = width.getText().toString();
        height_str = height.getText().toString();
        min_bid_str = min_bid.getText().toString();

        if(!validateInput()){
            return;
        }

        Item item = new Item(title_str, maker_str, description_str, user_id, min_bid_str, image, null);
        ItemController item_controller = new ItemController(item);
        item_controller.setDimensions(length_str, width_str, height_str);

        boolean success = item_list_controller.addItem(item, context);
        if (!success){
            return;
        }

        // End AddItemActivity
        final Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("user_id", user_id);
        Toast.makeText(context, "Item created.", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

    public void addPhoto(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_CODE);
        }
    }

    public void deletePhoto(View view) {
        image = null;
        photo.setImageResource(android.R.drawable.ic_menu_gallery);
        Toast.makeText(context, "Photo removed.", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int request_code, int result_code, Intent intent){
        if (request_code == REQUEST_CODE && result_code == RESULT_OK){
            Bundle extras = intent.getExtras();
            image = (Bitmap) extras.get("data");
            photo.setImageBitmap(image);
        }
        Toast.makeText(context, "Photo added.", Toast.LENGTH_SHORT).show();
    }

    public boolean validateInput(){
        if (title_str.equals("")) {
            title.setError("Empty field!");
            return false;
        }

        if (maker_str.equals("")) {
            maker.setError("Empty field!");
            return false;
        }

        if (description_str.equals("")) {
            description.setError("Empty field!");
            return false;
        }

        if (length_str.equals("")) {
            length.setError("Empty field!");
            return false;
        }

        if (width_str.equals("")) {
            width.setError("Empty field!");
            return false;
        }

        if (height_str.equals("")) {
            height.setError("Empty field!");
            return false;
        }

        if (min_bid_str.equals("")) {
            min_bid.setError("Empty field!");
            return false;
        }

        if (Float.valueOf(min_bid_str) <= 0) {
            min_bid.setError("Starting bid must be above 0!");
            return false;
        }

        return true;
    }
}
