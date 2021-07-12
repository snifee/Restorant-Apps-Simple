package com.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class paymentPanel extends JPanel{

    public static List<takedItem> takedItemArrayList = new ArrayList<>();
    private JPanel topPayPanel;
    private static JPanel centerPaymentPanel;
    private static JScrollPane scrollPanePayment;
    private static JTable table;
    private static DefaultTableModel model;
    private static int screenHeight;
    private static int screenWidth;
    private static int hargaTotal;
    private static double pajak;
    private JPanel invoice;
    private JTextField diskonText;
    private JLabel priceLabel1;
    private JTextField totalPrice;
    private JLabel priceLabel2;
    private JTextField finalPrice;
    private JLabel priceLabel3;
    private JPanel panelInvoice1;
    private JPanel panelInvoice2;
    private JPanel panelInvoice3;
    private JPanel bottomPayPanel;
    private JButton cancelButton;
    private JButton addButton;
    private JButton payButton;

    public paymentPanel(){
        topPayPanel = new JPanel();
        addButton = new JButton();
        cancelButton = new JButton();
        bottomPayPanel = new JPanel();
        payButton = new JButton();
        centerPaymentPanel = new JPanel();
        invoice = new JPanel();
        totalPrice = new JTextField();
        diskonText = new JTextField();
        finalPrice = new JTextField();
        priceLabel1= new JLabel();
        priceLabel2= new JLabel();
        priceLabel3 = new JLabel();
        panelInvoice1 = new JPanel();
        panelInvoice2 = new JPanel();
        panelInvoice3 = new JPanel();
        centerPaymentPanel = new JPanel();
        table = new JTable();
        model = new DefaultTableModel();
        table.setModel(model);
        screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        //========================================================================================================================

        topPayPanel.setBackground(new Color(11, 41, 60));
        topPayPanel.setPreferredSize(new Dimension(500,150));
        topPayPanel.setMaximumSize(new Dimension(500,150));
        addButton.setBackground(new Color(255, 255, 255));
        addButton.setIcon(new ImageIcon(getClass().getResource("/com/icon/save.png"))); // NOI18N
        addButton.setText("Save");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                double harga = paymentPanel.totalPrice();
                finalPrice.setText("IDR "+(String.valueOf(harga)));
            }
        });
        cancelButton.setBackground(new Color(255, 255, 255));
        cancelButton.setIcon(new ImageIcon(getClass().getResource("/com/icon/caic.png")));
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                paymentPanel.removeAllTakedItem();
                finalPrice.setText("");
            }
        });
        topPayPanel.add(addButton);
        topPayPanel.add(cancelButton);


        centerPaymentPanel.setPreferredSize(new Dimension(480,screenHeight-400));
        centerPaymentPanel.setMaximumSize(new Dimension(480,screenHeight-400));
        centerPaymentPanel.setBackground(new Color(11, 41, 60));
        centerPaymentPanel.setLayout(new BoxLayout(centerPaymentPanel, BoxLayout.Y_AXIS));
        scrollPanePayment = new JScrollPane(centerPaymentPanel);
        scrollPanePayment.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPanePayment.setPreferredSize(new Dimension(500,screenHeight-600));
        scrollPanePayment.setMaximumSize(new Dimension(500,screenHeight-600));

        invoice.setPreferredSize(new Dimension(500,150));
        invoice.setMaximumSize(new Dimension(500,150));
        invoice.setBackground(new Color(11, 41, 60));
        panelInvoice1.setBackground(new Color(11, 41, 60));
        panelInvoice2.setBackground(new Color(11, 41, 60));
        panelInvoice3.setBackground(new Color(11, 41, 60));
        totalPrice.setEditable(false);
        diskonText.setEditable(false);
        finalPrice.setEditable(false);
        priceLabel1.setText("Total");
        priceLabel1.setPreferredSize(new Dimension(80,30));
        totalPrice.setPreferredSize(new Dimension(300,30));
        priceLabel2.setText("Diskon");
        priceLabel2.setPreferredSize(new Dimension(80,30));
        diskonText.setPreferredSize(new Dimension(300,30));
        priceLabel3.setText("Total");
        priceLabel3.setPreferredSize(new Dimension(80,30));
        finalPrice.setPreferredSize(new Dimension(300,30));
        panelInvoice3.add(priceLabel3);
        panelInvoice3.add(finalPrice);
        invoice.add(panelInvoice1);
        invoice.add(panelInvoice2);
        invoice.add(panelInvoice3);

        bottomPayPanel.setBackground(new Color(11, 41, 60));
        bottomPayPanel.setPreferredSize(new Dimension(500,300));
        bottomPayPanel.setMaximumSize(new Dimension(500,300));
        payButton.setBackground(new Color(255, 255, 255));
        payButton.setIcon(new ImageIcon(getClass().getResource("/com/icon/pay_1.png")));
        payButton.setText("Pay");
        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                totalPricePay();
                paymentPanel.removeAllTakedItem();
                finalPrice.setText("");
            }
        });
        payButton.setAlignmentY(JButton.CENTER);
        bottomPayPanel.add(invoice);
        bottomPayPanel.add(payButton);

        setBackground(new Color(11, 41, 60));

        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        add(topPayPanel);
        add(scrollPanePayment);
        add(invoice);
        add(bottomPayPanel);

    }

    public static void addItemTaked(takedItem taked){
        centerPaymentPanel.add(taked);
        takedItemArrayList.add(taked);
    }

    public static void removeAllTakedItem(){
        centerPaymentPanel.removeAll();
        for (takedItem i:takedItemArrayList) {
            i.qty=0;
            i.setFalseToMenuItem();
        }
        loadData();
    }

    public static double totalPrice(){
        hargaTotal=0;
        for (takedItem i:takedItemArrayList) {
            hargaTotal=hargaTotal+((i.qty))*Integer.parseInt(i.foodPrice);
        }
        return hargaTotal;
    }

    public static void loadData(){
        centerPaymentPanel.revalidate();
        centerPaymentPanel.repaint();
    }


    public static void totalPricePay(){
        for (takedItem i:takedItemArrayList) {

            com.koneksi.koneksiSQL.insertData(i.foodName,String.valueOf(Integer.parseInt(i.foodPrice)*i.qty),i.qty);
        }
    }
}
