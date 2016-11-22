package cn.starteasy.core.common.adminui.controller.helpers;


import cn.starteasy.core.common.facade.ICommonMultiModelFacade;
import cn.starteasy.core.common.service.IBaseService;
import cn.starteasy.core.common.service.IPersistenceProvider;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * TODO 一句话描述该类用途
 * <p/>
 * 创建时间: 16/1/10 上午11:11<br/>
 *
 * @author qyang
 * @since v0.0.1
 */
public class BasePersistenceProviderMaps {
    protected final Map<String, IPersistenceProvider> providerMap = Maps.newHashMap();

    @Autowired
    private ICommonMultiModelFacade commonMultiModelFacade;
    private String RES_PREFIX = "resource_";

    protected void init() {
        providerMap.put(RES_PREFIX, commonMultiModelFacade);
    }

    public IPersistenceProvider get(BaseServiceMaps serviceMaps, String mainObj){
        if(mainObj.startsWith(RES_PREFIX)){
            return providerMap.get(RES_PREFIX);
        }
        IPersistenceProvider persistenceProvider = providerMap.get(mainObj);
        if(persistenceProvider != null){
            return persistenceProvider;
        }
        return serviceMaps.get(mainObj);
    }

    public IPersistenceProvider get(String mainObj){
        return providerMap.get(mainObj);
    }
}
