package com.example.mvc_simple;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvc_simple.controller.ILoginController;
import com.example.mvc_simple.controller.LoginController;
import com.example.mvc_simple.view.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView {
    private Button signInButton;
    private EditText userEditText,passEditText;
    private ILoginController loginController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginController=new LoginController(this);

        signInButton=findViewById(R.id.button);
        userEditText=findViewById(R.id.txt_user);
        passEditText=findViewById(R.id.txt_pass);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String id=userEditText.getText().toString().trim();
                String pass=passEditText.getText().toString().trim();

                loginController.OnLogin(id,pass);

            }
        });
    }

    @Override
    public void OnLoginSuccess(String message) {
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void OnLoginError(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();

    }
}