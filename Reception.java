import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame implements ActionListener
{
    JButton newcustomer , rooms , department , allemployees , customerinfo , managerinfo , checkout , updatestatus , updateroom , pickup , searchroom , logout;
    Reception()
    {
        getContentPane().setBackground(Color.white);
       
        setLayout(null);

        newcustomer = new JButton("New Customer Form");
        newcustomer.setBounds(20, 20, 200, 30);
         newcustomer.setBackground(Color.BLACK);
         newcustomer.setForeground(Color.white);
         newcustomer.addActionListener(this);
        add(newcustomer);

        rooms = new JButton("Rooms");
        rooms.setBounds(20, 60, 200, 30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.white);
        rooms.addActionListener(this);
        add(rooms);

        department = new JButton("Department");
        department.setBounds(20, 100, 200, 30);
        department.setBackground(Color.BLACK);
        department.setForeground(Color.white);
        department.addActionListener(this);
        add(department);

        allemployees = new JButton("All Employees");
        allemployees.setBounds(20, 140, 200, 30);
        allemployees.setBackground(Color.BLACK);
        allemployees.setForeground(Color.white);
        allemployees.addActionListener(this);
        add(allemployees);

        customerinfo = new JButton("Customer Info");
        customerinfo.setBounds(20, 180, 200, 30);
        customerinfo.setBackground(Color.BLACK);
        customerinfo.setForeground(Color.white);
        customerinfo.addActionListener(this);
        add(customerinfo);

         managerinfo = new JButton("Manager Info");
        managerinfo.setBounds(20, 220, 200, 30);
        managerinfo.setBackground(Color.BLACK);
        managerinfo.setForeground(Color.white);
        managerinfo.addActionListener(this);
        add(managerinfo);

         checkout = new JButton("Checkout");
        checkout.setBounds(20, 260, 200, 30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.white);
        checkout.addActionListener(this);
        add(checkout);

         updatestatus = new JButton("Update Status");
        updatestatus.setBounds(20, 300, 200, 30);
        updatestatus.setBackground(Color.BLACK);
        updatestatus.setForeground(Color.white);
        updatestatus.addActionListener(this);
        add(updatestatus);

         updateroom = new JButton("Update Room Status");
        updateroom.setBounds(20, 340, 200, 30);
        updateroom.setBackground(Color.BLACK);
        updateroom.setForeground(Color.white);
        updateroom.addActionListener(this);
        add(updateroom);

         pickup = new JButton("Pickup Service");
        pickup.setBounds(20, 380, 200, 30);
        pickup.setBackground(Color.BLACK);
        pickup.setForeground(Color.white);
        pickup.addActionListener(this);
        add(pickup);

         searchroom = new JButton("Search Room");
        searchroom.setBounds(20, 420, 200, 30);
        searchroom.setBackground(Color.BLACK);
        searchroom.setForeground(Color.white);
        searchroom.addActionListener(this);
        add(searchroom);

         logout = new JButton("Logout");
        logout.setBounds(20, 460, 200, 30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.white);
        logout.addActionListener(this);
        add(logout);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(250, 20, 500,470);
        add(image);





        setBounds(270, 90, 800, 570);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource() == newcustomer)
        {
            setVisible(false);
            new AddCustomer();
        }
        else if(ae.getSource() == rooms)
        {
            setVisible(false);
            new Rooms();
        }
        else if(ae.getSource() == department)
        {
            setVisible(false);
            new Department();
        }
         else if(ae.getSource() == allemployees)
        {
            setVisible(false);
            new EmployeeInfo();
        }
         else if(ae.getSource() == managerinfo)
        {
            setVisible(false);
            new ManagerInfo();
        }
         else if(ae.getSource() == customerinfo)
        {
            setVisible(false);
            new CustomerInfo();
        }
         else if(ae.getSource() == searchroom)
        {
            setVisible(false);
            new SearchRoom();
        }
         else if(ae.getSource() == updatestatus)
        {
            setVisible(false);
            new UpdateCheckOut();
        }
         else if(ae.getSource() == updateroom)
        {
            setVisible(false);
            new UpdateRoom();
        }
        else if(ae.getSource() == pickup)
        {
            setVisible(false);
            new PickupService();
        }
          else if(ae.getSource() == checkout)
        {
            setVisible(false);
            new Checkout();
        }
          else if(ae.getSource() == logout)
        {
            setVisible(false);
            new Login();
        }
        
    }

    public static void main(String args[]) 
    {
        new Reception();
        
    }
    
}
