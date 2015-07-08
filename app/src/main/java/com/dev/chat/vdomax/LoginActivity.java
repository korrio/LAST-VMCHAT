package com.dev.chat.vdomax;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
                Intent intent = new Intent(mContext, MainActivity.class);
                startActivity(intent);
                //checkLogin();
            }
        });


    }

    private  void saveId(){

        int userId = Integer.parseInt(mUserId.getText().toString());

            boolean isSuccess = mManager.registerUser(userId);

            if (isSuccess) {
                String message = getString(R.string.register_success);
                //Toast.makeText(mContext, message + "user_id:" + mManager, Toast.LENGTH_SHORT).show();

            } else {
                String message = getString(R.string.register_error_message);
                //Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
            }


    }

}
