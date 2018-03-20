package com.action;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TYundongyuanDAO;
import com.model.TYundongyuan;
import com.opensymphony.xwork2.ActionSupport;

public class yundongyuanAction extends ActionSupport
{
	private int id;
	private String loginname;
	private String loginpw;
	private String xuehao;
	private String banji;
	private String name;
	private String sex;
	private String age;
	private String tel;
	private String shengtizhuangkuang;
	
	private TYundongyuanDAO yundongyuanDAO;
	private String message;
	private String path;
	
	
	
	public String yundongyuanReg()
	{
		TYundongyuan yundongyuan=new TYundongyuan();
		yundongyuan.setLoginname(loginname);
		yundongyuan.setLoginpw(loginpw) ;
		yundongyuan.setXuehao(xuehao);
		yundongyuan.setBanji(banji);
		yundongyuan.setName(name);
		yundongyuan.setSex(sex);
		yundongyuan.setAge(age);
		yundongyuan.setTel(tel);
		yundongyuan.setDel("no");
		yundongyuan.setShengtizhuangkuang(shengtizhuangkuang);
		yundongyuanDAO.save(yundongyuan);
		return "successAdd";
	}
	
	public String yundongyuanMana()
	{
		//TUser user=userDAO.findById(userId);
		Map request=(Map)ServletActionContext.getContext().get("request");
		//request.put("user", user);
		return ActionSupport.SUCCESS;
	}
	
	
	public String yundongyuanDetail()
	{
		TYundongyuan yundongyuan=yundongyuanDAO.findById(id);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("yundongyuan", yundongyuan);
		System.out.println(yundongyuan.getBanji());
		return ActionSupport.SUCCESS;
	}
	
	
	
	
	public String getAge()
	{
		return age;
	}
	public void setAge(String age)
	{
		this.age = age;
	}
	public String getBanji()
	{
		return banji;
	}
	public void setBanji(String banji)
	{
		this.banji = banji;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getLoginname()
	{
		return loginname;
	}
	public void setLoginname(String loginname)
	{
		this.loginname = loginname;
	}

	public String getLoginpw()
	{
		return loginpw;
	}

	public void setLoginpw(String loginpw)
	{
		this.loginpw = loginpw;
	}

	public String getMessage()
	{
		return message;
	}
	public void setMessage(String message)
	{
		this.message = message;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getPath()
	{
		return path;
	}
	public void setPath(String path)
	{
		this.path = path;
	}
	public String getSex()
	{
		return sex;
	}
	public void setSex(String sex)
	{
		this.sex = sex;
	}
	public String getShengtizhuangkuang()
	{
		return shengtizhuangkuang;
	}
	public void setShengtizhuangkuang(String shengtizhuangkuang)
	{
		this.shengtizhuangkuang = shengtizhuangkuang;
	}
	public String getTel()
	{
		return tel;
	}
	public void setTel(String tel)
	{
		this.tel = tel;
	}
	public String getXuehao()
	{
		return xuehao;
	}
	public void setXuehao(String xuehao)
	{
		this.xuehao = xuehao;
	}
	public TYundongyuanDAO getYundongyuanDAO()
	{
		return yundongyuanDAO;
	}
	public void setYundongyuanDAO(TYundongyuanDAO yundongyuanDAO)
	{
		this.yundongyuanDAO = yundongyuanDAO;
	}
	
}
