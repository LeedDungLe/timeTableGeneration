package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static hangSo.cacHangSo.SO_NGAY_TRONG_TUAN;
import static hangSo.cacHangSo.SO_TIET;
import java.util.Collection;
import java.util.Collections;

public class tkbLop {

  private boolean acceptable = false;
    private List<monHocTrongNgay> tkb = new ArrayList<>(SO_NGAY_TRONG_TUAN);

    public tkbLop(List<monHocTrongNgay> tkb) {
        this.tkb = tkb;
    }

    public tkbLop() {
    }

    public tkbLop(tkbLop temp) {
        this.tkb = temp.gettkb();
    }


    
    
    public List<monHocTrongNgay> gettkb() {
        return tkb;
    }

    public void settkb(List<monHocTrongNgay> tkb) {
        this.tkb = tkb;
    }

    public void getValues(ArrayList<monHoc> monHocs){
        int a =0;
        for (int i = 0; i < SO_NGAY_TRONG_TUAN; i++){
            monHocTrongNgay mhtns = new monHocTrongNgay();
            for (int j=0; j < SO_TIET; j++){
               mhtns.getMonHocs().add(monHocs.get(a))  ;
                a++;
            }
            tkb.add(mhtns);
        }
    }


    public void  KhoiTaoTkbLop(){
        for (int i = 0; i < SO_NGAY_TRONG_TUAN; i++){
            tkb.get(i).nhomMonHocTrongNgay();
            tkb.get(i).setScoreTrongNgay();
        }
    }




    public void khuTrungLapMon(){
        KhoiTaoTkbLop();
        int[] sumScore = {0,0,0,0,0,0};
        


        while (acceptable != true){
            for (int i = 0; i <SO_NGAY_TRONG_TUAN; i++){
                sumScore[i] = tkb.get(i).getSumScore();
            }
            for (int i = 0; i <SO_NGAY_TRONG_TUAN; i++){

                // 4 môn toán trong một ngày
                if(sumScore[i] == 6){
                    int rand1 = random(i);
                    int rand2 = random(i);

                    // swap(tkb[i][0], tkb[rand1][0]);
                    monHoc temp1 = tkb.get(i).getMonHocs().get(0);
                    tkb.get(i).getMonHocs().get(0).changeMonHoc(tkb.get(rand1).getMonHocs().get(0));
                    tkb.get(rand1).getMonHocs().get(0).changeMonHoc(temp1);

                    //swap(tkb[i][3], tkb[rand2][3]);
                    monHoc temp2 = tkb.get(i).getMonHocs().get(3);
                    tkb.get(i).getMonHocs().get(3).changeMonHoc(tkb.get(rand2).getMonHocs().get(3));
                    tkb.get(rand2).getMonHocs().get(3).changeMonHoc(temp2);

                    tkb.get(i).nhomMonHocTrongNgay();
                    tkb.get(rand1).nhomMonHocTrongNgay();
                    tkb.get(rand2).nhomMonHocTrongNgay();

                    tkb.get(i).setScoreTrongNgay();
                    tkb.get(rand1).setScoreTrongNgay();
                    tkb.get(rand2).setScoreTrongNgay();

                    tkb.get(i).CalcSumScore();
                    tkb.get(rand1).CalcSumScore();
                    tkb.get(rand2).CalcSumScore();

                    sumScore[i] = tkb.get(i).getSumScore();
                    sumScore[rand1] = tkb.get(rand1).getSumScore();
                    sumScore[rand2] = tkb.get(rand2).getSumScore();
                }
                // 3 môn giống nhau trong 1 ngày (1,2,1) hoặc 2 cặp môn giống nhau (1,1,1,1)
                if(sumScore[i] == 4){
                    int rand = random(i);
                    //swap(tkb[i][1], tkb[rand][1]);
                    monHoc temp = tkb.get(i).getMonHocs().get(1);
                    tkb.get(i).getMonHocs().get(1).changeMonHoc(tkb.get(rand).getMonHocs().get(1));
                    tkb.get(rand).getMonHocs().get(1).changeMonHoc(temp);

                    tkb.get(i).nhomMonHocTrongNgay();
                    tkb.get(rand).nhomMonHocTrongNgay();

                    tkb.get(i).setScoreTrongNgay();
                    tkb.get(rand).setScoreTrongNgay();

                    tkb.get(i).CalcSumScore();
                    tkb.get(rand).CalcSumScore();

                    sumScore[i] = tkb.get(i).getSumScore();
                    sumScore[rand] = tkb.get(rand).getSumScore();
                }
                // 2 môn giống nhau có số lượng tiết yêu cầu trong tuần là 2
                if(sumScore[i] == 2){
                    System.out.println("HHHHHHHHHHHHHHHHHHHHHHHH");
                    for (int j=0; j < SO_TIET; j++){
                        if(tkb.get(i).getMonHocs().get(j).getScore() == 1 && tkb.get(i).getMonHocs().get(j).getSoMonMoiTuan() == 2){
                            int rand = random(i);

                            monHoc temp = tkb.get(i).getMonHocs().get(j);
                            tkb.get(i).getMonHocs().get(j).changeMonHoc(tkb.get(rand).getMonHocs().get(j));
                            tkb.get(rand).getMonHocs().get(j).changeMonHoc(temp);

                            tkb.get(i).nhomMonHocTrongNgay();
                            tkb.get(rand).nhomMonHocTrongNgay();

                            tkb.get(i).setScoreTrongNgay();
                            tkb.get(rand).setScoreTrongNgay();

                            tkb.get(i).CalcSumScore();
                            tkb.get(rand).CalcSumScore();

                            sumScore[i] = tkb.get(i).getSumScore();
                            sumScore[rand] = tkb.get(rand).getSumScore();
                             
                            break;
                        }
                    }
                }
            }
             //showScore();
            acceptable = kiemTraAcceptableTKB(tkb);
            if (acceptable == false){
                //showTimeTable();
            }
        }



    }





    public boolean kiemTraAcceptableTKB(List<monHocTrongNgay> tkb){
        for (int i = 0; i < 6; i++){
            tkb.get(i).kiemTraAcceptableNgay();
            if(tkb.get(i).isAcceptableNgay() == false) {
                System.out.println("false at i = "+ i);
                return false;
            }
        }
        return true;
    }

    public void showScore(){
        for (int i = 0; i <6; i++){
            tkb.get(i).CalcSumScore();
            System.out.print(tkb.get(i).getSumScore());
        }
        System.out.println();
    }

    public int random(int i){
        // sinh ra so integer trong khoang [0,5]
        int rnd = new Random().nextInt(6);
        if(i == rnd) return (i+1)%6;
        else return rnd;
    }
    public void showTimeTable(){
        for (int i = 0; i <SO_NGAY_TRONG_TUAN; i++){
                    for (int j=0; j < SO_TIET; j++){
                        System.out.print(tkb.get(i).getMonHocs().get(j).getTen()+"("+tkb.get(i).getMonHocs().get(j).getScore()+")"+" | ");
                    }
                    System.out.println();
                }
    }
    
    public void XaoTron(){
        Collections.shuffle(tkb);
    }
}
