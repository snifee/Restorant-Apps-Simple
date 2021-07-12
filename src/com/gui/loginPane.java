package com.gui;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import javax.tools.DocumentationTool;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class loginPane extends JFrame {
    // Variables declaration - do not modify
    private JButton cancbutt;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JPanel jPanel1;
    private JButton loginbuttonresto;
    private JPasswordField tfpasswordresto;
    private JTextField tfusernameresto;
    private JDialog alertBox;
    private JLabel alertBoxLabel;
    // End of variables declaration


    public loginPane() {
        jLabel3 = new JLabel();
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel4 = new JLabel();
        tfusernameresto = new JTextField();
        tfpasswordresto = new JPasswordField();
        loginbuttonresto = new JButton();
        cancbutt = new JButton();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new Color(11, 41, 60));

        jLabel2.setFont(new Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new Color(255, 255, 255));
        jLabel2.setText("Username");

        jLabel4.setFont(new Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new Color(255, 255, 255));
        jLabel4.setText("Password");

        tfusernameresto.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        tfpasswordresto.setFont(new Font("Tahoma", 0, 18)); // NOI18N

        loginbuttonresto.setBackground(new Color(255, 255, 255));
        loginbuttonresto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("hello");
                loginFromDataB(tfusernameresto.getText(),(new String(tfpasswordresto.getPassword())));
            }
        });

        cancbutt.setBackground(new Color(255, 255, 255));
        cancbutt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.exit(0);
            }
        });

        try{
            jLabel1.setIcon(new ImageIcon(getClass().getResource("/com/icon/login (1).png"))); // NOI18N
            loginbuttonresto.setIcon(new ImageIcon(getClass().getResource("/com/icon/loginbutt.png"))); // NOI18N
            cancbutt.setIcon(new ImageIcon(getClass().getResource("/com/icon/caic.png"))); // NOI18N
        }catch (Exception e){

        }

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(cancbutt)
                                                .addGap(18, 18, 18)
                                                .addComponent(loginbuttonresto))
                                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(63, 63, 63)
                                                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 364, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                        .addGap(90, 90, 90)
                                                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(tfusernameresto, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                                                                .addComponent(tfpasswordresto)))))
                                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tfusernameresto, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(tfpasswordresto, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(loginbuttonresto, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cancbutt, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(147, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );


        setLocationRelativeTo(null);
        pack();
    }

    public void loginFromDataB(String username, String passwd){
        try {
            Connection conn = com.koneksi.koneksiSQL.getKoneksi();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM User_Account_Login");

            while(resultSet.next()){
                Object[] data = new Object[2];
                data[0] = resultSet.getString("Username");
                data[1] = resultSet.getString("Password");

                System.out.println(data[0].toString()+"=="+username+" "+data[1].toString()+"=="+passwd);
                if (data[0].toString().equals(username) && data[1].toString().equals(passwd)){
                    this.setVisible(false);
                    new restoGui().setVisible(true);
                    return;
                }
            }

            statement.close();
            conn.close();

            alertBox("Gagal Dalam Melakukan Login");
        }catch (Exception e){
            new warningJOpPanel().setTextWarning("Gagal Dalam melakukan login",e.getMessage());
        }
    }


    public static void main(String[] args) {
        FlatLightLaf.install();

        try{
            UIManager.setLookAndFeel(new FlatLightLaf());
        }catch (Exception e){

        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginPane().setVisible(true);
            }
        });
    }


    void alertBox(String e){
        JLabel alertBoxLabel = new JLabel();
        JDialog alertBox = new JDialog(this,"Warning");
        alertBox.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        alertBox.setSize(300,150);
        alertBox.setLocationRelativeTo(null);
        alertBoxLabel.setText(e);
        alertBoxLabel.setHorizontalAlignment(JLabel.CENTER);
        alertBox.setBackground(new Color(11, 41, 60));
        alertBox.setBackground(Color.BLACK);
        alertBox.add(alertBoxLabel);
        alertBox.setVisible(true);
    }

}


