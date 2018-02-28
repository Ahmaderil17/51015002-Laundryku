package com.example.lenovo.laundryku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button pakethemat,paketlengkap,paketsatuan;
    User users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pakethemat = (Button) findViewById(R.id.hemat);

        paketlengkap = (Button) findViewById(R.id.lengkap);
        paketsatuan = (Button) findViewById(R.id.satuan);
        users = getIntent().getParcelableExtra("users");
        if (users == null){
            Intent intent = new Intent(MainActivity.this,loginActivity.class);
            startActivity(intent);
        }
        paketsatuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,satuanActivity.class);
                startActivity(intent);


            }
        });
        pakethemat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,HematActivity.class);
                startActivity(intent);


            }
        });

        paketlengkap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,HematActivity.class);
                startActivity(intent);


            }
        });


    }
@Override
    public boolean
    onCreateOptionsMenu(Menu menu){
      getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
}
@Override
    public boolean
    onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==R.id.menuLogout){
            startActivity(new Intent(MainActivity.this,loginActivity.class));
        }
        return true;
}
}

