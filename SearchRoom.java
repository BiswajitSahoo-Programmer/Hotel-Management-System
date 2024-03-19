import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import net.proteanit.sql.*;

public class SearchRoom extends JFrame implements ActionListener
{
    JButton back , submit;
    JTable table;
    JComboBox bedcombo;
    JCheckBox available;
    
    SearchRoom()
    {
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel lblroom = new JLabel("Search For Room");
        lblroom.setBounds(350,40, 200, 30);
        lblroom.setFont(new Font("serif" , Font.BOLD ,20));
        add(lblroom);

        
        JLabel bedtype = new JLabel("BedType");
        bedtype.setBounds(30,130, 90, 30);
        add(bedtype);

        String bedoption[] = {"Single Bed","Double Bed"};
         bedcombo = new JComboBox(bedoption);
        bedcombo.setBounds(170, 135, 120, 30);
        bedcombo.setBackground(Color.white);
        add(bedcombo);

        available = new JCheckBox("Only Display Available");
        available.setBounds(600, 135, 180, 25);
        available.setBackground(Color.white);
        add(available);

        
        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(40,200, 90, 30);
        add(l1);
        JLabel l2 = new JLabel("Availbility");
        l2.setBounds(230,200, 90, 30);
        add(l2);
        JLabel l3 = new JLabel("Status");
        l3.setBounds(430,200, 90, 30);
        add(l3);
        JLabel l4 = new JLabel("Price");
        l4.setBounds(600,200, 90, 30);
        add(l4);
        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(790,200, 90, 30);
        add(l5);

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
        if(ae.getSource() == submit)
        {
            try
            {
                String query1 = "select * from room where bed_type = '"+bedcombo.getSelectedItem()+"'";
                String query2 = "select * from room where availabilty = 'Available' AND bed_type = '"+bedcombo.getSelectedItem()+"'";
                Conn conn = new Conn();
                ResultSet rs;
                
                if (available.isSelected())
                {
                    rs = conn.s.executeQuery(query2);
                }
                else 
                {
                    rs = conn.s.executeQuery(query1);
                }
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
        new SearchRoom();
        
    }
    
}
