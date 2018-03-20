package applicationLayer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import proxyLayer.*;
import roles.*;
import modules.*;
public class SysUserManagement {
	private JFrame JfmUserManagement = null;
	private java.awt.List lstUserList = null;
	private JTextField txtSysUserId;
	private JTextField txtSysUserName;
	private JComboBox cmbGender;
	private JPasswordField txtSysUserPassword;
	private JPasswordField txtRetrySysUserPassword;
	private JComboBox cmbSysUserRole;
	private JCheckBox chkSysUserVoid;
	private JButton btnDelSysUser;
	private JButton btnUpdateUser;	
	private Vector vecSysUsers;
	
	public SysUserManagement(){	
		/*创建图形界面*/
		JfmUserManagement = new JFrame("系统用户管理");
		JPanel jLeftPane = new JPanel();
		BorderLayout constraint = new BorderLayout(); 
		jLeftPane.setLayout(constraint);
		jLeftPane.add(new JLabel("系统用户列表"),constraint.NORTH);
		
		lstUserList = new java.awt.List();
		jLeftPane.add(lstUserList,constraint.CENTER);
		
		JPanel jRightPane = new JPanel();
		GridLayout grid = new GridLayout(8,2);
		jRightPane.setLayout(grid);
		
		jRightPane.add(new JLabel("人员编号："));
		txtSysUserId = new JTextField(10);
		txtSysUserId.setEditable(false);
		jRightPane.add(txtSysUserId);
		
		jRightPane.add( new JLabel("人员姓名："));
		txtSysUserName = new JTextField(10);
		jRightPane.add( txtSysUserName );
		
		jRightPane.add(new JLabel("性别："));
		cmbGender = new JComboBox(new String[]{"男","女"});
		jRightPane.add( cmbGender );
		
		jRightPane.add( new JLabel("登录密码：") );
		txtSysUserPassword = new JPasswordField(10);
		jRightPane.add( txtSysUserPassword );
		
		jRightPane.add( new JLabel("确认密码：") );
		txtRetrySysUserPassword = new JPasswordField(10);
		jRightPane.add( txtRetrySysUserPassword );
		
		jRightPane.add(new JLabel("用户角色："));
		cmbSysUserRole = new JComboBox(new String[]{"系统管理员","系统操作员",""});
		jRightPane.add( cmbSysUserRole );
		
		jRightPane.add( new JLabel("用户状态:" ));
		chkSysUserVoid = new JCheckBox("无效");
		jRightPane.add(chkSysUserVoid);
		
		btnUpdateUser = new JButton("更新用户");
		btnDelSysUser = new JButton("删除用户");
		jRightPane.add(btnUpdateUser);
		jRightPane.add(btnDelSysUser);
		
		BorderLayout bdLayout = new BorderLayout();
		bdLayout.setHgap(10);
		JfmUserManagement.setLayout( bdLayout );
		JfmUserManagement.add( jLeftPane, BorderLayout.WEST );
		JfmUserManagement.add( jRightPane, BorderLayout.CENTER );
		JfmUserManagement.pack();
		JfmUserManagement.setLocation(200,200);
		JfmUserManagement.setVisible(true);
		/*图形界面创建完毕*/
		
		//为用户列表提取数据
		SysUserProxy sysUserProxy = new SysUserProxy(); 
		vecSysUsers = sysUserProxy.getAllSysUsers();
		try{
			sysUserProxy.closeDbConnection();
		}
		catch(SQLException ex){
			
		}
		for( int i = 0; i < vecSysUsers.size(); i ++ ){
			lstUserList.add(((SysUser)vecSysUsers.elementAt(i)).getName() + "  "+ ((SysUser)vecSysUsers.elementAt(i)).getSysUserId());
		}
		
		/*为控件注册事件*/
		
		this.lstUserList.addItemListener( new ListItemChange() );
		UserOperAction btnEvtHandle = new UserOperAction();
		this.btnDelSysUser.addActionListener(btnEvtHandle);
		this.btnUpdateUser.addActionListener(btnEvtHandle);
	}
	class ListItemChange implements ItemListener{
		public void itemStateChanged(ItemEvent e){
			java.awt.List lstCtrl = (java.awt.List)e.getSource();
			String str = lstCtrl.getSelectedItem();
			if( str == null || str == "")
				return;
			String[] result = str.split("\\s"); //分解成Token
			String sysUserId = result[2];
			SysUserProxy sysUserProxy = new SysUserProxy();
			SysUser instanceSysUser = sysUserProxy.getUserById(sysUserId);
			txtSysUserId.setText( instanceSysUser.getSysUserId() );
			txtSysUserName.setText( instanceSysUser.getName() );
			if( instanceSysUser.getGender().equals( "M") )
				cmbGender.setSelectedIndex(0);
			else if( instanceSysUser.getGender().equals("F"))
				cmbGender.setSelectedIndex(1);
			txtSysUserPassword.setText( instanceSysUser.getPassword() );
			txtRetrySysUserPassword.setText( instanceSysUser.getPassword() );
			if( instanceSysUser.getRoleId().equals(RoleIdMapRoleName.SYSADMIN ))
				cmbSysUserRole.setSelectedIndex(0);
			else if(instanceSysUser.getRoleId().equals(RoleIdMapRoleName.SYSOPERATOR) )
				cmbSysUserRole.setSelectedIndex(1);
			else
				cmbSysUserRole.setSelectedIndex(2);
			
			if( instanceSysUser.getVoid().equals("Y"))
				chkSysUserVoid.setSelected(true);
			else
				chkSysUserVoid.setSelected(false);
			
			try{
				sysUserProxy.closeDbConnection();
			}
			catch(SQLException ex){
				
			}
			
		}
	}

	class UserOperAction implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if( e.getSource() == (JButton)btnDelSysUser ){
				//删除系统用户
				String userId = txtSysUserId.getText();
				String finalSql = "DELETE　FROM SysUser WHERE SYSUSERID='"+userId+"'";
				SysUserProxy sysUserProxy = new SysUserProxy(); 
				sysUserProxy.UpdateUserById(finalSql);
				JOptionPane.showMessageDialog(null,"删除成功！","成功",JOptionPane.INFORMATION_MESSAGE);
			}
			else if( e.getSource() == (JButton)btnUpdateUser ){
				//更新现有用户
				String userId = txtSysUserId.getText();
				String userName = txtSysUserName.getText();
				String Gender;
				if( cmbGender.getSelectedItem().toString().equals("男"))
					Gender = "M";
				else
					Gender = "F";
				String Pass;
				if( txtSysUserPassword.getText().equals(txtRetrySysUserPassword.getText()) )
					Pass = txtSysUserPassword.getText();
				else{					
					JOptionPane.showMessageDialog(null,"密码不匹配","错误",JOptionPane.ERROR_MESSAGE);
					return;				
				}
				String userRole;
				if( cmbSysUserRole.getSelectedItem().toString().equals("系统管理员"))
					userRole = RoleIdMapRoleName.SYSADMIN;
				else if(cmbSysUserRole.getSelectedItem().toString().equals("系统操作员") )
					userRole = RoleIdMapRoleName.SYSOPERATOR;
				else
					userRole = "";
				String Void;
				if( chkSysUserVoid.isSelected() == true)
					Void = "Y";
				else
					Void = "N";
				String finalSql = "UPDATE SYSUSER SET NAME='" + userName + "', "+
							"PASSWORD = '" + Pass + "', GENDER='" + Gender + "', "+
							"ROLEID='" + userRole + "', VOID='" + Void + "' WHERE " +
							"SYSUSERID='" + userId + "'";
				SysUserProxy sysUserProxy = new SysUserProxy(); 
				sysUserProxy.UpdateUserById(finalSql);
				JOptionPane.showMessageDialog(null,"更新成功！","成功",JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}