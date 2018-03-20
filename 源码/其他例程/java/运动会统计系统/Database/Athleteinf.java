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


public class Athleteinf extends MyJPanel{
	private JTextField Ano;
	private JTextField Aname;
	private JComboBox collegeBox,departmentBox,classBox;
	String sex = "男";
	
	public Athleteinf() {
		setLayout(new BorderLayout(0, 0));
		final String[] foreignDepart = {"","商务英语","旅游英语","日语"};
		final String[] electricDepart = {"","机电工程","机械设计制造","热能与动力工程"};
		final String[] informationDepart = {"","信息管理与信息系统","网络工程","电子信息工程","通信工程"};
		final String[] foreignClass = {"","商英121","商英122","旅游121","日语121"};
		final String[] electricClass = {"","机电121","机械121","机械122","热能121"};
		final String[] informationClass = {"","信管121","信管122","信管123","网络121","电子121","电子122","通信121"};
		final Object[] columnName = {"姓名","性别","学院","专业","班级","比赛名称","裁判","成绩"};
		
		JLabel instruction = new JLabel("请输入新建运动员的信息 ");
		add(instruction, BorderLayout.NORTH);
		
		JPanel buttonPanel = new MyJPanel();
		add(buttonPanel, BorderLayout.SOUTH);
		
		JButton insert = new JButton("提交");
		buttonPanel.add(insert);
		
		JPanel main = new MyJPanel();
		add(main, BorderLayout.CENTER);
		main.setLayout(new GridLayout(6, 1, 0, 0));
		main.setBorder(new TitledBorder("新建运动员信息"));
		
		JPanel panel_1 = new MyJPanel();
		main.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel ano = new JLabel("    运动员编号    ");
		panel_1.add(ano, BorderLayout.WEST);
		
		Ano = new JTextField();
		panel_1.add(Ano, BorderLayout.CENTER);
		Ano.setColumns(30);
		
		JPanel panel_2 = new MyJPanel();
		main.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("    运动员姓名    ");
		panel_2.add(lblNewLabel, BorderLayout.WEST);
		
		Aname = new JTextField();
		panel_2.add(Aname, BorderLayout.CENTER);
		Aname.setColumns(10);
		
		JPanel panel_3 = new MyJPanel();
		main.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel asex = new JLabel("    运动员性别    ");
		panel_3.add(asex, BorderLayout.WEST);
		
		JPanel panel_6 = new MyJPanel();
		panel_3.add(panel_6, BorderLayout.CENTER);
		
		 JRadioButton radioButton = new JRadioButton("男",true);
		radioButton.setHorizontalAlignment(SwingConstants.LEFT);
		panel_6.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("女");
		panel_6.add(radioButton_1);
		
		final ButtonGroup g=new ButtonGroup();
		g.add(radioButton);
		g.add(radioButton_1);
		
		radioButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				sex = "男";
			}
		});
		radioButton_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				sex = "女";
			}
		});
		
		JPanel panel_4 = new MyJPanel();
		main.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel acollege = new JLabel("    运动员院系    ");
		panel_4.add(acollege, BorderLayout.WEST);
		
		 collegeBox = new JComboBox(new String[] {"","外国语学院","机电学院","信息科学与技术学院" });
		panel_4.add(collegeBox, BorderLayout.CENTER);
		
		JPanel panel = new MyJPanel();
		main.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel label = new JLabel("    运动员专业    ");
		panel.add(label, BorderLayout.WEST);
		
		departmentBox = new JComboBox();
		panel.add(departmentBox, BorderLayout.CENTER);
		
		JPanel panel_5 = new MyJPanel();
		main.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JLabel label_1 = new JLabel("    运动员班级    ");
		panel_5.add(label_1, BorderLayout.WEST);
		
		classBox = new JComboBox();
		panel_5.add(classBox, BorderLayout.CENTER);
		
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
						classBox.addItem(foreignClass[1]);
						classBox.addItem(foreignClass[2]);
						break;
					case 2:
						classBox.removeAllItems();
						classBox.addItem(foreignClass[3]);
						break;
					case 3:
						classBox.removeAllItems();
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
						classBox.addItem(electricClass[1]);
						break;
					case 2:
						classBox.removeAllItems();
						classBox.addItem(electricClass[2]);
						classBox.addItem(electricClass[3]);
						break;
					case 3:
						classBox.removeAllItems();
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
		insert.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Connection conn = connection();
					if(conn!=null){
						try{
							Statement stmt=conn.createStatement();							
							if(!Ano.getText().trim().equals("") && !Aname.getText().trim().equals("") && collegeBox.getSelectedItem() != null && departmentBox.getSelectedItem() != null && classBox.getSelectedItem() != null){
								ResultSet r = stmt.executeQuery("select 运动员编号 from 运动员 where 运动员编号 = '" + Ano.getText() + "'");
								if(r.next())
										JOptionPane.showMessageDialog(null,"该编号已存在,请重新输入","运动员信息录入",JOptionPane.WARNING_MESSAGE);									
								else{
									JOptionPane.showMessageDialog(null,"信息录入成功","运动员信息录入",JOptionPane.WARNING_MESSAGE);
									stmt.executeUpdate("insert into 运动员 (运动员编号,姓名,性别,学院,专业,班级) values ('" + Ano.getText() + "','" + Aname.getText() + "','" + 
										sex  + "','" + collegeBox.getSelectedItem() +	"','" + 
										departmentBox.getSelectedItem() + "','" + classBox.getSelectedItem() + "') ");}
							}
							else
								System.out.println("还有没输入的信息");
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
		JFrame jf=new JFrame();
		jf.getContentPane().add(new Athleteinf());
		jf.setSize(400,300);
		jf.setVisible(true);
	}
	
}
