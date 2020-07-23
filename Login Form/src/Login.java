
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{
    JButton b1, b2;
    JTextField  t1, t2;
    JLabel l,l1,l2;
    public Login(){
        //create labels and textfield
        l = new JLabel("LOGIN");
        l.setBounds(190, 20, 150, 30);
        l.setFont(new Font("login", Font.BOLD, 30));
        l.setForeground(Color.red);
        add(l);
        l1 = new JLabel("USERNAME");
        l1.setBounds(200, 60, 150, 30);
        l1.setFont(new Font("user", Font.BOLD, 15));
        l1.setForeground(Color.white);
        add(l1);
        t1 = new JTextField();
        t1.setBounds(140, 90, 200, 25);
        t1.setFont(new Font("t1", Font.BOLD, 15));
        add(t1);
        l2 = new JLabel("PASSWORD");
        l2.setBounds(200, 120, 150, 30);
        l2.setFont(new Font("pass", Font.BOLD, 15));
        l2.setForeground(Color.white);
        add(l2);
        t2 = new JTextField();
        t2.setBounds(140, 150, 200, 25);
        t2.setFont(new Font("t2", Font.BOLD, 15));
        add(t2);
        b1 = new JButton("login");
        b1.setBounds(190, 190, 100, 20);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);
        b2 = new JButton("logout");
        b2.setBounds(190, 220, 100, 20);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);
        // create form
        setBounds(470, 270, 500, 300);
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(Color.black);
    }
    
    public static void main(String[] args) {
          new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== b1){
           String username = t1.getText();
           String password = t2.getText();
           Conn c = new Conn();
           String str = "select * from login where username = '" + username + "' and password = '"+ password + "'" ;
           try {
               ResultSet rs = c.s.executeQuery(str);
               if(rs.next()){
               JOptionPane.showMessageDialog(null, "Welcome");
               this.setVisible(false);
               }else{
               JOptionPane.showMessageDialog(null, "invalid username and password");
               this.setVisible(false);
               }
           } catch (Exception ex) {
                ex.printStackTrace();
           }
           
       }else if(e.getSource()== b2){
           System.exit(0);
       }
    }
}
