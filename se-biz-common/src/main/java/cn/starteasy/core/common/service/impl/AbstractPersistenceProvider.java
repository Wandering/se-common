package cn.starteasy.core.common.service.impl;


import cn.starteasy.core.common.dao.IBaseDAO;
import cn.starteasy.core.common.domain.BaseDomain;
import cn.starteasy.core.common.service.IBaseService;
import cn.starteasy.core.common.service.IPersistenceProvider;

import java.util.List;
import java.util.Map;

/**
 * TODO 一句话描述该类用途
 * <p/>
 * 创建时间: 16/1/10 上午11:43<br/>
 *
 * @author qyang
 * @since v0.0.1
 */
public abstract class AbstractPersistenceProvider implements IPersistenceProvider {

    @Override
    public void verifyData(Map<String, Object> dataMap) {

    }

    @Override
    public Object create(Map<String, Object> entityMap) {
        return getMainService().create(entityMap);
    }

    @Override
    public int edit(Map<String, Object> entityMap) {
        return getMainService().edit(entityMap);
    }
}
