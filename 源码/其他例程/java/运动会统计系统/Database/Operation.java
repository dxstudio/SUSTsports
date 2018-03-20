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
			Font font = new Font("�ź�",Font.PLAIN,12);
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
		JMenu insertMenu = new JMenu("¼��");
		jmb.add(insertMenu);
		
		JMenu deleteMenu = new JMenu("ɾ��");
		jmb.add(deleteMenu);
		
		JMenu selectMenu = new JMenu("��ѯ");
		jmb.add(selectMenu);
		
		JMenu updateMenu = new JMenu("�޸�");
		jmb.add(updateMenu);
		
		JMenu tongjiMenu = new JMenu("ͳ��");
		jmb.add(tongjiMenu);
		
		insertMenu.add(athleteinf1 = new JMenuItem("�˶�Ա��Ϣ"));
		insertMenu.add(matchinf1 = new JMenuItem("������Ϣ"));
		insertMenu.add(worker1 = new JMenuItem("��Ŀ������Ա"));
		insertMenu.add(scoreinf1 = new JMenuItem("�����ɼ�"));
		insertMenu.add(workerinf1 = new JMenuItem("������Ա��Ϣ"));
		
		deleteMenu.add(athleteinf2 = new JMenuItem("�˶�Ա��Ϣ"));
		deleteMenu.add(matchinf2 = new JMenuItem("������Ϣ"));
		deleteMenu.add(worker2 = new JMenuItem("��Ŀ������Ա"));
		deleteMenu.add(scoreinf2 = new JMenuItem("�����ɼ�"));
		deleteMenu.add(workerinf2 = new JMenuItem("������Ա��Ϣ"));
		
		selectMenu.add(scoreinf4 = new JMenuItem("�����ɼ�"));
		selectMenu.add(matchinf4 = new JMenuItem("������Ϣ"));
		
		updateMenu.add(athleteinf3 = new JMenuItem("�˶�Ա��Ϣ"));
		updateMenu.add(matchinf3 = new JMenuItem("������Ϣ"));
		updateMenu.add(scoreinf3 = new JMenuItem("�����ɼ�"));
		updateMenu.add(workerinf3 = new JMenuItem("������Ա��Ϣ"));
		
		tongjiMenu.add(classinf = new JMenuItem("ͳ�Ƶ÷�"));
		
		//�����˶�Ա��Ϣ
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
		//���������Ϣ
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
		//��������ɼ�
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
		//���빤����Ա��Ϣ
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
		//ɾ���˶�Ա��Ϣ 
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
		//ɾ��������Ϣ
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
		//ɾ������
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
		//ɾ���ɼ�
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
		//ɾ��������Ա
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
		//�޸�
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
//main����	
	public static void main(String[] args){ 
		JFrame f1 = new Operation();
		
	}
}

