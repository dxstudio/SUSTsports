import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class UpdateComplete extends MyJPanel{
	private JTextField tsearch;
	private JTextField matchno;
	private JTextField matchname;
	private JTextField matchad;
	private JTextField matchTime;
	String sex = "男";
	public UpdateComplete() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel search = new MyJPanel();
		search.setBorder(new TitledBorder("查询"));
		add(search, BorderLayout.NORTH);
		search.setLayout(new BorderLayout(0, 0));
		
		JLabel label = new JLabel("请输入您要查询的比赛编号：");
		search.add(label, BorderLayout.WEST);
		
		JPanel panel = new MyJPanel();
		search.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		tsearch = new JTextField();
		panel.add(tsearch);
		tsearch.setColumns(20);
		
		JButton select = new JButton("查询");
		panel.add(select, BorderLayout.EAST);
		
		JPanel buttonPanel = new MyJPanel();
		add(buttonPanel, BorderLayout.SOUTH);
		
		final JButton submit = new JButton("提交");
		buttonPanel.add(submit);
		
		JPanel mainPanel = new MyJPanel();
		add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new GridLayout(5, 1, 1, 1));
		mainPanel.setBorder(new TitledBorder("查询结果"));
		
		JPanel panel_1 = new MyJPanel();
		mainPanel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel label_1 = new JLabel("    比赛编号：    ");
		panel_1.add(label_1, BorderLayout.WEST);
		
		matchno = new JTextField();
		matchno.setEditable(false);
		panel_1.add(matchno, BorderLayout.CENTER);
		matchno.setColumns(10);
		
		JPanel panel_2 = new MyJPanel();
		mainPanel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel label_2 = new JLabel("    比赛名称：    ");
		panel_2.add(label_2, BorderLayout.WEST);
		
		matchname = new JTextField();
		panel_2.add(matchname, BorderLayout.CENTER);
		matchname.setColumns(10);
		
		JPanel panel_3 = new MyJPanel();
		mainPanel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel label_3 = new JLabel("    比赛地点：    ");
		panel_3.add(label_3, BorderLayout.WEST);
		
		matchad = new JTextField();
		panel_3.add(matchad, BorderLayout.CENTER);
		matchad.setColumns(10);
		
		JPanel panel_4 = new MyJPanel();
		mainPanel.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel label_4 = new JLabel("    比赛时间：    ");
		panel_4.add(label_4, BorderLayout.WEST);
		
		matchTime = new JTextField();
		panel_4.add(matchTime, BorderLayout.CENTER);
		matchTime.setColumns(10);
		
		JPanel panel_5 = new MyJPanel();
		mainPanel.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JLabel label_5 = new JLabel("    性别要求：    ");
		panel_5.add(label_5, BorderLayout.WEST);
		
		JPanel panel_7 = new MyJPanel();
		panel_5.add(panel_7, BorderLayout.CENTER);
		
		JRadioButton radioButton = new JRadioButton("男");
		panel_7.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("女");
		panel_7.add(radioButton_1);
		
		
		final ButtonGroup g =new ButtonGroup();
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
		
		select.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Connection conn = connection();
					if(conn!=null){
						try{
							final Statement stmt=conn.createStatement();
							ResultSet rs = stmt.executeQuery("select * from 比赛  where 比赛编号 = ' " + tsearch.getText() + " ' ");
							if(rs.next()){
								matchno.setText(rs.getString(1));
								matchname.setText(rs.getString(2));
								matchad.setText(rs.getString(3));
								matchTime.setText(rs.getString(4));
							}
							else
								JOptionPane.showMessageDialog(null,"该比赛不存在","删除",JOptionPane.WARNING_MESSAGE);
							submit.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent e){					
									try {
										stmt.executeUpdate("Update 比赛 set 比赛名称 = '" + matchname.getText() + " ',比赛地点 = ' " + matchad.getText() + 
											"',比赛时间 = ' " + matchTime.getText() + "',性别要求 = ' " + sex + "' where 比赛编号 = '" + tsearch.getText() + "'");
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
		jf.getContentPane().add(new UpdateComplete());
		jf.setVisible(true);
		jf.setSize(400,300);

	}

}
