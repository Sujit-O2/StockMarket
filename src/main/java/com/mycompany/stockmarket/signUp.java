/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.stockmarket;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author sujit
 */
public class signUp extends JFrame implements  ActionListener{
    JLabel HEAD;
    JLabel name,userName,gender,Email,pass,repass;
    JTextField name1,username1,email1;
    JPasswordField pass1,repass1;
    JComboBox<String> Gender1;
    JButton Clear,SignupButton,Back;
    
    
    public signUp(){
        setResizable(false);
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         setLayout(null);
        setSize(900,600);
        HEAD=new JLabel("WELCOME TO THE STOCK MARCATE");
        HEAD.setBounds(280,30,350,40);
        HEAD.setFont(new Font("",Font.ITALIC,19));
        HEAD.setForeground(Color.darkGray);
        name=new JLabel("NAME :");
        userName=new JLabel("USER NAME :");
        gender=new JLabel("GENDER :");
        Email=new JLabel("EMAIL :");
        pass=new JLabel("PASSWORD :");
        repass=new JLabel("RE-PASSWORD :");
        name1=new JTextField();
        email1=new JTextField();
        username1=new JTextField();
        pass1=new JPasswordField();
        repass1=new JPasswordField();
        String s[]={"MALE","FEMALE","PREFER NOT TO SAY"};
        Gender1 =new JComboBox<>(s);
        
        Clear =new JButton("CLEAR");
        SignupButton =new JButton("SIGNUP");
        Back=new JButton("BACK");
        
       Clear.setBounds(550, 500, 100, 30);
       SignupButton.setBounds(400, 500, 100, 30);
       Back.setBounds(250, 500, 100, 30);
       Clear.setBackground(Color.blue);
       Back.setBackground(Color.red);
       SignupButton.setBackground(Color.GREEN);
       Clear.setForeground(Color.WHITE);
       Back.setForeground(Color.WHITE);
      
       
        
        
        
        name.setBounds(300,100,100,30);
        userName.setBounds(300,160,100,30);
        gender.setBounds(300,220,100,30);
        Email.setBounds(300,280,100,30);
        pass.setBounds(300,340,100,30);
        repass.setBounds(300,400,100,30);
        name1.setBounds(450, 100, 150, 30);
        username1.setBounds(450, 160,150, 30);
        Gender1.setBounds(450, 220,150, 30);
        email1.setBounds(450, 280, 150, 30);
        pass1.setBounds(450, 340, 150, 30);
        repass1.setBounds(450, 400, 150, 30);
        
        Back.addActionListener(this);
        SignupButton.addActionListener(this);
        Clear.addActionListener(this);
        
        
        
        
        this.add(HEAD);
        add(Clear);
        add(Back);
        add(SignupButton);
        add(repass);
        add(name);
        add(userName);
        add(gender);
        add(Email);
        add(pass);
        add(name1);
        add(username1);
        add(pass1);
        add(Gender1);
        add(email1);
        add(repass1);
        
        
        
       
        setLocationRelativeTo(null);
        
        
        setVisible(true);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Back){
            setVisible(false);
            new Login();
            
        }
        if(e.getSource()==SignupButton){
           
            if(!Arrays.toString(pass1.getPassword()).equals(Arrays.toString(repass1.getPassword()))){
                JOptionPane.showMessageDialog(this, "CHECK YOUR PASSWORD","NOT MATCHING",JOptionPane.WARNING_MESSAGE);
                return;
                
                
             
}
 
            String uname=name1.getText(); 
            char[] pa=pass1.getPassword();
            String upass=new String(pa);
            String ugen=Gender1.getSelectedItem().toString();
            String email=email1.getText();
            String Username=username1.getText();
              if (uname.isEmpty() || Username.isEmpty() || email.isEmpty()
        || ugen.isEmpty() || upass.isEmpty()) {
    
    JOptionPane.showMessageDialog(this, "Please fill all the fields.", "Missing Data", JOptionPane.WARNING_MESSAGE);
    return; }// stop further processing
            SQLStocks sq=new SQLStocks();
            sq.signuoSql(uname, Username, email, upass, ugen);
            setVisible(false);
            new Login();
           
            }
           
            
        
        if(e.getSource()==Clear){
            name1.setText("");
            email1.setText("");
            pass1.setText("");
            repass1.setText("");
            username1.setText("");
            Gender1.setSelectedItem("MALE");
            
            
        }
       
    }
    
    
    
}
