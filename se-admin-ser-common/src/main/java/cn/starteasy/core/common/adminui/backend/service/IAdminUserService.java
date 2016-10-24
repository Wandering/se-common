/*
 * Copyright (c) 2013-2014, starteasy Inc. All Rights Reserved.
 * 
 * Project Name: lms
 * $Id:  2016-10-21 19:10:00 $ 
 */



package cn.starteasy.core.common.adminui.backend.service;
import cn.starteasy.core.common.adminui.backend.dao.IAdminUserDAO;
import cn.starteasy.core.common.adminui.backend.domain.AdminUser;
import cn.starteasy.core.common.service.IBaseService;
import cn.starteasy.core.common.service.IPageService;

public interface IAdminUserService extends IBaseService<Long, IAdminUserDAO, AdminUser>,IPageService<IAdminUserDAO, AdminUser>{

}
