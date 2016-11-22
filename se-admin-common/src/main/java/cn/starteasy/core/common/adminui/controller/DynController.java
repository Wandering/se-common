package cn.starteasy.core.common.adminui.controller;

import cn.starteasy.core.common.adminui.backend.domain.ResourceDesign;
import cn.starteasy.core.common.adminui.backend.service.IDataModelService;
import cn.starteasy.core.common.adminui.backend.service.IResourceDesignService;
import cn.starteasy.core.common.domain.persistent.SearchEnum;
import cn.starteasy.core.common.domain.persistent.utils.ConditionBuilder;
import cn.starteasy.core.common.domain.view.BizData4Page;
import cn.starteasy.core.common.service.IPageService;
import cn.starteasy.core.common.utils.BizData4PageBuilder;

import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.Magic;
import com.github.abel533.echarts.code.Tool;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.feature.MagicType;
import com.github.abel533.echarts.series.Line;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 *
 * 动态报表的实现
 *
 * Created by qyang on 2016/11/10.
 */
public class DynController extends BaseController<IDataModelService>{
    @Autowired
    private IResourceDesignService resourceDesignService;

    protected String mainObjName;
    protected String viewTitle = "";

    public static final String link = "_";
    protected final String rpModePrefix = "report";
    protected final String rsModePrefix = "resource";
    private static final String viewPrefix = "module/dyn";
    private static final String number = "number";

    /**
     *
     * @param typeName  取值 rpModePrefix 或 rsModePrefix
     * @param rpCode
     * @param request
     * @param response
     * @return
     */
    protected final ModelAndView mainRender(String typeName, String rpCode, HttpServletRequest request, HttpServletResponse response){
        mainObjName = typeName + link + rpCode;
//        viewTitle

        ModelAndView modelAndView = super.doRenderMainView(request, response);
        //重载传回的一部分属性值 返回的页面是固定的
        modelAndView.setViewName(viewPrefix + typeName);

        return modelAndView;
    }

    /**
     * 获取表格数据
     * @return
     */
    public BizData4Page getTblDatas(String rpCode, HttpServletRequest request, HttpServletResponse response){
        ResourceDesign resourceDesign = resourceDesignService.viewOne(null, ConditionBuilder.condition(number, SearchEnum.eq, rpCode), null);

        //TODO  支持 order by； limit
        String sql = resourceDesign.getMainSql();
        //String countsql = resourceDesign.getMainCountSql();
        List<Map> datas = resourceDesignService.getDao().queryBySql(sql);

//        int count = (int) datas.get(0).get("count");
        BizData4Page bizData4Page = BizData4PageBuilder.innerCreateBizData4Page(datas, datas.size(), 1, 1000);

        return bizData4Page;
    }

    /**
     * 获取图表数据   暂时只支持 二维报表
     * @return
     */
    public Option getChartDatas(String rpCode, HttpServletRequest request, HttpServletResponse response){

        ResourceDesign resourceDesign = resourceDesignService.viewOne(null, ConditionBuilder.condition(number, SearchEnum.eq, rpCode), null);
        String sql = resourceDesign.getMainSql();

        //ChartHander 做不同的处理
        //TODO 做相关的 where条件替换 等 操作，获取 最终的数据     [移至facade]
        List<Map> datas = resourceDesignService.getDao().queryBySql(sql);

        //TODO 从 resourceGrid获取 属性key    替换掉name和xpoint
        List<String> xs = Lists.newArrayList();
        List<String> ys = Lists.newArrayList();
        for(Map map : datas){
            xs.add((String) map.get("name"));
            ys.add(String.valueOf( map.get("xpoint")));
        }

        Option option = new Option();
        option.legend("城市 与 人数 关系");
        option.toolbox().show(true).feature(
                Tool.mark,
                Tool.dataView,
                new MagicType(Magic.line, Magic.bar),
                Tool.restore,
                Tool.saveAsImage);

        option.calculable(true);
        option.tooltip().trigger(Trigger.axis).formatter("show : <br/>{b} : {c} 人数");

        ValueAxis valueAxis = new ValueAxis();
        valueAxis.axisLabel().formatter("{value} 人数");
        option.yAxis(valueAxis);

        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.axisLine().onZero(false);
//        categoryAxis.axisLabel().formatter("{value} ");
        categoryAxis.boundaryGap(true);
        categoryAxis.data(xs.toArray());
        option.xAxis(categoryAxis);

        Line line = new Line();
        line.smooth(true).name("城市 与 人数 关系")
                .data(ys.toArray())
                .itemStyle().normal().lineStyle().shadowColor("rgba(0,0,0,0.4)");
        option.series(line);

        return option;
    }

    @Override
    protected IPageService getMainService() {
        return null;
    }

    @Override
    protected String getBizSys() {
        return "sample";
    }

    @Override
    protected String getMainObjName() {
        return mainObjName;
    }

    @Override
    protected String getViewTitle() {
        return viewTitle;
    }

    @Override
    protected String getParentTitle() {
        return "业务报表";
    }

    @Override
    public boolean getEnableDataPerm() {
        return false;
    }
}
