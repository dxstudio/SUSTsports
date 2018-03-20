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

public class Updateattend extends MyJPanel{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField sportmanno;
	private JTextField matchno;
	private JTextField textField_2;
	private JTextField matchscore;
	public Updateattend() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel search = new MyJPanel();
		add(search, BorderLayout.NORTH);
		search.setLayout(new BorderLayout(0, 0));
		search.setBorder(new TitledBorder("查询"));
		
		JLabel instruction = new JLabel("请输入您要更改的运动员编号和比赛编号：");
		search.add(instruction, BorderLayout.NORTH);
		
		JPanel panel = new MyJPanel();
		search.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("运动员编号：");
		panel.add(lblNewLabel, BorderLayout.WEST);
		
		JPanel panel_1 = new MyJPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		textField = new JTextField();
		panel_1.add(textField, BorderLayout.WEST);
		textField.setColumns(8);
		
		JPanel panel_2 = new MyJPanel();
		panel_1.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("比赛编号：");
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
		
		JLabel label = new JLabel("比赛成绩：");
		label.setBounds(66, 90, 98, 15);
		main.add(label);
		
		JLabel label_1 = new JLabel("运动员编号：");
		label_1.setBounds(66, 30, 83, 15);
		main.add(label_1);
		
		JLabel label_2 = new JLabel("比赛编号： ");
		label_2.setBounds(66, 60, 85, 15);
		main.add(label_2);
		
		sportmanno = new JTextField();
		sportmanno.setEditable(false);
		sportmanno.setBounds(143, 27, 166, 21);
		main.add(sportmanno);
		sportmanno.setColumns(30);
		
		matchno = new JTextField();
		matchno.setEditable(false);
		matchno.setBounds(143, 60, 166, 21);
		main.add(matchno);
		matchno.setColumns(30);
		
		textField_2 = new JTextField();
		textField_2.setBounds(143, 90, 166, 21);
		main.add(textField_2);
		textField_2.setColumns(30);
		
		final JButton button = new JButton("提交");
		button.setBounds(85, 155, 93, 23);
		main.add(button);
		
		JLabel lblB = new JLabel("\u6BD4\u8D5B\u5F97\u5206\uFF1A");
		lblB.setBounds(66, 120, 83, 15);
		main.add(lblB);
		
		matchscore = new JTextField();
		matchscore.setBounds(143, 120, 166, 21);
		main.add(matchscore);
		matchscore.setColumns(10);
		button_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Connection conn = connection();
					if(conn!=null){
						try{
							final Statement stmt=conn.createStatement();
							ResultSet rs = stmt.executeQuery("select 运动员编号,比赛编号,成绩,得分  from 参加  where 比赛编号 = '" + textField_1.getText() + "' and 运动员编号 = '" + textField.getText() + "'");
							if(rs.next()){
								matchno.setText(rs.getString(1));
								sportmanno.setText(rs.getString(2));
								textField_2.setText(rs.getString(3));
								matchscore.setText(rs.getString(4));
							}
							else
								JOptionPane.showMessageDialog(null,"请检查运动员编号与比赛编号是否相对应","删除",JOptionPane.WARNING_MESSAGE);
							button.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent e){					
									try {
										stmt.executeUpdate("Update 参加 set 成绩 = '" + textField_2.getText() + "',得分 = '" + matchscore.getText() + "'where 比赛编号 = '" + textField_1.getText() + "' and 运动员编号 = '" + textField.getText() + "'");
										JOptionPane.showMessageDialog(null,"更新成功","更新",JOptionPane.INFORMATION_MESSAGE);					
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
		JFrame jf=new JFrame();
		jf.getContentPane().add(new Updateattend());
		jf.setVisible(true);
		jf.setSize(400,300);

	}
}
