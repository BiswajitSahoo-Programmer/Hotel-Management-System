import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddEmployee extends JFrame implements ActionListener
{
    JTextField tfname , tfage , tfsalary , tfemail , tfphone , tfaadhar;
    JRadioButton rbmale , rbfemale;
    JButton submit;
    JComboBox cbjob;
    AddEmployee()
    {
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setBounds(250,100, 850, 540);
       

        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60, 30, 80, 30);
        lblname.setFont(new Font("Tahoma " , Font.CENTER_BASELINE,20));
        add(lblname);

         tfname = new JTextField();
        tfname.setBounds(200, 35, 250, 25);
        add(tfname);

        JLabel lblage = new JLabel("AGE");
        lblage.setBounds(60, 70, 80, 30);
        lblage.setFont(new Font("Tahoma " , Font.CENTER_BASELINE,20));
        add(lblage);

         tfage = new JTextField();
        tfage.setBounds(200, 75, 250, 25);
        add(tfage);

        JLabel lblgender = new JLabel("GENDER");
        lblgender.setBounds(60, 110, 110, 30);
        lblgender.setFont(new Font("Tahoma " , Font.CENTER_BASELINE,20));
        add(lblgender);

         rbmale = new JRadioButton("Male");
        rbmale.setBounds(200, 110, 110, 30);
        rbmale.setBackground(Color.white);
        rbmale.setFont(new Font("serif " ,Font.PLAIN,14));
        add(rbmale);

          rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(330, 110, 110, 30);
        rbfemale.setBackground(Color.white);
        rbfemale.setFont(new Font("serif " ,Font.PLAIN,14));
        add(rbfemale);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);

        JLabel lbljob = new JLabel("JOB");
        lbljob.setBounds(60, 155, 110, 30);
        lbljob.setFont(new Font("Tahoma " , Font.CENTER_BASELINE,20));
        add(lbljob);

        String str[] = { "Front Desk Clerks", "Porters" , "Housekeeping" , "Kitchen Staff" , "Room Service" , "Chefs" , "Waiter/Waiteress" , "Manager" , "Accountant"};
         cbjob = new JComboBox(str);
        cbjob.setBounds(200, 155, 160, 30);
        cbjob.setBackground(Color.white);
        add(cbjob);

         JLabel lblsalary = new JLabel("SALARY");
        lblsalary.setBounds(60, 200, 120, 30);
        lblsalary.setFont(new Font("Tahoma " , Font.CENTER_BASELINE,20));
        add(lblsalary);

         tfsalary = new JTextField();
        tfsalary.setBounds(200, 205, 250, 25);
        add(tfsalary);

         JLabel lblphone = new JLabel("PHONE");
        lblphone.setBounds(60, 245, 80, 30);
        lblphone.setFont(new Font("Tahoma " , Font.CENTER_BASELINE,20));
        add(lblphone);

         tfphone = new JTextField();
        tfphone.setBounds(200, 250, 250, 25);
        add(tfphone);

         JLabel lblemail = new JLabel("EMAIL");
        lblemail.setBounds(60, 290, 80, 30);
        lblemail.setFont(new Font("Tahoma " , Font.CENTER_BASELINE,20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 295, 250, 25);
        add(tfemail);

        JLabel lblaadhar = new JLabel("AADHAR");
        lblaadhar.setBounds(60, 325, 120, 30);
        lblaadhar.setFont(new Font("Tahoma " , Font.CENTER_BASELINE,20));
        add(lblaadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(200, 330, 250, 25);
        add(tfaadhar);

         submit = new JButton("SUBMIT");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setBounds(250, 400, 150, 30);
        submit.addActionListener(this);
        add(submit);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);  
        image.setBounds(440, 60, 450, 370);
        add(image);



         setVisible(true);

    }
    public void actionPerformed(ActionEvent e) 
    {
        String name = tfname.getText();
        String age = tfage.getText();
        String salary = tfsalary.getText();
        String phone = tfphone.getText();
        String email = tfemail.getText();
        String aadhar = tfaadhar.getText();

        String gender = null;
        
        // validation should be filled

        if(name.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Name should not be empty");
            return;
        }

        if(rbmale.isSelected())
        {
            gender = "Male";
        }
        else if(rbfemale.isSelected())
        {
            gender = "Female";
        }

        String job = (String) cbjob.getSelectedItem();

        try{
            Conn conn = new Conn();
            String query = "insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";
            conn.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Employee added successfully");
            setVisible(false);

        }
        catch(Exception ae)
        {
            ae.printStackTrace();
        }
        
    }

     
    public static void main(String[] args) 
    {
        new AddEmployee();
        
    }
    
}
