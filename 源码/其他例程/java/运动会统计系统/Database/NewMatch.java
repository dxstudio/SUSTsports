import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
public class NewMatch extends MyJPanel{
	private JTextField Wno;
	private JTextField Mno;
	public NewMatch() {
		setLayout(null);
		
		JPanel panel = new MyJPanel();
		panel.setBounds(47, 38, 274, 154);
		add(panel);
		panel.setLayout(null);
		panel.setBorder(new TitledBorder("�½�"));
		
		JLabel label = new JLabel("�����˱��");
		label.setBounds(30, 39, 91, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("�������");
		label_1.setBounds(28, 70, 93, 15);
		panel.add(label_1);
		
		Wno = new JTextField();
		Wno.setBounds(103, 36, 143, 21);
		panel.add(Wno);
		Wno.setColumns(10);
		
		Mno = new JTextField();
		Mno.setBounds(103, 67, 143, 21);
		panel.add(Mno);
		Mno.setColumns(10);
		
		JButton submit = new JButton("�ύ");
		submit.setBounds(91, 104, 93, 23);
		panel.add(submit);
		submit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Connection conn = connection();				
					if(conn!=null){
						try{	
							Statement stmt=conn.createStatement();							
							if(!Wno.getText().trim().equals("") && !Mno.getText().trim().equals("")){
								ResultSet rs = stmt.executeQuery("select �����˱��,������� from ���� where �����˱�� = '" + Wno.getText() + "' and ������� = '" + Mno.getText() + "')");
								if(rs.next())
									JOptionPane.showMessageDialog(null,"�ñ���Ѵ���,����������","�˶�Ա��Ϣ¼��",JOptionPane.WARNING_MESSAGE);
								else{
									JOptionPane.showMessageDialog(null,"��Ϣ¼��ɹ�","������Ϣ¼��",JOptionPane.WARNING_MESSAGE);									
									stmt.executeUpdate("insert into ���� (�����˱��,�������) values ('" + Wno.getText() + "','" + Mno.getText() + "') ");
								}
							}
							else
								System.out.println("����û�������Ϣ");
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
		} catch (ClassNotFoundException e1) {
			System.out.println(e1.getMessage());
			return null;
		} catch (SQLException e2) {
			System.out.println(e2.getMessage());
			return null;
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame jf =new JFrame();
		jf.getContentPane().add(new NewMatch());
		jf.setSize(400,300);
		jf.setVisible(true);

	}
}
