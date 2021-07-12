package com.gui;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.koneksi.koneksiSQL;


public class menuPanel extends JPanel{
    private JLabel logoFoodMenu;
    private JPanel foodMenuHeader;
    private JPanel menuFoodPanel;
    private JScrollPane menuScroll;
    private int screenWidth;
    private int screenHeight;
    public menuPanel(String imgSrc){
        logoFoodMenu= new JLabel();
        foodMenuHeader = new JPanel();
        menuFoodPanel = new JPanel();
        screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;

        logoFoodMenu.setIcon(new ImageIcon(getClass().getResource(imgSrc)));
        this.setBackground(Color.white);
        foodMenuHeader.setPreferredSize(new Dimension(screenWidth-120-500,200));
        foodMenuHeader.setMaximumSize(new Dimension(screenWidth-120-500,200));
        foodMenuHeader.setBackground(Color.white);
        foodMenuHeader.add(logoFoodMenu);
//        menuFoodPanel.setPreferredSize(new Dimension(screenWidth-120-500,(screenHeight-200-10)));
//        menuFoodPanel.setMaximumSize(new Dimension(screenWidth-120-500,(screenHeight-200-10)));
        menuScroll = new JScrollPane(menuFoodPanel);
        menuScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        menuScroll.setPreferredSize(new Dimension(screenWidth-120-500,(screenHeight-200-10)));
        menuScroll.setMaximumSize(new Dimension(screenWidth-120-500,(screenHeight-200-10)));
        menuFoodPanel.setBackground(Color.white);
        GridLayout ly = new GridLayout(0,4);

        menuFoodPanel.setLayout(ly);

        GroupLayout mainGrupLayout = new GroupLayout(this);
        mainGrupLayout.setAutoCreateContainerGaps(true);
        mainGrupLayout.setAutoCreateContainerGaps(true);
        this.setLayout(mainGrupLayout);
        mainGrupLayout.setHorizontalGroup(mainGrupLayout.createSequentialGroup()
                .addGroup(mainGrupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(foodMenuHeader)
                        .addComponent(menuScroll))
        );
        mainGrupLayout.setVerticalGroup(mainGrupLayout.createSequentialGroup()
                .addGroup(mainGrupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(foodMenuHeader))
                .addGroup(mainGrupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(menuScroll))
        );
    }

    public void addMenu(menuItem mn){
        menuFoodPanel.add(mn);
    }

    public void loadMenuFromDatabase(String query){
        try{
            Connection con = koneksiSQL.getKoneksi();
            Statement statement = con.createStatement();

            ResultSet rs = statement.executeQuery(query);
            String nama,harga;
            while (rs.next()){
                nama = rs.getString("Nama");
                harga = rs.getString("Harga");
                addMenu(new menuItem("/com/icon/menu/"+nama+".png",harga, nama));
            }
            statement.close();
            con.close();
        }catch (SQLException e){
            System.err.println(e);
        }

    }

}
