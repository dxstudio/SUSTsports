import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Workinf extends MyJPanel{
	private JTextField Wno;
	private JTextField Wname;
	private JTextField Wtel;
	String sex = "男";
	public Workinf() {
		setLayout(null);
		
		JPanel panel = new MyJPanel();
		panel.setBounds(45, 10, 291, 236);
		add(panel);
		panel.setLayout(null);
		panel.setBorder(new TitledBorder("新建工作人员"));
		
		JLabel label = new JLabel("    工作人员编号    ");
		label.setBounds(22, 35, 132, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("    工作人员姓名    ");
		label_1.setBounds(22, 70, 132, 15);
		panel.add(label_1);
		
		JLabel lblNewLabel = new JLabel("    工作人员性别    ");
		lblNewLabel.setBounds(22, 105, 132, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("   联系方式      ");
		lblNewLabel_1.setBounds(22, 140, 132, 15);
		panel.add(lblNewLabel_1);
		
		JButton submit = new JButton("提交");
		submit.setBounds(93, 178, 93, 23);
		panel.add(submit);
		
		Wno = new JTextField();
		Wno.setBounds(131, 32, 112, 21);
		panel.add(Wno);
		Wno.setColumns(10);
		
		Wname = new JTextField();
		Wname.setBounds(131, 70, 112, 21);
		panel.add(Wname);
		Wname.setColumns(10);
		
		JPanel panel_1 = new MyJPanel();
		panel_1.setBounds(131, 98, 112, 27);
		panel.add(panel_1);
		
		JRadioButton radioButton = new JRadioButton("男",true);
		panel_1.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("女");
		panel_1.add(radioButton_1);
		
		final ButtonGroup g=new ButtonGroup();
		g.add(radioButton);
		g.add(radioButton_1);
		
		radioButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				sex = "男";
			}
		});
		radioButton_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				sex = "女";
			}
		});
		
		Wtel = new JTextField();
		Wtel.setBounds(131, 140, 112, 21);
		panel.add(Wtel);
		Wtel.setColumns(10);
		submit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Connection conn = connection();
					if(conn!=null){
						try{
							Statement stmt=conn.createStatement();							
							if(!Wno.getText().trim().equals("") && !Wname.getText().trim().equals("") && g.getElements() != null && !Wtel.getText().trim().equals("")){								
								ResultSet r = stmt.executeQuery("select 负责人编号 from 工作人员 where 负责人编号 = '" + Wno.getText() + "'");
								if(r.next())
										JOptionPane.showMessageDialog(null,"该编号已存在,请重新输入","负责人信息录入",JOptionPane.WARNING_MESSAGE);									
								else{
									JOptionPane.showMessageDialog(null,"信息录入成功","负责人信息录入",JOptionPane.INFORMATION_MESSAGE);
									stmt.executeUpdate("insert into 工作人员 (负责人编号,姓名,性别,联系方式) values ('" + Wno.getText() + "','" + Wname.getText() + "','" + 
											sex + "','" + Wtel.getText()  + "') ");}
								}								
							else
								System.out.println("还有没输入的信息");
						}
						catch(Exception ex){
							ex.printStackTrace();
						}
				}	
			}
		});
	}
	Connection connection() {
		
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			String url = "jdbc:odbc:driver={SQL Server};server=(local);database=DatabaseDesign";
			Connection connection = DriverManager.getConnection(url);
			return connection;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
//	public static void main(String[] args){
//		JFrame f1 = new JFrame();
//		f1.getContentPane().add(new Workinf());
//		f1.setVisible(true);
//		f1.setLocationRelativeTo(null);
//		f1.setSize(400,300);
//		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	}
}
