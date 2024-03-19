
import java.awt.event.*;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import java.util.Date;
import java.sql.ResultSet;



import javax.swing.*;



public class AddCustomer extends JFrame implements ActionListener
{
    JComboBox comboid;
    JTextField tfnumber , tfname ,  tfcountry ,tfdeposit;
    JRadioButton rbmale , rbfemale;
    Choice croom;
    JLabel lbltime;
    JButton add ,  back;
    AddCustomer()
    {
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text = new JLabel("NEW CUSTOMER FORM");
        text.setBounds(100, 20, 300, 30);
        text.setFont(new Font("Raleway", Font.BOLD , 20));
        add(text);

        JLabel lblid = new JLabel("ID");
        lblid.setBounds(30,80, 100, 20);
        lblid.setFont(new Font("Raleway", Font.PLAIN , 20));
        add(lblid);

        String option[] = {"Aadhar Card","Passport","Driving Lincense","Voter-id Card"};
         comboid = new JComboBox(option);
        comboid.setBounds(200, 75, 170, 30);
        comboid.setBackground(Color.white);
        add(comboid);

        JLabel lblnumber = new JLabel("NUMBER");
        lblnumber.setBounds(30,120, 100, 20);
        lblnumber.setFont(new Font("Raleway", Font.PLAIN , 20));
        add(lblnumber);

        tfnumber = new JTextField();
        tfnumber.setBounds(200, 115, 170, 30);
        add(tfnumber);

        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(30,160, 100, 20);
        lblname.setFont(new Font("Raleway", Font.PLAIN , 20));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 155, 170, 30);
        add(tfname);

        
        JLabel lblgender = new JLabel("GENDER");
        lblgender.setBounds(30,200, 100, 20);
        lblgender.setFont(new Font("Raleway", Font.PLAIN , 20));
        add(lblgender);

        rbmale = new JRadioButton("Male");
        rbmale.setBackground(Color.white);
        rbmale.setBounds(200, 200, 60, 25);
        add(rbmale);

         rbfemale = new JRadioButton("Female");
        rbfemale.setBackground(Color.white);
        rbfemale.setBounds(300, 200, 100, 25);
        add(rbfemale);

        JLabel lblcountry = new JLabel("COUNTRY");
        lblcountry.setBounds(30,245, 100, 20);
        lblcountry.setFont(new Font("Raleway", Font.PLAIN , 20));
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(200, 240, 170, 30);
        add(tfcountry);

        JLabel lblroomno = new JLabel("ROOM NO");
        lblroomno.setBounds(30,285, 100, 20);
        lblroomno.setFont(new Font("Raleway", Font.PLAIN , 20));
        add(lblroomno);

        croom = new Choice();
        try
        {
            Conn conn = new Conn();
            String query = "select * from room where availabilty = 'Available'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next())
            {
                croom.add(rs.getString("roomnumber"));
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        croom.setBounds(200, 285, 170, 50);
        add(croom);

        JLabel lblcheckintime = new JLabel("Checkin time");
        lblcheckintime.setBounds(30,325, 130, 20);
        lblcheckintime.setFont(new Font("Raleway", Font.PLAIN , 20));
        add(lblcheckintime);
        Date date = new Date();

         lbltime = new JLabel("" +date);
        lbltime.setBounds(200,325, 180, 20);
        lbltime.setFont(new Font("Raleway", Font.PLAIN , 12));
        add(lbltime);

        JLabel lbldeposit = new JLabel("DEPOSIT");
        lbldeposit.setBounds(30,365, 100, 20);
        lbldeposit.setFont(new Font("Raleway", Font.PLAIN , 20));
        add(lbldeposit);

        tfdeposit = new JTextField();
        tfdeposit.setBounds(200, 365, 170, 30);
        add(tfdeposit);

        add = new JButton("Add");
        add.setBounds(30, 425, 120, 30);
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBounds(250, 425, 120, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);  
        image.setBounds(390, 60, 450, 370);
        add(image);








        setBounds(250, 100, 800, 550);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource() == add)
        {
            String id = (String)comboid.getSelectedItem();
            String number = tfnumber.getText();
            String name = tfname.getText();
            String gender = null;

            if (rbmale.isSelected())
            {
                gender = "Male";
            }
            else if (rbfemale.isSelected())
            {
                gender = "Female";
            }

            String country = tfcountry.getText();
            String room = croom.getSelectedItem();
            String time = lbltime.getText();
            String deposit = tfdeposit.getText();

            try{
                Conn conn = new Conn();
                String query = "insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"')";
                String query2 = "update room set availabilty = 'Occupied' where roomnumber = '"+room+"'";

                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Added Customer Successfully");

                setVisible(false);
                new Reception();

            }
            catch(Exception e)
            { 
                e.printStackTrace();
            }

        }
        else if (ae.getSource() == back)
        
        {

             setVisible(false);
                new Reception();

        }
    }
    public static void main(String[] args) 
    {
        new AddCustomer();
        
    }
    
}
