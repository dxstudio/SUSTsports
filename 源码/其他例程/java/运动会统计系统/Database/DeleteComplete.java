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

public class DeleteComplete extends MyJPanel{
	private JTextField tsearch;
	private JTextField matchno;
	private JTextField matchname;
	private JTextField matchad;
	private JTextField matchTime;
	private JTextField tsex;
	public DeleteComplete() {
		setLayout(new BorderLayout(0, 0));
		setOpaque(false);
		
		JPanel search = new MyJPanel();
		search.setBorder(new TitledBorder("查询"));
		add(search, BorderLayout.NORTH);
		search.setLayout(new BorderLayout(0, 0));
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u60A8\u8981\u67E5\u8BE2\u7684\u6BD4\u8D5B\u7F16\u53F7\uFF1A");
		search.add(label, BorderLayout.WEST);
		
		JPanel panel = new MyJPanel();
		search.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		tsearch = new JTextField();
		panel.add(tsearch);
		tsearch.setColumns(20);
		
		JButton select = new JButton("\u67E5\u8BE2");
//		select.setDisabledIcon(new ImageIcon("image\\1.png"));
		panel.add(select, BorderLayout.EAST);
		
		JPanel buttonPanel = new MyJPanel();
		add(buttonPanel, BorderLayout.SOUTH);
		
		final JButton delete = new JButton("\u5220\u9664");
		buttonPanel.add(delete);
		
		JPanel mainPanel = new MyJPanel();
		add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new GridLayout(5, 1, 2, 2));
		mainPanel.setBorder(new TitledBorder("查询结果"));
		
		JPanel panel_1 = new MyJPanel();
		mainPanel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel label_1 = new JLabel("    \u6BD4\u8D5B\u7F16\u53F7\uFF1A    ");
		panel_1.add(label_1, BorderLayout.WEST);
		
		matchno = new JTextField();
		matchno.setEditable(false);
		panel_1.add(matchno, BorderLayout.CENTER);
		matchno.setColumns(10);
		
		JPanel panel_2 = new MyJPanel();
		mainPanel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel label_2 = new JLabel("    \u6BD4\u8D5B\u540D\u79F0\uFF1A    ");
		panel_2.add(label_2, BorderLayout.WEST);
		
		matchname = new JTextField();
		matchname.setEditable(false);
		panel_2.add(matchname, BorderLayout.CENTER);
		matchname.setColumns(10);
		
		JPanel panel_3 = new MyJPanel();
		mainPanel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel label_3 = new JLabel("    \u6BD4\u8D5B\u5730\u70B9\uFF1A    ");
		panel_3.add(label_3, BorderLayout.WEST);
		
		matchad = new JTextField();
		matchad.setEditable(false);
		panel_3.add(matchad, BorderLayout.CENTER);
		matchad.setColumns(10);
		
		JPanel panel_4 = new MyJPanel();
		mainPanel.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel label_4 = new JLabel("    \u6BD4\u8D5B\u65F6\u95F4\uFF1A    ");
		panel_4.add(label_4, BorderLayout.WEST);
		
		matchTime = new JTextField();
		matchTime.setEditable(false);
		panel_4.add(matchTime, BorderLayout.CENTER);
		matchTime.setColumns(10);
		
		JPanel panel_5 = new MyJPanel();
		mainPanel.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JLabel label_5 = new JLabel("    \u6027\u522B\u8981\u6C42\uFF1A    ");
		panel_5.add(label_5, BorderLayout.WEST);
		
		tsex = new JTextField();
		tsex.setEditable(false);
		panel_5.add(tsex, BorderLayout.CENTER);
		tsex.setColumns(10);
		
		ButtonGroup g =new ButtonGroup();			

		select.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Connection conn = connection();
					if(conn!=null){
						try{
							final Statement stmt=conn.createStatement();
							ResultSet rs = stmt.executeQuery("select * from 比赛 where 比赛编号 = '" + tsearch.getText() + "'");
							if(rs.next()){
								matchno.setText(rs.getString(1));
								matchname.setText(rs.getString(2));
								matchad.setText(rs.getString(3));
								matchTime.setText(rs.getString(4));
								tsex.setText(rs.getString(5));
							}
							else
								JOptionPane.showMessageDialog(null,"该比赛编号不存在","删除",JOptionPane.WARNING_MESSAGE);
							delete.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent e){					
									try {
										stmt.executeQuery("delete from 比赛 where 比赛编号 = '" + tsearch.getText() + "'");
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
		JFrame jf=new JFrame();
		jf.getContentPane().add(new DeleteComplete());
		jf.setVisible(true);
		jf.setSize(400,300);
	}
}
