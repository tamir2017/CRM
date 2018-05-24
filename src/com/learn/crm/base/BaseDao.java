package com.learn.crm.base;

import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface BaseDao<T> {

    public void save(T t);
    public void update(T t);
    public void delete(T t);
    public void saveOrUpdate(T t);

    public T findById(java.io.Serializable id);
    public List<T> findAll();

    public List<T> findAll(String condition, Object[] params);

    /**
     * 分页，查询总记录数
     * @param condition
     * @param params
     * @return
     */
    public int getTotalRecord(String condition, Object[] params);

    /**
     * 分页，查询结果
     * @param condition
     * @param params
     * @param startIndex
     * @param pageSize
     * @return
     */
    public List<T> findAll(String condition, Object[] params, int startIndex, int pageSize);

    /**
     * 离线条件查询，使用QBC
     * @param criteria
     * @return
     */
    public List<T> findAll(DetachedCriteria criteria);

    public List<T> findAll(DetachedCriteria criteria, int startIndex, int pageSize);
}
