package model;

import java.util.ArrayList;
import java.util.Objects;

public class monHoc {
    private int ID;
    private String ten;
    private int soMonMoiTuan;
    private int score = 0;
    private ArrayList<giaoVien> giaoViens;



    public monHoc(int ID, String ten, int soMonMoiTuan) {
        this.ID = ID;
        this.ten = ten;
        this.soMonMoiTuan = soMonMoiTuan;
    }

    public  monHoc (monHoc mh){
        this.ID = mh.getID();
        this.ten = mh.getTen();
        this.soMonMoiTuan = mh.getSoMonMoiTuan();
        this.giaoViens = mh.getGiaoViens();
    }

    public monHoc(int ID, String ten, int soMonMoiTuan, ArrayList<giaoVien> giaoViens) {
        this.ID = ID;
        this.ten = ten;
        this.soMonMoiTuan = soMonMoiTuan;
        this.giaoViens = giaoViens;
    }

    public monHoc(int ID, String ten, int soMonMoiTuan, int score, ArrayList<giaoVien> giaoViens) {
        this.ID = ID;
        this.ten = ten;
        this.soMonMoiTuan = soMonMoiTuan;
        this.score = score;
        this.giaoViens = giaoViens;
    }

    public int getScore() {
        return score;
    }

    public void changeMonHoc (monHoc mh){
        this.ID = mh.getID();
        this.ten = mh.getTen();
        this.soMonMoiTuan = mh.getSoMonMoiTuan();
        this.giaoViens = mh.getGiaoViens();
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getSoMonMoiTuan() {
        return soMonMoiTuan;
    }

    public void setSoMonMoiTuan(int soMonMoiTuan) {
        this.soMonMoiTuan = soMonMoiTuan;
    }

    public ArrayList<giaoVien> getGiaoViens() {
        return giaoViens;
    }

    public void setGiaoViens(ArrayList<giaoVien> giaoViens) {
        this.giaoViens = giaoViens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        monHoc monHoc = (monHoc) o;
        return ID == monHoc.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }
}
