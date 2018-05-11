package com.example.sharingapp;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Users must log into the app
 */
public class LoginActivity extends AppCompatActivity {

    private UserList user_list = new UserList();
    private UserListController user_list_controller = new UserListController(user_list);

    private EditText username;
    private EditText email;
    private TextView email_tv;
    private Context context;
    private String username_str;
    private String email_str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);
        email_tv = (TextView) findViewById(R.id.email_tv);

        email.setVisibility(View.GONE);
        email_tv.setVisibility(View.GONE);

        context = getApplicationContext();
        user_list_controller.loadUsers(context);
    }

    public void login(View view) {
        username_str = username.getText().toString();
        email_str = email.getText().toString();
        String user_id = "";

        if (user_list_controller.getUserByUsername(username_str) == null && email.getVisibility() == View.GONE) {
            email.setVisibility(View.VISIBLE);
            email_tv.setVisibility(View.VISIBLE);
            email.setError("New user! Must enter email!");
            return;
        }

        // User does not already have an account
        if (user_list_controller.getUserByUsername(username_str) == null && email.getVisibility() == View.VISIBLE){
            if(!validateInput()){
                return;
            }

            User user = new User(username_str, email_str, null);
            UserController user_controller = new UserController(user);
            user_id = user_controller.getId();

            boolean success = user_list_controller.addUser(user, context);
            if (!success){
                return;
            }

            Toast.makeText(context, "Profile created.", Toast.LENGTH_SHORT).show();
        } else { // User already has an account
            user_id = user_list_controller.getUserIdByUsername(username_str);
        }

        // Either way, start MainActivity
        final Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("user_id", user_id);
        Toast.makeText(context, "Welcome!", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

    public boolean validateInput(){
        if (email_str.equals("")) {
            email.setError("Empty field!");
            return false;
        }

        if (!email_str.contains("@")) {
            email.setError("Must be an email address!");
            return false;
        }

        if (user_list_controller.getUserByUsername(username_str) != null) {
            username.setError("Username already taken!");
            return false;
        }

        return true;
    }
}
