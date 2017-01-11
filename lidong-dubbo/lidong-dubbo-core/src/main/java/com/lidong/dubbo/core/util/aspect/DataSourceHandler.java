package com.lidong.dubbo.core.util.aspect;
/**
 * 数据源的Handler类
 * @author lidong
 *
 */
public class DataSourceHandler {
    /**
     * 数据源名称线程池
     */
    public static final ThreadLocal<String> holder = new ThreadLocal<String>();

    /**
     * 在项目启动的时候将配置的读、写数据源加到holder中
     * @param datasource
     */
    public static void putDataSource(String datasource) {
        holder.set(datasource);
    }

    /**
     * 从holer中获取数据源字符串
     * @return
     */
    public static String getDataSource() {
        return holder.get();
    }
}
