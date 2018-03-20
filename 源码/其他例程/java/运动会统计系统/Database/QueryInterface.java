import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

import javax.swing.*;

public class QueryInterface extends JPanel {
	JComboBox collegeBox;
	JComboBox departmentBox;
	JComboBox classBox;
	JTable score;
	JLabel jlb1;
	JTextField jtf1;
	JScrollPane scrollPanel;
	Vector<String> columnNames = new Vector<String>();
	Vector rows = new Vector();
	
	public static void main(String[] args){
		JFrame jf=new JFrame();
		jf.getContentPane().add(new QueryInterface());
		jf.setSize(400,300);
		jf.setVisible(true);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public QueryInterface() {
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
		JPanel jpnl2 = new JPanel();
		jlb1 = new JLabel("�˶�Ա���");
		jtf1 = new JTextField(6);
		jpnl1.add(jlb1);
		jpnl1.add(jtf1);
		jpnl1.add(button);
		jpnl2.add(collegeBox);
		jpnl2.add(departmentBox);
		jpnl2.add(classBox);
		jpnl2.setSize(400,30);
		add(jpnl1,BorderLayout.NORTH);
		add(jpnl2,BorderLayout.CENTER);
		add(scrollPanel = new JScrollPane(),BorderLayout.SOUTH);
		
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
						 rs=stmt.executeQuery("select �˶�Ա.����,�˶�Ա.�Ա�,�༶,��������,������Ա.���� as ������,�ɼ�  from �˶�Ա,����,������Ա,�μ�,����"
						 		+ "  where �˶�Ա.�˶�Ա��� = �μ�.�˶�Ա��� and �μ�.������� = ����.������� and ����.������� = ����.������� and ����.�����˱�� = ������Ա.�����˱�� and ѧԺ='"+ collegeBox.getSelectedItem() + 
								"' and רҵ='" + departmentBox.getSelectedItem() + "' and �༶='" + classBox.getSelectedItem() + "'" );
						ResultSetMetaData rsMetaData = rs.getMetaData();
						int colNum = rsMetaData.getColumnCount();
						columnNames.clear();
						for(int column = 0;column < colNum;column++){
							columnNames.addElement(rsMetaData.getColumnLabel(column + 1));
							}
						rows.clear();
						while(rs.next()){
							Vector<Object> newRow = new Vector<Object>();
							for(int i = 1;i <= colNum;i++){
								newRow.addElement(rs.getObject(i));
							}
							rows.addElement(newRow);
						}
						remove(scrollPanel);
						scrollPanel = new JScrollPane(new JTable(rows,columnNames));
						add(scrollPanel,BorderLayout.CENTER);
						setVisible(true);
						 
					}
					else if(collegeBox.getSelectedItem() != null && departmentBox.getSelectedItem() != null && jtf1.getText().trim().length() != 0){
						 rs=stmt.executeQuery("select �˶�Ա.����,�˶�Ա.�Ա�,�༶,��������,������Ա.���� as ������,�ɼ�  from �˶�Ա,����,������Ա,�μ�,����  where " +
								"�˶�Ա.�˶�Ա��� = �μ�.�˶�Ա��� and �μ�.������� = ����.������� and ����.������� = ����.������� and ����.�����˱�� = ������Ա.�����˱�� and ѧԺ='"+ collegeBox.getSelectedItem() + "' and רҵ='" + departmentBox.getSelectedItem() + "'" );
							ResultSetMetaData rsMetaData = rs.getMetaData();
							int colNum = rsMetaData.getColumnCount();
							columnNames.clear();
							for(int column = 0;column < colNum;column++){
								columnNames.addElement(rsMetaData.getColumnLabel(column + 1));
								}
							rows.clear();
							while(rs.next()){
								Vector<Object> newRow = new Vector<Object>();
								for(int i = 1;i <= colNum;i++){
									newRow.addElement(rs.getObject(i));
								}
								rows.addElement(newRow);
							}							
							remove(scrollPanel);
							scrollPanel = new JScrollPane(score = new JTable(rows,columnNames));
							add(scrollPanel,BorderLayout.CENTER);
							setVisible(true);
					}
					else if(collegeBox.getSelectedItem() != null && jtf1.getText().trim().length() != 0){
						 rs=stmt.executeQuery("select �˶�Ա.����,�˶�Ա.�Ա�,�༶,��������,������Ա.���� as ������,�ɼ�  from �˶�Ա,����,������Ա,�μ�,����  where " +
							"�˶�Ա.�˶�Ա��� = �μ�.�˶�Ա��� and �μ�.������� = ����.������� and ����.������� = ����.������� and ����.�����˱�� = ������Ա.�����˱�� and ѧԺ='"+ collegeBox.getSelectedItem() + "'" );
						 ResultSetMetaData rsMetaData = rs.getMetaData();
							int colNum = rsMetaData.getColumnCount();
							columnNames.clear();
							for(int column = 0;column < colNum;column++){
								columnNames.addElement(rsMetaData.getColumnLabel(column + 1));
								}
							rows.clear();
							while(rs.next()){
								Vector<Object> newRow = new Vector<Object>();
								for(int i = 1;i <= colNum;i++){
									newRow.addElement(rs.getObject(i));
								}
								rows.addElement(newRow);
							}
							remove(scrollPanel);
							scrollPanel = new JScrollPane(score = new JTable(rows,columnNames));
							add(scrollPanel,BorderLayout.CENTER);
							setVisible(true);
					}
					else if(jtf1.getText().trim().length() != 0){
						 rs=stmt.executeQuery("select �˶�Ա.����,�˶�Ա.�Ա�,�༶,��������,������Ա.���� as ������,�ɼ�  from �˶�Ա,����,������Ա,�μ�,����  where " +
								"�˶�Ա.�˶�Ա���='" + jtf1.getText() + "' and �˶�Ա.�˶�Ա��� = �μ�.�˶�Ա��� and �μ�.������� = ����.������� and ����.������� = ����.������� and ����.�����˱�� = ������Ա.�����˱��" );
						 ResultSetMetaData rsMetaData = rs.getMetaData();
							int colNum = rsMetaData.getColumnCount();
							columnNames.clear();
							for(int column = 0;column < colNum;column++){
								columnNames.addElement(rsMetaData.getColumnLabel(column + 1));
								}
							rows.clear();
							while(rs.next()){
								Vector<Object> newRow = new Vector<Object>();
								for(int i = 1;i <= colNum;i++){
									newRow.addElement(rs.getObject(i));
								}
								rows.addElement(newRow);
							}
							remove(scrollPanel);
							scrollPanel = new JScrollPane(score = new JTable(rows,columnNames));
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
}
