package com.learn.crm.classes.service;

import com.learn.crm.classes.domain.CrmClasses;

import java.util.List;

public interface ClassesService {

    /**
     * 查询所有
     * @return
     */
    public List<CrmClasses> findAll();

    /**
     *通过ID查询
     * @param classesId
     * @return
     */
    public CrmClasses findById(String classesId);

    void updateUpload(CrmClasses model);
}
