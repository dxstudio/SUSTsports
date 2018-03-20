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

public class UpdateWorker extends MyJPanel{
	private JTextField searchwork;
	private JTextField workno;
	private JTextField Workname;
	private JTextField workphone;
	private JTextField worksex;
	public UpdateWorker() {
		setLayout(new BorderLayout(0, 0));
		setOpaque(false);
		
		JPanel search = new MyJPanel();
		add(search, BorderLayout.NORTH);
		search.setLayout(new BorderLayout(0, 0));
		search.setBorder(new TitledBorder("查询"));
		
		JLabel label = new JLabel("请输入您要查询的工作人员的编号：");
		search.add(label, BorderLayout.WEST);
		
		JButton button = new JButton("查询");
		search.add(button, BorderLayout.EAST);
		
		searchwork = new JTextField();
		search.add(searchwork, BorderLayout.CENTER);
		searchwork.setColumns(10);
		
		JPanel panel_1 = new MyJPanel();
		add(panel_1, BorderLayout.SOUTH);
		
		JPanel panel_2 = new MyJPanel();
		add(panel_2, BorderLayout.CENTER);
		panel_2.setBorder(new TitledBorder("查询结果"));
		panel_2.setLayout(null);
		
		JLabel label_1 = new JLabel("工作人员编号：");
		label_1.setBounds(58, 37, 92, 15);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("工作人员姓名：");
		label_2.setBounds(58, 65, 92, 15);
		panel_2.add(label_2);
		
		JLabel label_4 = new JLabel("工作人员性别：");
		label_4.setBounds(58,93,92,15);
		panel_2.add(label_4);
		
		JLabel label_3 = new JLabel("工作人员电话：");
		label_3.setBounds(58, 121, 92, 15);
		panel_2.add(label_3);
		
		workno = new JTextField();
		workno.setEditable(false);
		workno.setBounds(147, 34, 148, 21);
		panel_2.add(workno);
		workno.setColumns(30);
		
		Workname = new JTextField();
		Workname.setBounds(147, 62, 148, 21);
		panel_2.add(Workname);
		Workname.setColumns(10);
		
		worksex = new JTextField();
		worksex.setBounds(147, 90, 148, 21);
		panel_2.add(worksex);
		worksex.setColumns(10);
		
		workphone = new JTextField();
		workphone.setBounds(147, 118, 148, 21);
		panel_2.add(workphone);
		workphone.setColumns(30);
		
		final JButton submit = new JButton("修改");
		submit.setBounds(126, 156, 93, 23);
		panel_2.add(submit);
		
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Connection conn = connection();
					if(conn!=null){
						try{
							final Statement stmt=conn.createStatement();
							ResultSet rs = stmt.executeQuery("select * from 工作人员  where 负责人编号 = '" + searchwork.getText() + "'");
							if(rs.next()){
								workno.setText(rs.getString(1));
								Workname.setText(rs.getString(2));
								worksex.setText(rs.getString(3));
								workphone.setText(rs.getString(4));
								
							}
							else
								JOptionPane.showMessageDialog(null,"该工作人员不存在","更新",JOptionPane.WARNING_MESSAGE);
							submit.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent e){					
									try {
										stmt.executeUpdate("Update 工作人员 set 姓名 = '" + Workname.getText() + " ',性别= ' " + worksex.getText() + " ',联系方式 = ' " + workphone.getText() +  "'" + "where 负责人编号 = '" + searchwork.getText() + "'");
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
		jf.getContentPane().add(new UpdateWorker());
		jf.setVisible(true);
		jf.setSize(400,300);

	}

}
