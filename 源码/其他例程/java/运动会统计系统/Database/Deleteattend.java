import java.awt.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Deleteattend extends MyJPanel{
	private JTextField Ano;
	private JTextField textField_1;
	private JTextField sportmanno;
	private JTextField matchno;
	private JTextField textField_2;
	private JTextField textField_3;
	public Deleteattend() {
		setLayout(new BorderLayout(0, 0));
			
		JPanel search = new MyJPanel();
		add(search, BorderLayout.NORTH);
		search.setLayout(new BorderLayout(0, 0));
		search.setBorder(new TitledBorder("查询"));
		
		JLabel instruction = new JLabel("请输入你想删除的运动员的编号:");
		search.add(instruction, BorderLayout.NORTH);
		
		JPanel panel = new MyJPanel();
		search.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("\u8FD0\u52A8\u5458\u7F16\u53F7\uFF1A");
		panel.add(lblNewLabel, BorderLayout.WEST);
		
		JPanel panel_1 = new MyJPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
			
		Ano = new JTextField();
		panel_1.add(Ano, BorderLayout.WEST);
		Ano.setColumns(8);
		
		JPanel panel_2 = new MyJPanel();
		panel_1.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("\u6BD4\u8D5B\u7F16\u53F7\uFF1A");
		panel_2.add(lblNewLabel_1, BorderLayout.WEST);
		
		JPanel panel_3 = new MyJPanel();
		panel_2.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		textField_1 = new JTextField();
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button_1 = new JButton("查询");
		panel_3.add(button_1, BorderLayout.EAST);
		
		JPanel main = new MyJPanel();
		add(main, BorderLayout.CENTER);
		main.setLayout(null);
		main.setBorder(new TitledBorder("查询结果"));
		
		JLabel label = new JLabel("\u6BD4\u8D5B\u6210\u7EE9\uFF1A");
		label.setBounds(66, 94, 98, 15);
		main.add(label);
		
		JLabel label_1 = new JLabel("\u8FD0\u52A8\u5458\u7F16\u53F7\uFF1A");
		label_1.setBounds(66, 30, 83, 15);
		main.add(label_1);
		
		JLabel label_2 = new JLabel("\u6BD4\u8D5B\u7F16\u53F7\uFF1A ");
		label_2.setBounds(66, 62, 85, 15);
		main.add(label_2);
		
		JLabel label_3 = new JLabel("比赛得分: ");
		label_3.setBounds(66, 126, 85, 15);
		main.add(label_3);
		
		sportmanno = new JTextField();
		sportmanno.setEditable(false);
		sportmanno.setBounds(143, 27, 166, 21);
		main.add(sportmanno);
		sportmanno.setColumns(30);
		
		matchno = new JTextField();
		matchno.setEditable(false);
		matchno.setBounds(143, 59, 166, 21);
		main.add(matchno);
		matchno.setColumns(30);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(143, 91, 166, 21);
		main.add(textField_2);
		textField_2.setColumns(30);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(143, 123, 166, 21);
		main.add(textField_3);
		textField_3.setColumns(30);
		
		final JButton delete = new JButton("\u5220\u9664");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		delete.setBounds(150, 155, 93, 23);
		main.add(delete);
		button_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Connection conn = connection();
					if(conn!=null){
						try{
							final Statement stmt=conn.createStatement();
							ResultSet rs = stmt.executeQuery("select * from 参加 where 运动员编号 = '" + Ano.getText() + "' and 比赛编号 = '" + textField_1.getText() + "'");
							if(rs.next()){
								sportmanno.setText(rs.getString(1));
								matchno.setText(rs.getString(2));
								textField_2.setText(rs.getString(3));
								textField_3.setText(rs.getString(4));
								}
							else
								JOptionPane.showMessageDialog(null,"请检查运动员编号是否与比赛编号相对应","删除",JOptionPane.WARNING_MESSAGE);
							delete.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent e){					
									try {
										stmt.executeQuery("delete from 参加 where 运动员编号 = '" + Ano.getText() + " ' and 比赛编号 = '" + textField_1.getText() + "'");
										JOptionPane.showMessageDialog(null,"删除成功","删除",JOptionPane.INFORMATION_MESSAGE);
									} catch (SQLException e1) {
										e1.printStackTrace();
									}
								}
							});
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame jf=new JFrame();
		jf.getContentPane().add(new Deleteattend());
		jf.setVisible(true);
		jf.setSize(400,300);
	}
}
