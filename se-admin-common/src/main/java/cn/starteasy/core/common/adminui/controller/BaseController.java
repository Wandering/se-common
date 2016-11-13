/*
 * Copyright (c) 2013-2014, starteasy Inc. All Rights Reserved.
 * 
 * Project Name: sample
 * $Id:  2016-11-10 21:12:10 $ 
 */
package cn.starteasy.core.common.adminui.controller;

import cn.starteasy.core.common.adminui.backend.domain.Resource;
import cn.starteasy.core.common.adminui.backend.domain.ResourceGrid;
import cn.starteasy.core.common.adminui.controller.helpers.MenuUtils;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public abstract class BaseController<T> extends AbstractAdminController {



    @Override
    protected void enhanceModelAndView(HttpServletRequest request, ModelAndView mav) {

        List<Resource> resourceList = (List) mav.getModel().get("resources");
        mav.addObject("resources", MenuUtils.getTreeMenu(resourceList));

        List<ResourceGrid> resourceGridList = (List) mav.getModel().get("cols");
        MenuUtils.setGridValue(resourceGridList);
        mav.addObject("cols", resourceGridList);

        mav.addObject("current_userName", "");
     }

}
