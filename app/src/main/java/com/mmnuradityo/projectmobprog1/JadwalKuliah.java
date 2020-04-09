package com.mmnuradityo.projectmobprog1;

public class JadwalKuliah {
    private String mataKuliah;
    private String jamKuliah;

    public JadwalKuliah (String mataKuliah, String jamKuliah) {
        this.mataKuliah = mataKuliah;
        this.jamKuliah = jamKuliah;
    }

    public String getMataKuliah() {
        return mataKuliah;
    }

    public void setMataKuliah(String mataKuliah) {
        this.mataKuliah = mataKuliah;
    }

    public String getJamKuliah() {
        return jamKuliah;
    }

    public void setJamKuliah(String jamKuliah) {
        this.jamKuliah = jamKuliah;
    }
}
