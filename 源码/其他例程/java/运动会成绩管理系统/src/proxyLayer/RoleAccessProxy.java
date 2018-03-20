package proxyLayer;
import java.util.*;
import java.sql.*;
import javax.swing.*;

import dbAccessLayer.*;
import modules.*;
public class RoleAccessProxy {
	private AccessTableData userDataset = new AccessTableData();
	public boolean ValidateUserExist(String UserName,String Password,String RoleId){
		ResultSet userSet = userDataset.DMLOperation(
				"SELECT * FROM sysuser WHERE  NAME='"+ UserName + "' " + 
				"AND Password='"+ Password + "' AND ROLEID='"+ RoleId + "'");
				
		try
		{
			if( userSet.next() ){
				return true;
			}
			else
				return false;
		}
		catch(SQLException sqlEx){
			JOptionPane.showMessageDialog(null,"数据转换发生错误\n"+sqlEx.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
			System.exit(-1);
		}
		return false;
	}
}
