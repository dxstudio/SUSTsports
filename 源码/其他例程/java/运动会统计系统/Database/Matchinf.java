import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Matchinf extends MyJPanel{
	JTextField Mno,Mtime;
	JRadioButton Mboy,Mgirl;
	JComboBox Mmonth,Mday;
	JButton insert;
	private JTextField tmatchno,Mname,Mplace,tmatchname;
	String sex = "��";
	
	public Matchinf(){
		Mmonth = new JComboBox(new String[]{"1","2","3","4","5","6","7","8","9","10","11","12"});
		Mday = new JComboBox();
		final String[] day = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		setLayout(null);
		
		JPanel panel = new MyJPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "�������� ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(24, 10, 336, 240);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new MyJPanel();
		panel.add(panel_1, BorderLayout.SOUTH);
		
		insert = new JButton("�ύ");
		panel_1.add(insert);
		
		JPanel panel_2 = new MyJPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(5, 1, 0, 0));
		
		JPanel panel_3 = new MyJPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel matchno = new JLabel("    �������:    ");
		panel_3.add(matchno, BorderLayout.WEST);
		
		Mno = new JTextField();
		panel_3.add(Mno, BorderLayout.CENTER);
		Mno.setColumns(10);
		
		JPanel panel_4 = new MyJPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel matchname = new JLabel("    ��������:    ");
		panel_4.add(matchname, BorderLayout.WEST);
		
		Mname = new JTextField();
		panel_4.add(Mname, BorderLayout.CENTER);
//		Mname.setColumns(10);
		
		JPanel panel_5 = new MyJPanel();
		panel_2.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("    ����ʱ��:    ");
		panel_5.add(lblNewLabel, BorderLayout.WEST);
		
		JPanel panel_8 = new MyJPanel();
		panel_5.add(panel_8, BorderLayout.CENTER);
		
		panel_8.add(Mmonth);
		
		JLabel lblNewLabel_1 = new JLabel("��");
		panel_8.add(lblNewLabel_1);
		
		panel_8.add(Mday);
		
		JLabel label = new JLabel("��");
		panel_8.add(label);
		
		JPanel panel_6 = new MyJPanel();
		panel_2.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("    �����ص�:    ");
		panel_6.add(lblNewLabel_2, BorderLayout.WEST);
		
		Mplace = new JTextField();
		panel_6.add(Mplace, BorderLayout.CENTER);
		
		JPanel panel_7 = new MyJPanel();
		panel_2.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JLabel label_1 = new JLabel("    �Ա�Ҫ��    ");
		panel_7.add(label_1, BorderLayout.WEST);
		
		JPanel panel_9 = new MyJPanel();
		panel_7.add(panel_9, BorderLayout.CENTER);
		
		JRadioButton radioButton = new JRadioButton("��");
		panel_9.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("Ů");
		panel_9.add(radioButton_1);		
		
		final ButtonGroup g=new ButtonGroup();
		g.add(radioButton);
		g.add(radioButton_1);
		
		radioButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				sex = "��";
			}
		});
		radioButton_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				sex = "Ů";
			}
		});
		
		
		Mmonth.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(Mmonth.getSelectedItem() == "2"){
					Mday.removeAllItems();				
					for(int i = 0;i <28;i++){
						Mday.addItem(day[i]);
					}
				}
				else if(Mmonth.getSelectedItem() == "4" || Mmonth.getSelectedItem() == "6" || Mmonth.getSelectedItem() == "9" ||Mmonth.getSelectedItem() == "10"){
					Mday.removeAllItems();	
					for(int i = 0;i < 30;i++){
						Mday.addItem(day[i]);
					}
				}
				else{
					Mday.removeAllItems();
					for(int i = 0;i < 31;i++){
						Mday.addItem(day[i]);
					}
				}
			}
		});
		insert.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Connection conn = connection();
					if(conn!=null){
						try{
							Statement stmt=conn.createStatement();							
							if(!Mno.getText().trim().equals("") && Mname.getText().trim().equals("") && g.getElements() != null 
								&& Mmonth.getSelectedItem() != null && Mday.getSelectedItem() != null && Mplace.getText().trim().equals("")){
								ResultSet rs = stmt.executeQuery("select ������� from ���� where ������� = '" + Mno.getText() + "')");
								if(rs.next())
									JOptionPane.showMessageDialog(null,"�ñ�������Ѵ���,����������","������Ϣ¼��",JOptionPane.WARNING_MESSAGE);
								else{
									JOptionPane.showMessageDialog(null,"��Ϣ¼��ɹ�","�˶�Ա��Ϣ¼��",JOptionPane.INFORMATION_MESSAGE);
									stmt.executeQuery("insert into �˶�Ա (�������,��������,����ʱ��,�����ص�,�Ա�Ҫ��) values ('" + Mno.getText() + "','" + Mname.getText() + "','" + 
											Mmonth.getSelectedItem() +	"��" + Mday.getSelectedItem() + "��','" + Mplace.getText() + "','" + sex + "') ");
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
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args){
		JFrame f1 = new JFrame();
		f1.getContentPane().add(new Matchinf());
		f1.setVisible(true);
		f1.setSize(400,300);
		f1.setLocationRelativeTo(null);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
	}
}
