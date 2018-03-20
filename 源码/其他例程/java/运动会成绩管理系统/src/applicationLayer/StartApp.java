package applicationLayer;
import javax.swing.*;
import proxyLayer.*;
import roles.*;
import java.awt.*;
import java.awt.event.*;

public class StartApp {
	private JButton jbtLogin;
	private JButton jbtAnonymous;
	private JTextField jtxtUser;
	private JPasswordField jtxtPass;
	private JComboBox jcmbIdentify;
	private LoginEvtHandle evtHandle;	
	public void InitUI(){
		JFrame LoginBoard = new JFrame("运动会管理系统");
		JPanel jplUserLogin = new JPanel();
		JLabel jblUser = new JLabel("用户名：");
		jtxtUser = new JTextField(10);
		JLabel jblPass = new JLabel("密   码：");
		jtxtPass = new JPasswordField(10);
		JLabel jblIdentify = new JLabel("身  份：");
		jcmbIdentify = new JComboBox(UserRole.getAllRoles());
		jcmbIdentify.setSize(jtxtUser.getWidth(),1);
		jbtLogin = new JButton("登录");	
		jbtAnonymous = new JButton("匿名登录");
		if( evtHandle == null )
			evtHandle = new LoginEvtHandle();
		jbtLogin.addActionListener( evtHandle );
		jbtAnonymous.addActionListener( evtHandle );
		
		GridLayout gridLayout = new GridLayout(4,2);
		FlowLayout flowLayout = new FlowLayout();
		gridLayout.setVgap(2);
		LoginBoard.setLayout( flowLayout );
		LoginBoard.add( jblUser );
		LoginBoard.add( jtxtUser );
		LoginBoard.add( jblPass );
		LoginBoard.add( jtxtPass );
		LoginBoard.add( jblIdentify );
		LoginBoard.add( jcmbIdentify );
		LoginBoard.add( jbtLogin );		
		LoginBoard.add( jbtAnonymous );	
		LoginBoard.setLocation(200,200);
		LoginBoard.setSize(200,160);
		LoginBoard.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*根据需要，打开下面运行开关*/
		
		/*主登录窗口界面
		StartApp mainForm = new StartApp();
		mainForm.InitUI();
		*/
		
		//运动员管理模块
		//new SportorManagement();
		//
		
		//运动员成绩管理模块
		new SportorScoreManagement();
		//
		
		//系统人员管理模块
		 new SysUserManagement();
		//
	}
	public class LoginEvtHandle implements ActionListener{
		public void actionPerformed(ActionEvent e){
			try{
				if( (JButton)e.getSource() == jbtLogin ){
					//根据用户登录身份，转向对应的界面
					String UserName = jtxtUser.getText().trim();
					String Password = jtxtPass.getText().toString();
					EnumRole role = UserRole.getUserRole( jcmbIdentify.getSelectedItem().toString().trim() );
					System.out.println("UserName:" + UserName + " Password:" +
							Password + " " + "Role :" + role);
					if( role == EnumRole.NOROLE ){
						JOptionPane.showMessageDialog(null,"用户角色未设定，请单击匿名登录访问系统！","错误",JOptionPane.ERROR_MESSAGE);
						return;
					}
					else if( role == EnumRole.NOTSUPPORT ){
						JOptionPane.showMessageDialog(null,"用户角色不支持，请联系管理员！","错误",JOptionPane.ERROR_MESSAGE);
						return;
					}
					else if( role == EnumRole.SYSADMINISTRATOR ){
						//连接数据库，验证是否管理人员
						RoleAccessProxy roleProxy = new RoleAccessProxy();
						if( roleProxy.ValidateUserExist(UserName,Password,RoleIdMapRoleName.SYSADMIN) == true )
							JOptionPane.showMessageDialog(null,"登录成功！","正确",JOptionPane.INFORMATION_MESSAGE);
						else
						{	JOptionPane.showMessageDialog(null,"用户角色不支持，请联系管理员！","错误",JOptionPane.ERROR_MESSAGE);
							System.exit( - 1 );
						}
					}
					else if( role == EnumRole.SYSOPERATOR ){
						//连接数据库，验证是否系统操作人员并转到相应界面
						RoleAccessProxy roleProxy = new RoleAccessProxy();
						if( roleProxy.ValidateUserExist(UserName,Password,RoleIdMapRoleName.SYSOPERATOR) == true )
							JOptionPane.showMessageDialog(null,"登录成功！","正确",JOptionPane.INFORMATION_MESSAGE);
						else
						{
							JOptionPane.showMessageDialog(null,"用户角色不支持，请联系管理员！","错误",JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
					else{
						JOptionPane.showMessageDialog(null,"发生未知错误！","错误",JOptionPane.ERROR_MESSAGE );
						return;
					}
				}
				else if( (JButton)e.getSource() == jbtAnonymous ){
					System.out.println("Anonymous");
				}
				else
					System.out.println("Unsupported!");
			}
			catch(Exception ex){
				System.out.println("Unknow Exception: "+ ex.getMessage() );
				
			}
		}
	}
}
