
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class HotelManagement extends JFrame implements ActionListener
 {
    HotelManagement()
    {
        setSize(1350,1000);
        
        setBounds(-10, 0, 1350, 1000);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1350, 1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(-10, 0, 1350,1000);
        add(image);

        JLabel text = new JLabel("Hotel Management System");
        text.setBounds(20, 550, 1000,90);
        text.setForeground(Color.white);
        text.setFont(new Font( "serif",Font.BOLD,50));
        image.add(text);

        JButton next = new JButton("Next");
        next.setBounds(1150,600, 100,40);
        next.setBackground(Color.orange);
        next.setForeground(Color.BLACK);
        next.addActionListener(this);
        next.setFont(new Font("serif" ,Font.PLAIN,20));
        image.add(next);
        setVisible(true);

        while(true){
            text.setVisible(false);
            try{ Thread.sleep(500);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            text.setVisible(true);
             try{ Thread.sleep(500);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            }
        }
        public void actionPerformed(ActionEvent ae) 
        {
            setVisible(false);
            new Login();
            
        }
       
        
    
    public static void main(String[] args)
     {
        new HotelManagement();
    }
}
    
