package com.learn.crm.post.service;

import com.learn.crm.department.domain.CrmDepartment;
import com.learn.crm.post.domain.CrmPost;

import java.util.List;

public interface PostService {

    /**
     *
     * @param department
     * @return
     */
    public List<CrmPost> findAll(CrmDepartment department);
}
