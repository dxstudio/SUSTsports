import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Scoreinf extends MyJPanel{
	private JTextField Ano;
	private JTextField Mno;
	private JTextField score;
	private JTextField grade;
	
	public Scoreinf(){
		setLayout(null);
		
		JPanel panel = new MyJPanel();
		panel.setBorder(new TitledBorder(null, "�ɼ���Ϣ¼��", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(30, 20, 325, 223);
		add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("    �˶�Ա���:    ");
		label.setBounds(36, 44, 108, 15);
		panel.add(label);
		
		JLabel lblNewLabel = new JLabel("    �������:    ");
		lblNewLabel.setBounds(36, 78, 120, 15);
		panel.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("    �����ɼ�:      ");
		label_1.setBounds(36, 112, 108, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("    �����÷�:      ");
		label_2.setBounds(36, 146, 108, 15);
		panel.add(label_2);
		
		Ano = new JTextField();
		Ano.setBounds(134, 41, 129, 21);
		panel.add(Ano);
		Ano.setColumns(10);
		
		Mno = new JTextField();
		Mno.setBounds(134, 75, 129, 21);
		panel.add(Mno);
		Mno.setColumns(10);
		
		score = new JTextField();
		score.setBounds(134, 109, 129, 21);
		panel.add(score);
		score.setColumns(10);
		
		grade = new JTextField();
		grade.setBounds(134, 145, 129, 21);
		panel.add(grade);
		grade.setColumns(10);
		
		JButton submit = new JButton("�ύ");
		submit.setBounds(112, 176, 93, 23);
		panel.add(submit);
		
		submit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Connection conn = connection();
					if(conn!=null){
						try{
							Statement stmt=conn.createStatement();							
							if(!Ano.getText().trim().equals("") && !Mno.getText().trim().equals("") && !score.getText().trim().equals("") && !grade.getText().trim().equals("")){
								ResultSet r = stmt.executeQuery("select �˶�Ա���,������� from �˶�Ա where �˶�Ա��� = '" + Ano.getText() + "' and ������� = '" + Mno.getText() + "'");
								if(r.next())
										JOptionPane.showMessageDialog(null,"�ñ���Ѵ���,����������","�˶�Ա��Ϣ¼��",JOptionPane.WARNING_MESSAGE);									
								else{
									JOptionPane.showMessageDialog(null,"��Ϣ¼��ɹ�","�˶�Ա��Ϣ¼��",JOptionPane.WARNING_MESSAGE);
									stmt.executeQuery("insert into �μ� (�˶�Ա���,�������,�ɼ�,�÷�) values ('" + Ano.getText() + "','" + Mno.getText() + "','" +	score.getText() + "','" +	grade.getText() + "') ");
								}
							}
							else
								System.out.println("����û�������Ϣ");
						}
						catch(Exception ex){
							ex.getMessage();
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
//	public static void main(String[] args){
//		JFrame f1 = new JFrame();
//		f1.getContentPane().add(new Scoreinf());
//		f1.setVisible(true);
//		f1.setSize(400,300);
//	}
}
