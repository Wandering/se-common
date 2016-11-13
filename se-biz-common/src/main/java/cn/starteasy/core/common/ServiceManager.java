package cn.starteasy.core.common;

import cn.starteasy.core.common.service.IBaseService;
import cn.starteasy.core.common.service.IPersistenceProvider;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 服务管理类 service&facade
 * Created by qyang on 2016/11/11.
 */
@Component
public class ServiceManager {
    protected final Map<String, IBaseService> serviceMap = Maps.newHashMap();
    protected final Map<String, IPersistenceProvider> persistenceProviderMap = Maps.newHashMap();

    public void batchAdd(Map<String, IBaseService> existMap){
        serviceMap.putAll(existMap);
    }

    public IBaseService getService(String model){
        Preconditions.checkNotNull(model);
        return serviceMap.get(model);
    }

    public void batchAddPersistenceProvider(Map<String, IPersistenceProvider> existMap){
        persistenceProviderMap.putAll(existMap);
    }

    public IPersistenceProvider getPersistenceProvider(String model){
        Preconditions.checkNotNull(model);
        return persistenceProviderMap.get(model);
    }
}
