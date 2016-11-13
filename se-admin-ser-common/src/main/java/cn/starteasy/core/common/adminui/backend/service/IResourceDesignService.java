/*
 * Copyright (c) 2013-2014, starteasy Inc. All Rights Reserved.
 * 
 * Project Name: sample
 * $Id:  2016-11-13 15:07:11 $ 
 */



package cn.starteasy.core.common.adminui.backend.service;
import cn.starteasy.core.common.adminui.backend.dao.IResourceDesignDAO;
import cn.starteasy.core.common.adminui.backend.domain.ResourceDesign;
import cn.starteasy.core.common.service.IBaseService;
import cn.starteasy.core.common.service.IPageService;


public interface IResourceDesignService extends IBaseService<Long, IResourceDesignDAO, ResourceDesign>,IPageService<IResourceDesignDAO, ResourceDesign>{

}
