
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class Statistic extends JPanel{
	JTable score;
	JRadioButton jrb1;
	JRadioButton jrb2;
	JRadioButton jrb3;
//	JComboBox collegeBox;
//	JComboBox departmentBox;
//	JComboBox classBox;
	JButton statistic = new JButton("ͳ��");
	JPanel jpnl1 = new JPanel();
	JPanel p2 = new JPanel();
	JScrollPane scrollPanel = new JScrollPane();
	String sort = "ѧԺ";
	
	public static void main(String[] args){
		JFrame jf=new JFrame();
		jf.getContentPane().add(new Statistic());
		jf.setSize(400,300);
		jf.setVisible(true);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public Statistic() {
		ButtonGroup rangeGroup = new ButtonGroup();
		jrb1 = new JRadioButton("Ժ");
		jrb2 = new JRadioButton("ϵ");
		jrb3 = new JRadioButton("��");
		jrb1.setSelected(true);
		rangeGroup.add(jrb1);
		rangeGroup.add(jrb2);
		rangeGroup.add(jrb3);
		jpnl1.add(jrb1);
		jpnl1.add(jrb2);
		jpnl1.add(jrb3);
		jpnl1.add(statistic);
		add(jpnl1,BorderLayout.NORTH);
		add(p2,BorderLayout.CENTER);
//		add(scrollPanel,BorderLayout.CENTER);
		
		jrb1.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				sort = "ѧԺ";
			}
		});
			
		jrb2.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				sort = "רҵ";
			}
		});
		
		jrb3.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				sort = "�༶";
			}
		});
		
		statistic.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{	
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					String url = "jdbc:odbc:driver={SQL Server};server=(local);database=DatabaseDesign";
					Connection con = DriverManager.getConnection(url);
					Statement stmt=con.createStatement();
					ResultSet rs;
					String sql = "select " + sort + ",sum(�÷�) from �˶�Ա,�μ� where �˶�Ա.�˶�Ա��� = �μ�.�˶�Ա��� group by " + sort;
					rs = stmt.executeQuery(sql);
					ResultSetMetaData rsMetaData = rs.getMetaData();
					int colNum = rsMetaData.getColumnCount();
					int rowNum = 0;
					while(rs.next()){
						rowNum++;
					}
					
					add(p2);
					p2.setLayout(new GridLayout(rowNum,colNum));
					p2.add(new JLabel(sort));
					p2.add(new JLabel("�÷�"));
					while(rs.next()){
						p2.add(new JLabel(rs.getString(1)));
						p2.add(new JLabel(rs.getString(2)));
						}
					setVisible(true);
					}
				catch (ClassNotFoundException e1){
					e1.printStackTrace();
					} 
				catch (SQLException e2){
					e2.printStackTrace();
					}				
				}
			});
		}		
		
//		jrb1.addActionListener(new ActionListener() {	
//			public void actionPerformed(ActionEvent e) {
//				remove(temPanel);//�л���塪��������������������ͬһָ�븳��ͬJPanel������в���
//				temPanel = new JPanel();
//				add(temPanel,BorderLayout.CENTER);
//				setVisible(true);
//			}
//		});
//			
//		jrb2.addActionListener(new ActionListener() {	
//			public void actionPerformed(ActionEvent e) {
//				remove(temPanel);
//				temPanel = new JPanel();
//				add(temPanel,BorderLayout.CENTER);
//				setVisible(true);
//			}
//		});
//		
//		jrb3.addActionListener(new ActionListener() {			
//			public void actionPerformed(ActionEvent e) {
//				remove(temPanel);
//				temPanel = new JPanel();
//				add(temPanel,BorderLayout.CENTER);
//				setVisible(true);
//			}
//		});
//	}	
	
	
	Connection connection() {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			String url = "jdbc:odbc:driver={SQL Server};server=(local);database=DatabaseDesign";
			Connection connection = DriverManager.getConnection(url);
			return connection;
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			return null;
		} catch (SQLException e2) {
			e2.printStackTrace();
			return null;
		}
	}	
}