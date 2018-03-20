package proxyLayer;

import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import modules.*;
import dbAccessLayer.AccessTableData;

public class ItemAttendProxy {
	private AccessTableData sportItemDataset = new AccessTableData();
	
	public void closeDbConnection() throws SQLException{
		sportItemDataset.closeAll();
	}
	
	public ItemAttend getSportItemById(String itemId,String sportorId){
		ItemAttend result = new ItemAttend(); 
		String sqlQuery = "SELECT * FROM ItemAttend WHERE  ITEMID='" + itemId + "' AND SPORTORID = '" + sportorId + "'";
		ResultSet itemSet = sportItemDataset.DMLOperation(sqlQuery);
		try
		{
			if( itemSet.next() ){
				result.setItemId( itemSet.getString("ITEMID") );
				result.setSportorId( itemSet.getString("SPORTORID"));
				result.setScore( itemSet.getString("SCORE"));
				result.setVoid( itemSet.getString("VOID"));
			}			
		}
		catch(SQLException sqlEx){
			JOptionPane.showMessageDialog(null,"数据转换发生错误\n"+sqlEx.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
			System.exit(-1);
		}
		return result;
	}
	
	public void UpdateById(String sql){
		sportItemDataset.DMLOperation(sql);		
	}
}
