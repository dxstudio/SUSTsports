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

public class DeleteWorker extends MyJPanel{
	private JTextField searchwork;
	private JTextField Workno;
	private JTextField Workname;
	private JTextField workphone;
	public DeleteWorker() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel search = new MyJPanel();
		add(search, BorderLayout.NORTH);
		search.setLayout(new BorderLayout(0, 0));
		search.setBorder(new TitledBorder("查询"));
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u60A8\u8981\u67E5\u8BE2\u7684\u5DE5\u4F5C\u4EBA\u5458\u7F16\u53F7\uFF1A");
		search.add(label, BorderLayout.WEST);
		
		JButton button = new JButton("\u67E5\u8BE2");
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
		
		JLabel label_1 = new JLabel("\u5DE5\u4F5C\u4EBA\u5458\u7F16\u53F7\uFF1A");
		label_1.setBounds(58, 37, 92, 15);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("\u5DE5\u4F5C\u4EBA\u5458\u59D3\u540D\uFF1A");
		label_2.setBounds(58, 76, 92, 15);
		panel_2.add(label_2);
		
		JLabel label_3 = new JLabel("\u5DE5\u4F5C\u4EBA\u5458\u7535\u8BDD\uFF1A");
		label_3.setBounds(58, 115, 92, 15);
		panel_2.add(label_3);
		
		Workno = new JTextField();
		Workno.setEditable(false);
		Workno.setBounds(147, 34, 148, 21);
		panel_2.add(Workno);
		Workno.setColumns(30);
		
		Workname = new JTextField();
		Workname.setEditable(false);
		Workname.setBounds(147, 73, 148, 21);
		panel_2.add(Workname);
		Workname.setColumns(10);
		
		workphone = new JTextField();
		workphone.setEditable(false);
		workphone.setBounds(147, 112, 148, 21);
		panel_2.add(workphone);
		workphone.setColumns(30);
		
		final JButton delete = new JButton("\u5220\u9664");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		delete.setBounds(147, 154, 93, 23);
		panel_2.add(delete);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Connection conn = connection();
					if(conn!=null){
						try{
							final Statement stmt=conn.createStatement();
							ResultSet rs = stmt.executeQuery("select * from 工作人员  where 负责人编号 = '" + searchwork.getText() + "'");
							if(rs.next()){
								Workno.setText(rs.getString(1));
								Workname.setText(rs.getString(2));
								workphone.setText(rs.getString(3));
							}
							else
								JOptionPane.showMessageDialog(null,"该负责人不存在","删除",JOptionPane.INFORMATION_MESSAGE);
							delete.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent e){					
									try {
										stmt.executeQuery("delete from 工作人员 where 负责人编号 = '" + searchwork.getText() + "'");
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
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame jf=new JFrame();
		jf.getContentPane().add(new DeleteWorker());
		jf.setVisible(true);
		jf.setSize(400,300);

	}

}
