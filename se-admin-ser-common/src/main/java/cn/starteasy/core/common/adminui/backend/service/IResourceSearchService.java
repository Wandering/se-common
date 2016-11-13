/*
 * Copyright (c) 2013-2014, starteasy Inc. All Rights Reserved.
 * 
 * Project Name: sample
 * $Id:  2016-11-13 15:07:13 $ 
 */



package cn.starteasy.core.common.adminui.backend.service;
import cn.starteasy.core.common.adminui.backend.dao.IResourceSearchDAO;
import cn.starteasy.core.common.adminui.backend.domain.ResourceSearch;
import cn.starteasy.core.common.service.IBaseService;
import cn.starteasy.core.common.service.IPageService;


public interface IResourceSearchService extends IBaseService<Integer, IResourceSearchDAO, ResourceSearch>,IPageService<IResourceSearchDAO, ResourceSearch>{

}
