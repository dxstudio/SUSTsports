package proxyLayer;
import java.sql.*;
import java.util.*;
import javax.swing.*;

import dbAccessLayer.*;
import modules.*;
public class SportItemProxy {
	private AccessTableData sportItemDataset = new AccessTableData();
	public Vector getAllSportsItem(){
		Vector vecItemList = new Vector();
		ResultSet itemSet = sportItemDataset.DMLOperation("SELECT * FROM SportItems");
		try
		{
			while( itemSet.next() ){
				SportItem sportItem = new SportItem();
				sportItem.setItemId( itemSet.getString("ITEMID") );
				sportItem.setItemName( itemSet.getString("ITEMNAME"));
				sportItem.setItemType( itemSet.getString("ITEMTYPE"));
				sportItem.setVoid( itemSet.getString("VOID"));
				vecItemList.add(sportItem);
			}			
		}
		catch(SQLException sqlEx){
			JOptionPane.showMessageDialog(null,"数据转换发生错误\n"+sqlEx.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
			System.exit(-1);
		}
		return vecItemList;
	}
	
	public void closeDbConnection() throws SQLException{
		sportItemDataset.closeAll();
	}
	
	public SportItem getSportItemById(String itemId){
		SportItem result = new SportItem(); 
		ResultSet itemSet = sportItemDataset.DMLOperation("SELECT * FROM SPORTITEMS WHERE ITEMID='"+itemId+"'");
		try
		{
			if( itemSet.next() ){
				result.setItemId( itemSet.getString("ITEMID") );
				result.setItemName( itemSet.getString("ITEMNAME"));
				result.setItemType( itemSet.getString("ITEMTYPE"));
				result.setVoid( itemSet.getString("VOID"));
			}			
		}
		catch(SQLException sqlEx){
			JOptionPane.showMessageDialog(null,"数据转换发生错误\n"+sqlEx.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
			System.exit(-1);
		}
		return result;
	}
	
	public void UpdateUserById(String sql){
		sportItemDataset.DMLOperation(sql);		
	}
}
