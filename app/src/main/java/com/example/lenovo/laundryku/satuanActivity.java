package com.example.lenovo.laundryku;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;


public class satuanActivity extends AppCompatActivity implements ViewInterface {

    private RecyclerView rvPaket;
    private ArrayList<Paket> list;

    private TextView tvTotal, tvListJmlh, tvListMenu, tvListHarga;

    private Nota nota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_satuan);

        tvTotal = (TextView) findViewById(R.id.tvTotal);
        tvListJmlh = (TextView) findViewById(R.id.tvListJmlh);
        tvListMenu = (TextView) findViewById(R.id.tvListMenu);
        tvListHarga = (TextView) findViewById(R.id.tvListHarga);

        tvListJmlh.setText("");
        tvListMenu.setText("");
        tvListHarga.setText("");

        rvPaket = (RecyclerView)findViewById(R.id.rvPaket);
        rvPaket.setHasFixedSize(true);

        list = new ArrayList<>();
        list.addAll(PaketData.getListData());

        nota = new Nota();

        showRecyclerMenu();

    }

    private void showRecyclerMenu() {
        rvPaket.setLayoutManager(new LinearLayoutManager(this));
        PaketAdapter paketAdapter = new PaketAdapter(this, PaketData.getListData());
        rvPaket.setAdapter(paketAdapter);
    }

    @Override
    public void updateNota(Paket paket, int increment) {
        NotaItem item = new NotaItem();

        item.setid(paket.getId());
        item.setNama(paket.getNama());
        item.setHarga(paket.getHarga());

        nota.addItem(item, increment);
        tvTotal.setText(nota.getTotalHarga().toString());

        tvListJmlh.setText(nota.getCurrent().getQuantity().toString());
        tvListMenu.setText(nota.getCurrent().getNama());
        tvListHarga.setText(""+nota.getCurrent().getJumlahHarga());

        Log.e(nota.getTotalHarga().toString(),"ttl");

        Log.e(nota.getCurrent().getQuantity().toString(),"Jumlh");
        Log.e(nota.getCurrent().getNama(),"Nama");
        Log.e(nota.getCurrent().getJumlahHarga().toString(),"Harga");
    }
}
