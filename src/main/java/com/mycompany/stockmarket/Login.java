/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.stockmarket;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author sujit
 */
public class Login  extends JFrame implements ActionListener{
    
       JLabel HEAD;
    JLabel userName,pass;
    JTextField name1;
    JPasswordField pass1;
  
    JButton Signup,LoginB,Clear;
    
    
    public Login(){
//        new Stock(null).setVisible(false);
        setTitle("LOGIN");
        setResizable(false);
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         setLayout(null);
        setSize(600,500);
        HEAD=new JLabel("WELCOME TO THE STOCK MARCATE");
        HEAD.setBounds(130,30,350,40);
        HEAD.setFont(new Font("",Font.ITALIC,19));
        HEAD.setForeground(Color.darkGray);
      
        userName=new JLabel("USER NAME :");
        
        pass=new JLabel("PASSWORD :");
        name1=new JTextField();
        pass1=new JPasswordField();
        String s[]={"MALE","FEMALE","PREFER NOT TO SAY"};        
        Clear =new JButton("CLEAR");
        LoginB =new JButton("LOGIN");
        Signup=new JButton("SIGNUP");
        
       Clear.setBounds(400, 300, 100, 30);
       LoginB.setBounds(250, 300, 100, 30);
       Signup.setBounds(100, 300, 100, 30);
       Clear.setBackground(Color.RED);
       Signup.setBackground(Color.BLUE);
       LoginB.setBackground(Color.GREEN);
       Clear.setForeground(Color.WHITE);
       Signup.setForeground(Color.WHITE);
      
       
        
        
        
        userName.setBounds(160,140,100,30);
       pass.setBounds(160,200,100,30);
        name1.setBounds(250, 140, 180, 30);
        pass1.setBounds(250, 200, 180, 30);
        
        Signup.addActionListener(this);
        LoginB.addActionListener(this);
        Clear.addActionListener(this);
        
        
        
        
        this.add(HEAD);
        add(Clear);
        add(Signup);
        add(LoginB);
       add(userName);
        add(pass);
        add(name1);
        add(pass1);
        
        
        
       
        setLocationRelativeTo(null);
        
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Signup){
            setVisible(false);
            signUp ss=new signUp();
            
        }
        if(e.getSource()==Clear){
            name1.setText("");
            pass1.setText("");
            
            
        }
        if(e.getSource()==LoginB){
            SQLStocks sq=new SQLStocks();
            
            String[]details=sq.GetUsers(name1.getText(),new String( pass1.getPassword()));
            if  (details==null) {
                JOptionPane.showMessageDialog(this,"Username or Email/ Password Incorrect", "||",JOptionPane.WARNING_MESSAGE);
                
            }
            else if(details.length==1){
              
                JOptionPane.showMessageDialog(this,"Fill the Username/Password .","|", JOptionPane.WARNING_MESSAGE);
            
            }
            else if(details!=null){
            User us=new User(details);
                setVisible(false);
            }
          
            
            
        }
        }
}
