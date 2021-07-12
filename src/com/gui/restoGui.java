package com.gui;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class restoGui extends JFrame {

    private int screenWidth;
    private int screenHeight;

    private JButton FoodButton;
    private JButton beverageButton;

    private JButton dessertButton;
    private JPanel headerPanel;
    private JPanel foodPanel;
    private JPanel foodHeader;
    private JPanel menuFoodPanel;
    private JScrollPane scrollPanefood;
    private JPanel dessertPanel;
    private JPanel dessertHeader;
    private JPanel menuDessertPanel;
    private JPanel scrollPaneDessert;
    private JPanel beveragePanel;
    private JPanel beverageHeader;
    private JPanel menuBeveragePanel;
    private JScrollPane scrollPaneBeverage;
    private JLabel logoFoodMenu;
    private JLabel logoDessertMenu;
    private JLabel logoBeverageMenu;
    private JPanel mainPanel;
    private static JPanel rightPanel;
    private JPanel typePanel;
    private JScrollPane scrollPanePayment;
    private JButton loginButton;
    private JButton reportButton;

    public restoGui() {
        screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;

        Color mainColor = new Color(11, 41, 60);

        typePanel = new JPanel();
        FoodButton = new JButton();
        dessertButton = new JButton();
        beverageButton = new JButton();

        mainPanel = new JPanel();
        headerPanel = new JPanel();
        rightPanel = new JPanel();
        loginButton = new JButton();
        reportButton = new JButton();



        CardLayout cardLayout = new CardLayout();

        //SET COMPONENT PROPERTY

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
        setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        Container conPanel = this.getContentPane();


        //TYPE PANEL SET
        typePanel.setBackground(new Color(11, 41, 60));
        typePanel.setPreferredSize(new Dimension((120),(Toolkit.getDefaultToolkit().getScreenSize().height)));
        typePanel.setMaximumSize(new Dimension((120),(Toolkit.getDefaultToolkit().getScreenSize().height)));

        FoodButton.setBackground(new Color(255, 255, 255));
        FoodButton.setPreferredSize(new Dimension(56,56));
        FoodButton.setMaximumSize(new Dimension(56,56));
        FoodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cardLayout.show(mainPanel,"foodMenu");
            }
        });

        dessertButton.setBackground(new Color(255, 255, 255));
        dessertButton.setPreferredSize(new Dimension(56,56));
        dessertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cardLayout.show(mainPanel,"dessertMenu");
            }
        });

        beverageButton.setBackground(new Color(255, 255, 255));
        beverageButton.setPreferredSize(new Dimension(56,56));

        beverageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cardLayout.show(mainPanel,"beverageMenu");
            }
        });

        reportButton.setBackground(new Color(255, 255, 255));
        reportButton.setPreferredSize(new Dimension(56,56));
        reportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cardLayout.show(mainPanel,"report");
            }
        });


        loginButton.setBackground(new Color(255, 255, 255));
        loginButton.setPreferredSize(new Dimension(56,56));




        try{
            FoodButton.setIcon(new ImageIcon(getClass().getResource("/com/icon/food_1.png")));
            dessertButton.setIcon(new ImageIcon(getClass().getResource("/com/icon/dessert_1.png")));
            beverageButton.setIcon(new ImageIcon(getClass().getResource("/com/icon/drink_1.png")));
            loginButton.setIcon(new ImageIcon(getClass().getResource("/com/icon/admin.png")));
            reportButton.setIcon(new ImageIcon(getClass().getResource("/com/icon/report.png")));
        }catch (Exception e){

        }


        GroupLayout mainGrupLayout = new GroupLayout(typePanel);
        mainGrupLayout.setAutoCreateContainerGaps(true);
        mainGrupLayout.setAutoCreateContainerGaps(true);
        typePanel.setLayout(mainGrupLayout);
        mainGrupLayout.setHorizontalGroup(mainGrupLayout.createSequentialGroup()
                .addGap(30)
                .addGroup(mainGrupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(FoodButton)
                        .addComponent(dessertButton)
                        .addComponent(beverageButton)
                        .addComponent(reportButton)
                        .addComponent(loginButton))
        );
        mainGrupLayout.setVerticalGroup(mainGrupLayout.createSequentialGroup()
                .addGap(200)
                .addGroup(mainGrupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(FoodButton))
                .addGap(20)
                .addGroup(mainGrupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(dessertButton))
                .addGap(20)
                .addGroup(mainGrupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(beverageButton))
                .addGap(400)
                .addGroup(mainGrupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(reportButton))
                .addGap(20)
                .addGroup(mainGrupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(loginButton))
        );



        //MAIN PANEL====================================================================================================
        mainPanel.setBackground(new Color(255, 255, 255));
        mainPanel.setMaximumSize(new Dimension(screenWidth-120-500,(screenHeight)));
        mainPanel.setLayout(cardLayout);

        menuPanel foodS = new menuPanel("/com/icon/maincourse (1).jpg");
        menuPanel dessertMenu = new menuPanel("/com/icon/dessert (1).jpg");
        menuPanel beverageMenu = new menuPanel("/com/icon/beverage (1).jpg");
        reportPanel reportPane = new reportPanel();
        reportPane.loadReportFromDB();

        foodS.loadMenuFromDatabase("SELECT * FROM R_List_Makanan");
        dessertMenu.loadMenuFromDatabase("SELECT * FROM R_List_Dessert");
        beverageMenu.loadMenuFromDatabase("SELECT * FROM R_List_Minuman");


        mainPanel.add(foodS,"foodMenu");
        mainPanel.add(dessertMenu,"dessertMenu");
        mainPanel.add(beverageMenu,"beverageMenu");
        mainPanel.add(reportPane,"report");


        //PAYMENT PANEL=================================================================================================

        //PERCOBAAAN MANTAP AJEGILE


        rightPanel.setBackground(new Color(11, 41, 60));
        rightPanel.setMaximumSize(new Dimension(500,screenHeight));
        rightPanel.setMinimumSize(new Dimension(500,screenHeight));
        rightPanel.setPreferredSize(new Dimension(500,screenHeight));

        paymentPanel ts = new paymentPanel();
        rightPanel.add(ts);


        conPanel.add(typePanel);
        conPanel.add(mainPanel);
        conPanel.add(rightPanel);
        setLayout (new BoxLayout(conPanel, BoxLayout.X_AXIS));
        setVisible(true);
        revalidate();
        pack();
    }
}


