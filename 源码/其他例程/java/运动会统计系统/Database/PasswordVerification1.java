import javax.swing.*;  

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class PasswordVerification1 extends JFrame{

	
	public static void main(String[] args) {
		PasswordVerification1 p = new PasswordVerification1();
		p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension size=Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize=p.getSize();
		p.setLocation((size.width-frameSize.width)/2,(size.height-frameSize.height)/2);

	}
	
	JLabel userLabel;
	JLabel passwordLabel;
	JTextField userText;
	JPasswordField passwordText;
	
	
	int count=1;
	
	public PasswordVerification1(){
		super("µ«¬Ω“≥√Ê");
		
		Font font = new Font("—≈∫⁄",Font.PLAIN,12);
		UIManager.put("Label.font", font);
	
		passwordLabel = new JLabel("√‹  ¬Î£∫");
		passwordLabel.setBounds(179, 207, 60, 15);
		userLabel = new JLabel("”√ªß√˚£∫");
		userLabel.setBounds(179, 172, 60, 15);
		userText = new JTextField(10);
		userText.setBounds(238, 169, 85, 21);
		passwordText = new JPasswordField(10);
		passwordText.setBounds(238, 204, 85, 21);
		passwordText.setEchoChar('#');
		passwordText.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
//				JFrame mainFrame=new Operation();
//				mainFrame.setVisible(true);
//				setV();
//				System.exit(0);
			String userName = userText.getText();
			char[] passwords = passwordText.getPassword();
			String password = new String(passwords);
			if(e.getSource()==passwordText){
				Connection con=connection();
				if(con!=null){
					try{
					Statement stmt=con.createStatement();
					ResultSet rs=stmt.executeQuery("select * from admin where π‹¿Ì‘±='"+userName+"' and √‹¬Î='"+password+"'");
				if(rs.next()){
					JOptionPane.showMessageDialog(null, "ª∂”≠ƒ„"+userName);
					JFrame mainFrame=new Operation();
					mainFrame.setVisible(true);
					setV();
				}else if(count>3){
					System.exit(0);
				}else{
					JOptionPane.showMessageDialog(null, userText.getText()+"£¨ƒ˙µƒ√‹¬Î ‰»Î¥ÌŒÛ£°");
					passwordText.setText("");
					userText.setText("");
					count++;
				}
				}catch(SQLException e1){System.out.println(e1.getMessage());}
				}
			}
			}
			});
		
		Container container = new JPanel(){
			protected void paintComponent(Graphics g) {  
                ImageIcon icon = new ImageIcon("image\\background.png");  
                Image img = icon.getImage();  
                g.drawImage(img, 0, 0, 400,  
                        300, icon.getImageObserver());  
                
  
            }  
		};
		container.setLayout(null);
		container.add(userLabel);
		container.add(userText);
		container.add(passwordLabel);
		container.add(passwordText);
		getContentPane().add(container);
		
		
		setSize(400,300);
		setVisible(true);
		
		}
	
        Connection connection() {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			String url = "jdbc:odbc:driver={SQL Server};server=(local);database=DatabaseDesign";
			Connection connection = DriverManager.getConnection(url);
			return connection;
		} catch (ClassNotFoundException e1) {
			System.out.println(e1.getMessage());
			return null;
		} catch (SQLException e2) {
			System.out.println(e2.getMessage());
			return null;
		}
	}
        
        public void setV(){
        	this.setVisible(false);
        }
	
	
	
	

}

 
