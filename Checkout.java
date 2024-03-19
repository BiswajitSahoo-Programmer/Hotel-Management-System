import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.util.Date;

public class Checkout extends JFrame implements ActionListener
{
    Choice c;
    JLabel roomno ,checkintime  , checkouttime;
    JButton checkout , back;
    Checkout()
    {
        getContentPane().setBackground(Color.white);
        setLayout(null);

         JLabel lblcheck = new JLabel("CHECKOUT");
        lblcheck.setBounds(150,20, 200, 30);
        lblcheck.setFont(new Font("serif" , Font.BOLD ,20));
        lblcheck.setForeground(Color.blue  );
        add(lblcheck);

         JLabel l1 = new JLabel("Customer Id");
        l1.setBounds(40,100, 90, 30);
        add(l1);

        c = new Choice();
        c.setBounds(150, 105, 140, 30);
        add(c);

      
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(300, 105, 20,20);
        add(image);

         JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(40,150, 90, 30);
        add(lblroom);

          JLabel roomno = new JLabel();
        roomno.setBounds(150,150, 90, 30);
        add(roomno);

         JLabel lblcheckintime = new JLabel("Checkin Time");
        lblcheckintime.setBounds(40,200, 90, 30);
        add(lblcheckintime);
        Date d = new Date();

           checkintime = new JLabel("" +d);
        checkintime.setBounds(150,200, 120, 30);
        add(checkintime);

         JLabel lblcheckouttime = new JLabel("Checkout Time");
         lblcheckouttime.setBounds(40,250, 90, 30);
        add( lblcheckouttime);
        Date date = new Date();

           checkouttime = new JLabel("" +date);
        checkouttime.setBounds(150,250, 120, 30);
        add(checkouttime);

         checkout = new JButton("CHECKOUT");
        checkout.setBounds(50, 300, 120, 30);
         checkout.setBackground(Color.BLACK);
         checkout.setForeground(Color.white);
         checkout.addActionListener(this);
        add(checkout);

        back = new JButton("BACK");
        back.setBounds(200, 300, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

          try
        {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from customer");
            while(rs.next())
            {
                c.add(rs.getString("number"));
                roomno.setText(rs.getString("room"));
                checkintime.setText(rs.getString("checkintime"));
            }


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image img2 = img.getImage().getScaledInstance(400, 250,Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel img4 = new JLabel(img3);
        img4.setBounds(350, 50, 400,250);
        add(img4);



        setBounds(300, 200, 800, 400);
        setVisible(true);


    }

      public void actionPerformed(ActionEvent ae) 
      {
        if(ae.getSource() == checkout)
        {
            String query1 = "delete from customer where number = '"+c.getSelectedItem()+"'";  
            String query2 = "update room set availabilty = 'Available' where roomnumber = '"+roomno.getText()+"'";

            try{
                Conn conn = new Conn();
                conn.s.executeQuery(query1);
                conn.s.executeQuery(query2);

                JOptionPane.showMessageDialog(null,"Checkout done");
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

        new Checkout();
    }
    
}
