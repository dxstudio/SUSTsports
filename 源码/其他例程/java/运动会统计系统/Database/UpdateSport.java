import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateSport extends MyJPanel{
	private JTextField department;
	private JTextField class1;
	private JTextField no;
	private JTextField textField;
	private JTextField textField_1;
	String sex = "男";
	private JTextField sex1;
	public UpdateSport() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel north = new MyJPanel();
		north.setBorder(new LineBorder(Color.GRAY, 1, true));
		add(north, BorderLayout.NORTH);
		north.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new MyJPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		
		JPanel detailPanel = new MyJPanel();
		detailPanel.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		panel.add(detailPanel, BorderLayout.CENTER);
		detailPanel.setLayout(new BorderLayout(0, 0));
		detailPanel.setBorder(new TitledBorder("查询结果"));
		
		JPanel panel_1 = new MyJPanel();
		detailPanel.add(panel_1, BorderLayout.SOUTH);
		
		final JButton submit = new JButton("提交");
		panel_1.add(submit);
		
		JPanel panel_2 = new MyJPanel();
		detailPanel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(6, 1, 3, 3));
		
		JPanel panel_5 = new MyJPanel();
		panel_2.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JLabel label = new JLabel("    编号：    ");
		panel_5.add(label, BorderLayout.WEST);
		
		textField = new JTextField();
		textField.setEditable(false);
		panel_5.add(textField, BorderLayout.CENTER);
		
		JPanel panel_6 = new MyJPanel();
		panel_2.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("    姓名：    ");
		panel_6.add(lblNewLabel, BorderLayout.WEST);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panel_6.add(textField_1);
		
		JPanel panel_4 = new MyJPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel label_1 = new JLabel("    性别：    ");
		panel_4.add(label_1, BorderLayout.WEST);
	
		sex1 = new JTextField();
		sex1.setColumns(10);
		panel_4.add(sex1);
		
		JPanel panel_8 = new MyJPanel();
		panel_2.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JLabel label_2 = new JLabel("    学院：    ");
		panel_8.add(label_2, BorderLayout.WEST);
		
		final JTextField college = new JTextField();
		panel_8.add(college, BorderLayout.CENTER);
		
		JPanel panel_9 = new MyJPanel();
		panel_2.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JLabel label_3 = new JLabel("    系别：    ");
		panel_9.add(label_3, BorderLayout.WEST);
		
		department = new JTextField();
		panel_9.add(department);
		
		JPanel panel_10 = new MyJPanel();
		panel_2.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JLabel label_4 = new JLabel("    班级：    ");
		panel_10.add(label_4, BorderLayout.WEST);
		
		class1 = new JTextField();
		panel_10.add(class1);
		
		JPanel search = new MyJPanel();
		panel.add(search, BorderLayout.NORTH);
		search.setLayout(new BorderLayout(0, 0));
		search.setBorder(new TitledBorder("查询"));
		
		JLabel instruction = new JLabel("请输入您要查找的运动员的编号：");
		search.add(instruction, BorderLayout.WEST);
		
		JPanel panel_3 = new MyJPanel();
		search.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		no = new JTextField();
		panel_3.add(no, BorderLayout.CENTER);
		no.setColumns(20);
		
		JButton select = new JButton("查询");
		panel_3.add(select, BorderLayout.EAST);
		
		select.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Connection conn = connection();
					if(conn!=null){
						try{
							final Statement stmt=conn.createStatement();
							ResultSet rs = stmt.executeQuery("select * from 运动员 where 运动员编号 = '" + no.getText() + "'");
							if(rs.next()){
								textField.setText(rs.getString(1));
								textField_1.setText(rs.getString(2));
								sex1.setText(rs.getString(3));
								college.setText(rs.getString(4));
								department.setText(rs.getString(5));
								class1.setText(rs.getString(6));
							}
							else
								JOptionPane.showMessageDialog(null,"该运动员编号不存在","删除",JOptionPane.WARNING_MESSAGE);
							submit.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent e){					
									try {
										stmt.executeUpdate("Update 运动员 set 姓名 = '" + textField_1.getText() + "',性别 = '" + sex1.getText() + "',学院 = '" + 
												college.getText() + "',专业 = ' " + department.getText() + "',班级 = ' " + class1.getText() + "'"
												+ "where 运动员编号 = '" + no.getText() +  "'");
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
	
	public static void main(String[] args){
		JFrame jf=new JFrame();
		jf.getContentPane().add(new UpdateSport());
		jf.setVisible(true);
		jf.setSize(400,300);
	}
}
