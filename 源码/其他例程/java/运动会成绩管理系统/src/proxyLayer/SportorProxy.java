package proxyLayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import dbAccessLayer.*;
import modules.*;
import modules.SysUser;

public class SportorProxy {
	private AccessTableData userDataset = new AccessTableData();
	public Vector getAllSportUsers(){
		Vector userList = new Vector();
		ResultSet userSet = userDataset.DMLOperation("SELECT * FROM Sportor");
		try
		{
			while( userSet.next() ){
				SportsMan user = new SportsMan();
				user.setSportorId( userSet.getString("SPORTORID") );
				user.setName( userSet.getString("NAME"));
				user.setGender( userSet.getString("GENDER"));
				user.setWeight( userSet.getFloat("WEIGHT") );
				user.setHeight( userSet.getFloat("HEIGHT") );
				user.setAge( userSet.getInt("AGE"));
				user.setGrade( userSet.getInt("GRADE"));
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
	
	public Vector getSportUsersBySql(String Sql){
		Vector userList = new Vector();
		ResultSet userSet = userDataset.DMLOperation(Sql);
		try
		{
			while( userSet.next() ){
				SportsMan user = new SportsMan();
				user.setSportorId( userSet.getString("SPORTORID") );
				user.setName( userSet.getString("NAME"));
				userList.add(user);
			}			
		}
		catch(SQLException sqlEx){
			JOptionPane.showMessageDialog(null,"数据转换发生错误\n"+sqlEx.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
			System.exit(-1);
		}
		return userList;
	}
	public SportsMan getUserById(String UserId){
		SportsMan result = new SportsMan(); 
		ResultSet userSet = userDataset.DMLOperation("SELECT * FROM Sportor WHERE SPORTORID='"+UserId+"'");
		try
		{
			if( userSet.next() ){
				result.setSportorId( userSet.getString("SPORTORID") );
				result.setName( userSet.getString("NAME"));
				result.setGender( userSet.getString("GENDER"));
				result.setWeight( userSet.getFloat("WEIGHT"));
				result.setHeight( userSet.getFloat("HEIGHT"));
				result.setAge( userSet.getInt("AGE"));
				result.setGrade( userSet.getInt("GRADE"));
				result.setVoid( userSet.getString("VOID"));
			}			
		}
		catch(SQLException sqlEx){
			JOptionPane.showMessageDialog(null,"数据转换发生错误\n"+sqlEx.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
			System.exit(-1);
		}
		return result;
	}

	public void UpdateUserById(String strSQL){
		userDataset.DMLOperation(strSQL);
	}
	public void closeDbConnection() throws SQLException{
		userDataset.closeAll();
	}
}
