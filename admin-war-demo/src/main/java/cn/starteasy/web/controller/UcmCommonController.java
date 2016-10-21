/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: basedata
 * $Id:  ClassesController.java 2015-07-29 12:04:59 $
 */

package cn.starteasy.web.controller;

import cn.starteasy.core.common.adminui.controller.AbstractCommonController;
import cn.starteasy.core.common.adminui.controller.helpers.BasePersistenceProviderMaps;
import cn.starteasy.core.common.adminui.controller.helpers.BaseServiceMaps;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("prototype")
@RequestMapping(value="/admin/ucm")
public class UcmCommonController extends AbstractCommonController {
//    @Autowired
//    private ServiceMaps serviceMaps;

    @Override
    protected BaseServiceMaps getServiceMaps() {
        return null;
    }



    @Override
    protected BasePersistenceProviderMaps getPersistenceProviderMaps() {
        return null;
    }

//    @Override
//    protected IBaseService getExportService() {
//        return null;
//    }

    @Override
    public boolean getEnableDataPerm() {
        return false;
    }
}
