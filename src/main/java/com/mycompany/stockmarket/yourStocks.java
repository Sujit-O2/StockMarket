
package com.mycompany.stockmarket;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 *
 * @author sujit
 */
public class yourStocks extends JFrame implements ActionListener{
    SQLStocks sq=new SQLStocks();
    JLabel poty, welcome,money,usname,email,btn,tPrice;
    JButton addmoney,viewMar,sellStk,hist,home,addBtn,sell;
    JTable allStocks;
    JDialog selling,dialog;
    JTextField amountField;
    JScrollPane spp;
    ArrayList<StockBuyed> bb;
    int id;
    float qnt;
    JComboBox<String> qt;
String aadj[];
    public yourStocks(String aadj[]){
        this.aadj=aadj;
        poty=new JLabel("MY PORTFOLIO");
        poty.setBounds(0,00,700,50);
        poty.setHorizontalAlignment(SwingConstants.CENTER);
        poty.setVerticalAlignment(SwingConstants.CENTER);
        poty.setOpaque(true);
        poty.setBackground(Color.LIGHT_GRAY);
        poty.setFont(new Font("",Font.BOLD|Font.TRUETYPE_FONT,20));
        String Name=aadj[0];
         float Amount=Float.parseFloat(String.format("%.2f", Float.parseFloat(aadj[2])));
        welcome=new JLabel("Welcone to you "+Name +" .");
        usname=new JLabel("UserName : "+aadj[1]);
        email=new JLabel("Email : "+aadj[3]);
        usname.setFont(new Font("",Font.ITALIC,16));
        email.setFont(new Font("",Font.ITALIC,16));
        
        money=new JLabel("Balence : "+Amount);
        welcome.setFont(new Font("",Font.BOLD|Font.ITALIC,20));
        money.setFont(new Font("",Font.BOLD,16));
        viewMar=new JButton(" VIEW MARKET");
        
        addmoney=new JButton("+");
        
        home=new JButton("HOME");
        hist=new JButton("HISTORY");
        addmoney.setBackground(Color.white);
        addmoney.setBorderPainted(false);
        addmoney.setFocusPainted(false);
        addmoney.setContentAreaFilled(true);
        addmoney.setOpaque(false);
        addmoney.setFont(new Font("",Font.BOLD,20));
        addmoney.setForeground(Color.DARK_GRAY);
       
        viewMar.setBackground(Color.LIGHT_GRAY);
        home.setBackground(Color.lightGray);
        hist.setBackground(Color.lightGray);
        
        
        
        welcome.setBounds(20,50,300,30);
        usname.setBounds(20,70,300,30);
        email.setBounds(20,90,300,30);
        money.setBounds(400,80,200,30);
        money.setHorizontalAlignment(SwingConstants.RIGHT);
            addmoney.setBounds(600,80,50,30);
            
            
//        logout.setBounds(400,250,150,50);
        btn=new JLabel();
        btn.setBounds(0,180,700,50);
        btn.setOpaque(true);
        btn.setBackground(Color.GRAY);
        JPanel pp=new  JPanel(null);
        pp.setBounds(0,250,700,450);
        pp.setVisible(false);
        
        
        
            bb=sq.getownstock(aadj[1]);
            
            
        if(bb==null||bb.isEmpty()){
            pp.setVisible(true);
            JLabel jj=new JLabel("Nothing here ....");
            jj.setFont(new Font("",Font.CENTER_BASELINE|Font.BOLD,14) {
            });
           
            jj.setSize(700,300);
            jj.setHorizontalAlignment(SwingConstants.CENTER);
            jj.setVerticalAlignment(SwingConstants.CENTER);
            pp.add(jj);
            
        }
        else{
             String row1[][]=new String[bb.size()][8];
             int count=0;
            for(StockBuyed b:bb){
                row1[count][0]=b.stockid;
                row1[count][1]=b.stockname;
                row1[count][2]=b.buyprice;
                row1[count][3]=b.currentP;
                row1[count][4]=b.quantity;
                row1[count][5]=b.invested;
                row1[count][6]=b.value;
                row1[count][7]=b.porL;
                System.out.println(row1[count][0]);
                count++;
        }
           
            
            String column[]={"STOCK ID","NAME","BUY PRICE","CURRENT PRICE","QNT","INVESTED","VALUE","P/L"};
            
            
            allStocks=new JTable(row1,column);
           spp=new JScrollPane(allStocks);
            spp.setBounds(10,250,670,150);
            sellStk=new JButton("SELL");
            this.add(spp);
            sellStk.setBackground(Color.red);
            sellStk.setBounds(300,510,100,50);
            this.add(sellStk);
            sellStk.addActionListener(this);
            home.addActionListener(this);
            hist.addActionListener(this);
            
            
            
        }
        Timer t1=new Timer(2000,e->{
            sq.updatePrice();
           bb=sq.getownstock(aadj[1]);
           refreshTable();
           
        
        });
        t1.start();
        viewMar.setBounds(62,10,150,30);
        home.setBounds(274,10,150,30);
        hist.setBounds(486,10,150,30);
        btn.setHorizontalAlignment(SwingConstants.CENTER);
        btn.setVerticalAlignment(SwingConstants.CENTER);
         btn.add(home);
        btn.add(hist);
        btn.add(viewMar);
        this.add(btn);
        this.add(welcome);
        this.add(money);
//        this.add(viewMar);
        
        this.add(addmoney);
//        this.add(logout);
        this.add(usname);
        this.add(email);
//        this.add(hist);1

        this.add(poty);
        this.add(pp);
        
//        this.add(home);
        
        
        
        addmoney.addActionListener(this);
        viewMar.addActionListener(this);

        setSize(700,700);
        setResizable(false);
        setLocationRelativeTo(null);
        
       setLayout(null);
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
//                new User(aadj);
               
                
            }
        });
        setVisible(true); 
    }
     public void refreshTable() {
         if(this.allStocks!=null){
         String row1[][]=new String[bb.size()][8];
             int count=0;
            for(StockBuyed b:bb){
                row1[count][0]=b.stockid;
                row1[count][1]=b.stockname;
                row1[count][2]=b.buyprice;
                row1[count][3]=b.currentP;
                row1[count][4]=b.quantity;
                row1[count][5]=b.invested;
                row1[count][6]=b.value;
                row1[count][7]=b.porL;
                System.out.println(row1[count][0]);
                count++;

        for (int i = 0; i < row1.length; i++) {
            for (int j = 0; j < row1[i].length; j++) {
                allStocks.setValueAt(row1[i][j], i, j);  // update cell
            }
        }
    
}
     }
         }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==addmoney){
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
    home.addActionListener(this);
    
    
    
            

        
    }
        if(e.getSource()==viewMar){
            
            new Stock(aadj);
            dispose();

        
    }
        if(e.getSource()==sellStk){
            if(allStocks.getSelectedRow()==-1){
                JOptionPane.showMessageDialog(null, "Please select a stock!!!");
                
            }
            else{
                  id=Integer.parseInt((String)allStocks.getValueAt(allStocks.getSelectedRow(),0 ));
                  String name=(String) allStocks.getValueAt(allStocks.getSelectedRow(), 1);
                  
               
               
               
                selling=new JDialog(this,"paying");
                
                selling.setLayout(null);
                
                selling.setSize(400,200);
                JLabel stkname=new JLabel("Stock : "+name);
                JLabel ll=new JLabel("ENTER THE QNT : ");
                int s=Integer.parseInt(allStocks.getValueAt(allStocks.getSelectedRow(), 4).toString());
                String a[]=new String[10];
                while(s>0){
                    a[s-1]=""+s;
                    s--;
                }
                
                qt=new JComboBox<>(a);
                sell=new JButton("SELL");
                qnt=Float.parseFloat(allStocks.getValueAt(allStocks.getSelectedRow(), 3).toString())*Float.parseFloat(qt.getSelectedItem().toString());
                tPrice=new JLabel("TOTAL : "+qnt);
                qt.addActionListener(this);
                sell.addActionListener(this);
                stkname.setBounds(0,10,400,30);
                stkname.setFont(new Font("",Font.ITALIC|Font.BOLD,14));
                stkname.setHorizontalAlignment(SwingConstants.CENTER);
                stkname.setVerticalAlignment(SwingConstants.CENTER);
                qt.setFont(new Font("",Font.PLAIN,12));
                sell.setFont(new Font("",Font.PLAIN,12));
                ll.setFont(new Font("",Font.PLAIN,12));
                tPrice.setFont(new Font("",Font.PLAIN,12));
                ll.setBounds(30,60,200,30);
                ll.setHorizontalAlignment(SwingConstants.CENTER);
                qt.setBounds(210,60,50,30);
                tPrice.setBounds(100,100,150,30);
                sell.setBounds(250,100,100,30);
                qt.setBackground(Color.LIGHT_GRAY);
                sell.setBackground(Color.GREEN);
                
                selling.add(qt);
                selling.add(ll);
                selling.add(stkname);
                selling.add(sell);
                selling.add(tPrice);
                selling.setVisible(true);
                selling.setLocationRelativeTo(this);
            }
            
        }
        if(e.getSource()==qt){
            qnt=Float.parseFloat(allStocks.getValueAt(allStocks.getSelectedRow(), 3).toString())*Float.parseFloat(qt.getSelectedItem().toString());
            tPrice.setText("TOTAL : "+qnt);
        }
        if (e.getSource()==sell){
            double dd=qnt+Double.parseDouble(aadj[2]);
            sq.updatePrice(aadj[1], dd);
            aadj[2]=""+dd;
            money.setText("Balence : "+dd );
            int d1=Integer.parseInt(qt.getSelectedItem().toString());
            int q1t=Integer.parseInt(allStocks.getValueAt(allStocks.getSelectedRow(), 4).toString())-d1;
            System.out.println(q1t);
            sq.updateMyStock(q1t,""+qnt, ""+id);
            bb=sq.getownstock(aadj[1]);
            refreshTable();
sq.setHist(aadj[1], allStocks.getValueAt(allStocks.getSelectedRow(), 1)+" sold qnt "+d1+" at price "+aadj[2]+" on "+new Date());
           dispose();
           new yourStocks(aadj);
            
            
            
            
          
                
               
                
             
              
          }
        
        if(e.getSource()==hist){
            new history(aadj);
            

        
    }
        if(e.getSource()==home){
            this.setVisible(false);
            new User(aadj);
            

        
    }
        if(e.getSource()==addBtn){
            String s=amountField.getText();
            double d1=Double.parseDouble(s);
            if(d1<1000000){
            double d2=Double.parseDouble(aadj[2]);
            d2=d1+d2;
            SQLStocks sq=new SQLStocks();
            d2=sq.updatePrice(aadj[1], d2);
            money.setText("Balence : "+String.format("%.2f",d2));
            aadj[2]=""+d2;
             sq.setHist(aadj[1],"You Recharged  "+d1+" on "+new Date());
            dialog.setVisible(false);
        }
            else{
                JOptionPane.showMessageDialog(this,"NOT ALLOWED","|", JOptionPane.WARNING_MESSAGE);
            }
            

        
        }
    }
}

 
