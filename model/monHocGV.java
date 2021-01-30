/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author Admin
 */
public class monHocGV {
    private int ID;
    private List<giaoVien> giaoViens;

    public monHocGV(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public List<giaoVien> getGiaoViens() {
        return giaoViens;
    }

    public void setGiaoViens(List<giaoVien> giaoViens) {
        this.giaoViens = giaoViens;
    }
    
    
    
    
}
