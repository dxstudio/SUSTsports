package dbAccessLayer;
import java.sql.*;

import javax.swing.JOptionPane;
public class AccessTableData {
	private Connection dbConn = null;
	private Statement stat = null;
	private ResultSet rSet = null;
	final  ConnectionPool connPool = ConnectionPool.DbConnectionPool;
	public ResultSet DMLOperation ( String strSQL ){		
		try{
			dbConn = ConnectionPool.DbConnectionPool.getConnection();
			if( dbConn == null ){
				JOptionPane.showMessageDialog(null,"连接池已满，请稍后再试","错误",JOptionPane.ERROR_MESSAGE);
				System.exit(-1);
			}
			stat = dbConn.createStatement();			
			rSet = stat.executeQuery( strSQL );			
			return rSet;
		}
		catch(SQLException sqlEx){
			JOptionPane.showMessageDialog(null,"数据库错误\n系统将中止运行，请稍后再试","错误",JOptionPane.ERROR_MESSAGE);
			return null;
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null,"未知错误\n系统将中止运行，请稍后再试","错误",JOptionPane.ERROR_MESSAGE);
			return null;
		}		
	}

	public void closeAll() throws SQLException{
		stat.close();
		rSet.close();
		connPool.CleanUp();
	}
}
