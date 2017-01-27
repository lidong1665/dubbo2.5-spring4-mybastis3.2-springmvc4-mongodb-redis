package com.lidong.dubbo.util;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.*;
import java.net.URI;

public class HdfsFileSystem {
    /** 
     * 按路径上传文件到hdfs
     * @param conf 
     * @param local 
     * @param remote 
     * @throws IOException 
     */  
    public static void copyFile(Configuration conf , String uri , String local, String remote) throws IOException {
        FileSystem fs = FileSystem.get(URI.create(uri), conf);
        fs.copyFromLocalFile(new Path(local), new Path(remote));
        System.out.println("copy from: " + local + " to " + remote);  
        fs.close();  
    }  
    
    /** 
     * 按路径下载hdfs上的文件 
     * @param conf 
     * @param uri 
     * @param remote 
     * @param local 
     * @throws IOException 
     */  
    public static void download(Configuration conf , String uri ,String remote, String local) throws IOException {  
           Path path = new Path(remote);  
           FileSystem fs = FileSystem.get(URI.create(uri), conf);  
           fs.copyToLocalFile(path, new Path(local));  
           System.out.println("download: from" + remote + " to " + local);  
           fs.close();  
   } 
    
    /** 
     * File对象上传到hdfs 
     * @param localPath
     * @param hdfsPath
     * @throws IOException 
     */  
    public static void createFile(File localPath, String hdfsPath) throws IOException {
        InputStream in = null;
        try {  
            Configuration conf = new Configuration();  
            FileSystem fileSystem = FileSystem.get(URI.create(hdfsPath), conf);  
            FSDataOutputStream out = fileSystem.create(new Path(hdfsPath));
            in = new BufferedInputStream(new FileInputStream(localPath));
            IOUtils.copyBytes(in, out, 4096, false);
            out.hsync();  
            out.close();  
            System.out.println("create file in hdfs:" + hdfsPath);  
        } finally {  
            IOUtils.closeStream(in);  
        }  
    }
}