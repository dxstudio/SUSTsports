package roles;
import dbAccessLayer.*;
import java.sql.*;

import javax.swing.JOptionPane;

import modules.*;
public class GenericRole {
	private AccessTableData tbDataAccess = new AccessTableData();
	public GenericUser ValidateSysUser(String UserName,String Password,String Priority){
		//验证用户的合法性
		String strSQL = "SELECT a.sysuserid,a.name,a.password,a.gender,a.roleid,b.rolename "+
						"FROM sysuser a, roles b " +
						"WHERE a.roleid=b.roleid " +
						"AND a.void = 'N' AND b.void ='N' " +
						"AND a.name = '" + UserName + "' " +
						"AND a.password ='" + Password + "' " +
						"AND b.rolename ='"+ Priority + "'";
		ResultSet dataStore = tbDataAccess.DMLOperation( strSQL );		
		try
		{
			SysUser user = new SysUser();
			if( dataStore.next() == true )
			{
				user.setSysUserId( dataStore.getString("SYSUSERID") );
				user.setName( dataStore.getString("NAME") );
				user.setRoleId(dataStore.getString("ROLEID"));
				user.setVoid( dataStore.getString("VOID"));				
			}
			return user;
		}
		catch(SQLException ex){
			JOptionPane.showMessageDialog(null,"数据库错误\n系统将中止运行\n"+ex.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
			System.exit(-1);
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null,"未知异常\n系统将中止运行\n"+ex.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
			System.exit(-1);
		}
		return  null;
	}	
}