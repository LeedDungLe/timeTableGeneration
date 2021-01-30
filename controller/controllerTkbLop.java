package controller;

import database.connectDB;
import model.monHoc;
import model.tkbLop;

import java.util.ArrayList;
import java.util.Collections;

import static hangSo.cacHangSo.SO_NGAY_TRONG_TUAN;
import static hangSo.cacHangSo.SO_TIET;

public class controllerTkbLop {
    private  tkbLop tkbLop;

    public model.tkbLop getTkbLop() {
        return tkbLop;
    }

    public void setTkbLop(model.tkbLop tkbLop) {
        this.tkbLop = tkbLop;
    }

    public ArrayList<monHoc> getAllMonHoc(){
         connectDB db =new connectDB();
         ArrayList<monHoc> temp = db.getMonHocs();
         ArrayList<monHoc> monHocs = new ArrayList<>();
         // tao ra 25 tiet hoc theo du so luong tung mon
         for( monHoc mh :  temp) {
             for (int i = 0; i < mh.getSoMonMoiTuan(); i++){
                 monHoc monHoc = new monHoc(mh);
                 monHoc.setGiaoViens(db.getGiaoVienPhuTrach(monHoc.getID()));
                 monHocs.add(monHoc);
             }
         }
         return monHocs;
     }


    // Tao tkb cho mot lop thoa man cac rang buoc trong mot lop
    public tkbLop taoTKBLop(ArrayList<monHoc> monHocs){
        tkbLop = new tkbLop();

       // ArrayList<monHoc> monHocs = getAllMonHoc();
        //xao tron 24 mon hoc
        Collections.shuffle(monHocs);

        tkbLop.getValues(monHocs);
    
        tkbLop.khuTrungLapMon();

        //tkbLop.showTimeTable();

        return  tkbLop;
    }




}
