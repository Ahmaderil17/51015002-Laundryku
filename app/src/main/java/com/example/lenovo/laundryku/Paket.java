package com.example.lenovo.laundryku;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by lenovo on 2/5/2018.
 */

public class Paket implements Parcelable {
    private String id;
    private String nama;
    private String jenis;
    private Integer harga;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.nama);
        dest.writeString(this.jenis);
        dest.writeValue(this.harga);
    }

    public Paket() {
    }

    protected Paket(Parcel in) {
        this.id = in.readString();
        this.nama = in.readString();
        this.jenis = in.readString();
        this.harga = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Creator<Paket> CREATOR = new Creator<Paket>() {
        @Override
        public Paket createFromParcel(Parcel source) {
            return new Paket(source);
        }

        @Override
        public Paket[] newArray(int size) {
            return new Paket[size];
        }
    };
}
