package com.learn.crm.classes.service;

import com.learn.crm.classes.domain.CrmClasses;

import java.util.List;

public interface ClassesService {

    /**
     * 查询所有
     * @return
     */
    public List<CrmClasses> findAll();
}
