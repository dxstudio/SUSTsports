package roles;

import applicationLayer.EnumRole;

public final class UserRole {
	private static String NOROLE = "";
	private static String SYSADMIN = "系统管理员";
	private static String SYSOPER = "系统操作员";
	
	public static String[] getAllRoles(){
		String[] roles = new String[]{NOROLE,SYSADMIN,SYSOPER};		
		return roles;
	}
	
	public static EnumRole getUserRole(String role){
		if( role.equals( UserRole.NOROLE ) ){
			return EnumRole.NOROLE;
		}
		else if( role.equals( UserRole.SYSADMIN )){
			return EnumRole.SYSADMINISTRATOR;
		}
		else if( role.equals( UserRole.SYSOPER )){
			return EnumRole.SYSOPERATOR;
		}
		else
			return EnumRole.NOTSUPPORT;
	}
}
