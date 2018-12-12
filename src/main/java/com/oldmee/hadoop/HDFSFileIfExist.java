package com.oldmee.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.*;

/**
 * @Author: R.oldmee
 * @Description:
 * @Date: Create in 13:13 2018/12/12
 */
public class HDFSFileIfExist {
    public static void main(String[] args){
        System.setProperty("hadoop.home.dir", "D:\\hadoop\\hadoop-2.5.2");
        try{
            String fileName = "/user/output/part-r-00000";
//            String fileName = "/user/input/test2.txt";
            Configuration conf = new Configuration();
            FileSystem fs = FileSystem.get(conf);
            if(fs.exists(new Path(fileName))){
                System.out.println("文件存在");
                FSDataInputStream inputStream =  fs.open(new Path(fileName));
                BufferedReader bf=new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));//防止中文乱码
                String s;
                StringBuffer sb = new StringBuffer();
                while((s=bf.readLine()) != null){
                    sb.append(s+"\n");
                }
                bf.close();
                System.out.println(sb);
//                IOUtils.copyBytes(inputStream, System.out, 4096, false);

            }else{
                System.out.println("文件不存在");
//                fs.mkdir
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
