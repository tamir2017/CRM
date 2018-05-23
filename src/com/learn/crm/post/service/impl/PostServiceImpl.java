package com.learn.crm.post.service.impl;

import com.learn.crm.department.domain.CrmDepartment;
import com.learn.crm.post.dao.PostDao;
import com.learn.crm.post.domain.CrmPost;
import com.learn.crm.post.service.PostService;

import java.util.List;

public class PostServiceImpl implements PostService {

    private PostDao postDao;
    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }

    @Override
    public List<CrmPost> findAll(CrmDepartment department) {
        return postDao.findAll(department);
    }
}
