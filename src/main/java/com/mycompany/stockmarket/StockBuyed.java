package com.mycompany.stockmarket;


/**
 *
 * @author sujit
 */
public class StockBuyed {
    String stockid, stockname;
    String quantity;
    String buyprice, currentP;
    
    String invested, value;
    String porL;

    public StockBuyed(String stockname, String stockid, String quantity, String buyprice, String currentP) {
        this.stockname = stockname;
        this.stockid = stockid;
        this.quantity = quantity;
        this.buyprice = buyprice;
        this.currentP = currentP;

        int qty = Integer.parseInt(quantity);
        float buy = Float.parseFloat(buyprice);
        float curr = Float.parseFloat(currentP);

        float investedFloat = buy * qty;
        float valueFloat = curr * qty;

        invested = String.format("%.2f", investedFloat);
        value = String.format("%.2f", valueFloat);

        if (valueFloat > investedFloat) {
            porL = "P";  // Profit
        } else {
            porL = "L";  // Loss
        }

        System.out.println("completed");
    }
}
