package com.nx.kernel.service;

import java.io.Serializable;
import java.util.LinkedHashMap;


public interface NxBaseDAO<T> {
	/**
	 * 獲取記錄總數
	 * @param entityClass 實體類
	 * @return
	 */
	public long getCount();
	/**
	 * 清除一級緩存的數據
	 */
	public void clear();
	/**
	 * 保存實體
	 * @param entity 實體id
	 */
	public void save(T entity);
	/**
	 * 更新實體
	 * @param entity 實體id
	 */
	public void update(T entity);
	/**
	 * 刪除實體
	 * @param entityClass 實體類
	 * @param entityids 實體id數組
	 */
	public void delete(Serializable ... entityids);
	/**
	 * 獲取實體
	 * @param <T>
	 * @param entityClass 實體類
	 * @param entityId 實體id
	 * @return
	 */
	public T find(Serializable entityId);
	/**
	 * 獲取分頁數據
	 * @param <T>
	 * @param entityClass 實體類
	 * @param firstindex 開始索引
	 * @param maxresult 需要獲取的記錄數
	 * @return
	 */
	public NxQueryResult<T> getScrollData(int firstindex, int maxresult, String wherejpql, Object[] queryParams,LinkedHashMap<String, String> orderby);
	
	public NxQueryResult<T> getScrollData(int firstindex, int maxresult, String wherejpql, Object[] queryParams);
	
	public NxQueryResult<T> getScrollData(int firstindex, int maxresult, LinkedHashMap<String, String> orderby);
	
	public NxQueryResult<T> getScrollData(int firstindex, int maxresult);
	
	public NxQueryResult<T> getScrollData();
}
