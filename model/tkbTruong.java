package model;

import java.util.ArrayList;
import java.util.List;

import static hangSo.cacHangSo.SO_LOP_HOC;

public class tkbTruong {
    private List<tkbLop> tkbs = new ArrayList<>(SO_LOP_HOC);
    private int score;

    public tkbTruong(List<tkbLop> tkbs) {
        this.tkbs = tkbs;
    }

    public List<tkbLop> getTkbs() {
        return tkbs;
    }

    public void setTkbs(List<tkbLop> tkbs) {
        this.tkbs = tkbs;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
