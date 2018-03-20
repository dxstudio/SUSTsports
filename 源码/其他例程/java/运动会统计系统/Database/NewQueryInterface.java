import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewQueryInterface extends JPanel{
	private JTextField tsportNo;
	public NewQueryInterface() {
		setLayout(null);
		
		JPanel selectpanel = new JPanel();
		selectpanel.setBorder(new TitledBorder(null, "\u67E5\u8BE2\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		selectpanel.setBounds(10, 10, 364, 93);
		add(selectpanel);
		selectpanel.setLayout(null);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(10, 25, 304, 25);
		selectpanel.add(panel1);
		panel1.setLayout(null);
		
		JLabel sportNo = new JLabel("运动员编号:");
		sportNo.setBounds(5, 4, 84, 15);
		panel1.add(sportNo);
		
		tsportNo = new JTextField();
		tsportNo.setBounds(81, 1, 127, 21);
		panel1.add(tsportNo);
		tsportNo.setColumns(10);
		
		JButton selectButton = new JButton("查询");
		selectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		selectButton.setBounds(218, 0, 76, 23);
		panel1.add(selectButton);
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(10, 58, 344, 25);
		selectpanel.add(panel2);
		panel2.setLayout(null);
		
		JComboBox collegeBox = new JComboBox();
		collegeBox.setBounds(0, 0, 110, 21);
		panel2.add(collegeBox);
		
		JComboBox departmentBox = new JComboBox();
		departmentBox.setBounds(120, 0, 100, 21);
		panel2.add(departmentBox);
		
		JComboBox classBox = new JComboBox();
		classBox.setBounds(230, 0, 110, 21);
		panel2.add(classBox);
		
		JPanel resultpanel = new JPanel();
		resultpanel.setBorder(new TitledBorder(null, "\u67E5\u8BE2\u7ED3\u679C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		resultpanel.setBounds(10, 101, 364, 157);
		add(resultpanel);
		resultpanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 15, 344, 137);
		resultpanel.add(scrollPane);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame jf=new JFrame();
		NewQueryInterface nqi=new NewQueryInterface();
		jf.getContentPane().add(nqi);
		jf.setSize(400,300);
		jf.setVisible(true);
		
	}
}
