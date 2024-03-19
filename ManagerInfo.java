import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import net.proteanit.sql.*;

public class ManagerInfo extends JFrame implements ActionListener
{
    JButton back;
    JTable table;
    ManagerInfo()
    {
        getContentPane().setBackground(Color.white);
        setLayout(null);


        JLabel l1 = new JLabel("Name");
        l1.setBounds(30,5, 90, 30);
        add(l1);
        JLabel l2 = new JLabel("Age");
        l2.setBounds(150,5, 90, 30);
        add(l2);
        JLabel l3 = new JLabel("Gender");
        l3.setBounds(250,5, 90, 30);
        add(l3);
        JLabel l4 = new JLabel("Job");
        l4.setBounds(380,5, 90, 30);
        add(l4);
        JLabel l5 = new JLabel("Salary");
        l5.setBounds(470,5, 90, 30);
        add(l5);

         JLabel l6 = new JLabel("Phone");
        l6.setBounds(585,5, 90, 30);
        add(l6);
         JLabel l7 = new JLabel("Email");
        l7.setBounds(720,5, 90, 30);
        add(l7);
         JLabel l8 = new JLabel("Aadhar");
        l8.setBounds(820,5, 90, 30);
        add(l8);




        table = new JTable();
        table.setBounds(0, 30, 900, 400);
        add(table);

        back = new JButton("BACK");
        back.setBounds(350, 500, 120, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

    try
    {
        Conn conn = new Conn();
        ResultSet rs = conn.s.executeQuery("select * from employee where job = 'Manager'");
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
        new ManagerInfo();
        
    }
    
}
