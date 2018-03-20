package dbAccessLayer;
import java.util.*;
import java.sql.*;
import javax.swing.*;
import oracle.jdbc.*;
import oracle.jdbc.driver.*;
public class ConnectionPool {
	public static ConnectionPool DbConnectionPool = new ConnectionPool();
	private Vector DbConnectPool = new Vector(DBConstValue.DbConnectionPoolSize); //连接池数目
	private int[] ConnectUsed = new int[DBConstValue.DbConnectionPoolSize];
	
	private ConnectionPool(){
		int length = this.DbConnectPool.capacity();	
		for(int i = 0; i < DBConstValue.DbConnectionPoolSize; i++){
			this.ConnectUsed[i] = 0;
			DbConnectPool.add(null);
		}
	}
	private  synchronized boolean isConnectElemnetUsed( int elementPosition ){
			return ConnectUsed[elementPosition] == 1;
	}
	private synchronized void setConnectElementUsed( int elementPosition ){
		ConnectUsed[ elementPosition ] = 1;
	}
	private synchronized void setConnectionElementUnUsed( int elementPosition ){
		ConnectUsed[ elementPosition ] = 0;
	}
	public void CleanUp() throws SQLException{
		for( int element = 0; element < DbConnectPool.size(); element ++){
			Connection conn = (Connection)DbConnectPool.elementAt( element );
			if( conn == null ){
				setConnectionElementUnUsed(element);
				continue;
			}
			if( conn.isClosed() == false){
				setConnectionElementUnUsed(element);
			}
			if( conn.isClosed() == true ){
				DbConnectPool.setElementAt(null,element );
				setConnectionElementUnUsed(element);
			}
		}
	}
	public Connection getConnection() throws SQLException{
		for( int i = 0; i < DBConstValue.DbConnectionPoolSize; i ++ ){
			if ( isConnectElemnetUsed( i ) == false ){
				if( DbConnectPool.size() > 0 &&
					DbConnectPool.elementAt( i ) != null && 
					(((Connection)DbConnectPool.elementAt(i)).isClosed() == true) ){
					this.setConnectElementUsed( i );
					return  (Connection)DbConnectPool.elementAt( i );
				}
				else{
					try{
						Class.forName(DBConstValue.DBDriver);
						Connection conn = DriverManager.getConnection(
								DBConstValue.ConnStr,
								DBConstValue.DbUserName,
								DBConstValue.DbPassWord);
						DbConnectPool.setElementAt(conn,i);
						this.setConnectElementUsed( i );
						return  (Connection)DbConnectPool.elementAt( i );
					}
					catch(ClassNotFoundException clsEx){
						System.out.println("ClassNotFoundException Happens:" + clsEx.getMessage());
						JOptionPane.showMessageDialog(null,"数据库驱动装载错误\n系统将中止运行","错误",JOptionPane.ERROR_MESSAGE);
					}
					catch(SQLException sqlEx){
						System.out.println("SQLException Happens:" + sqlEx.getMessage());
						JOptionPane.showMessageDialog(null,"数据库驱动装载错误\n系统将中止运行","错误",JOptionPane.ERROR_MESSAGE);
					}
					catch(Exception unhandle){
						System.out.println("Unexpect Exception Happens:" + unhandle.getMessage());
						JOptionPane.showMessageDialog(null,"未知系统异常\n系统将中止运行","错误",JOptionPane.ERROR_MESSAGE);
					}
				}//else
			}
		}
		return null;//所有元素已经都占用了
	}
	public void returnConnection(int position){
		setConnectionElementUnUsed(position);
	}
}
