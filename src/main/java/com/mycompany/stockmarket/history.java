package com.mycompany.stockmarket;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class history extends JFrame {
    SQLStocks sq;

    public history(String s[]) {
        sq = new SQLStocks();
        String ss[] = s;
        setLayout(null);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                new User(ss);
                dispose();
            }
        });

        JPanel pp = new JPanel(null);
        pp.setBounds(0, 0, 700, 700);
        pp.setVisible(false);
        setSize(700, 700);
        this.add(pp);

        ArrayList<String> bb = sq.getHIST(s[1]);

        if (bb == null || bb.isEmpty()) {
            pp.setVisible(true);
            JLabel jj = new JLabel("History is empty ....");
            jj.setFont(new Font("", Font.BOLD, 18));
            jj.setSize(700, 700);
            jj.setHorizontalAlignment(SwingConstants.CENTER);
            jj.setVerticalAlignment(SwingConstants.CENTER);
            pp.add(jj);
        } else {
            String column[] = {"DATA"};
            DefaultTableModel model = new DefaultTableModel(column, 0);

            // Fill model with history data
            for (String item : bb) {
                model.addRow(new String[]{item});
            }

            JTable hist = new JTable(model);
            hist.setRowHeight(40);

            JScrollPane sp = new JScrollPane(hist);
            sp.setBounds(10, 10, 670, 650);
            this.add(sp);
        }

        setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
