import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddRooms extends JFrame implements ActionListener
{
    JTextField tfroomno , tfprice;
    JButton add , cancel;
    JComboBox availablecombo , cleancombo , bedcombo;
    AddRooms()
    {
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel addrooms = new JLabel("ADD ROOMS");
        addrooms.setBounds(150, 20, 130, 30);
        addrooms.setFont(new Font("serif ",Font.BOLD,20));
        add(addrooms);

         JLabel lblroomno = new JLabel("Room Number");
        lblroomno.setBounds(80, 60, 130, 30);
        lblroomno.setFont(new Font("serif ",Font.PLAIN,18));
        add(lblroomno);

        tfroomno = new JTextField();
        tfroomno.setBounds(280, 68, 120, 20);
        tfroomno.setFont(new Font("serif",Font.BOLD ,12));
        add(tfroomno);

         JLabel lblavailable = new JLabel("Available");
        lblavailable.setBounds(80, 100, 130, 30);
        lblavailable.setFont(new Font("serif ",Font.PLAIN,18));
        add(lblavailable);

        String availableoption[] = {"Available","Occupied"};
         availablecombo = new JComboBox(availableoption);
        availablecombo.setBounds(280, 100, 120, 30);
        add(availablecombo);

          JLabel lblclean = new JLabel("Cleaning Status");
        lblclean.setBounds(80, 140, 130, 30);
        lblclean.setFont(new Font("serif ",Font.PLAIN,18));
        add(lblclean);

        String cleanoption[] = {"Cleaned","Dirty"};
         cleancombo = new JComboBox(cleanoption);
        cleancombo.setBounds(280, 140, 120, 30);
        add(cleancombo);

         JLabel lblprice = new JLabel("Price");
        lblprice.setBounds(80, 180, 130, 30);
        lblprice.setFont(new Font("serif ",Font.PLAIN,18));
        add(lblprice);

        tfprice = new JTextField();
        tfprice.setBounds(280, 185, 120, 20);
        tfprice.setFont(new Font("serif",Font.BOLD ,12));
        add(tfprice);

         JLabel lblbedtype = new JLabel("Bed Type");
        lblbedtype.setBounds(80, 220, 130, 30);
        lblbedtype.setFont(new Font("serif ",Font.PLAIN,18));
        add(lblbedtype);

        String bedoption[] = {"Single Bed","Double Bed"};
         bedcombo = new JComboBox(bedoption);
        bedcombo.setBounds(280, 218, 120, 30);
        add(bedcombo);

        add = new JButton("Add Rooms");
        add.setForeground(Color.white);
        add.setBackground(Color.black);
        add.setBounds(80, 280, 130, 30);
        add.addActionListener(this);
        add(add);

         cancel = new JButton("Cancel");
        cancel.setForeground(Color.white);
        cancel.setBackground(Color.black);
        cancel.setBounds(270, 280, 130, 30);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(450,30, 400, 250);
        add(image);




        setBounds(250, 150, 900, 400);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) 
    {
        

        if(ae.getSource() == add)
        {
            String roomnumber = tfroomno.getText();
            String availbility = (String) availablecombo.getSelectedItem();
            String status = (String) cleancombo.getSelectedItem();
            String price = tfprice.getText();
            String type = (String) bedcombo.getSelectedItem();

            try{
                Conn conn = new Conn();
                String str = "insert into room values('"+roomnumber+"' , '"+availbility+"' , '"+status+"' , '"+price+"' , '"+type+"')";
                conn.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "New Room Added Successfully");
                setVisible(false);

            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

        }
        else
        {
           setVisible(false);
        }
    }
    public static void main(String[] args) 
    {
        new AddRooms();
        
    }
}
