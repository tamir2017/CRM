package com.learn.crm.web.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor {

    @Override
    public String doIntercept(ActionInvocation actionInvocation) throws Exception {
        Object obj = ActionContext.getContext().getSession().get("loginStaff");
        if (obj == null){
            /**
             * friendly information
             */
            Object action = actionInvocation.getAction();
            if (action instanceof ActionSupport){
                ActionSupport actionSupport = (ActionSupport) action;
                actionSupport.addFieldError("","请登录");
            }

            return "login";
        }
        return actionInvocation.invoke();
    }
}
