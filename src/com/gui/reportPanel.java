package com.gui;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.koneksi.koneksiSQL;


public class reportPanel extends JPanel{
    private JLabel logoReport;
    private JPanel reportHeader;
    private JPanel menuFoodPanel;
    private JScrollPane menuScroll;
    private DefaultTableModel model;
    private JTable table;
    private int screenWidth;
    private int screenHeight;
    private JButton buttonR;
    public reportPanel(){
        logoReport = new JLabel();
        reportHeader = new JPanel();
        buttonR = new JButton("Refresh");

        model = new DefaultTableModel();
        table = new JTable();
        screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;

        try{
            logoReport.setIcon(new ImageIcon(getClass().getResource("/com/icon/reportresto.png")));
        }catch(Exception e){

        }

        this.setBackground(Color.white);
        reportHeader.setPreferredSize(new Dimension(screenWidth-120-500,200));
        reportHeader.setMaximumSize(new Dimension(screenWidth-120-500,200));
        reportHeader.setBackground(Color.white);
        reportHeader.add(logoReport);

        menuScroll = new JScrollPane(table);
        menuScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        menuScroll.setPreferredSize(new Dimension(screenWidth-120-500,(screenHeight-200-10)));
        menuScroll.setMaximumSize(new Dimension(screenWidth-120-500,(screenHeight-200-10)));

        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        model.addColumn("ID");
        model.addColumn("Nama Barang");
        model.addColumn("Harga");
        model.addColumn("Jumlah");
        model.addColumn("Waktu");
        table.setRowHeight(30);
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(300);
        table.setRowSelectionAllowed(true);

        buttonR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                loadReportFromDB();
            }
        });


        GridLayout ly = new GridLayout(0,4);
        GroupLayout mainGrupLayout = new GroupLayout(this);
        mainGrupLayout.setAutoCreateContainerGaps(true);
        mainGrupLayout.setAutoCreateContainerGaps(true);
        this.setLayout(mainGrupLayout);
        mainGrupLayout.setHorizontalGroup(mainGrupLayout.createSequentialGroup()
                .addGroup(mainGrupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(reportHeader)
                        .addComponent(buttonR)
                        .addComponent(menuScroll))
        );
        mainGrupLayout.setVerticalGroup(mainGrupLayout.createSequentialGroup()
                .addGroup(mainGrupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(reportHeader))
                .addGroup(mainGrupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonR))
                .addGroup(mainGrupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(menuScroll))
        );
    }

    public void addMenu(menuItem mn){
        menuFoodPanel.add(mn);
    }

    public void loadReportFromDB(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        try{
            Connection conn = koneksiSQL.getKoneksi();
            Statement statement = conn.createStatement();
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM R_List_Penjualan");

            while(resultSet.next()){
                Object[] data = new Object[5];
                data[0] = resultSet.getString("ID");
                data[1] = resultSet.getString("Nama");
                data[2] = resultSet.getString("Harga");
                data[3] = resultSet.getString("Jumlah");
                data[4] = resultSet.getString("Waktu");
                model.addRow(data);
            }

            conn.close();
            stmt.close();
        }catch (SQLException e){
            System.err.println(e);
        }

    }

}

