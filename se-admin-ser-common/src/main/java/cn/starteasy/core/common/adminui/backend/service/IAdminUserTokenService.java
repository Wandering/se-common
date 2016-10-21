/*
 * Copyright (c) 2013-2014, starteasy Inc. All Rights Reserved.
 * 
 * Project Name: lms
 * $Id:  2016-10-21 19:09:57 $ 
 */



package cn.starteasy.core.common.adminui.backend.service;
import cn.starteasy.core.common.adminui.backend.dao.IAdminUserTokenDAO;
import cn.starteasy.core.common.adminui.backend.domain.AdminUserToken;
import cn.starteasy.core.common.service.IBaseService;
import cn.starteasy.core.common.service.IPageService;

public interface IAdminUserTokenService extends IBaseService<Integer, IAdminUserTokenDAO, AdminUserToken>,IPageService<IAdminUserTokenDAO, AdminUserToken>{

}
