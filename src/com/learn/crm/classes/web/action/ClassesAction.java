package com.learn.crm.classes.web.action;

import com.learn.crm.base.BaseAction;
import com.learn.crm.classes.domain.CrmClasses;

import java.util.List;

public class ClassesAction extends BaseAction<CrmClasses> {

    /**
     * 查询所有
     * @return
     */
    public String findAll(){
        List<CrmClasses> allClasses =  this.getClassesService().findAll();
        this.set("allClasses",allClasses);
        return "findAll";
    }
}
