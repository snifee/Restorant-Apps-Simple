package com.koneksi;

import java.sql.*;
import com.mysql.jdbc.*;
import com.gui.warningJOpPanel;

public class koneksiSQL {
    private static Connection KONEKSI;
    private static Statement statement;
    private static ResultSet resultSet;

    public static Connection getKoneksi(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9384600";
            String user = "sql9384600";
            String passwd = "ElZ7eQfHsv";
//            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            KONEKSI = DriverManager.getConnection(url,user,passwd);

        }catch (Exception e){
            System.err.println("Gagal Dalam Membuat Koneksi");
            new warningJOpPanel().setTextWarning("Gagal Dalam Membuat Koneksi",e.getMessage());
        }
        return KONEKSI;
    }

    public static void insertData(String nama, String harga, int qty){

        try {
            statement = getKoneksi().createStatement();
            String query = "INSERT into R_List_Penjualan (ID,Nama,Harga,Jumlah) VALUES(0,'%s','%s','%d')";
            query = String.format(query,nama,harga,qty);
            statement.execute(query);
            statement.close();
            KONEKSI.close();
        }catch (Exception e){
            System.out.println("Error Insert");
            new warningJOpPanel().setTextWarning("Error Dalam Insert Data Ke Database",e.getMessage());
        }
    }



}
