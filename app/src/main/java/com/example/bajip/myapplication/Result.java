package com.example.bajip.myapplication;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("id_dosen")
    @Expose
    private String idDosen;
    @SerializedName("nama_dosen")
    @Expose
    private String namaDosen;
    @SerializedName("fakultas")
    @Expose
    private String fakultas;
    @SerializedName("jurusan")
    @Expose
    private String jurusan;
    @SerializedName("komuditi")
    @Expose
    private String komuditi;

    public String getIdDosen() {
        return idDosen;
    }

    public void setIdDosen(String idDosen) {
        this.idDosen = idDosen;
    }

    public String getNamaDosen() {
        return namaDosen;
    }

    public void setNamaDosen(String namaDosen) {
        this.namaDosen = namaDosen;
    }

    public String getFakultas() {
        return fakultas;
    }

    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getKomuditi() {
        return komuditi;
    }

    public void setKomuditi(String komuditi) {
        this.komuditi = komuditi;
    }

}