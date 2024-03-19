import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class Login extends JFrame implements ActionListener
{
    JTextField username;
    JPasswordField password;
    JButton login,cancel;
    Login()
    {
        getContentPane().setBackground(Color.white);
        setBounds(400, 50, 600, 400);
       
        setLayout(null);

        JLabel user = new JLabel("Username");
        user.setBounds(60,20, 100, 50);
        add(user);

         username = new JTextField();
        username.setBounds(160,30,150, 30); 
        add(username);

        JLabel pass = new JLabel("Password");
        pass.setBounds(60 ,100, 100, 50);
        add(pass);

         password = new JPasswordField();
        password.setBounds(160,110,150, 30); 
        add(password);

         login = new JButton("Login");
        login.setBounds(60, 200, 100, 40);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

         cancel = new JButton("Cancel");
        cancel.setBounds(210, 200, 100, 40);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 50,200, 200);
        add(image);


        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource() == login)
        {
            String user = username.getText();
            String pass = password.getText();

            try{
                Conn c = new Conn();
                String query = "select * from login where username = '" + user + "' and password = '" + pass + "'";
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next())
                {
                    setVisible(false);
                    new Dashboard();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                    setVisible(false);
                }

            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

        }
        else if(ae.getSource() == cancel)
        {
            setVisible(false);
        }
        
    }
    public static void main(String[] args) 
    {
        new Login();
        
    }
    
}
