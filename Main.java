import controller.controllerTkbLop;
import controller.controllerTkbTruong;
import database.connectDB;
import model.monHoc;
import model.tkbLop;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class Main {


    public static void main(String[] args) {
      //  controllerTkbLop tkbLopController = new controllerTkbLop();
        controllerTkbTruong tkbTruongctrl = new controllerTkbTruong();
        tkbTruongctrl.taoTKBTruong();


    }
}
