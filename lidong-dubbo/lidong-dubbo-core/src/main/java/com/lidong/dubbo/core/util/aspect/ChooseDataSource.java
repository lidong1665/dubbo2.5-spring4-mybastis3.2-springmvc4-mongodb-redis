package com.lidong.dubbo.core.util.aspect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @项目名称:lidong-dubbo
 * @类名:ChooseDataSource
 * @类的描述:获取数据源，用于动态切换数据源
 * @作者:lidong
 * @创建时间:2017/1/9 上午9:34
 * @公司:chni
 * @QQ:1561281670
 * @邮箱:lidong1665@163.com
 */
public  class ChooseDataSource extends AbstractRoutingDataSource {

    public static Map<String, List<String>> METHOD_TYPE_MAP = new HashMap<String, List<String>>();


    /**
     * 实现父类中的抽象方法，获取数据源名称
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceHandler.getDataSource();
    }


    /**
     * 设置方法名前缀对应的数据源
     * @param map
     */
    public void setMethodType(Map<String, String> map) {
        for (String key : map.keySet()) {
            List<String> v = new ArrayList<String>();
            String[] types = map.get(key).split(",");
            for (String type : types) {
                if (StringUtils.isNotBlank(type)) {
                    v.add(type);
                }
            }
            METHOD_TYPE_MAP.put(key, v);
        }
    }


}