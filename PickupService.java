import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import net.proteanit.sql.*;

public class PickupService extends JFrame implements ActionListener
{
    JButton back , submit;
    JTable table;
    Choice c;
    JCheckBox available;
    
    PickupService()
    {
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel lblroom = new JLabel("Pickup Service");
        lblroom.setBounds(350,40, 200, 30);
        lblroom.setFont(new Font("serif" , Font.BOLD ,20));
        add(lblroom);

        
        JLabel cartype = new JLabel("Car Model");
        cartype.setBounds(30,130, 90, 30);
        add(cartype);

        c = new Choice();
        c.setBounds(150, 135, 140, 30);
        add(c);

        try
        {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from driver");
            while(rs.next())
            {
                c.add(rs.getString("brand"));
            }


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        
        JLabel l1 = new JLabel("Name");
        l1.setBounds(40,200, 90, 30);
        add(l1);
        JLabel l2 = new JLabel("Age");
        l2.setBounds(200,200, 90, 30);
        add(l2);
        JLabel l3 = new JLabel("Gender");
        l3.setBounds(300,200, 90, 30);
        add(l3);
        JLabel l4 = new JLabel("Company");
        l4.setBounds(420,200, 90, 30);
        add(l4);
        JLabel l5 = new JLabel("Brand");
        l5.setBounds(560,200, 90, 30);
        add(l5);
         JLabel l6 = new JLabel("Availbilty");
        l6.setBounds(670,200, 90, 30);
        add(l6);
         JLabel l7 = new JLabel("Location");
        l7.setBounds(790,200, 90, 30);
        add(l7);

        table = new JTable();
        table.setBounds(0, 250, 900, 200);
        add(table);

         submit = new JButton("SUBMIT");
        submit.setBounds(200, 500, 120, 30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);

        back = new JButton("BACK");
        back.setBounds(500, 500, 120, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

    try
    {
        Conn conn = new Conn();
        ResultSet rs = conn.s.executeQuery("select * from driver");
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
        if(ae.getSource() == submit)
        {
            try
            {
                String query1 = "select * from driver where brand = '"+c.getSelectedItem()+"'";
                
                Conn conn = new Conn();
                ResultSet rs;
                rs = conn.s.executeQuery(query1);
                table.setModel(DbUtils.resultSetToTableModel(rs));            
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
       else if(ae.getSource() == back)
        {
            setVisible(false);
            new Reception();
        }
        
    }
    public static void main(String[] args) 
    {
        new PickupService();
        
    }
    
}
