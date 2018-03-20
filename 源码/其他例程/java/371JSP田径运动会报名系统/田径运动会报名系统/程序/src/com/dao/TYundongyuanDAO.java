package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TYundongyuan;

/**
 * Data access object (DAO) for domain model class TYundongyuan.
 * 
 * @see com.model.TYundongyuan
 * @author MyEclipse Persistence Tools
 */

public class TYundongyuanDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TYundongyuanDAO.class);

	// property constants
	public static final String LOGINNAME = "loginname";

	public static final String LOGIN_PW = "loginPw";

	public static final String XUEHAO = "xuehao";

	public static final String BANJI = "banji";

	public static final String NAME = "name";

	public static final String SEX = "sex";

	public static final String AGE = "age";

	public static final String TEL = "tel";

	public static final String SHENGTIZHUANGKUANG = "shengtizhuangkuang";

	public static final String DEL = "del";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TYundongyuan transientInstance)
	{
		log.debug("saving TYundongyuan instance");
		try
		{
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re)
		{
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TYundongyuan persistentInstance)
	{
		log.debug("deleting TYundongyuan instance");
		try
		{
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re)
		{
			log.error("delete failed", re);
			throw re;
		}
	}

	public TYundongyuan findById(java.lang.Integer id)
	{
		log.debug("getting TYundongyuan instance with id: " + id);
		try
		{
			TYundongyuan instance = (TYundongyuan) getHibernateTemplate().get(
					"com.model.TYundongyuan", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TYundongyuan instance)
	{
		log.debug("finding TYundongyuan instance by example");
		try
		{
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re)
		{
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value)
	{
		log.debug("finding TYundongyuan instance with property: "
				+ propertyName + ", value: " + value);
		try
		{
			String queryString = "from TYundongyuan as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByLoginname(Object loginname)
	{
		return findByProperty(LOGINNAME, loginname);
	}

	public List findByLoginPw(Object loginPw)
	{
		return findByProperty(LOGIN_PW, loginPw);
	}

	public List findByXuehao(Object xuehao)
	{
		return findByProperty(XUEHAO, xuehao);
	}

	public List findByBanji(Object banji)
	{
		return findByProperty(BANJI, banji);
	}

	public List findByName(Object name)
	{
		return findByProperty(NAME, name);
	}

	public List findBySex(Object sex)
	{
		return findByProperty(SEX, sex);
	}

	public List findByAge(Object age)
	{
		return findByProperty(AGE, age);
	}

	public List findByTel(Object tel)
	{
		return findByProperty(TEL, tel);
	}

	public List findByShengtizhuangkuang(Object shengtizhuangkuang)
	{
		return findByProperty(SHENGTIZHUANGKUANG, shengtizhuangkuang);
	}

	public List findByDel(Object del)
	{
		return findByProperty(DEL, del);
	}

	public List findAll()
	{
		log.debug("finding all TYundongyuan instances");
		try
		{
			String queryString = "from TYundongyuan";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TYundongyuan merge(TYundongyuan detachedInstance)
	{
		log.debug("merging TYundongyuan instance");
		try
		{
			TYundongyuan result = (TYundongyuan) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TYundongyuan instance)
	{
		log.debug("attaching dirty TYundongyuan instance");
		try
		{
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TYundongyuan instance)
	{
		log.debug("attaching clean TYundongyuan instance");
		try
		{
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TYundongyuanDAO getFromApplicationContext(
			ApplicationContext ctx)
	{
		return (TYundongyuanDAO) ctx.getBean("TYundongyuanDAO");
	}
}