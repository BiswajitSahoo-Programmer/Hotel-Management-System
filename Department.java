import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import net.proteanit.sql.*;

public class Department extends JFrame implements ActionListener
{
    JButton back;
    JTable table;
    Department()
    {
        getContentPane().setBackground(Color.white);
        setLayout(null);

         

        JLabel l1 = new JLabel("DEPARTMENT");
        l1.setBounds(90,5,90, 30);
        add(l1);
        JLabel l2 = new JLabel("BUDGET");
        l2.setBounds(400,5, 90, 30);
        add(l2);
        
        table = new JTable();
        table.setBounds(0, 30, 600, 300);
        add(table);

        back = new JButton("BACK");
        back.setBounds(250, 400, 120, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

    try
    {
        Conn conn = new Conn();
        ResultSet rs = conn.s.executeQuery("select * from depratment");
        table.setModel(DbUtils.resultSetToTableModel(rs));
        

    }
    catch(Exception e)
    {
        e.printStackTrace();
    }

        setBounds(300, 100, 600, 500);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == back)
        {
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args) 
    {
        new Department();
        
    }
    
}
