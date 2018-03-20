package modules;
public class SysUser extends GenericUser{
	private String SysUserId;
	private String Password;
	private String RoleId;
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getRoleId() {
		return RoleId;
	}
	public void setRoleId(String roleId) {
		RoleId = roleId;
	}
	public String getSysUserId() {
		return SysUserId;
	}
	public void setSysUserId(String sysUserId) {
		SysUserId = sysUserId;
	}
}
