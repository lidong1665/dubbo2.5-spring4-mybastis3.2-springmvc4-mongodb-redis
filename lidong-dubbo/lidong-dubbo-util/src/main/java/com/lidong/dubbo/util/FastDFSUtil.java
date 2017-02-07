package com.lidong.dubbo.util;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @项目名称:lidong-dubbo
 * @类名:FastDFSUtil
 * @类的描述: FastDFS 上传文件到文件服务器
 * @作者:lidong
 * @创建时间:2017/2/6 下午5:23
 * @公司:chni
 * @QQ:1561281670
 * @邮箱:lidong1665@163.com
 */
public class FastDFSUtil {

    private final static

    Logger logger = LoggerFactory.getLogger(FastDFSUtil.class);


    /**
     *上传服务器本地文件-通过Linux客户端,调用客户端命令上传
     * @param filePath 文件绝对路径
     * @return Map<String,Object> code-返回代码, group-文件组, msg-文件路径/错误信息
     */
    public static Map<String, Object> uploadLocalFile(String filePath) {
        Map<String, Object> retMap = new HashMap<String, Object>();
        /**
         * 1.上传文件的命令
         */
        String command = "fdfs_upload_file /etc/fdfs/client.conf  " + filePath;
        /**
         * 2.定义文件的返回信息
         */
        String fileId = "";
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            /**
             * 3.通过调用api, 执行linux命令上传文件
             */
            Process process = Runtime.getRuntime().exec(command);
            /**
             * 4.读取上传后返回的信息
             */
             inputStreamReader = new InputStreamReader(process.getInputStream());
             bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            if ((line = bufferedReader.readLine()) != null) {
                fileId = line;
            }
            /**
             * 5.如果fileId包含M00，说明文件已经上传成功。否则文件上传失败
             */
            if (fileId.contains("M00")) {
                retMap.put("code", "0000");
                retMap.put("group", fileId.substring(0, 6));
                retMap.put("msg", fileId.substring(7, fileId.length()));
            } else {
                retMap.put("code", "0001");  //上传错误
                retMap.put("msg", fileId);   //返回信息
            }

        } catch (Exception e) {
            logger.error("IOException:" + e.getMessage());
            retMap.put("code", "0002");
            retMap.put("msg", e.getMessage());
        }finally {
            if (inputStreamReader!=null){
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return retMap;
    }


    /**
     * Description: 直接通过fdfs java客户端上传到服务器-读取本地文件上传
     *
     * @param filePath 本地文件绝对路径
     * @return Map<String,Object> code-返回代码, group-文件组, msg-文件路径/错误信息
     */
    public static Map<String, Object> upload(String filePath) {
        Map<String, Object> retMap = new HashMap<String, Object>();
        File file = new File(filePath);
        TrackerServer trackerServer = null;
        StorageServer storageServer = null;
        if (file.isFile()) {
            try {
                String tempFileName = file.getName();
                byte[] fileBuff = FileUtil.getBytesFromFile(file);
                String fileId = "";
                //截取后缀
                String fileExtName = tempFileName.substring(tempFileName.lastIndexOf(".") + 1);
                ConfigAndConnectionServer configAndConnectionServer = new ConfigAndConnectionServer().invoke(1);
                StorageClient1 storageClient1 = configAndConnectionServer.getStorageClient1();
                storageServer = configAndConnectionServer.getStorageServer();
                trackerServer = configAndConnectionServer.getTrackerServer();

                /**
              * 4.设置文件的相关属性。调用客户端的upload_file1的方法上传文件
              */
                NameValuePair[] metaList = new NameValuePair[3];
                //原始文件名称
                metaList[0] = new NameValuePair("fileName", tempFileName);
                //文件后缀
                metaList[1] = new NameValuePair("fileExtName", fileExtName);
                //文件大小
                metaList[2] = new NameValuePair("fileLength", String.valueOf(file.length()));
                //开始上传文件
                fileId = storageClient1.upload_file1(fileBuff, fileExtName, metaList);
                retMap = handleResult(retMap, fileId);
            } catch (Exception e) {
                e.printStackTrace();
                retMap.put("code", "0002");
                retMap.put("msg", e.getMessage());
            } finally {
                /**
                 * 5.关闭跟踪服务器的连接
                 */
                colse(storageServer, trackerServer);
            }
        } else {
            retMap.put("code", "0001");
            retMap.put("msg", "error:本地文件不存在!");
        }
        return retMap;
    }


    /**
     * Description:远程选择上传文件-通过MultipartFile
     *
     * @param file 文件流
     * @return Map<String,Object> code-返回代码, group-文件组, msg-文件路径/错误信息
     */
    public static Map<String, Object> upload(MultipartFile file) {
        Map<String, Object> retMap = new HashMap<String, Object>();
        TrackerServer trackerServer = null;
        StorageServer storageServer = null;
        try {
            if (file.isEmpty()) {
                retMap.put("code", "0001");
                retMap.put("msg", "error:文件为空!");
            } else {
                ConfigAndConnectionServer configAndConnectionServer = new ConfigAndConnectionServer().invoke(1);
                StorageClient1 storageClient1 = configAndConnectionServer.getStorageClient1();
                storageServer = configAndConnectionServer.getStorageServer();
                trackerServer = configAndConnectionServer.getTrackerServer();
                String tempFileName = file.getOriginalFilename();
                //设置元信息
                NameValuePair[] metaList = new NameValuePair[3];
                //原始文件名称
                metaList[0] = new NameValuePair("fileName", tempFileName);
                //文件后缀
                byte[] fileBuff = file.getBytes();
                String fileId = "";
                //截取后缀
                String fileExtName = tempFileName.substring(tempFileName.lastIndexOf(".") + 1);

                metaList[1] = new NameValuePair("fileExtName", fileExtName);
                //文件大小
                metaList[2] = new NameValuePair("fileLength", String.valueOf(file.getSize()));
                /**
                 * 4.调用客户端呢的upload_file1的方法开始上传文件
                 */
                fileId = storageClient1.upload_file1(fileBuff, fileExtName, metaList);
                retMap = handleResult(retMap, fileId);
            }
        } catch (Exception e) {
            retMap.put("code", "0002");
            retMap.put("msg", "error:文件上传失败!");
        }finally {
            /**
             * 5.关闭跟踪服务器的连接
             */
            colse(storageServer, trackerServer);
        }
        return retMap;
    }


    /**
     * 下载文件
     *
     * @param response
     * @param filepath 数据库存的文件路径
     * @param downname 下载后的名称
     *                 filepath M00/开头的文件路径
     *                 group 文件所在的组 如：group0
     * @throws IOException
     */
    public static void download(HttpServletResponse response, String group, String filepath, String downname) {
        StorageServer storageServer = null;
        TrackerServer trackerServer = null;
        try {
            ConfigAndConnectionServer configAndConnectionServer = new ConfigAndConnectionServer().invoke(0);
            StorageClient storageClient = configAndConnectionServer.getStorageClient();
            storageServer = configAndConnectionServer.getStorageServer();
            trackerServer = configAndConnectionServer.getTrackerServer();

            /**
             *4.调用客户端的下载download_file的方法
             */
            byte[] b = storageClient.download_file(group, filepath);
            if (b == null) {
                logger.error("Error1 : file not Found!");
                response.getWriter().write("Error1 : file not Found!");
            } else {
                logger.info("下载文件..");
                downname = new String(downname.getBytes("utf-8"), "ISO8859-1");
                response.setHeader("Content-Disposition", "attachment;fileName=" + downname);
                OutputStream out = response.getOutputStream();
                out.write(b);
                out.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                response.getWriter().write("Error1 : file not Found!");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }finally {
            /**
             * 5.关闭跟踪服务器的连接
             */
            colse(storageServer, trackerServer);
        }
    }

    /**
     * 删除文件
     *
     * @param group 文件分组,  filepath 已M00/ 开头的文件路径
     * @return Map<String,Object> code-返回代码,  msg-错误信息
     */
    public static Map<String, Object> delete(String group, String filepath) {
        Map<String, Object> retMap = new HashMap<String, Object>();
        StorageServer storageServer = null;
        TrackerServer trackerServer = null;
        try {
            ConfigAndConnectionServer configAndConnectionServer = new ConfigAndConnectionServer().invoke(0);
            StorageClient storageClient = configAndConnectionServer.getStorageClient();
            storageServer = configAndConnectionServer.getStorageServer();
            trackerServer = configAndConnectionServer.getTrackerServer();
            /**
             * 4.调用客户端的delete_file方法删除文件
             */
            int i = storageClient.delete_file(group, filepath);
            if (i == 0) {
                retMap.put("code", "0000");
                retMap.put("msg", "删除成功！");
            } else {
                retMap.put("code", "0001");
                retMap.put("msg", "文件不存在!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            retMap.put("code", "0002");
            retMap.put("msg", "删除失败！");
        } finally {
            /**
             * 5.关闭跟踪服务器的连接
             */
            colse(storageServer, trackerServer);
        }

        return retMap;

    }

    /**
     * 关闭服务器
     *
     * @param storageServer
     * @param trackerServer
     */
    private static void colse(StorageServer storageServer, TrackerServer trackerServer) {
        if (storageServer != null && trackerServer != null) {
            try {
                storageServer.close();
                trackerServer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 处理上传到文件服务器之后，返回来的结果
     *
     * @param retMap
     * @param fileId
     * @return
     */
    private static Map<String, Object> handleResult(Map<String, Object> retMap, String fileId) {
        if (!fileId.equals("") && fileId != null) {
            retMap.put("code", "0000");
            retMap.put("group", fileId.substring(0, 6));
            retMap.put("msg", fileId.substring(7, fileId.length()));
        } else {
            retMap.put("code", "0003");
            retMap.put("msg", "error:上传失败!");
        }

        return retMap;
    }

    /**
     * @项目名称:lidong-dubbo
     * @类名:FastDFSUtil
     * @类的描述: ConfigAndConnectionServer
     * @作者:lidong
     * @创建时间:2017/2/7 上午8:47
     * @公司:chni
     * @QQ:1561281670
     * @邮箱:lidong1665@163.com
     */
    private static class ConfigAndConnectionServer {
        private TrackerServer trackerServer;
        private StorageServer storageServer;
        private StorageClient storageClient;
        private StorageClient1 storageClient1;


        public TrackerServer getTrackerServer() {
            return trackerServer;
        }

        public StorageServer getStorageServer() {
            return storageServer;
        }

        public StorageClient getStorageClient() {
            return storageClient;
        }

        public StorageClient1 getStorageClient1() {
            return storageClient1;
        }

        public ConfigAndConnectionServer invoke(int flag) throws IOException, MyException {
            /**
             * 1.读取fastDFS客户端配置文件
             */
            ClassPathResource cpr = new ClassPathResource("fdfs_client.conf");
            /**
             * 2.配置文件的初始化信息
             */
            ClientGlobal.init(cpr.getClassLoader().getResource("fdfs_client.conf").getPath());
            TrackerClient tracker = new TrackerClient();
            /**
             * 3.建立连接
             */
            trackerServer = tracker.getConnection();
            storageServer = null;
            /**
             * 如果flag=0时候，构造StorageClient对象否则构造StorageClient1
             */
            if (flag == 0) {
                storageClient = new StorageClient(trackerServer, storageServer);
            } else {
                storageClient1 = new StorageClient1(trackerServer, storageServer);
            }
            return this;
        }
    }
}
