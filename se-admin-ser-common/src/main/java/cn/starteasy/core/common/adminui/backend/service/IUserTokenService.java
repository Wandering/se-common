/*
 * Copyright (c) 2013-2014, starteasy Inc. All Rights Reserved.
 * 
 * Project Name: lms
 * $Id:  2016-10-21 19:10:24 $ 
 */



package cn.starteasy.core.common.adminui.backend.service;
import cn.starteasy.core.common.adminui.backend.dao.IUserTokenDAO;
import cn.starteasy.core.common.adminui.backend.domain.UserToken;
import cn.starteasy.core.common.service.IBaseService;
import cn.starteasy.core.common.service.IPageService;

public interface IUserTokenService extends IBaseService<Integer, IUserTokenDAO, UserToken>,IPageService<IUserTokenDAO, UserToken>{

}
