import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.border.TitledBorder;
public class DeleteXiangmu extends MyJPanel{
	private JTextField matchno;
	private JTextField fuzerenno;
	public DeleteXiangmu() {
		setLayout(null);
		
		JPanel panel = new MyJPanel();
		panel.setBorder(new TitledBorder(null, "删除比赛与负责人关系", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(28, 30, 325, 207);
		add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("比赛编号：");
		label.setBounds(67, 60, 69, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("负责人编号：");
		label_1.setBounds(67, 96, 79, 15);
		panel.add(label_1);
		
		fuzerenno = new JTextField();
		fuzerenno.setBounds(139, 93, 118, 21);
		panel.add(fuzerenno);
		fuzerenno.setColumns(10);
		
		matchno = new JTextField();
		matchno.setBounds(139, 57, 118, 21);
		panel.add(matchno);
		matchno.setColumns(10);
		
		JButton delete = new JButton("删除");
		delete.setBounds(114, 133, 93, 23);
		panel.add(delete);
		
		delete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Connection conn = connection();
					if(conn!=null){
						try{
							Statement stmt=conn.createStatement();
							stmt.executeUpdate("delete from 负责  where 比赛编号 = '" + matchno.getText() + "' and 负责人编号 = '" + fuzerenno.getText() + "'");
							JOptionPane.showMessageDialog(null,"删除成功","删除",JOptionPane.INFORMATION_MESSAGE);
						}
						catch(Exception ex){
							JOptionPane.showMessageDialog(null,"请检查比赛编号是否和负责人编号相对应","删除",JOptionPane.WARNING_MESSAGE);
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
	
	
	public static void main(String[] args){
		JFrame jf =new JFrame();
		jf.getContentPane().add(new DeleteXiangmu());
		jf.setSize(400,300);
		jf.setVisible(true);
	}
}
