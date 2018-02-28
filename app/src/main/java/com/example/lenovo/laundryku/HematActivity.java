package com.example.lenovo.laundryku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class HematActivity extends AppCompatActivity {
private EditText nama,telpon,tanggalmasuk,berat;
private Button bayar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hemat);
        nama = (EditText)findViewById(R.id.nama );
        telpon = (EditText)findViewById(R.id.telpon);
        tanggalmasuk = (EditText)findViewById(R.id.tanggalmasuk);
        berat = (EditText)findViewById(R.id.berat);

        bayar = (Button)findViewById(R.id.bayar);

    }
}
