/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.stockmarket;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

   
public class User extends JFrame implements ActionListener{
    JLabel HEAD, Welcome,Money;
    JButton viewMar,sellSeeStk,addMon,logout,addBtn;
    JDialog dialog;
    JTextField amountField;
    String alldet[];
    public User( String alldet[]){
        HEAD=new JLabel("WELCOME TO THE STOCK MARKET");
        HEAD.setBounds(130,30,350,40);
        HEAD.setFont(new Font("",Font.ITALIC,19));
        HEAD.setForeground(Color.darkGray);
        this.alldet=alldet;
        setLayout(null);
        setBackground(Color.GRAY);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(600,500);
        String Name=alldet[0];
        float Amount=Float.parseFloat(String.format("%.2f", Float.parseFloat(alldet[2])));
        Welcome=new JLabel("Welcome to you " +Name +" .");
        Money=new JLabel("Balence : "+Amount);
        Welcome.setFont(new Font("",Font.BOLD|Font.ITALIC,20));
        Money.setFont(new Font("",Font.BOLD,16));
        viewMar=new JButton(" VIEW MARKET");
        sellSeeStk=new JButton("PORTFOLIO");
        addMon=new JButton("+");
        logout=new JButton("LOGOUT");
        addMon.setBackground(Color.GRAY);
        addMon.setBorderPainted(false);
        addMon.setFocusPainted(false);
        addMon.setContentAreaFilled(true);
        addMon.setOpaque(false);
        addMon.setFont(new Font("",Font.BOLD,20));
        addMon.setForeground(Color.DARK_GRAY);
        logout.setBackground(Color.red);
        viewMar.setBackground(Color.gray);
        sellSeeStk.setBackground(Color.GREEN);
        
        
        
        
        
        Welcome.setBounds(20,100,300,50);
        Money.setBounds(300,110,200,30);
        Money.setHorizontalAlignment(SwingConstants.RIGHT);
        viewMar.setBounds(30,250,150,50);
        sellSeeStk.setBounds(215,250,150,50);
        logout.setBounds(400,250,150,50);
          addMon.setBounds(500,110,50,30);
        
        this.add(Welcome);
        this.add(Money);
        this.add(viewMar);
        this.add(sellSeeStk);
        this.add(addMon);
        this.add(logout);
        add(HEAD);
        addMon.addActionListener(this);
        viewMar.addActionListener(this);
        logout.addActionListener(this);
        sellSeeStk.addActionListener(this);
        
        setLocationRelativeTo(null);
       
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(e.getSource()== viewMar){
            this.setVisible(false);
            new Stock(alldet);
            
            
        }
       
        if(e.getSource()== logout){
            dispose();
            new Login();
            
            
        }
       
        if(e.getSource()== addMon){
             dialog = new JDialog(this, "Add Balance");

    dialog.setSize(300, 150);
    dialog.setLayout(null);
    dialog.setResizable(false);
    dialog.setLocationRelativeTo(this);

    // Label
    JLabel label = new JLabel("Enter amount to add:");
    label.setBounds(20, 20, 200, 25);
    dialog.add(label);

    // Text Field
     amountField = new JTextField();
    amountField.setBounds(20, 50, 150, 25);
    dialog.add(amountField);

    // Add Button
     addBtn = new JButton("Add");
    addBtn.setBounds(180, 50, 80, 25);
    dialog.add(addBtn);
    dialog.setVisible(true);
    addBtn.addActionListener(this);

            
            
        }
        if(e.getSource()==addBtn){
            String s=amountField.getText();
            double d1=Double.parseDouble(s);
            if(d1<1000000){
            double d2=Double.parseDouble(alldet[2]);
            d2=d1+d2;
            SQLStocks sq=new SQLStocks();
            d2=sq.updatePrice(alldet[1], d2);
            Money.setText("Balance : "+String.format("%.2f",d2));
            alldet[2]=""+d2;
             sq.setHist(alldet[1],"You Recharged  "+d1+" on "+new Date());
            dialog.setVisible(false);
        }
            else{
                JOptionPane.showMessageDialog(this,"NOT ALLOWED","|", JOptionPane.WARNING_MESSAGE);
            }
        }
        if(e.getSource()== sellSeeStk){
            setVisible(false);
            new yourStocks(alldet);
            
        }
        
// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

