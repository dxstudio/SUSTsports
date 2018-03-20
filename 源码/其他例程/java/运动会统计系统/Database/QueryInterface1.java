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
		collegeBox = new JComboBox(new String[]{"","�����ѧԺ","���繤��ѧԺ","��Ϣ��ѧ�뼼��ѧԺ"});
		departmentBox = new JComboBox();
		classBox = new JComboBox();
		final String[] foreignDepart = {"","����Ӣ��","����Ӣ��","����"};
		final String[] electricDepart = {"","���繤��","��е�������","�����붯������"};
		final String[] informationDepart = {"","��Ϣ��������Ϣϵͳ","���繤��","������Ϣ����","ͨ�Ź���"};
		final String[] foreignClass = {"","��Ӣ121","��Ӣ122","����121","����121"};
		final String[] electricClass = {"","����121","��е121","��е122","����121"};
		final String[] informationClass = {"","�Ź�121","�Ź�122","�Ź�123","����121","����121","����122","ͨ��121"};
		final Object[] columnName = {"����","�Ա�","רҵ","�༶","��������","����","�ɼ�"};
		
		JButton button= new JButton("��ѯ");
		JPanel jpnl1 = new JPanel();
		jpnl1.setBounds(20, 5, 273, 33);
		JPanel jpnl2 = new JPanel();
		jpnl2.setLocation(20, 41);
		jlb1 = new JLabel("�˶�Ա���");
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
						 rs=stmt.executeQuery("select �˶�Ա.����,�˶�Ա.�Ա�,רҵ,�༶,��������,������Ա.����,�ɼ�  from �˶�Ա,����,������Ա,�μ�,����"
						 		+ "  where �˶�Ա.�˶�Ա��� = �μ�.�˶�Ա��� and �μ�.������� = ����.������� and ����.������� = ����.������� and ����.�����˱�� = ������Ա.�����˱�� and ѧԺ='"+ collegeBox.getSelectedItem() + 
								"' and רҵ='" + departmentBox.getSelectedItem() + "' and �༶='" + classBox.getSelectedItem() + "'" );
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
						 rs=stmt.executeQuery("select �˶�Ա.����,�˶�Ա.�Ա�,רҵ,�༶,��������,������Ա.����,�ɼ�  from �˶�Ա,����,������Ա,�μ�,����  where " +
								"�˶�Ա.�˶�Ա��� = �μ�.�˶�Ա��� and �μ�.������� = ����.������� and ����.������� = ����.������� and ����.�����˱�� = ������Ա.�����˱�� and ѧԺ='"+ collegeBox.getSelectedItem() + "' and רҵ='" + departmentBox.getSelectedItem() + "'" );
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
						 rs=stmt.executeQuery("select �˶�Ա.����,�˶�Ա.�Ա�,רҵ,�༶,��������,������Ա.����,�ɼ�  from �˶�Ա,����,������Ա,�μ�,����  where " +
							"�˶�Ա.�˶�Ա��� = �μ�.�˶�Ա��� and �μ�.������� = ����.������� and ����.������� = ����.������� and ����.�����˱�� = ������Ա.�����˱�� and ѧԺ='"+ collegeBox.getSelectedItem() + "'" );
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
						 rs=stmt.executeQuery("select �˶�Ա.����,�˶�Ա.�Ա�,רҵ,�༶,��������,������Ա.����,�ɼ�  from �˶�Ա,����,������Ա,�μ�,����  where " +
								"�˶�Ա.�˶�Ա���='" + jtf1.getText() + "' and �˶�Ա.�˶�Ա��� = �μ�.�˶�Ա��� and �μ�.������� = ����.������� and ����.������� = ����.������� and ����.�����˱�� = ������Ա.�����˱��" );
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
