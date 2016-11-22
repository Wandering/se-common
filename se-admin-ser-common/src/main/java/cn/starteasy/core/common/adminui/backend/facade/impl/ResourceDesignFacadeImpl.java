/*
 * Copyright (c) 2013-2014, starteasy Inc. All Rights Reserved.
 * 
 * Project Name: sample
 * $Id:  2016-11-14 17:52:35 $ 
 */
package cn.starteasy.core.common.adminui.backend.facade.impl;

import cn.starteasy.core.common.adminui.backend.domain.Resource;
import cn.starteasy.core.common.adminui.backend.domain.ResourceAction;
import cn.starteasy.core.common.adminui.backend.domain.ResourceGrid;
import cn.starteasy.core.common.adminui.backend.facade.IResourceDesignFacade;
import cn.starteasy.core.common.adminui.backend.service.IResourceActionService;
import cn.starteasy.core.common.adminui.backend.service.IResourceDesignService;
import cn.starteasy.core.common.adminui.backend.service.IResourceGridService;
import cn.starteasy.core.common.adminui.backend.service.IResourceService;
import cn.starteasy.core.common.domain.persistent.SearchEnum;
import cn.starteasy.core.common.domain.persistent.utils.ConditionBuilder;
import cn.starteasy.core.common.exception.BizException;
import cn.starteasy.core.common.service.IBaseService;
import cn.starteasy.core.common.service.impl.AbstractPersistenceProvider;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("ResourceDesignFacadeImpl")
public class ResourceDesignFacadeImpl extends AbstractPersistenceProvider implements IResourceDesignFacade {
    @Autowired
    private IResourceDesignService resourceDesignService;

    @Autowired
    private IResourceService resourceService;

    //正常 他们的逻辑 在  resourceFacade里处理
    @Autowired
    private IResourceGridService resourceGridService;

    @Autowired
    private IResourceActionService resourceActionService;




//    @Transactional(propagation = Propagation.REQUIRED)
//    @Override
//    public void add() {
//        resourceDesignService.add();
//    }

    @Override
    public IBaseService getMainService() {
        return resourceDesignService;
    }


    @Override
    public void verifyData(Map<String, Object> dataMap) {
        super.verifyData(dataMap);
    }

    @Override
    public Object create(Map<String, Object> entityMap) {
        Resource resource = new Resource();
        resource.setUrl("/admin/sample/resource_" + entityMap.get("number"));

        Resource parentResource = null;
        if(!Strings.isNullOrEmpty((String)entityMap.get("parentName"))) {
            parentResource = resourceService.viewOne(null, ConditionBuilder.condition("name", SearchEnum.eq, entityMap.get("parentName")), null);
        } else {
            parentResource = resourceService.viewOne(null, ConditionBuilder.condition("name", SearchEnum.eq, "自定义业务"), null);
        }
        resource.setParentId(Math.toIntExact(parentResource.getId()));
        resource.setBizModelName("resource_" + entityMap.get("number"));
        resource.setName((String)entityMap.get("menuName"));
        resourceService.create(resource);

        //解析sql colid    "select city.id as 'city.id', city.name as 'city.name',  province.name as 'city.provinceId' from sample_city city inner join sample_province province on city.provinceId = province.id"
        List<String> cols = parseSql((String)entityMap.get("mainSql"));

        ResourceGrid resourceGrid = null;
        String[] displayConfigs = ((String)entityMap.get("displayConfig")).split(",");

        if(cols.size() != displayConfigs.length){
            throw new BizException("9222222", "sql字段和显示配置不一致");
        }

        int i = 0;
        for(String displayConfig : displayConfigs) {
            resourceGrid = new ResourceGrid();
            resourceGrid.setDisplayName(displayConfig);
            resourceGrid.setColId(cols.get(i));
            resourceGrid.setResId(Math.toIntExact(resource.getId()));
            resourceGrid.setOrderNum(0);
            resourceGrid.setWidth(200);
            resourceGrid.setEditable("true");
            resourceGrid.setEditoptions("{}");
            resourceGrid.setEditrules("{}");
            resourceGrid.setModuleName("resource_" + entityMap.get("number"));

            //根据displayConfig 设置displayName
            resourceGridService.create(resourceGrid);
            i++;
        }

        ResourceAction resourceAction = new ResourceAction();
        resourceAction.setName("新增");
        resourceAction.setActionAlias("add");
        resourceAction.setResourceId(Math.toIntExact(resource.getId()));

        resourceActionService.create(resourceAction);

        entityMap.put("resourceId", Math.toIntExact(resource.getId()));
        return super.create(entityMap);
    }

    @Override
    public int edit(Map<String, Object> entityMap) {
        return super.edit(entityMap);
    }

    private List<String> parseSql(String sql){
        String select = sql.substring(7, sql.indexOf("from"));

        String[] selectors = select.split(",");
        String[] keys;
        String col;
        List<String> cols = Lists.newArrayList();
        for(String selector : selectors){
            keys = selector.split("as");

            col = keys[1].trim().replaceAll("'", "");
            cols.add(col);
        }

        return cols;
    }
}
