package com.example.lenovo.laundryku;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by lenovo on 1/28/2018.
 */

public class PaketData {


    public static  String[][] datamenu = new String[][]{
            {"0001","kemeja","PAKAIAN","15000"},
            {"0002","jeans","CELANA","20000"},
            {"0003","celana dalam","DALAMAN","10000"},
            {"0004","selimut","LAIN-LAIN","10000"},
    } ;

    public static ArrayList<Paket> getListData(){
        Paket paket = null;
        ArrayList<Paket> list = new ArrayList<>();

        for (int i = 0; i < datamenu.length ; i++){
            paket = new Paket();
            paket.setId(datamenu[i][0]);
            paket.setNama(datamenu[i][1]);
            paket.setJenis(datamenu[i][2]);
            paket.setHarga(Integer.valueOf(datamenu[i][3]));

            list.add(paket);
        }

        return list;
    }
}
