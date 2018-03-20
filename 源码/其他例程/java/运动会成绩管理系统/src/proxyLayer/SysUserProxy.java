package proxyLayer;
import java.sql.*;
import java.util.*;
import javax.swing.*;

import dbAccessLayer.*;
import modules.*;
public class SysUserProxy {
	private AccessTableData userDataset = new AccessTableData();
	public Vector getAllSysUsers(){
		Vector userList = new Vector();
		ResultSet userSet = userDataset.DMLOperation("SELECT * FROM SYSUSER");
		try
		{
			while( userSet.next() ){
				SysUser user = new SysUser();
				user.setSysUserId( userSet.getString("SYSUSERID") );
				user.setName( userSet.getString("NAME"));
				user.setPassword( userSet.getString("PASSWORD"));
				user.setGender( userSet.getString("GENDER"));
				user.setRoleId( userSet.getString("ROLEID") );
				user.setVoid( userSet.getString("VOID"));
				userList.add(user);
			}			
		}
		catch(SQLException sqlEx){
			JOptionPane.showMessageDialog(null,"数据转换发生错误\n"+sqlEx.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
			System.exit(-1);
		}
		return userList;
	}
	
	public void closeDbConnection() throws SQLException{
		userDataset.closeAll();
	}
	
	public SysUser getUserById(String userId){
		SysUser result = new SysUser(); 
		ResultSet userSet = userDataset.DMLOperation("SELECT * FROM SYSUSER WHERE SYSUSERID='"+userId+"'");
		try
		{
			if( userSet.next() ){
				result.setSysUserId( userSet.getString("SYSUSERID") );
				result.setName( userSet.getString("NAME"));
				result.setPassword( userSet.getString("PASSWORD"));
				result.setGender( userSet.getString("GENDER"));
				result.setRoleId( userSet.getString("ROLEID") );
				result.setVoid( userSet.getString("VOID"));
			}			
		}
		catch(SQLException sqlEx){
			JOptionPane.showMessageDialog(null,"数据转换发生错误\n"+sqlEx.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
			System.exit(-1);
		}
		return result;
	}
	
	public void UpdateUserById(String sql){
		userDataset.DMLOperation(sql);		
	}
}
