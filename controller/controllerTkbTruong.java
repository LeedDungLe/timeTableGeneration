package controller;

import database.connectDB;
import static hangSo.cacHangSo.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import model.*;

public class controllerTkbTruong {
    private tkbTruong tkb;
    private controllerTkbLop LopController;
    private Set<tkbLop> quanTheTKBLop ;
    private ArrayList<giaoVien> giaoViens;
    
    public controllerTkbTruong() {
         this.LopController = new controllerTkbLop();   
         this.quanTheTKBLop = new HashSet<>();
         
    }

    public tkbTruong getTkb() {
        return tkb;
    }

    public void setTkb(tkbTruong tkb) {
        this.tkb = tkb;
    }
   
   
    
     
    public void taoTKBTruong(){
         ArrayList<monHoc>  dataDB = LopController.getAllMonHoc();
         
         // Tao ra 15 tkbLop hoan chinh
        for (int i = 0; i < 15; i++){
            tkbLop tkbLopTemp = new tkbLop(LopController.taoTKBLop(dataDB));
            System.out.println(i);
             quanTheTKBLop.add(tkbLopTemp);
         }
        
        //Tao ra 1 tkb truong ngau nhien
        List<tkbLop> tempList = new ArrayList(quanTheTKBLop);  
         tkb = new tkbTruong(tempList);
           // tkb.setTkbs(tempList);
        
            
        // Mot mang giao vien de su dung cho qua trinh dot bien     
        connectDB db =new connectDB();
        List<monHocGV> monhocGVs = db.getMonHocGVs();
        for( monHocGV mh : monhocGVs){
            mh.setGiaoViens(db.getGiaoVienPhuTrachs(mh.getID()));
        }
        
        //Sinh tkb thong nhat
        int count = 0;
        
        while (tkb.kiemTra() != true){
           int rnd = new Random().nextInt(20);
            int flag = 0;
            for (int i =0; i < SO_NGAY_TRONG_TUAN; i++){
                for (int j = 0; j< SO_TIET; j++){
                   for( int k = 0; k < SO_LOP_HOC; k++){
                       for( int h= k+1; h < SO_LOP_HOC; h++){
                           if(tkb.getTkbs().get(k).gettkb().get(i).getMonHocs().get(j).getGiaoViens().getId()
                               == tkb.getTkbs().get(h).gettkb().get(i).getMonHocs().get(j).getGiaoViens().getId()){
                                        if(rnd < 6){
                                            System.out.println("ngay "+ i +" Tiet "+j+": Lop "+k+ " = Lop "+ h );
                                            System.out.println(tkb.getTkbs().get(k).gettkb().get(i).getMonHocs().get(j).getGiaoViens().getTen()+ " : "+tkb.getTkbs().get(k).gettkb().get(i).getMonHocs().get(j).getTen());
                                            System.out.println("-----------------------------------------");
                                            //tkb.getTkbs().get(h).gettkb().get(i).xaoTron();
                                            tkb.getTkbs().get(k).gettkb().get(i).xaoTron();
                                            flag = 1;
                                            break;
                                        }
                                         if (rnd >= 6 && rnd < 10 ){
                                             System.out.println("ngay "+ i +" Tiet "+j+": Lop "+k+ " = Lop "+ h );
                                            System.out.println(tkb.getTkbs().get(k).gettkb().get(i).getMonHocs().get(j).getGiaoViens().getTen()+ " : "+tkb.getTkbs().get(k).gettkb().get(i).getMonHocs().get(j).getTen());
                                            System.out.println("-----------------------------------------");                                            
                                            tkbLop tkbLopTemp = new tkbLop(LopController.taoTKBLop(dataDB));
                                            tkb.getTkbs().get(h).settkb(tkbLopTemp.gettkb());
                                             flag = 1;
                                            break;
                                        }
                                         if (rnd >= 10){
                                             for( monHocGV mh : monhocGVs){
                                                if(tkb.getTkbs().get(k).gettkb().get(i).getMonHocs().get(j).getID() == mh.getID()){
                                                        if( mh.getGiaoViens().size() > 1){
                                                            System.out.println("ngay "+ i +" Tiet "+j+": Lop "+k+ " = Lop "+ h );
                                                            System.out.println(tkb.getTkbs().get(k).gettkb().get(i).getMonHocs().get(j).getGiaoViens().getTen()+ " : "+tkb.getTkbs().get(k).gettkb().get(i).getMonHocs().get(j).getTen());
                                                            System.out.println("-----------------------------------------");                                                            
                                                            List<giaoVien> gvTemps = mh.getGiaoViens();
                                                            gvTemps.remove(tkb.getTkbs().get(k).gettkb().get(i).getMonHocs().get(j).getGiaoViens());
                                                            Random rand = new Random();
                                                            giaoVien gv =   gvTemps.get(rand.nextInt(gvTemps.size()));
                                                            tkb.getTkbs().get(k).gettkb().get(i).getMonHocs().get(j).setGiaoViens(gv);
//                                                             flag = 1;
//                                                             break;
                                                        }
                                                        break;
                                                }
                                            }
                                        }
                                    

                           }             
                       }   
                   }if (flag == 1) break;
                } if (flag == 1) break;
            }
           
          
           
            count ++;
            System.out.println(count);
        }
        
        System.out.println("done");
        
    }

    
    
    }
    

