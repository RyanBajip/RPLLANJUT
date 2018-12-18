package com.example.bajip.myapplication;

public class konfigurasidosen {
    public static final String URL_GET_ALL = "http://umam-developer.com/API/hijab/TampilDosen.php";
    public static final String URL_ADD_PRODUK = "http://umam-developer.com/API/hijab/tambahHijab.php";
    public static final String URL_GET_EMP = "http://umam-developer.com/API/hijab/tampilKategori.php?kategori_id=";
    public static final String URL_UPDATE_EMP = "http://umam-developer.com/API/hijab/updateKategori.php";
    public static final String URL_DELETE_EMP = "http://umam-developer.com/API/hijab/hapusKategori.php";

    //Dibawah ini merupakan Kunci yang akan digunakan untuk mengirim permintaan ke Skrip PHP
    public static final String KEY_EMP_ID_KATEGORI = "kategori_id";
    public static final String KEY_EMP_NAMA = "barang_nama";
    public static final String KEY_EMP_GAMBAR = "gambar";
    public static final String KEY_EMP_HARGA = "harga";
    public static final String KEY_EMP_STOK = "stok";
    public static final String KEY_EMP_NAMAKAT = "nama_kategori";


    //JSON Tags
    public static final String TAG_JSON_ARRAY = "result";
    public static final String TAG_id_dosen = "id_dosen";
    public static final String TAG_nama_dosen = "nama_dosen";
    public static final String TAG_fakultas = "fakultas";
    public static final String TAG_jurusan = "jurusan";
    public static final String TAG_komuditi = "komuditi";

    //ID karyawan
    //emp itu singkatan dari Employee
    public static final String EMP_ID = "emp_id";
}
