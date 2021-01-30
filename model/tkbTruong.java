package model;

import java.util.ArrayList;
import java.util.List;

import static hangSo.cacHangSo.*;
import java.util.Collections;

import java.util.Objects;


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

    
      
    
        

    
    public boolean kiemTra(){
        for (int i =0; i < SO_NGAY_TRONG_TUAN; i++){
            for (int j = 0; j< SO_TIET; j++){
               for( int k = 0; k < SO_LOP_HOC; k++){
                   for( int h= k+1; h < SO_LOP_HOC; h++){
                       if(tkbs.get(k).gettkb().get(i).getMonHocs().get(j).getGiaoViens().getId()
                           == tkbs.get(h).gettkb().get(i).getMonHocs().get(j).getGiaoViens().getId()){

                                    return false;
                       }             
                   }   
               }
            }
        }
        return true;
    }

    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.tkbs);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final tkbTruong other = (tkbTruong) obj;
        return true;
    }
    
}
