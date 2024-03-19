
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.*;

import java.sql.*;

public class UpdateRoom extends JFrame implements ActionListener
 {
    Choice c;
    JTextField tfroomno , tfavailable , tfamount ,tfpending , tfstatus;
    JButton check , update , back;
    UpdateRoom()
    {
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel l1 = new JLabel("Update Room Status");
        l1.setBounds(110, 30, 200, 30);
        l1.setFont(new Font("Tahoma" , Font.PLAIN ,20));
        l1.setForeground(Color.blue);
        add(l1);

          JLabel l2 = new JLabel("Customer ID");
        l2.setBounds(90, 100, 100, 30);
        add(l2);
         c = new Choice();
        c.setBounds(200,105, 150, 25);
        add(c);

          JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(90, 150, 100, 30);
        add(lblroom);

        tfroomno = new JTextField();
        tfroomno.setBounds(200, 155, 150, 25);
        add(tfroomno);

           JLabel lblavailable = new JLabel("Availbilty");
        lblavailable.setBounds(90, 200, 100, 30);
        add(lblavailable);

        tfavailable = new JTextField();
        tfavailable.setBounds(200, 205, 150, 25);
        add(tfavailable);

           JLabel status = new JLabel("Cleaning Status");
        status.setBounds(90, 250, 100, 30);
        add(status);

        tfstatus = new JTextField();
        tfstatus.setBounds(200, 255, 150, 25);
        add(tfstatus);

         check = new JButton("Check");
        check.setForeground(Color.white);
        check.setBackground(Color.black);
        check.setBounds(20, 320, 100, 30);
        check.addActionListener(this);
        add(check);

        update = new JButton("Update");
        update.setForeground(Color.white);
        update.setBackground(Color.black);
        update.setBounds(140, 320, 100, 30);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        back.setBounds(260, 320, 100, 30);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 500,300);
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


        setBounds(200, 100, 900, 450);
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
                }
                   

            ResultSet rs2 = conn.s.executeQuery("select * from room where roomnumber = '"+tfroomno.getText()+"'");

            while(rs2.next())
            {
                tfavailable.setText(rs2.getString("availabilty"));
                tfstatus.setText(rs2.getString("cleaning_status"));
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
            String availableroom = tfavailable.getText();
            String status = tfstatus.getText();

            try
            {
                Conn conn = new Conn();
                conn.s.executeUpdate("update room set availabilty = '"+availableroom+"' , cleaning_status = '"+status+"'where roomnumber = '"+room+"'");
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
        new UpdateRoom();
        
    }
    
}
