import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class QueryInterface1 extends JPanel {
	JComboBox collegeBox;
	JComboBox departmentBox;
	JComboBox classBox;
	JTable score;
	JLabel jlb1;
	JTextField jtf1;
	JScrollPane scrollPanel;
	
	
	public static void main(String[] args){
		JFrame jf=new JFrame();
		jf.getContentPane().add(new QueryInterface1());
		jf.setSize(400,300);
		jf.setVisible(true);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public QueryInterface1() {
		collegeBox = new JComboBox(new String[]{"","外国语学院","机电工程学院","信息科学与技术学院"});
		departmentBox = new JComboBox();
		classBox = new JComboBox();
		final String[] foreignDepart = {"","商务英语","旅游英语","日语"};
		final String[] electricDepart = {"","机电工程","机械设计制造","热能与动力工程"};
		final String[] informationDepart = {"","信息管理与信息系统","网络工程","电子信息工程","通信工程"};
		final String[] foreignClass = {"","商英121","商英122","旅游121","日语121"};
		final String[] electricClass = {"","机电121","机械121","机械122","热能121"};
		final String[] informationClass = {"","信管121","信管122","信管123","网络121","电子121","电子122","通信121"};
		final Object[] columnName = {"姓名","性别","专业","班级","比赛名称","裁判","成绩"};
		
		JButton button= new JButton("查询");
		JPanel jpnl1 = new JPanel();
		jpnl1.setBounds(20, 5, 273, 33);
		JPanel jpnl2 = new JPanel();
		jpnl2.setLocation(20, 41);
		jlb1 = new JLabel("运动员编号");
		jtf1 = new JTextField(6);
		jpnl1.add(jlb1);
		jpnl1.add(jtf1);
		jpnl1.add(button);
		jpnl2.add(collegeBox);
		jpnl2.add(departmentBox);
		jpnl2.add(classBox);
		jpnl2.setSize(316,31);
		setLayout(null);
		add(jpnl1);
		add(jpnl2);
		add(scrollPanel = new JScrollPane(),BorderLayout.SOUTH);
		scrollPanel.setBounds(10, 82, 283, 177);
		scrollPanel.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPanel.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		collegeBox.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				switch (collegeBox.getSelectedIndex()) {
				case 1:
					departmentBox.removeAllItems();
					classBox.removeAllItems();
					for(int i = 0;i < foreignDepart.length;i++)
						departmentBox.addItem(foreignDepart[i]);
					break;
				case 2:
					departmentBox.removeAllItems();
					classBox.removeAllItems();
					for(int i = 0;i < electricDepart.length;i++)
						departmentBox.addItem(electricDepart[i]);
					break;
				case 3:
					departmentBox.removeAllItems();
					classBox.removeAllItems();
					for(int i = 0;i < informationDepart.length;i++)
						departmentBox.addItem(informationDepart[i]);
					break;

				default:
					departmentBox.removeAllItems();
					classBox.removeAllItems();
					break;
				}
				
			}
		});
		
		departmentBox.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				if(collegeBox.getSelectedIndex() == 1){
					switch (departmentBox.getSelectedIndex()) {
					case 1:
						classBox.removeAllItems();
						classBox.addItem("");
						classBox.addItem(foreignClass[1]);
						classBox.addItem(foreignClass[2]);
						break;
					case 2:
						classBox.removeAllItems();
						classBox.addItem("");
						classBox.addItem(foreignClass[3]);
						break;
					case 3:
						classBox.removeAllItems();
						classBox.addItem("");
						classBox.addItem(foreignClass[4]);
						break;
					default:
						classBox.removeAllItems();
						break;
					}
				}
				else if(collegeBox.getSelectedIndex() == 2){
					switch (departmentBox.getSelectedIndex()) {
					case 1:
						classBox.removeAllItems();
						classBox.addItem("");
						classBox.addItem(electricClass[1]);
						break;
					case 2:
						classBox.removeAllItems();
						classBox.addItem("");
						classBox.addItem(electricClass[2]);
						classBox.addItem(electricClass[3]);
						break;
					case 3:
						classBox.removeAllItems();
						classBox.addItem("");
						classBox.addItem(electricClass[4]);
						break;
					default:
						break;
					}
				}
				else if(collegeBox.getSelectedIndex() == 3){
					switch (departmentBox.getSelectedIndex()) {
					case 1:
						classBox.removeAllItems();
						classBox.addItem(informationClass[1]);
						classBox.addItem(informationClass[2]);
						classBox.addItem(informationClass[3]);
						break;
					case 2:
						classBox.removeAllItems();
						classBox.addItem(informationClass[4]);
						break;
					case 3:
						classBox.removeAllItems();
						classBox.addItem(informationClass[5]);
						classBox.addItem(informationClass[6]);
						break;
					case 4:
						classBox.removeAllItems();
						classBox.addItem(informationClass[7]);
						break;
					default:
						classBox.removeAllItems();
						break;
					}
				}
			}
		});
	
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con=connection();
				if(con!=null){
					try{
					Statement stmt=con.createStatement();
					ResultSet rs;
					if(collegeBox.getSelectedItem() != null && departmentBox.getSelectedItem() != null && classBox.getSelectedItem() != null && jtf1.getText().trim().length() == 0){
						 rs=stmt.executeQuery("select 运动员.姓名,运动员.性别,专业,班级,比赛名称,工作人员.姓名,成绩  from 运动员,比赛,工作人员,参加,负责"
						 		+ "  where 运动员.运动员编号 = 参加.运动员编号 and 参加.比赛编号 = 比赛.比赛编号 and 比赛.比赛编号 = 负责.比赛编号 and 负责.负责人编号 = 工作人员.负责人编号 and 学院='"+ collegeBox.getSelectedItem() + 
								"' and 专业='" + departmentBox.getSelectedItem() + "' and 班级='" + classBox.getSelectedItem() + "'" );
						ResultSetMetaData rsMetaData = rs.getMetaData();
						int colNum = rsMetaData.getColumnCount();
						int rowNum = 0;
						while(rs.next()){
							rowNum++;
						}
						Object[][] rowData = new Object[rowNum][colNum];
						while(rs.next()){
							for (int i = 0;i < rowNum;i ++){
								for(int j = 0;j < colNum;j ++){									 
									rowData[i][j] = rs.getString(j + 1);
								}
								
							}
						}
						remove(scrollPanel);
						scrollPanel = new JScrollPane(new JTable(rowData,columnName));
						add(scrollPanel,BorderLayout.CENTER);
						setVisible(true);
						 
					}
					else if(collegeBox.getSelectedItem() != null && departmentBox.getSelectedItem() != null && jtf1.getText().trim().length() != 0){
						 rs=stmt.executeQuery("select 运动员.姓名,运动员.性别,专业,班级,比赛名称,工作人员.姓名,成绩  from 运动员,比赛,工作人员,参加,负责  where " +
								"运动员.运动员编号 = 参加.运动员编号 and 参加.比赛编号 = 比赛.比赛编号 and 比赛.比赛编号 = 负责.比赛编号 and 负责.负责人编号 = 工作人员.负责人编号 and 学院='"+ collegeBox.getSelectedItem() + "' and 专业='" + departmentBox.getSelectedItem() + "'" );
						 ResultSetMetaData rsMetaData = rs.getMetaData();
							int colNum = rsMetaData.getColumnCount();
							int rowNum = 0;
							while(rs.next()){
								rowNum++;
							}
							Object[][] rowData = new Object[rowNum][colNum];
							while(rs.next()){
								for (int i = 0;i < rowNum;i ++){
									for(int j = 0;j < colNum;j ++){										 
										rowData[i][j] = rs.getString(j + 1);
									}									
								}
							 }
							remove(scrollPanel);
							scrollPanel = new JScrollPane(new JTable(rowData,columnName));
							add(scrollPanel,BorderLayout.CENTER);
							setVisible(true);
					}
					else if(collegeBox.getSelectedItem() != null && jtf1.getText().trim().length() != 0){
						 rs=stmt.executeQuery("select 运动员.姓名,运动员.性别,专业,班级,比赛名称,工作人员.姓名,成绩  from 运动员,比赛,工作人员,参加,负责  where " +
							"运动员.运动员编号 = 参加.运动员编号 and 参加.比赛编号 = 比赛.比赛编号 and 比赛.比赛编号 = 负责.比赛编号 and 负责.负责人编号 = 工作人员.负责人编号 and 学院='"+ collegeBox.getSelectedItem() + "'" );
						 ResultSetMetaData rsMetaData = rs.getMetaData();
							int colNum = rsMetaData.getColumnCount();
							int rowNum = 0;
							while(rs.next()){
								rowNum++;
							}
							Object[][] rowData = new Object[rowNum][colNum];
							while(rs.next()){
								for (int i = 0;i < rowNum;i ++){
									for(int j = 0;j < colNum;j ++){
										rowData[i][j] = rs.getString(j + 1);
									}									
								}
							 }
							remove(scrollPanel);
							scrollPanel = new JScrollPane(new JTable(rowData,columnName));
							add(scrollPanel,BorderLayout.CENTER);
							setVisible(true);
					}
					else if(jtf1.getText().trim().length() != 0){
						 rs=stmt.executeQuery("select 运动员.姓名,运动员.性别,专业,班级,比赛名称,工作人员.姓名,成绩  from 运动员,比赛,工作人员,参加,负责  where " +
								"运动员.运动员编号='" + jtf1.getText() + "' and 运动员.运动员编号 = 参加.运动员编号 and 参加.比赛编号 = 比赛.比赛编号 and 比赛.比赛编号 = 负责.比赛编号 and 负责.负责人编号 = 工作人员.负责人编号" );
						 ResultSetMetaData rsMetaData = rs.getMetaData();
							int colNum = rsMetaData.getColumnCount();
							int rowNum = 0;
							while(rs.next()){
								rowNum++;
							}
							Object[][] rowData = new Object[rowNum][colNum];
							while(rs.next()){
								for (int i = 0;i < rowNum;i ++){
									for(int j = 0;j < colNum;j ++){
										rowData[i][j] = rs.getString(j + 1);
									}								
								}
							 }
							remove(scrollPanel);
							scrollPanel = new JScrollPane(new JTable(rowData,columnName));
							add(scrollPanel,BorderLayout.CENTER);
							setVisible(true);
					}		
				
				}
					catch(SQLException e1){e1.printStackTrace();}
				}
			}
		});
	}
	
	 Connection connection() {
		 try {
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				System.out.println("Driver loaded");
				
				String url = "jdbc:odbc:driver={SQL Server};server=(local);database=DatabaseDesign";
				Connection connection = DriverManager.getConnection(url);

				System.out.println("Database connected");
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
}
