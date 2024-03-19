import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddDrivers extends JFrame implements ActionListener
{
    JTextField tfname ,tfgender, tfcompany ,tfmodel , tflocation;;
    JButton add , cancel;
    JComboBox availablecombo , agecombo , bedcombo;
    AddDrivers()
    {
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel addrooms = new JLabel("ADD DRIVERS");
        addrooms.setBounds(150, 20, 150, 30);
        addrooms.setFont(new Font("serif ",Font.BOLD,20));
        add(addrooms);

         JLabel lblroomno = new JLabel("Name");
        lblroomno.setBounds(80, 60, 130, 30);
        lblroomno.setFont(new Font("serif ",Font.PLAIN,18));
        add(lblroomno);

        tfname = new JTextField();
        tfname.setBounds(280, 68, 120, 20);
        tfname.setFont(new Font("serif",Font.BOLD ,12));
        add(tfname);

         JLabel lblavailable = new JLabel("Age");
        lblavailable.setBounds(80, 100, 130, 30);
        lblavailable.setFont(new Font("serif ",Font.PLAIN,18));
        add(lblavailable);

        tfgender = new JTextField();
        tfgender.setBounds(280, 103, 120, 20);
        tfgender.setFont(new Font("serif",Font.BOLD ,12));
        add(tfgender);

          JLabel lblclean = new JLabel("Gender");
        lblclean.setBounds(80, 140, 130, 30);
        lblclean.setFont(new Font("serif ",Font.PLAIN,18));
        add(lblclean);

        String cleanoption[] = {"Male","Female"};
         agecombo = new JComboBox(cleanoption);
        agecombo.setBounds(280, 135, 120, 30);
        add(agecombo);

         JLabel lblprice = new JLabel("Car Company");
        lblprice.setBounds(80, 180, 130, 30);
        lblprice.setFont(new Font("serif ",Font.PLAIN,18));
        add(lblprice);

        tfcompany = new JTextField();
        tfcompany.setBounds(280, 185, 120, 20);
        tfcompany.setFont(new Font("serif",Font.BOLD ,12));
        add(tfcompany);

         JLabel lblbedtype = new JLabel("Car Model");
        lblbedtype.setBounds(80, 220, 130, 30);
        lblbedtype.setFont(new Font("serif ",Font.PLAIN,18));
        add(lblbedtype);

       tfmodel = new JTextField();
        tfmodel.setBounds(280, 230, 120, 20);
        tfmodel.setFont(new Font("serif",Font.BOLD ,12));
        add(tfmodel);

        JLabel lblavailbilty = new JLabel("Availbility");
        lblavailbilty.setBounds(80, 260, 130, 30);
        lblavailbilty.setFont(new Font("serif ",Font.PLAIN,18));
        add(lblavailbilty);

        
        String driveroption[] = {"Available","Busy"};
         availablecombo = new JComboBox(driveroption);
        availablecombo.setBounds(280, 264, 120, 30);
        add(availablecombo);

         JLabel lbllocation = new JLabel("Location");
        lbllocation.setBounds(80, 300, 130, 30);
        lbllocation.setFont(new Font("serif ",Font.PLAIN,18));
        add(lbllocation);

       tflocation = new JTextField();
        tflocation.setBounds(280, 305, 120, 20);
        tflocation.setFont(new Font("serif",Font.BOLD ,12));
        add(tflocation);

        add = new JButton("Add Drivers");
        add.setForeground(Color.white);
        add.setBackground(Color.black);
        add.setBounds(80, 350, 130, 30);
        add.addActionListener(this);
        add(add);

         cancel = new JButton("Cancel");
        cancel.setForeground(Color.white);
        cancel.setBackground(Color.black);
        cancel.setBounds(270, 350, 130, 30);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450,10, 440, 450);
        add(image);




        setBounds(250, 150, 900, 450);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) 
    {
        

        if(ae.getSource() == add)
        {
            String name = tfname.getText();
            String age = tfgender.getText();
            String gender = (String) agecombo.getSelectedItem();
            String company = tfcompany.getText();
            String brand = tfmodel.getText();
            String availble = (String) availablecombo.getSelectedItem();
            String location = tflocation.getText();

            try{
                Conn conn = new Conn();
                String str = "insert into driver values('"+name+"' , '"+age+"' , '"+gender+"' , '"+company+"' , '"+brand+"' , '"+availble+"' , '"+location+"')";
                conn.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "New Driver Added Successfully");
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
        new AddDrivers();
        
    }
}
