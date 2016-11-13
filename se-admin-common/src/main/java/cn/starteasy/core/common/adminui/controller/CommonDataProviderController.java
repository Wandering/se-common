package cn.starteasy.core.common.adminui.controller;

import cn.starteasy.core.common.ServiceManager;
import cn.starteasy.core.common.domain.wrapper.ListWrapper;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 通用的获取远程数据的接口。 主要用于 select 这种控件取数
 * Created by qyang on 2016/11/13.
 */
@Controller
@RequestMapping(value="/admin/common")
public class CommonDataProviderController {
    @Autowired
    private ServiceManager serviceManager;

    @RequestMapping(value="/getdatas/{modelName}")
    @ResponseBody
    public ListWrapper getDatas(@PathVariable("modelName")String modelName){
        Map<String, String> selector = Maps.newHashMap();
        selector.put("id", "id");
        selector.put("name", "name");

        ListWrapper listWrapper = new ListWrapper();
        listWrapper.setLists(serviceManager.getService(modelName).viewList(selector, Maps.newHashMap(), null));
        return listWrapper;
    }
}
