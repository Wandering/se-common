/*
 * Copyright (c) 2013-2014, starteasy Inc. All Rights Reserved.
 * 
 * Project Name: lms
 * $Id:  2016-10-21 19:10:23 $ 
 */



package cn.starteasy.core.common.adminui.backend.service;
import cn.starteasy.core.common.adminui.backend.dao.IUserDAO;
import cn.starteasy.core.common.adminui.backend.domain.User;
import cn.starteasy.core.common.service.IBaseService;
import cn.starteasy.core.common.service.IPageService;

public interface IUserService extends IBaseService<Integer, IUserDAO, User>,IPageService<IUserDAO, User>{

}
