package com.dev.chat.vdomax;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dev.chat.vdomax.utils.UserManager;

public class LoginActivity extends AppCompatActivity {

    private Button mLogin;
    private EditText mUserId;
    private Context mContext;
    private UserManager mManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mManager  = new UserManager(this);
        mContext = this;

        mLogin = (Button) findViewById(R.id.button2);
        mUserId = (EditText) findViewById(R.id.editText3);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveId();
                checkLogin();
            }
        });

        Log.e("isLogin/LoginActivity", "::" + mManager.registerUser(mUserId.toString()));
    }

    private void checkLogin() {
        String password = mUserId.getText().toString().trim();
        boolean isSuccess = mManager.checkLoginValidate(password);

        if (isSuccess) {
            Intent intent = new Intent(mContext, MainActivity.class);
            startActivity(intent);
        }
    }

    private  void saveId(){

        String password = mUserId.getText().toString();


        if (password.equals(password)) {
            boolean isSuccess = mManager.registerUser(password);

            if (isSuccess) {
                String message = getString(R.string.register_success);
                Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();

            } else {
                String message = getString(R.string.register_error_message);
                Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
            }

        } else {
            String message = getString(R.string.register_password_error);
            Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
        }
    }

}
