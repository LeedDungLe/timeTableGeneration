package model;

import java.util.ArrayList;

public class giaoVien {
    private int id;
    private String ten;
    private ArrayList<monHoc> monHocs;

    public giaoVien(int id, String ten, ArrayList<monHoc> monPhuTrach) {
        this.id = id;
        this.ten = ten;
        this.monHocs= monPhuTrach;
    }

    public giaoVien(int id, String ten) {
        this.id = id;
        this.ten = ten;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public ArrayList<monHoc> getMonHocs() {
        return monHocs;
    }

    public void setMonHocs(ArrayList<monHoc> monHocs) {
        this.monHocs = monHocs;
    }
}
