package com.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuItem extends JButton{
    String harga;
    String nama;
    menuItem buffer;
    public boolean clicked;
    public menuItem(String imageSrc,String harga,String nama) {
        buffer=this;
        this.harga = harga;
        this.nama = nama;
        try{
            this.setIcon(new ImageIcon(getClass().getResource(imageSrc)));
        }catch (Exception e){
            this.setText("Picture not found");
        }
        this.clicked=false;
        this.addActionListener(new ActionListener() {
            takedItem buff;
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (clicked==false){
                    clicked=true;
                    buff = new takedItem(nama,harga);
                    buff.setMenuFor(buffer);
                    buff.increment();
                    paymentPanel.addItemTaked(buff);
                    paymentPanel.loadData();
                }else {
                    buff.increment();
                }
            }
        });

    }

    private String getNamaMenu(){
        return this.nama;
    }
    private String getHargaMenu(){
        return this.harga;
    }

}
