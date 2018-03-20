
import java.awt.BorderLayout; 
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;
import java.sql.ResultSetMetaData;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class MatchQueryInterface extends JPanel{
	JTable score;
	JLabel jlb1;
	JTextField jtf1;
	JButton jbtn;
	JRadioButton jrb2;
	JRadioButton jrb3;
	JScrollPane scrollPanel;
	Vector<String> columnName = new Vector<String>();
	Vector rows = new Vector();
//	Object[][] s = {{1,2,3,4,5},{2,3,4,5,6}};
	
	public static void main(String[] args){
		JFrame jf=new JFrame();
		jf.getContentPane().add(new MatchQueryInterface());
		jf.setSize(400,300);
		jf.setVisible(true);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public MatchQueryInterface(){
		jlb1 = new JLabel("�������");
		jtf1 = new JTextField(6);
		jbtn = new JButton("��ѯ");
		ButtonGroup sexBtnGroup = new ButtonGroup();
		ButtonGroup matTypeGroup = new ButtonGroup();
		JPanel jpn1 = new JPanel();
		jpn1.add(jlb1);
		jpn1.add(jtf1);
		jpn1.add(jbtn);		
		add(jpn1,BorderLayout.NORTH);
//		add(jpn4,BorderLayout.CENTER);
		add(scrollPanel = new JScrollPane(),BorderLayout.SOUTH);
		
		
		jbtn.addActionListener(new ActionListener(){			
			public void actionPerformed(ActionEvent e) {
				Connection con=connection();
				if(con != null ){
					try{
						Statement stmt=con.createStatement();
						ResultSet rs;
						if(jtf1.getText().trim().length() != 0){
							rs=stmt.executeQuery("select ����.������� ,��������,����ʱ��,�����ص�,������Ա.���� from ����,����,������Ա  where " +
									"����.������� = ����.�������  and ����.�����˱�� = ������Ա.�����˱�� and ����.�������='"+ jtf1.getText() + "'" );
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
							DefaultTableModel tableModel = new DefaultTableModel(rows,columnName);
							remove(scrollPanel);						
							scrollPanel = new JScrollPane(score = new JTable(tableModel));
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

