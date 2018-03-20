import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Scoreinf extends MyJPanel{
	private JTextField Ano;
	private JTextField Mno;
	private JTextField score;
	private JTextField grade;
	
	public Scoreinf(){
		setLayout(null);
		
		JPanel panel = new MyJPanel();
		panel.setBorder(new TitledBorder(null, "成绩信息录入", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(30, 20, 325, 223);
		add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("    运动员编号:    ");
		label.setBounds(36, 44, 108, 15);
		panel.add(label);
		
		JLabel lblNewLabel = new JLabel("    比赛编号:    ");
		lblNewLabel.setBounds(36, 78, 120, 15);
		panel.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("    比赛成绩:      ");
		label_1.setBounds(36, 112, 108, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("    比赛得分:      ");
		label_2.setBounds(36, 146, 108, 15);
		panel.add(label_2);
		
		Ano = new JTextField();
		Ano.setBounds(134, 41, 129, 21);
		panel.add(Ano);
		Ano.setColumns(10);
		
		Mno = new JTextField();
		Mno.setBounds(134, 75, 129, 21);
		panel.add(Mno);
		Mno.setColumns(10);
		
		score = new JTextField();
		score.setBounds(134, 109, 129, 21);
		panel.add(score);
		score.setColumns(10);
		
		grade = new JTextField();
		grade.setBounds(134, 145, 129, 21);
		panel.add(grade);
		grade.setColumns(10);
		
		JButton submit = new JButton("提交");
		submit.setBounds(112, 176, 93, 23);
		panel.add(submit);
		
		submit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Connection conn = connection();
					if(conn!=null){
						try{
							Statement stmt=conn.createStatement();							
							if(!Ano.getText().trim().equals("") && !Mno.getText().trim().equals("") && !score.getText().trim().equals("") && !grade.getText().trim().equals("")){
								ResultSet r = stmt.executeQuery("select 运动员编号,比赛编号 from 运动员 where 运动员编号 = '" + Ano.getText() + "' and 比赛编号 = '" + Mno.getText() + "'");
								if(r.next())
										JOptionPane.showMessageDialog(null,"该编号已存在,请重新输入","运动员信息录入",JOptionPane.WARNING_MESSAGE);									
								else{
									JOptionPane.showMessageDialog(null,"信息录入成功","运动员信息录入",JOptionPane.WARNING_MESSAGE);
									stmt.executeQuery("insert into 参加 (运动员编号,比赛编号,成绩,得分) values ('" + Ano.getText() + "','" + Mno.getText() + "','" +	score.getText() + "','" +	grade.getText() + "') ");
								}
							}
							else
								System.out.println("还有没输入的信息");
						}
						catch(Exception ex){
							ex.getMessage();
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
		} catch (ClassNotFoundException e1) {
			System.out.println(e1.getMessage());
			return null;
		} catch (SQLException e2) {
			System.out.println(e2.getMessage());
			return null;
		}
	}
//	public static void main(String[] args){
//		JFrame f1 = new JFrame();
//		f1.getContentPane().add(new Scoreinf());
//		f1.setVisible(true);
//		f1.setSize(400,300);
//	}
}
