import controller.controllerTkbLop;
import database.connectDB;
import model.monHoc;
import model.tkbLop;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class Main {


    public static void main(String[] args) {
        controllerTkbLop tkbLopController = new controllerTkbLop();
        tkbLop tkbLoprand = tkbLopController.taoTKBLop();



    }
}
