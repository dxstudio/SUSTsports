package applicationLayer;
import javax.swing.*;

import modules.*;

import java.sql.SQLException;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import proxyLayer.*;
public class SportorScoreManagement {
	private java.awt.List lstSportItems ;
	private java.awt.List lstSportors;
	private JTextField txtScore1;
	private JTextField txtScore2;
	private JTextField txtScore3;
	private JTextField txtScore4;
	private JTextField txtScore5;
	private JTextField txtScore6;
	private JCheckBox chkValid;
	private JButton btnOK;
	private JButton btnCancel;
	private Vector vecSportItem; 
	public SportorScoreManagement(){
		/*界面初始化*/
		JFrame jfmScore = new JFrame("成绩录入");
		
		JPanel jleftPane = new JPanel();
		BorderLayout constraintLeft = new BorderLayout(); 
		jleftPane.setLayout( constraintLeft );
		jleftPane.add( new JLabel("比赛项目："),constraintLeft.NORTH );
		lstSportItems = new java.awt.List();	
		lstSportItems.addItemListener( new ListItemChange() );
		jleftPane.add( lstSportItems,constraintLeft.CENTER );
		
		JPanel jmidPane = new JPanel();
		BorderLayout constraintMid = new BorderLayout();
		jmidPane.setLayout( constraintMid );
		jmidPane.add( new JLabel("运动员列表："),constraintMid.NORTH );
		lstSportors = new java.awt.List();
		lstSportors.addItemListener( new ListItemChange() );
		jmidPane.add( lstSportors,constraintMid.CENTER );
		
		JPanel jrightPane = new JPanel();
		GridLayout gridLayout = new GridLayout(8,2);
		jrightPane.setLayout(gridLayout);
		jrightPane.add( new JLabel("成绩１:"));
		txtScore1 = new JTextField(10);
		jrightPane.add( txtScore1 );
		
		jrightPane.add( new JLabel("成绩2:"));
		txtScore2 = new JTextField(10);
		jrightPane.add( txtScore2 );
		
		jrightPane.add( new JLabel("成绩3:"));
		txtScore3 = new JTextField(10);
		jrightPane.add( txtScore3 );
		
		jrightPane.add( new JLabel("成绩4:"));
		txtScore4 = new JTextField(10);
		jrightPane.add( txtScore4 );
		
		jrightPane.add( new JLabel("成绩5:"));
		txtScore5 = new JTextField(10);
		jrightPane.add( txtScore5);
		
		jrightPane.add( new JLabel("成绩6:"));
		txtScore6 = new JTextField(10);
		jrightPane.add( txtScore6 );		
		
		jrightPane.add( new JLabel("成绩有效性:"));
		chkValid = new JCheckBox("无效");
		jrightPane.add( chkValid );
		
		btnOK = new JButton("提交");
		btnCancel = new JButton("取消");
		jrightPane.add( btnOK );
		jrightPane.add( btnCancel );
		btnOK.addActionListener( new btnActionHandle() );
		btnCancel.addActionListener(new btnActionHandle() );
		
		jfmScore.add( jleftPane, BorderLayout.WEST);
		jfmScore.add( jmidPane, BorderLayout.CENTER );
		jfmScore.add( jrightPane, BorderLayout.EAST );
		jfmScore.setSize(200,300);
		jfmScore.pack();
		jfmScore.setVisible(true);
		
		InitData();
	}
	private void InitData(){
		/*初始化控件上的数据*/
		SportItemProxy sportItemproxy = new SportItemProxy();
		vecSportItem = sportItemproxy.getAllSportsItem();
		try{
			sportItemproxy.closeDbConnection();
		}
		catch(SQLException ex){
			
		}
		lstSportItems.removeAll();
		for( int i = 0; i < vecSportItem.size(); i ++ ){
			lstSportItems.add(((SportItem)vecSportItem.elementAt(i)).getItemName() + "		"+ ((SportItem)vecSportItem.elementAt(i)).getItemId());
		}
	}
	
	class ListItemChange implements ItemListener{
		public void itemStateChanged(ItemEvent e){
			if( e.getSource() == (java.awt.List)lstSportItems ){
				//初始化界面
				txtScore1.setText( "" );
				txtScore2.setText( "" );
				txtScore3.setText( "" );
				txtScore4.setText( "" );
				txtScore5.setText( "" );
				txtScore6.setText( "" );
				chkValid.setSelected(false);
				
				java.awt.List lstCtrl = (java.awt.List)e.getSource();
				String str = lstCtrl.getSelectedItem();
				if( str == null || str == "")
					return;
				String[] result = str.split("\\s"); //分解成Token
				String itemId = result[2];
				
				String sqlQuery = "SELECT a.name, a.sportorid " + 
								  "FROM sportor a,itemAttend b " +
								  "WHERE b.itemid = '"+ itemId + "' and "+
								  "b.sportorid = a.sportorid ";
				SportorProxy sportProxy = new SportorProxy();
				Vector vecSportor = sportProxy.getSportUsersBySql(sqlQuery);
				lstSportors.removeAll();
				for( int i = 0; i < vecSportor.size(); i ++ ){
					lstSportors.add(((SportsMan)vecSportor.elementAt(i)).getName() + "		"+ ((SportsMan)vecSportor.elementAt(i)).getSportorId());
				}
				try{
					sportProxy.closeDbConnection();
				}
				catch(SQLException sqlEx){
					
				}
			}
			else if( e.getSource() == (java.awt.List)lstSportors ){
				//初始化界面
				txtScore1.setText( "" );
				txtScore2.setText( "" );
				txtScore3.setText( "" );
				txtScore4.setText( "" );
				txtScore5.setText( "" );
				txtScore6.setText( "" );
				chkValid.setSelected(false);
				//显示成绩
				String str = lstSportors.getSelectedItem();
				if( str == null || str == "")
					return;
				String[] result = str.split("\\s"); //分解成Token
				String SportorId = result[2];
				
				str = lstSportItems.getSelectedItem();
				if( str == null || str == "" )
					return;
				result = str.split("\\s");
				String SportItemId = result[2];
				
				ItemAttendProxy itemAttendProxy = new ItemAttendProxy();
				ItemAttend itemAttend = itemAttendProxy.getSportItemById(SportItemId,SportorId);
				try{
					itemAttendProxy.closeDbConnection();
				}
				catch(SQLException ex){
					
				}
				if( itemAttend.getVoid().equals("Y") ){
					chkValid.setSelected(true);
				}
				else
					chkValid.setSelected(false);
				
				String[] scores = itemAttend.getScore().split("\\s");
				switch(scores.length){
					case 1:
						txtScore1.setText( scores[0] );
						break;
					case 3:
						txtScore1.setText( scores[0] );
						txtScore2.setText( scores[2] );
						break;
					case 5:
						txtScore1.setText( scores[0] );
						txtScore2.setText( scores[2] );
						txtScore3.setText( scores[4] );
						break;
					case 7:
						txtScore1.setText( scores[0] );
						txtScore2.setText( scores[2] );
						txtScore3.setText( scores[4] );
						txtScore4.setText( scores[6] );
						break;
					case 9:
						txtScore1.setText( scores[0] );
						txtScore2.setText( scores[2] );
						txtScore3.setText( scores[4] );
						txtScore4.setText( scores[6] );
						txtScore5.setText( scores[8] );
						break;
					case 11:
						txtScore1.setText( scores[0] );
						txtScore2.setText( scores[2] );
						txtScore3.setText( scores[4] );
						txtScore4.setText( scores[6] );
						txtScore5.setText( scores[8] );
						txtScore6.setText( scores[10] );
						break;
				}
			}
		}
	}
	
	class btnActionHandle implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if( e.getSource() == (JButton)btnOK ){
				//提交数据
				String str = lstSportors.getSelectedItem();
				if( str == null || str == "")
					return;
				String[] result = str.split("\\s"); //分解成Token
				String SportorId = result[2];
				
				str = lstSportItems.getSelectedItem();
				if( str == null || str == "" )
					return;
				result = str.split("\\s");
				String SportItemId = result[2];
				
				String scoreAll = txtScore1.getText()+ "	"+
								  txtScore2.getText()+ "	"+
								  txtScore3.getText()+ "	"+
								  txtScore4.getText()+ "	"+
								  txtScore5.getText()+ "	"+
								  txtScore6.getText();
				String Void = "";
				if( chkValid.isSelected() == true ){
					Void = "Y";
				}
				else 
					Void = "N";
				String updateSql = "UPDATE ItemAttend Set Score ='"+ scoreAll + "',"+
									"Void ='" + Void + "' WHERE SPORTORID='" + SportorId + "' "+
									"AND ITEMID='"+SportItemId+"'";
				ItemAttendProxy itemAttendProxy = new ItemAttendProxy();
				itemAttendProxy.UpdateById(updateSql);
				try{
					itemAttendProxy.closeDbConnection();
				}
				catch(SQLException sqlEx){
					
				}
			}
			else if( e.getSource() == (JButton)btnCancel ){
				txtScore1.setText( "" );
				txtScore2.setText( "" );
				txtScore3.setText( "" );
				txtScore4.setText( "" );
				txtScore5.setText( "" );
				txtScore6.setText( "" );
				chkValid.setSelected(false);
			}
		}
	}
}
