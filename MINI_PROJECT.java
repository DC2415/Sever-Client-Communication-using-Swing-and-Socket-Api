import java.awt.event.ActionListener;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.*;
public class MINI_PROJECT implements ActionListener
{
JFrame f;
        JTextField t;
        JLabel heading , l1 , reply,jl;
        JButton find;
 MINI_PROJECT( ){
 f = new JFrame("2013804_Dhananjay_Chacherkar");
            
            System.out.println("frame is created");
            
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
    
            heading = new JLabel("Check Number is Prime or Not");
            heading.setBounds(135, 30, 500, 30);
            heading.setFont(new Font("Arial", Font.BOLD,30));
    
            l1 = new JLabel("Enter number :");
            l1.setBounds(165, 180, 200, 30);
            l1.setFont(new Font("Arial", Font.BOLD,20));
    
            t = new JTextField(20);
            t.setBounds(330, 180, 200, 30);

            



            find = new JButton("CHECK");
            find.setBounds(285, 400, 100, 30);
            find.addActionListener(this);
			jl = new JLabel("Press Check after giving input");
            jl.setBounds(250,300,200,80);
    
            
            f.add(l1);
            f.add(heading);
            f.add(t);
            
            f.add(find);
			f.add(jl);
    
            
            
        
            f.setSize(700, 500);
            f.setLayout(null);
            f.setVisible(true);


}
public void actionPerformed(ActionEvent ae)  {
    try{
Socket s = new Socket("localhost",1559);
System.out.println("SERVER CONNECTED");
InputStream  is = s.getInputStream();
OutputStream os = s.getOutputStream();

String str = t.getText();
PrintWriter pw = new PrintWriter(os,true);
pw.println(str);

Scanner sc = new Scanner(is);
String str2 = sc.nextLine();
System.out.println(str2);
 jl.setText(str2);

}
catch(Exception e){
}  
}
public static void main(String args[]){
new MINI_PROJECT();
}
}