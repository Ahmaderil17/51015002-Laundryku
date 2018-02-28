package com.example.lenovo.laundryku;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by lenovo on 2/1/2018.
 */

public class User implements Parcelable {
    private String nama;
    private String alamat;
    private String telpon;
    private String password;
    protected String [][] data = new String[][]{
            {"08123456","alfredo","Jl. hertasning no.11","dayat"},
            {"08198765","billy","Jl. sultan alauddin no.5","billy"},
            {"08231111","eril","Jl. Meranti no.1","ahaide123"},
    };
    public User (String tlp){
        this.telpon=tlp;
        this.caridata();
        
    }

    private void caridata() {
        for (int i=0; i<this.data.length; i++){
            if( this.telpon.equals(this.data[i][0] )){
                this.nama=this.data[i][1];
                this.alamat=this.data[i][2];
                this.password=this.data[i][3];
            }
        }
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelpon() {
        return telpon;
    }

    public void setTelpon(String telpon) {
        this.telpon = telpon;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.alamat);
        dest.writeString(this.telpon);
        dest.writeString(this.password);
    }


    protected User(Parcel in) {
        this.nama = in.readString();
        this.alamat = in.readString();
        this.telpon = in.readString();
        this.password = in.readString();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
