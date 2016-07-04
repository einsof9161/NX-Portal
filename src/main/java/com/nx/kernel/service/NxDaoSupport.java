package com.nx.kernel.service;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nx.kernel.utils.GenericsUtils;



@SuppressWarnings("unchecked")
@Transactional
public abstract class NxDaoSupport<T> implements NxBaseDAO<T>{
	
	private final Class<T> persistentClass;

	@SuppressWarnings("unchecked")
	public NxDaoSupport(){
		
		this.persistentClass =GenericsUtils.getSuperClassGenricType(this.getClass());
		System.out.println("######this.persistentClass......"+this.persistentClass.getName());
	}
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession(){
		return sessionFactory.openSession();
	}
	
	public void clear(){
		getSession().clear();
	}

	public void delete(Serializable ... entityids) {
		for(Serializable id : entityids){
			getSession().delete(getSession().get(this.persistentClass, id));
		}
	}
	
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public T find(Serializable entityId) {
		if(entityId==null) throw new RuntimeException(this.persistentClass.getName()+ ":傳入的實體id不能為空");
		return (T) getSession().get(this.persistentClass, entityId);
	}

	public void save(T entity) {
		getSession().save(entity);
	}
	
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public long getCount() {
		return ((Integer)getSession().createQuery(
					"select count("+ getCountField(this.persistentClass) +") from "
					+ getEntityName(this.persistentClass)+ " o").iterate().next()).intValue();
	}
	
	public void update(T entity) {
		getSession().update(entity);
	}
	
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public NxQueryResult<T> getScrollData(int firstindex, int maxresult, LinkedHashMap<String, String> orderby) {
		return getScrollData(firstindex,maxresult,null,null,orderby);
	}
	
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public NxQueryResult<T> getScrollData(int firstindex, int maxresult, String wherejpql, Object[] queryParams) {
		return getScrollData(firstindex,maxresult,wherejpql,queryParams,null);
	}
	
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public NxQueryResult<T> getScrollData(int firstindex, int maxresult) {
		return getScrollData(firstindex,maxresult,null,null,null);
	}
	
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public NxQueryResult<T> getScrollData() {
		return getScrollData(-1, -1);
	}

	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public NxQueryResult<T> getScrollData(int firstindex, int maxresult, String wherejpql, Object[] queryParams,LinkedHashMap<String, String> orderby) {
		NxQueryResult qr = new NxQueryResult<T>();
		String entityname = getEntityName(this.persistentClass);
		Query query = getSession().createQuery("select o from "+ entityname+ " o "+(wherejpql==null || "".equals(wherejpql.trim())? "": "where "+ wherejpql)+ buildOrderby(orderby));
		setQueryParams(query, queryParams);
		if(firstindex!=-1 && maxresult!=-1) query.setFirstResult(firstindex).setMaxResults(maxresult);
		qr.setResultlist(query.list());
		query = getSession().createQuery("select count("+ getCountField(this.persistentClass)+ ") from "+ entityname+ " o "+(wherejpql==null || "".equals(wherejpql.trim())? "": "where "+ wherejpql));
		setQueryParams(query, queryParams);
		qr.setTotalrecord((Long)query.uniqueResult());
		return qr;
	}
	
	protected static void setQueryParams(Query query, Object[] queryParams){
		if(queryParams!=null && queryParams.length>0){
			for(int i=0; i<queryParams.length; i++){
				query.setParameter(i+1, queryParams[i]);
			}
		}
	}
	
	/**
	 * 組裝order by語句
	 * @param orderby
	 * @return
	 */
	protected static String buildOrderby(LinkedHashMap<String, String> orderby){
		StringBuffer orderbyql = new StringBuffer("");
		if(orderby!=null && orderby.size()>0){
			orderbyql.append(" order by ");
			for(String key : orderby.keySet()){
				orderbyql.append("o.").append(key).append(" ").append(orderby.get(key)).append(",");
			}
			orderbyql.deleteCharAt(orderbyql.length()-1);
		}
		return orderbyql.toString();
	}
	/**
	 * 獲取實體的名稱
	 * @param <E>
	 * @param clazz 實體類
	 * @return
	 */
	protected static <E> String getEntityName(Class<E> clazz){
		String entityname = clazz.getSimpleName();
		Entity entity = clazz.getAnnotation(Entity.class);
		if(entity.name()!=null && !"".equals(entity.name())){
			entityname = entity.name();
		}
		return entityname;
	}
	/**
	 * 獲取統計屬性,該方法是為瞭解決hibernate解析聯合主鍵
	 * select count(o) from Xxx o語句BUG而增加,hibernate對此jpql解析後的sql為select count(field1,field2,...),顯示使用count()統計多個字段是錯誤的
	 * @param <E>
	 * @param clazz
	 * @return
	 */
	protected static <E> String getCountField(Class<E> clazz){
		String out = "o";
		try {
			PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(clazz).getPropertyDescriptors();
			for(PropertyDescriptor propertydesc : propertyDescriptors){
				Method method = propertydesc.getReadMethod();
				if(method!=null && method.isAnnotationPresent(EmbeddedId.class)){					
					PropertyDescriptor[] ps = Introspector.getBeanInfo(propertydesc.getPropertyType()).getPropertyDescriptors();
					out = "o."+ propertydesc.getName()+ "." + (!ps[1].getName().equals("class")? ps[1].getName(): ps[0].getName());
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        return out;
	}
}
