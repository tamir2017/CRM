package com.learn.crm.post.dao;

import com.learn.crm.department.domain.CrmDepartment;
import com.learn.crm.post.domain.CrmPost;

import java.util.List;

public interface PostDao {

    /**
     *
     * @param department
     * @return
     */
    public List<CrmPost> findAll(CrmDepartment department);
}
