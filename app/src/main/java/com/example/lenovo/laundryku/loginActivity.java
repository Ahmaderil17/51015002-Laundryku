package com.example.lenovo.laundryku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {

    EditText  etTelpon,etPassword;
    Button btLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etTelpon = (EditText) findViewById(R.id.etTelpon);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btLogin = (Button) findViewById(R.id.btLogin);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User users = new User(etTelpon.getText().toString());
                if (users.getTelpon().equals(etTelpon.getText().toString()) && users.getPassword().equals(etPassword.getText().toString())) {
                    Log.d(">>>>>> CHECK 2 >>>>>>>", users.getTelpon());
                    Toast.makeText(getApplicationContext(), "Login Sukses", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(loginActivity.this, MainActivity.class);
                    intent.putExtra("users", users);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                } else if (etTelpon.equals(null) ){
                    Toast.makeText(getApplicationContext(), "Login Gagal /Username Pasword Salah", Toast.LENGTH_SHORT).show();
                    etTelpon.setText("");
                    etTelpon.requestFocus();
                }

            }
        });
    }
}
