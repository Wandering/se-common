package cn.starteasy.core.common.facade.impl;

import cn.starteasy.core.common.ServiceManager;
import cn.starteasy.core.common.facade.ICommonMultiModelFacade;
import cn.starteasy.core.common.service.IBaseService;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by qyang on 2016/11/11.
 */
@Service("CommonMultiModelFacadeImpl")
public class CommonMultiModelFacadeImpl implements ICommonMultiModelFacade {
    @Autowired
    private ServiceManager serviceManager;

    @Override
    public IBaseService getMainService() {
        return null;
    }

    @Override
    public void verifyData(Map<String, Object> dataMap) {

    }

    @Override
    public Object create(Map<String, Object> entityMap) {
        //只支持两级级联 平铺map改成嵌套map
        Map<String, Map<String, Object>> nestedMap = Maps.newHashMap();
        Map<String, Object> innerMap = null;

        String[] keys;
        String mainEntity = null;
        if(entityMap.get("_mainObj_") != null){
            mainEntity = ((String)entityMap.get("_mainObj_")).replace("resource_", "");
        }
        for(Map.Entry<String, Object> entry : entityMap.entrySet()){
            if(entry.getKey().contains(".")){
                keys = entry.getKey().split("\\.");
                innerMap = nestedMap.get(keys[0]);
                if(innerMap == null) {
                    innerMap = Maps.newHashMap();
                    nestedMap.put(keys[0], innerMap);
                }
                innerMap.put(keys[1], entry.getValue());
            } else {
                //主对象属性值
                innerMap = nestedMap.get(mainEntity);
                if(innerMap == null) {
                    innerMap = Maps.newHashMap();
                    nestedMap.put(mainEntity, innerMap);
                }
                innerMap.put(entry.getKey(), entry.getValue());

            }
        }

        //一对一的处理方式
        Object id = null;
        for(String key : nestedMap.keySet()){
            id = serviceManager.getService(key).create(nestedMap.get(key));
        }

        return id;
    }

    @Override
    public int edit(Map<String, Object> entityMap) {
        //只支持两级级联 平铺map改成嵌套map
        Map<String, Map<String, Object>> nestedMap = Maps.newHashMap();
        Map<String, Object> innerMap = null;

        String[] keys;
        for(Map.Entry<String, Object> entry : entityMap.entrySet()){
            if(entry.getKey().contains(".")){
                keys = entry.getKey().split(".");
                innerMap = nestedMap.get(keys[0]);
                if(innerMap != null) {
                    innerMap = Maps.newHashMap();
                    nestedMap.put(keys[0], innerMap);
                }
                innerMap.put(keys[1], nestedMap.get(keys[0]));
            }
        }

        //一对一的处理方式
        int id = 0;
        for(String key : nestedMap.keySet()){
            id = serviceManager.getService(key).edit(nestedMap.get(key));
        }

        return id;

    }
}
