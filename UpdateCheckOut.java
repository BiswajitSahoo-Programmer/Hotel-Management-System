import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.*;

import java.sql.*;

public class UpdateCheckOut extends JFrame implements ActionListener
 {
    Choice c;
    JTextField tfroomno , tfname , tfamount ,tfpending , tftime;
    JButton check , update , back;
    UpdateCheckOut()
    {
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel l1 = new JLabel("Update Status");
        l1.setBounds(90, 30, 200, 30);
        l1.setFont(new Font("Tahoma" , Font.PLAIN ,20));
        l1.setForeground(Color.blue);
        add(l1);

          JLabel l2 = new JLabel("Customer ID");
        l2.setBounds(90, 100, 100, 30);
        add(l2);

          JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(90, 140, 100, 30);
        add(lblroom);

        tfroomno = new JTextField();
        tfroomno.setBounds(200, 145, 150, 25);
        add(tfroomno);

           JLabel lblname = new JLabel("Name");
        lblname.setBounds(90, 180, 100, 30);
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 185, 150, 25);
        add(tfname);

           JLabel lblcheck = new JLabel("Checkin Time");
        lblcheck.setBounds(90, 220, 100, 30);
        add(lblcheck);

        tftime = new JTextField();
        tftime.setBounds(200, 225, 150, 25);
        add(tftime);

           JLabel lblamount = new JLabel("Amount Paid");
        lblamount.setBounds(90, 260, 100, 30);
        add(lblamount);

        tfamount = new JTextField();
        tfamount.setBounds(200, 265, 150, 25);
        add(tfamount);

           JLabel lblpending = new JLabel("Pending Amount");
        lblpending.setBounds(90, 300, 100, 30);
        add(lblpending);

        tfpending = new JTextField();
        tfpending.setBounds(200, 305, 150, 25);
        add(tfpending);

        c = new Choice();
        c.setBounds(200,105, 150, 25);
        add(c);

         check = new JButton("Check");
        check.setForeground(Color.white);
        check.setBackground(Color.black);
        check.setBounds(20, 380, 100, 30);
        check.addActionListener(this);
        add(check);

        update = new JButton("Update");
        update.setForeground(Color.white);
        update.setBackground(Color.black);
        update.setBounds(140, 380, 100, 30);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        back.setBounds(260, 380, 100, 30);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(350, 50, 500,300);
        add(image);


        try
        {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from customer"); 
            while(rs.next())
            {
                c.add(rs.getString("number"));
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


        setBounds(200, 100, 900, 500);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == check)
        {
            String id = c.getSelectedItem();
            String query = "select * from customer where number = '"+id+"'";
            try 
            {
                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery(query);
                while(rs.next())
                {
                    tfroomno.setText(rs.getString("room"));
                    tfname.setText(rs.getString("name"));
                    tftime.setText(rs.getString("checkintime"));
                    tfamount.setText(rs.getString("deposit"));
            }

            ResultSet rs2 = conn.s.executeQuery("select * from room where roomnumber = '"+tfroomno.getText()+"'");

            while(rs2.next())
            {
                String price = rs2.getString("Price");
                int Amountpaid = Integer.parseInt(price) - Integer.parseInt(tfamount.getText());
                tfpending.setText("" + Amountpaid);
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
        else if (ae.getSource() == update)
        {
            String number = c.getSelectedItem();
            String room = tfroomno.getText();
            String name = tfname.getText();
            String checkin = tftime.getText();
            String deposit = tfamount.getText();

            try
            {
                Conn conn = new Conn();
                conn.s.executeUpdate("update customer set room = '"+room+"' , name = '"+name+"' , checkintime = '"+checkin+"' , deposit = '"+deposit+"' where number = '"+number+"'");
                JOptionPane.showMessageDialog(null,"Data Upadated Succesfully");

                setVisible(false);
                new Reception();

            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

        }
        else
        {
             setVisible(false);
                new Reception();
             
        }
    }
    public static void main(String[] args) 
    {
        new UpdateCheckOut();
        
    }
    
}
