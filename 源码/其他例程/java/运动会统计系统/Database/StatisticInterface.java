import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

import javax.swing.*;

public class StatisticInterface extends JPanel{
	JTable score;
	JLabel jlb;
	JRadioButton jrb1;
	JRadioButton jrb2;
	JRadioButton jrb3;
	JButton statistic = new JButton("ͳ��");
	JPanel jpnl1 = new JPanel();
	JScrollPane scrollPane = new JScrollPane();
	Vector<String> columnName = new Vector<String>();
	Vector rows = new Vector();	
	
	public static void main(String[] args){
		JFrame jf=new JFrame();
		jf.getContentPane().add(new StatisticInterface());
		jf.setSize(400,300);
		jf.setVisible(true);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public StatisticInterface() {
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
		add(scrollPane,BorderLayout.CENTER);
		
		if(jrb1.isSelected()){			
			statistic.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						try{	
						Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						String url = "jdbc:odbc:driver={SQL Server};server=(local);database=DatabaseDesign";
						Connection con = DriverManager.getConnection(url);
						Statement stmt=con.createStatement();
						ResultSet rs;
						String sql = "select ѧԺ,sum(�÷�)as �÷� from �˶�Ա,�μ� where �˶�Ա.�˶�Ա��� = �μ�.�˶�Ա��� group by ѧԺ  order by �÷� DESC";
						rs = stmt.executeQuery(sql);
						ResultSetMetaData rsMetaData = rs.getMetaData();
						int colNum = rsMetaData.getColumnCount();
						columnName.clear();
						for(int column = 0;column < colNum;column++){
							columnName.addElement(rsMetaData.getColumnLabel(column + 1));
						}
						rows.clear();							
						while(rs.next()){
							Vector<Object> newRow = new Vector<Object>();								
							for(int i = 1;i <= colNum;i++){
								newRow.addElement(rs.getObject(i));
								}
							rows.addElement(newRow);
							
							}
						remove(scrollPane);
						add(scrollPane = new JScrollPane(new JTable(rows,columnName)),BorderLayout.CENTER);
						setVisible(true);
						}catch (ClassNotFoundException e1) {
							e1.printStackTrace();
						} catch (SQLException e2) {
							e2.printStackTrace();
						}
				}
			});
		}
		else if(jrb2.isSelected()){
			statistic.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						try{	
						Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						String url = "jdbc:odbc:driver={SQL Server};server=(local);database=DatabaseDesign";
						Connection con = DriverManager.getConnection(url);
						Statement stmt=con.createStatement();
						ResultSet rs;
						String sql = "select רҵ,sum(�÷�) as �÷� from �˶�Ա,�μ� where �˶�Ա.�˶�Ա��� = �μ�.�˶�Ա��� group by רҵ";
						rs = stmt.executeQuery(sql);
						ResultSetMetaData rsMetaData = rs.getMetaData();
						int colNum = rsMetaData.getColumnCount();
						columnName.clear();
						for(int column = 0;column < colNum;column++){
							columnName.addElement(rsMetaData.getColumnLabel(column + 1));
						}
						rows.clear();							
						while(rs.next()){
							Vector<Object> newRow = new Vector<Object>();								
							for(int i = 1;i <= colNum;i++){
								newRow.addElement(rs.getObject(i));
								}
							rows.addElement(newRow);							
							}
						remove(scrollPane);
						add(scrollPane = new JScrollPane(new JTable(rows,columnName)),BorderLayout.CENTER);
						setVisible(true);
						}catch (ClassNotFoundException e1) {
							e1.printStackTrace();
						} catch (SQLException e2) {
							e2.printStackTrace();
						}
				}
			});
		
		}
		else{
			statistic.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						try{	
						Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						String url = "jdbc:odbc:driver={SQL Server};server=(local);database=DatabaseDesign";
						Connection con = DriverManager.getConnection(url);
						Statement stmt=con.createStatement();
						ResultSet rs;
						String sql = "select �༶,sum(�÷�) as �÷� from �˶�Ա,�μ� where �˶�Ա.�˶�Ա��� = �μ�.�˶�Ա��� group by �༶";
						rs = stmt.executeQuery(sql);
						ResultSetMetaData rsMetaData = rs.getMetaData();
						int colNum = rsMetaData.getColumnCount();
						columnName.clear();
						for(int column = 0;column < colNum;column++){
							columnName.addElement(rsMetaData.getColumnLabel(column + 1));
						}
						rows.clear();							
						while(rs.next()){
							Vector<Object> newRow = new Vector<Object>();								
							for(int i = 1;i <= colNum;i++){
								newRow.addElement(rs.getObject(i));
								}
							rows.addElement(newRow);							
							}
						remove(scrollPane);
						JTable t1 = new JTable(rows,columnName);					
						add(scrollPane = new JScrollPane(t1),BorderLayout.CENTER);
						setVisible(true);
						setSize(350,100);
						}catch (ClassNotFoundException e1) {
							e1.printStackTrace();
						} catch (SQLException e2) {
							e2.printStackTrace();
						}
				}
			});		
		}	
		
	}
	
	
	
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