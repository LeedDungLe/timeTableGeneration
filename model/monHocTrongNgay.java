package model;


import java.util.*;

import static hangSo.cacHangSo.SO_TIET;

public class monHocTrongNgay {
    private List<monHoc> monHocs = new ArrayList<>(SO_TIET);
    private int sumScore;
    private boolean AcceptableNgay;

    public monHocTrongNgay() {
    }

    public monHocTrongNgay(List<monHoc> monHocs) {
        this.monHocs = monHocs;
    }

    public List<monHoc> getMonHocs() {
        return monHocs;
    }



    public void setMonHocs(List<monHoc> monHocs) {
        this.monHocs = monHocs;
    }

    public int getSumScore() {
        return sumScore;
    }

    public void setSumScore(int sumScore) {
        this.sumScore = sumScore;
    }

    public boolean isAcceptableNgay() {
        return AcceptableNgay;
    }

    public void setAcceptableNgay(boolean acceptableNgay) {
        AcceptableNgay = acceptableNgay;
    }

    public void nhomMonHocTrongNgay(){
        int index = 0;
        for (int i = index+1; i < this.monHocs.size(); i++){
            if (this.monHocs.get(index) == this.monHocs.get(i) ){
                Collections.swap(monHocs,i,index+1);
                index++;
            }
        }
    }

    public void setScoreTrongNgay(){
        for (int i =0; i < SO_TIET; i++){
            if( i == 1 || i == 2){
                if ( this.monHocs.get(i).getID() == this.monHocs.get(i-1).getID() && this.monHocs.get(i).getID() == this.monHocs.get(i+1).getID()){
                    this.monHocs.get(i).setScore(2);
                }
                else if ( this.monHocs.get(i).getID() == this.monHocs.get(i-1).getID() || this.monHocs.get(i).getID() == this.monHocs.get(i+1).getID() ) this.monHocs.get(i).setScore(1);
                else this.monHocs.get(i).setScore(0);
            }
            else if (i == 0){
                if ( this.monHocs.get(0).getID() == this.monHocs.get(1).getID()) this.monHocs.get(0).setScore(1);
                else this.monHocs.get(i).setScore(0);
            }
            else if (i==3){
                if ( this.monHocs.get(3).getID() == this.monHocs.get(2).getID()) this.monHocs.get(3).setScore(1);
                else this.monHocs.get(i).setScore(0);
            }
        }
    }

    public void CalcSumScore(){
        int sum = 0;
        for (int j=0; j < SO_TIET; j++){
            sum += this.monHocs.get(j).getScore();
        }
        this.sumScore = sum;
    }

    public void kiemTraAcceptableNgay(){
        if(this.sumScore == 2){
            for (int j=0; j < SO_TIET; j++){
                if(monHocs.get(j).getScore() == 1 && monHocs.get(j).getSoMonMoiTuan() == 2){
                    this.AcceptableNgay = false;
                }
            }
        }
        if(this.sumScore >= 3) this.AcceptableNgay = false;
        this.AcceptableNgay = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        monHocTrongNgay that = (monHocTrongNgay) o;
        return monHocs.equals(that.monHocs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(monHocs);
    }
}
