package com.gui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.koneksi.koneksiSQL;

public class takedItem extends JPanel{
    private JPanel panel1;
    private JButton kurang;
    private JButton tambah;
    private JLabel labelHarga;
    private JLabel labelNama;
    private JTextField qtyText;
    menuItem buffer;
    int qty;
    public String foodPrice;
    public String foodName;

    public takedItem(String foodName, String foodPrice){
        panel1 = new JPanel();
        this.foodPrice = foodPrice;
        this.foodName = foodName;
        this.qty=0;
        qtyText = new JTextField();
        qtyText.setText("0");
        qtyText.setPreferredSize(new Dimension(35,30));
        qtyText.setEditable(false);
        tambah = new JButton("Tambah");
        kurang = new JButton("kurang");
        tambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                increment();
            }
        });

        kurang.addActionListener(new ActionListener() {
            boolean clicked;
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (qty!=0){
                    clicked = false;
                    qty--;
                }else if (clicked==false){
                    qty--;
                    if (qty==0){
                        setVisible(false);
                        kurang.setEnabled(false);
                        buffer.clicked=false;
                        paymentPanel.loadData();
                    }
                }
                String temp = String.valueOf(qty);
                qtyText.setText(temp);
            }
        });
        labelHarga = new JLabel("| Rp."+foodPrice);
        labelNama = new JLabel(foodName);
        setMaximumSize(new Dimension(490,60));
        panel1.setPreferredSize(new Dimension(200,50));
        panel1.add(labelNama);
        panel1.add(labelHarga);
        panel1.setLayout(new GridLayout(1,2));
        panel1.setBackground(Color.white);


        add(tambah);
        add(qtyText);
        add(kurang);
        add(panel1);

        setLayout(new FlowLayout());
        setBackground(Color.white);
        setBorder(new LineBorder(Color.BLACK));
    }

    int getQty(){
        return this.qty;
    }

    public void increment(){
        this.qty++;
        String temp = String.valueOf(qty);
        qtyText.setText(temp);
    }

    public void setMenuFor(menuItem m){//MENGHUBUNGKAN MENU ITEM DENGAN TAKED ITEM
        this.buffer = m;
    }

    public void setFalseToMenuItem(){
        this.buffer.clicked=false;
    }

    public void insertDataIntoDB(){
        koneksiSQL.insertData(this.foodName,this.foodPrice,this.qty);
    }
}
