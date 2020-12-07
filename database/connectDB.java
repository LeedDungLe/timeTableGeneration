package database;

import model.giaoVien;
import model.monHoc;

import java.sql.*;
import java.util.ArrayList;

import static java.sql.DriverManager.getConnection;

public class connectDB {
    private Connection conn;
    private PreparedStatement ps ;
    private ArrayList<monHoc> monHocs;
    private ArrayList<giaoVien> giaoViens;

    public static Connection openConnection() {

        String DB_URL = "jdbc:mysql://127.0.0.1/project?useLegacyDatetimeCode=false&serverTimezone=UTC";
        String USER_NAME = "root";
        String PASSWORD = "";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }

    public ArrayList<monHoc> getMonHocs(){
        conn = openConnection();
        monHocs = new ArrayList<>();
        String query = "SELECT * FROM monhoc";

        try {
            PreparedStatement ps =  conn.prepareCall(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                monHoc monhoc = new monHoc(rs.getInt("id"),rs.getString("ten"),rs.getInt("soLuong"));
                monHocs.add(monhoc);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return monHocs;
    }

    public ArrayList<monHoc> getMonHocPhuTrach(int IDgiaovien){
        conn = openConnection();
        monHocs = new ArrayList<>();
        String query = "SELECT monhoc.* FROM monhoc,phutrach WHERE monhoc.id=phutrach.monhoc_id and phutrach.giaovien_id = "+IDgiaovien;

        try {
            PreparedStatement ps =  conn.prepareCall(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                monHoc monhoc = new monHoc(rs.getInt("id"),rs.getString("ten"),rs.getInt("soLuong"));
                monHocs.add(monhoc);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return monHocs;
    }

    public ArrayList<giaoVien> getGiaoViens(){
        conn = openConnection();
        giaoViens = new ArrayList<>();
        String query = "SELECT * FROM giaovien";
        try {
            PreparedStatement ps =  conn.prepareCall(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                giaoVien giaovien = new giaoVien(rs.getInt("id"),rs.getString("ten"));
                giaoViens.add(giaovien);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return giaoViens;
    }

    public ArrayList<giaoVien> getGiaoVienPhuTrach( int IDmonhoc){
        conn = openConnection();
        giaoViens = new ArrayList<>();
        String query = "SELECT giaovien.* FROM giaovien,phutrach WHERE giaovien.id=phutrach.giaovien_id and phutrach.monhoc_id = "+ IDmonhoc;
        try {
            PreparedStatement ps =  conn.prepareCall(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                giaoVien giaovien = new giaoVien(rs.getInt("id"),rs.getString("ten"));
                giaoViens.add(giaovien);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return giaoViens;
    }

}
