import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class Operation extends JFrame {
		private JMenuItem athleteinf1,matchinf1,worker1,scoreinf1,workerinf1,classinf,collegeinf;
		private JMenuItem athleteinf2,matchinf2,worker2,scoreinf2,workerinf2;
		private JMenuItem athleteinf3,matchinf3,worker3,scoreinf3,workerinf3;
		private JMenuItem matchinf4,scoreinf4,workerinf4;
		JPanel p1;
		JPanel  ainf ,minf;
		public Operation(){
			Font font = new Font("雅黑",Font.PLAIN,12);
			UIManager.put("Button.font", font); 
		    UIManager.put("Label.font", font);
		    UIManager.put("TitledBorder.font", font);
			UIManager.put("ComboBox.font", font);
			UIManager.put("MenuItem.font", font);
			UIManager.put("Menu.font", font);
			UIManager.put("TextField.font", font);
			UIManager.put("CheckBox.font", font);
			UIManager.put("RadioButton.font", font);
			
			
			setVisible(true);
			setSize(400,320);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Dimension size=Toolkit.getDefaultToolkit().getScreenSize();
			Dimension frameSize=this.getSize();
			setLocation((size.width-frameSize.width)/2,(size.height-frameSize.height)/2);
			
			 p1 = new MyJPanel(){
				 protected void paintComponent(Graphics g) {  
		                ImageIcon icon = new ImageIcon("image\\in_background.png");  
		                Image img = icon.getImage();  
		                g.drawImage(img, 0, 0, 400,  
		                        300, icon.getImageObserver());  
		    
		  
		            }  
			 };
			
		add(p1);
		JMenuBar jmb = new JMenuBar();
		setJMenuBar(jmb);
		JMenu insertMenu = new JMenu("录入");
		jmb.add(insertMenu);
		
		JMenu deleteMenu = new JMenu("删除");
		jmb.add(deleteMenu);
		
		JMenu selectMenu = new JMenu("查询");
		jmb.add(selectMenu);
		
		JMenu updateMenu = new JMenu("修改");
		jmb.add(updateMenu);
		
		JMenu tongjiMenu = new JMenu("统计");
		jmb.add(tongjiMenu);
		
		insertMenu.add(athleteinf1 = new JMenuItem("运动员信息"));
		insertMenu.add(matchinf1 = new JMenuItem("比赛信息"));
		insertMenu.add(worker1 = new JMenuItem("项目工作人员"));
		insertMenu.add(scoreinf1 = new JMenuItem("比赛成绩"));
		insertMenu.add(workerinf1 = new JMenuItem("工作人员信息"));
		
		deleteMenu.add(athleteinf2 = new JMenuItem("运动员信息"));
		deleteMenu.add(matchinf2 = new JMenuItem("比赛信息"));
		deleteMenu.add(worker2 = new JMenuItem("项目工作人员"));
		deleteMenu.add(scoreinf2 = new JMenuItem("比赛成绩"));
		deleteMenu.add(workerinf2 = new JMenuItem("工作人员信息"));
		
		selectMenu.add(scoreinf4 = new JMenuItem("比赛成绩"));
		selectMenu.add(matchinf4 = new JMenuItem("比赛信息"));
		
		updateMenu.add(athleteinf3 = new JMenuItem("运动员信息"));
		updateMenu.add(matchinf3 = new JMenuItem("比赛信息"));
		updateMenu.add(scoreinf3 = new JMenuItem("比赛成绩"));
		updateMenu.add(workerinf3 = new JMenuItem("工作人员信息"));
		
		tongjiMenu.add(classinf = new JMenuItem("统计得分"));
		
		//插入运动员信息
		athleteinf1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				remove(p1);
				p1=new Athleteinf(){
					protected void paintComponent(Graphics g) {  
		                ImageIcon icon = new ImageIcon("image\\in_background.png");  
		                Image img = icon.getImage();  
		                g.drawImage(img, 0, 0, 400,  
		                        300, icon.getImageObserver());  
		    
		  
		            }  
				};
				add(p1);
				setVisible(true);
			}
		});
		//插入比赛信息
		matchinf1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				remove(p1);
				p1=new Matchinf(){
					protected void paintComponent(Graphics g) {  
		                ImageIcon icon = new ImageIcon("image\\in_background.png");  
		                Image img = icon.getImage();  
		                g.drawImage(img, 0, 0, 400,  
		                        300, icon.getImageObserver());  
		    
		  
		            }  
				};
				add(p1);				
				setVisible(true);
			}
		});
		worker1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				remove(p1);
				p1=new NewMatch(){
					protected void paintComponent(Graphics g) {  
		                ImageIcon icon = new ImageIcon("image\\in_background.png");  
		                Image img = icon.getImage();  
		                g.drawImage(img, 0, 0, 400,  
		                        300, icon.getImageObserver());  
		    
		  
		            }  
				};
				add(p1);				
				setVisible(true);
			}
		});
		//插入比赛成绩
		scoreinf1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {				
				remove(p1);
				p1=new Scoreinf(){
					protected void paintComponent(Graphics g) {  
		                ImageIcon icon = new ImageIcon("image\\in_background.png");  
		                Image img = icon.getImage();  
		                g.drawImage(img, 0, 0, 400,  
		                        300, icon.getImageObserver());  
		    
		  
		            }  
				};
				add(p1);	
				setVisible(true);
			}
		});
		//插入工作人员信息
		workerinf1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				remove(p1);
				p1=new Workinf(){
					protected void paintComponent(Graphics g) {  
		                ImageIcon icon = new ImageIcon("image\\in_background.png");  
		                Image img = icon.getImage();  
		                g.drawImage(img, 0, 0, 400,  
		                        300, icon.getImageObserver());  
		    
		  
		            }  
				};
				add(p1);	
				setVisible(true);
			}
		});
		//删除运动员信息 
		athleteinf2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				remove(p1);
				p1=new DeleteSport(){
					protected void paintComponent(Graphics g) {  
		                ImageIcon icon = new ImageIcon("image\\in_background.png");  
		                Image img = icon.getImage();  
		                g.drawImage(img, 0, 0, 400,  
		                        300, icon.getImageObserver());  
		    
		  
		            }  
				};
				add(p1);	
				setVisible(true);
			}
		});
		//删除比赛信息
		matchinf2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				remove(p1);
				p1=new DeleteComplete(){
					protected void paintComponent(Graphics g) {  
		                ImageIcon icon = new ImageIcon("image\\in_background.png");  
		                Image img = icon.getImage();  
		                g.drawImage(img, 0, 0, 400,  
		                        300, icon.getImageObserver());  
		    
		  
		            }  
				};
				add(p1);	
				setVisible(true);
			}
		});
		//删除负责
		worker2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				remove(p1);
				p1=new DeleteXiangmu(){
					protected void paintComponent(Graphics g) {  
		                ImageIcon icon = new ImageIcon("image\\in_background.png");  
		                Image img = icon.getImage();  
		                g.drawImage(img, 0, 0, 400,  
		                        300, icon.getImageObserver());  
		    
		  
		            }  
				};
				add(p1);	
				setVisible(true);
			}
		});
		//删除成绩
		scoreinf2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				remove(p1);
				p1=new Deleteattend(){
					protected void paintComponent(Graphics g) {  
		                ImageIcon icon = new ImageIcon("image\\in_background.png");  
		                Image img = icon.getImage();  
		                g.drawImage(img, 0, 0, 400,  
		                        300, icon.getImageObserver());  
		    
		  
		            }  
				};
				add(p1);	
				setVisible(true);
			}
		});
		//删除工作人员
		workerinf2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				remove(p1);
				p1=new DeleteWorker(){
					protected void paintComponent(Graphics g) {  
		                ImageIcon icon = new ImageIcon("image\\in_background.png");  
		                Image img = icon.getImage();  
		                g.drawImage(img, 0, 0, 400,  
		                        300, icon.getImageObserver());  
		    
		  
		            }  
				};
				add(p1);	
				setVisible(true);
			}
		});
		//修改
		athleteinf3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				remove(p1);
				p1=new UpdateSport(){
					protected void paintComponent(Graphics g) {  
		                ImageIcon icon = new ImageIcon("image\\in_background.png");  
		                Image img = icon.getImage();  
		                g.drawImage(img, 0, 0, 400,  
		                        300, icon.getImageObserver());  
		    
		  
		            }  
				};
				add(p1);	
				setVisible(true);
			}
		});
		matchinf3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				remove(p1);
				p1=new UpdateComplete(){
					protected void paintComponent(Graphics g) {  
		                ImageIcon icon = new ImageIcon("image\\in_background.png");  
		                Image img = icon.getImage();  
		                g.drawImage(img, 0, 0, 400,  
		                        300, icon.getImageObserver());  
		    
		  
		            }  
				};
				add(p1);	
				setVisible(true);
			}
		});
		scoreinf3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				remove(p1);
				p1=new Updateattend(){
					protected void paintComponent(Graphics g) {  
		                ImageIcon icon = new ImageIcon("image\\in_background.png");  
		                Image img = icon.getImage();  
		                g.drawImage(img, 0, 0, 400,  
		                        300, icon.getImageObserver());  
		    
		  
		            }  
				};
				add(p1);	
				setVisible(true);
			}
		});
		workerinf3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				remove(p1);
				p1=new UpdateWorker(){
					protected void paintComponent(Graphics g) {  
		                ImageIcon icon = new ImageIcon("image\\in_background.png");  
		                Image img = icon.getImage();  
		                g.drawImage(img, 0, 0, 400,  
		                        300, icon.getImageObserver());  
		    
		  
		            }  
				};
				add(p1);	
				setVisible(true);
			}
		});
		scoreinf4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				remove(p1);
				p1=new QueryInterface(){
					protected void paintComponent(Graphics g) {  
		                ImageIcon icon = new ImageIcon("image\\in_background.png");  
		                Image img = icon.getImage();  
		                g.drawImage(img, 0, 0, 400,  
		                        300, icon.getImageObserver());  
		    
		  
		            }  
				};
				add(p1);	
				setVisible(true);
			}
		});
		matchinf4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				remove(p1);
				p1=new MatchQueryInterface(){
					protected void paintComponent(Graphics g) {  
		                ImageIcon icon = new ImageIcon("image\\in_background.png");  
		                Image img = icon.getImage();  
		                g.drawImage(img, 0, 0, 400,  
		                        300, icon.getImageObserver());  
		    
		  
		            }  
				};
				add(p1);	
				setVisible(true);
			}
		});
//		workerinf4.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e){
//				
//			}
//		});
		classinf.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				remove(p1);
				p1=new StatisticInterface(){
					protected void paintComponent(Graphics g) {  
		                ImageIcon icon = new ImageIcon("image\\in_background.png");  
		                Image img = icon.getImage();  
		                g.drawImage(img, 0, 0, 400,  
		                        300, icon.getImageObserver());  
		    
		  
		            }  
				};
				add(p1);	
				setVisible(true);
			}
		});
		}
//main方法	
	public static void main(String[] args){ 
		JFrame f1 = new Operation();
		
	}
}

