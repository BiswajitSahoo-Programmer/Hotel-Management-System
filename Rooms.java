import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import net.proteanit.sql.*;

public class Rooms extends JFrame implements ActionListener
{
    JButton back;
    JTable table;
    Rooms()
    {
        getContentPane().setBackground(Color.white);
        setLayout(null);

         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);  
        image.setBounds(500, 0, 400, 600);
        add(image);

        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(0,5, 90, 30);
        add(l1);
        JLabel l2 = new JLabel("Availbility");
        l2.setBounds(100,5, 90, 30);
        add(l2);
        JLabel l3 = new JLabel("Status");
        l3.setBounds(200,5, 90, 30);
        add(l3);
        JLabel l4 = new JLabel("Price");
        l4.setBounds(300,5, 90, 30);
        add(l4);
        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(400,5, 90, 30);
        add(l5);

        table = new JTable();
        table.setBounds(0, 30, 500, 400);
        add(table);

        back = new JButton("BACK");
        back.setBounds(200, 500, 120, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

    try
    {
        Conn conn = new Conn();
        ResultSet rs = conn.s.executeQuery("select * from room");
        table.setModel(DbUtils.resultSetToTableModel(rs));
        

    }
    catch(Exception e)
    {
        e.printStackTrace();
    }

        setBounds(200, 100, 900, 600);
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
        new Rooms();
        
    }
    
}
