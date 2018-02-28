package com.example.lenovo.laundryku;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by lenovo on 1/28/2018.
 */

public class PaketAdapter extends RecyclerView.Adapter<PaketAdapter.PaketAdapterHolder> {

    List<Paket> paket;
    private LayoutInflater inflater;
    private Context context;

    SharedPreferences mylocaldata;

    public PaketAdapter (Context context, List<Paket> listpaket ){
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.paket = listpaket;
    }

    @Override
    public PaketAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.satuancard,parent, false);
        PaketAdapterHolder holder = new PaketAdapterHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(PaketAdapterHolder holder, int position) {
        Paket current = paket.get(position);
        holder.setData(current, position);
        holder.setListeners();

    }

    @Override
    public int getItemCount() {
        return paket.size();
    }

    public class PaketAdapterHolder extends RecyclerView.ViewHolder {
        TextView tvJenis , tvHarga ,tvSatuan  ;

        int position;
        Paket current;

        View itemView;
        ViewInterface viewInterface = (ViewInterface) context;

        public PaketAdapterHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;

            tvJenis = (TextView)itemView.findViewById(R.id.tvJenis);
            tvSatuan = (TextView)itemView.findViewById(R.id.tvSatuan);
            tvHarga = (TextView)itemView.findViewById(R.id.tvHarga);
        }

        public void setData (Paket current, int position) {
            tvJenis.setText(current.getJenis());
            tvSatuan.setText(current.getNama());
            tvHarga.setText(""+current.getHarga());
            this.position = position;
            this.current = current;

        }

        public void setListeners() {
            //UNTUK MENAMPILKAN JUMLAH PESANAN
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewInterface.updateNota(current, 1);
                }
            });
        }
    }
}
