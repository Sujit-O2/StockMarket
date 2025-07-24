package com.mycompany.stockmarket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLStocks {
    String url = "jdbc:mysql://localhost:3306/StockMarket";
    String name = "root";
    String Pass = "tAPASWINI";

    public String[][] getStocks() {
        String Stocks[][] = new String[50][3];
        int count = 0;
        try (
            Connection cc = DriverManager.getConnection(url, name, Pass);
            PreparedStatement pp = cc.prepareStatement("Select * from Stocks;");
            ResultSet rs = pp.executeQuery()
        ) {
            while (rs.next()) {
                String id = "" + rs.getInt("id");
                String name = rs.getString("name");
                String Price = rs.getString("price");
                Stocks[count][0] = id;
                Stocks[count][1] = name;
                Stocks[count][2] = Price;
                count++;
            }
            return Stocks;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updatePrice() {
        try (
            Connection cc = DriverManager.getConnection(url, name, Pass);
            PreparedStatement pp = cc.prepareStatement("Select * from Stocks;");
            ResultSet rs = pp.executeQuery()
        ) {
            while (rs.next()) {
                String id = "" + rs.getInt("id");
                String Price = rs.getString("price");
                double newPrice = Double.parseDouble(Price) + (Math.random() - 0.5) * 10;

                try (PreparedStatement update = cc.prepareStatement("update stocks set price=? where id=" + id + ";")) {
                    update.setString(1, String.format("%.2f", newPrice));
                    update.executeUpdate();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void signuoSql(String uname, String username, String email, String upass, String gen) {
        try (
            Connection cc = DriverManager.getConnection(url, name, Pass);
            PreparedStatement st = cc.prepareStatement("Insert into users(username,uname,email,gender,pass) values(?,?,?,?,?);")
        ) {
            st.setString(1, username);
            st.setString(2, uname);
            st.setString(3, email);
            st.setString(4, gen);
            st.setString(5, upass);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SQLStocks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String[] GetUsers(String uname, String upass) {
        try (
            Connection cc = DriverManager.getConnection(url, name, Pass);
            PreparedStatement ps = uname.contains("@")
                    ? cc.prepareStatement("select * from users where Email=?;")
                    : cc.prepareStatement("select * from users where username=?;")
        ) {
            ps.setString(1, uname);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next() && rs.getString("pass").equals(upass)) {
                    System.out.println("sujit");
                    String details[] = new String[4];
                    details[0] = rs.getString("uname");
                    details[1] = rs.getString("userName");
                    details[2] = rs.getString("Money");
                    details[3] = rs.getString("Email");
                    return details;
                } else {
                    System.out.println("hii bye");
                    String[] a = { "1" };
                    return a;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    double updatePrice(String usname, double alt) {
        try (
            Connection cc = DriverManager.getConnection(url, name, Pass);
            PreparedStatement ps = cc.prepareStatement("update users set money=? where username=?;")
        ) {
            ps.setString(1, "" + alt);
            ps.setString(2, usname);
            ps.executeUpdate();
            return alt;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public void setOwnStock(String uuname, int sid, String price, String Qut, String upPrice) {
        try (
            Connection cc = DriverManager.getConnection(url, name, Pass);
            PreparedStatement ps1 = cc.prepareStatement("insert into mystocks values(?,?,?,?);");
            PreparedStatement ps2 = cc.prepareStatement("Update users set money=? where username=?")
        ) {
            ps1.setString(1, uuname);
            ps1.setInt(2, sid);
            ps1.setString(3, price);
            ps1.setString(4, Qut);
            ps1.executeUpdate();

            ps2.setString(1, upPrice);
            ps2.setString(2, uuname);
            ps2.executeUpdate();

            System.out.println("done");
        } catch (SQLException ex) {
            Logger.getLogger(SQLStocks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<StockBuyed> getownstock(String uname) {
        try (
            Connection cc = DriverManager.getConnection(url, name, Pass);
            PreparedStatement ps = cc.prepareStatement(
                    "SELECT users.username,mystocks.stockid,mystocks.price AS buy_price,mystocks.quantity," +
                    "stocks.name AS stock_name,stocks.price AS market_price FROM users " +
                    "JOIN mystocks ON mystocks.username = users.username " +
                    "JOIN stocks ON mystocks.stockid = stocks.id " +
                    "WHERE users.username = ?;"
            )
        ) {
            ps.setString(1, uname);
            try (ResultSet rs = ps.executeQuery()) {
                ArrayList<StockBuyed> ab = new ArrayList<>();
                while (rs.next()) {
                    int stockId = rs.getInt("stockid");
                    String buyPrice = rs.getString("buy_price");
                    String quantity = rs.getString("quantity");
                    String stockName = rs.getString("stock_name");
                    String marketPrice = rs.getString("market_price");
                    ab.add(new StockBuyed(stockName, "" + stockId, quantity, buyPrice, marketPrice));
                }
                return ab;
            }
        } catch (SQLException ex) {
            System.out.println("Nouthing here");
        }
        return null;
    }
    public void updateMyStock(int qnt,String price,String id){
        try(Connection cc = DriverManager.getConnection(url,name,Pass)){
            if(qnt==0){
            PreparedStatement pp=cc.prepareStatement("Delete from mystocks where stockid=?");
            pp.setInt(1, Integer.parseInt(id));
            pp.executeUpdate();
                System.out.println("deleteed");
        }
            else{
                 PreparedStatement pp=cc.prepareStatement("update mystocks set price=?,quantity=?  where stockid=?");
                 pp.setString(1, price);
                 pp.setString(2, ""+qnt);
                 pp.setInt(3, Integer.parseInt(id));
                 pp.executeUpdate();
                 
                 
            
                System.out.println("updated");
            }
            
        }
        catch(Exception e){
            
        }
        
        
        
    }
    public ArrayList<String> getHIST(String username){
    ArrayList<String> aab=new ArrayList<>();
    try(Connection cc = DriverManager.getConnection(url,name,Pass)){
        PreparedStatement ps=cc.prepareStatement("Select hist from history where username=?");
        ps.setString(1,username);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            aab.add(rs.getString("hist"));
        }
        return aab;
        
    }
    catch(SQLException E){
        E.printStackTrace();
        return null;
      
        
    }
}
    
    public void setHist(String userName, String Value){
        try(Connection cc=DriverManager.getConnection(url,name,Pass)){
            PreparedStatement ps=cc.prepareStatement("Insert into history values (?,?);");
            ps.setString(1, userName);
            ps.setString(2, Value);
            ps.executeUpdate();
            
            
        }
        catch(Exception e){
            e.printStackTrace();
            
        }
        
        
    }
}
