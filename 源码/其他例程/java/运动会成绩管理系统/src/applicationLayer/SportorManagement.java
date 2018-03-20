package applicationLayer;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.*;
import javax.swing.*;
import modules.*;
import proxyLayer.*;
import roles.RoleIdMapRoleName;

public class SportorManagement {
	private JFrame JfmSportorManagement = null;
	private java.awt.List lstUserList = null;
	private JTextField txtUserId;
	private JTextField txtUserName;
	private JComboBox cmbGender;
	private JTextField txtUserWeight ;
	private JTextField txtUserHeight;
	private JTextField txtUserAge;
	private JTextField txtUserGrade;
	private JCheckBox chkSysUserVoid;
	
	private JButton btnAddUser;
	private JButton btnUpdateUser;
	private JButton btnDelUser;
	private Vector vecUsers;
	
	private void InitCtlData(){
//		为用户列表提取数据
		SportorProxy UserProxy = new SportorProxy(); 
		vecUsers = UserProxy.getAllSportUsers();
		try{
			UserProxy.closeDbConnection();
		}
		catch(SQLException ex){
			
		}
		for( int i = 0; i < vecUsers.size(); i ++ ){
			lstUserList.add(((SportsMan)vecUsers.elementAt(i)).getName() + "		"+ ((SportsMan)vecUsers.elementAt(i)).getSportorId());
		}
	}
	public SportorManagement(){
		/*创建图形界面*/
		JfmSportorManagement = new JFrame("运动员管理模块");
		JPanel jLeftPane = new JPanel();
		BorderLayout constraint = new BorderLayout(); 
		jLeftPane.setLayout(constraint);
		jLeftPane.add(new JLabel("运动员列表"),constraint.NORTH);
		
		lstUserList = new java.awt.List();
		jLeftPane.add(lstUserList,constraint.CENTER);
		
		JPanel jRightPane = new JPanel();
		BorderLayout borderlayout = new BorderLayout();
		jRightPane.setLayout(borderlayout);
		
		GridLayout grid = new GridLayout(8,2);
		JPanel dataItemPane = new JPanel();
		dataItemPane.setLayout( grid );
		
		dataItemPane.add(new JLabel("人员编号："));
		txtUserId = new JTextField(10);
		txtUserId.setEditable(false);
		dataItemPane.add(txtUserId);
		
		dataItemPane.add( new JLabel("人员姓名："));
		txtUserName = new JTextField(10);
		dataItemPane.add( txtUserName );
		
		dataItemPane.add(new JLabel("性别："));
		cmbGender = new JComboBox(new String[]{"男","女"});
		dataItemPane.add( cmbGender );
		
		dataItemPane.add( new JLabel("体重(KG)：") );
		txtUserWeight = new JPasswordField(10);
		dataItemPane.add( txtUserWeight );
		
		dataItemPane.add( new JLabel("身高(CM)：") );
		txtUserHeight = new JTextField(10);
		dataItemPane.add( txtUserHeight );
		
		dataItemPane.add(new JLabel("年龄："));
		txtUserAge = new JTextField(10);
		dataItemPane.add( txtUserAge );
		
		dataItemPane.add(new JLabel("等级："));
		txtUserGrade = new JTextField(10);
		dataItemPane.add( txtUserGrade );
		
		dataItemPane.add( new JLabel("用户状态:" ));
		chkSysUserVoid = new JCheckBox("无效");
		dataItemPane.add(chkSysUserVoid);
		
		btnAddUser = new JButton("添加用户");
		btnUpdateUser = new JButton("更新用户");
		btnDelUser = new JButton("删除用户");
		JPanel btnPane = new JPanel();
		btnPane.setLayout( new GridLayout(1,3));
		btnPane.add(btnAddUser);
		btnPane.add(btnUpdateUser);
		btnPane.add(btnDelUser);
		
		jRightPane.add(btnPane,BorderLayout.SOUTH);
		jRightPane.add(dataItemPane,BorderLayout.NORTH);
		
		BorderLayout bdLayout = new BorderLayout();
		bdLayout.setHgap(10);
		JfmSportorManagement.setLayout( bdLayout );
		JfmSportorManagement.add( jLeftPane, BorderLayout.WEST );
		JfmSportorManagement.add( jRightPane, BorderLayout.CENTER );
		JfmSportorManagement.pack();
		JfmSportorManagement.setLocation(200,200);
		JfmSportorManagement.setVisible(true);
		
		this.lstUserList.addItemListener( new ListItemChange() );
		UserOperAction btnEvtHandle = new UserOperAction();
		this.btnAddUser.addActionListener(btnEvtHandle);
		this.btnDelUser.addActionListener(btnEvtHandle);
		this.btnUpdateUser.addActionListener(btnEvtHandle);
		/*图形界面创建完毕*/
		InitCtlData();
	}
		
	class ListItemChange implements ItemListener{
		public void itemStateChanged(ItemEvent e){
			java.awt.List lstCtrl = (java.awt.List)e.getSource();
			String str = lstCtrl.getSelectedItem();
			if( str == null || str == "")
				return;
			String[] result = str.split("\\s"); //分解成Token
			String UserId = result[2];
			SportorProxy sportorProxy = new SportorProxy();
			SportsMan instanceSportor = sportorProxy.getUserById(UserId);
			
			txtUserId.setText( instanceSportor.getSportorId() );
			txtUserName.setText( instanceSportor.getName() );
			if( instanceSportor.getGender().equals( "M") )
				cmbGender.setSelectedIndex(0);
			else if( instanceSportor.getGender().equals("F"))
				cmbGender.setSelectedIndex(1);
			txtUserWeight.setText( new Float(instanceSportor.getWeight()).toString() );
			txtUserHeight.setText( new Float(instanceSportor.getHeight()).toString() );
			txtUserAge.setText( new Integer(instanceSportor.getAge()).toString() );
			txtUserGrade.setText( new Integer(instanceSportor.getGrade()).toString());
			if( instanceSportor.getVoid().equals("Y"))
				chkSysUserVoid.setSelected(true);
			else
				chkSysUserVoid.setSelected(false);
			
			try{
				sportorProxy.closeDbConnection();
			}
			catch(SQLException ex){
				
			}
		}
	}

	class UserOperAction implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if( e.getSource() == (JButton)btnAddUser ){
				//增加系统用户
				/*课后作业*/
				JOptionPane.showMessageDialog(null,"新增成功！","成功",JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			else if( e.getSource() == (JButton)btnUpdateUser ){
				//更新现有用户
				String userId = txtUserId.getText();
				String userName = txtUserName.getText();
				String Gender;
				if( cmbGender.getSelectedItem().toString().equals("男"))
					Gender = "M";
				else
					Gender = "F";
				float weight = 0.0f;
				if( txtUserWeight.getText() != null && txtUserWeight.getText() != "")
					weight = Float.parseFloat(txtUserWeight.getText());	
				float height = 0.0f;
				if( txtUserHeight.getText() != null && txtUserHeight.getText() != "")
					height = Float.parseFloat( txtUserHeight.getText() );
				int age = 0;
				if( txtUserAge.getText() != null && txtUserAge.getText() != "")
					age = Integer.parseInt( txtUserAge.getText() );
				int grade = 0;
				if( txtUserGrade.getText() != null && txtUserGrade.getText() != "")
					grade = Integer.parseInt( txtUserGrade.getText() );
				String Void;
				if( chkSysUserVoid.isSelected() == true)
					Void = "Y";
				else
					Void = "N";
			
				String finalSql = "";  
				finalSql = "UPDATE sportor "+
							" SET NAME='" + userName +"',GENDER='"+Gender + "', "+
							" WEIGHT=" + weight + ", HEIGHT =" + height + ", " + 
							" AGE = " + age +", " + " GRADE = " + grade + ",VOID='" + Void + "' "+
							"WHERE SPORTORID='"+ userId + "'"; 
				SportorProxy UserProxy = new SportorProxy(); 
				UserProxy .UpdateUserById(finalSql);
				JOptionPane.showMessageDialog(null,"更新成功！","成功",JOptionPane.INFORMATION_MESSAGE);
				return;	
			}
			else if(e.getSource() == (JButton)btnDelUser){
				String userId = txtUserId.getText();
				String finalSql = "DELETE　FROM sportor WHERE SPORTORID='"+userId+"'";
				SportorProxy UserProxy = new SportorProxy(); 
				UserProxy.UpdateUserById(finalSql);
				lstUserList.removeAll();
				InitCtlData();
				JOptionPane.showMessageDialog(null,"删除成功！","成功",JOptionPane.INFORMATION_MESSAGE);
				return;
			}
		}
	}

}
