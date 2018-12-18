package com.example.bajip.myapplication;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class f_mipa extends AppCompatActivity {

    private RecyclerView rvView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<String> id_d;
    private ArrayList<String> nama_d;
    private ArrayList<String> juru;
    private ArrayList<String> faku;
    private ArrayList<String> komu;

    private String JSON_STRING;
    SwipeRefreshLayout swipeRefreshLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fakultas_mipa);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swiperefresh);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorAccent,R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                        startActivity(getIntent());
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 2000);
            }
            });

                //Tampilan menu dropdown
                /*
                Spinner spinner = findViewById(R.id.spinner1);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.fmipa, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
                spinner.setOnItemSelectedListener(this);
                */

                id_d = new ArrayList<>();
                nama_d = new ArrayList<>();
                juru = new ArrayList<>();
                faku = new ArrayList<>();
                komu = new ArrayList<>();

                rvView = (RecyclerView) findViewById(R.id.rv_main);
                rvView.setHasFixedSize(true);

               layoutManager = new LinearLayoutManager(this);
                //layoutManager = new LinearLayoutManager(this);
                rvView.setLayoutManager(layoutManager);


                getJSON();


                //Toast.makeText(Kategori.this,"Get Json : "+namakate.size(),Toast.LENGTH_SHORT).show();

            }

            private void showEmployee() {
                if (!id_d.isEmpty()) {
                    id_d.clear();
                }
                if (!nama_d.isEmpty()) {
                    nama_d.clear();
                }
                if (!juru.isEmpty()) {
                    juru.clear();
                }
                if (!faku.isEmpty()) {
                    faku.clear();
                }
                if (!komu.isEmpty()) {
                    komu.clear();
                }
                JSONObject jsonObject = null;
//        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
                try {
                    jsonObject = new JSONObject(JSON_STRING);
                    JSONArray result = jsonObject.getJSONArray(konfigurasidosen.TAG_JSON_ARRAY);

                    for (int i = 0; i < result.length(); i++) {
                        JSONObject jo = result.getJSONObject(i);
                        String id_dos = jo.getString(konfigurasidosen.TAG_id_dosen);
                        String nama_dos = jo.getString(konfigurasidosen.TAG_nama_dosen);
                        String jur = jo.getString(konfigurasidosen.TAG_jurusan);
                        String fak = jo.getString(konfigurasidosen.TAG_fakultas);
                        String kom = jo.getString(konfigurasidosen.TAG_komuditi);

                        id_d.add(id_dos);
                        nama_d.add(nama_dos);
                        juru.add(jur);
                        faku.add(fak);
                        komu.add(kom);

//                HashMap<String,String> employees = new HashMap<>();
//                employees.put(Konfigurasi.TAG_ID,id);
//                employees.put(Konfigurasi.TAG_NAMA,nama_kategor);
//                list.add(employees);
                    }
                    adapter = new RecycleViewAdapter(id_d, nama_d, juru, faku, komu);
                    rvView.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

//        ListAdapter adapter = new SimpleAdapter(
//                TampilSemuaPgw.this, list, R.layout.list_item,
//                new String[]{konfigurasi.TAG_ID,konfigurasi.TAG_NAMA},
//                new int[]{R.id.id, R.id.name});
//
//        listView.setAdapter(adapter);
            }

            private void getJSON() {
                class GetJSON extends AsyncTask<Void, Void, String> {

                    ProgressDialog loading;

                    @Override
                    protected void onPreExecute() {
                        super.onPreExecute();
                        loading = ProgressDialog.show(f_mipa.this, "Mengambil Data", "Mohon Tunggu...", false, false);
                    }

                    @Override
                    protected void onPostExecute(String s) {
                        super.onPostExecute(s);
                        loading.dismiss();
                        JSON_STRING = s;
                        showEmployee();
                    }

                    @Override
                    protected String doInBackground(Void... params) {
                        RequestHandler rh = new RequestHandler();
                        String s = rh.sendGetRequest(konfigurasidosen.URL_GET_ALL);
                        return s;
                    }
                }
                GetJSON gj = new GetJSON();
                gj.execute();
            }
}
