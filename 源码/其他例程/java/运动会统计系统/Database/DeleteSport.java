import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
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
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class DeleteSport  extends MyJPanel{
	private JTextField Aprofession;
	private JTextField Aclassname;
	private JTextField no;
	private JTextField Ano;
	private JTextField Aname;
	private JTextField Asex;
	private JTextField Acollege;
	public DeleteSport() {
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
		
		final JButton delete = new JButton("\u5220\u9664");
		panel_1.add(delete);
		
		JPanel panel_2 = new MyJPanel();
		detailPanel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(6, 1, 3, 3));
		
		JPanel panel_5 = new MyJPanel();
		panel_2.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JLabel label = new JLabel("    编号:    ");
		panel_5.add(label, BorderLayout.WEST);
		
		Ano = new JTextField();
		Ano.setEditable(false);
		panel_5.add(Ano, BorderLayout.CENTER);
		
		JPanel panel_6 = new MyJPanel();
		panel_2.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("    姓名:    ");
		panel_6.add(lblNewLabel, BorderLayout.WEST);
		
		Aname = new JTextField();
		Aname.setEditable(false);
		Aname.setColumns(10);
		panel_6.add(Aname);
		
		JPanel panel_4 = new MyJPanel();
		panel_2.add(panel_4);
		
		ButtonGroup g=new ButtonGroup();
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel label_1 = new JLabel("    性别:    ");
		panel_4.add(label_1, BorderLayout.WEST);
		
		JPanel panel_7 = new MyJPanel();
		panel_4.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		Asex = new JTextField();
		Asex.setEditable(false);
		panel_7.add(Asex, BorderLayout.CENTER);
		Asex.setColumns(10);
		
		JPanel panel_8 = new MyJPanel();
		panel_2.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JLabel label_2 = new JLabel("    院系:    ");
		panel_8.add(label_2, BorderLayout.WEST);
		
		Acollege = new JTextField();
		Acollege.setEditable(false);
		panel_8.add(Acollege, BorderLayout.CENTER);
		Acollege.setColumns(10);
		
		JPanel panel_9 = new MyJPanel();
		panel_2.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JLabel label_3 = new JLabel("    专业:    ");
		panel_9.add(label_3, BorderLayout.WEST);
		
		Aprofession = new JTextField();
		Aprofession.setEditable(false);
		panel_9.add(Aprofession);
		Aprofession.setColumns(20);
		
		JPanel panel_10 = new MyJPanel();
		panel_2.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JLabel label_4 = new JLabel("    班级:    ");
		panel_10.add(label_4, BorderLayout.WEST);
		
		Aclassname = new JTextField();
		Aclassname.setEditable(false);
		panel_10.add(Aclassname);
		Aclassname.setColumns(20);
		
		JPanel search = new MyJPanel();
		panel.add(search, BorderLayout.NORTH);
		search.setLayout(new BorderLayout(0, 0));
		search.setBorder(new TitledBorder("查询"));
		
		JLabel instruction = new JLabel("\u8BF7\u8F93\u5165\u60A8\u8981\u67E5\u627E\u7684\u8FD0\u52A8\u5458\u7F16\u53F7\uFF1A");
		search.add(instruction, BorderLayout.WEST);
		
		JPanel panel_3 = new MyJPanel();
		search.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		no = new JTextField();
		panel_3.add(no, BorderLayout.CENTER);
		no.setColumns(20);
		
		JButton select = new JButton("\u67E5\u8BE2");
		panel_3.add(select, BorderLayout.EAST);
		
		select.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Connection conn = connection();
					if(conn!=null){
						try{
							final Statement stmt=conn.createStatement();
							ResultSet rs = stmt.executeQuery("select * from 运动员 where 运动员编号 = '" + no.getText() + "'");
							if(rs.next()){
								Ano.setText(rs.getString(1));
								Aname.setText(rs.getString(2));
								Asex.setText(rs.getString(3));
								Acollege.setText(rs.getString(4));
								Aprofession.setText(rs.getString(5));
								Aclassname.setText(rs.getString(6));
							}
							else
								JOptionPane.showMessageDialog(null,"该运动员不存在","删除",JOptionPane.WARNING_MESSAGE);
							delete.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent e){					
									try {
										stmt.executeUpdate("delete from 运动员 where 运动员编号 = '" + no.getText() + "'");
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
	
	public static void main(String[] args){
		JFrame jf=new JFrame();
		jf.getContentPane().add(new DeleteSport());
		jf.setVisible(true);
		jf.setSize(400,300);
	}
}
