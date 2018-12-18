package com.example.bajip.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>{

    private ArrayList<String> id_dosen;
    private ArrayList<String> nama_dosen;
    private ArrayList<String> jurusan;
    private ArrayList<String> fakultas;
    private ArrayList<String> komuditi;
    Context context;
    public RecycleViewAdapter(ArrayList<String> ID,ArrayList<String> NAMA, ArrayList<String> JURUSAN, ArrayList<String> FAKULTAS, ArrayList<String> KOMUDITI) {

        id_dosen = ID;
        nama_dosen = NAMA;
        jurusan = JURUSAN;
        fakultas = FAKULTAS;
        komuditi = KOMUDITI;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // di tutorial ini kita hanya menggunakan data String untuk tiap item
        public TextView iddosen;
        public TextView namadosen;
        public TextView jurusann;
        public TextView fakultass;
        public TextView komuditii;
        public CardView cvMain;

        public ViewHolder(View v) {
            super(v);
            iddosen = (TextView) v.findViewById(R.id.iddosen);
            namadosen = (TextView) v.findViewById(R.id.namadosen);
            jurusann = (TextView) v.findViewById(R.id.jurusan);
            fakultass = (TextView) v.findViewById(R.id.fakultas);
            komuditii = (TextView) v.findViewById(R.id.komuditi);
            cvMain = (CardView) v.findViewById(R.id.cv_main);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // membuat view baru
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_rv_item, parent, false);
        // mengeset ukuran view, margin, padding, dan parameter layout lainnya
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - mengambil elemen dari dataset (ArrayList) pada posisi tertentu
        // - mengeset isi view dengan elemen dari dataset tersebut
        //final String id = nama_dosen.get(position);
        final String name = nama_dosen.get(position);
        holder.iddosen.setText(id_dosen.get(position));
        holder.namadosen.setText(nama_dosen.get(position));
        holder.jurusann.setText(jurusan.get(position));
        holder.fakultass.setText(fakultas.get(position));
        holder.komuditii.setText(komuditi.get(position));

        // Set onclicklistener pada view cvMain (CardView)
        holder.cvMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(context,"Nama :  "+name,Toast.LENGTH_SHORT).show();
              Snackbar.make(view, "Nama : " + name, Snackbar.LENGTH_LONG).show();
            //  Intent intent = new Intent(view.getContext(), DetailKategori.class);
//                intent.putExtra("id_kategori", id);
//                view.getContext().startActivity(intent);
//                ((Activity) view.getContext()).finish();

            }
        });
    }


    @Override
    public int getItemCount() {
        // menghitung ukuran dataset / jumlah data yang ditampilkan di RecyclerView
        return nama_dosen.size();
    }
}
