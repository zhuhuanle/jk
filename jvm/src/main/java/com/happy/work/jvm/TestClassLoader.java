package com.happy.work.jvm;

import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author : zhu_huan
 * @createTime : 2021/3/21
 **/
@Slf4j
public class TestClassLoader extends ClassLoader {


    @Override
    protected Class<?> findClass(String name){
        byte[] bytes = new byte[0];
        try {
            bytes = this.getByte4File("F:\\jk\\第一周\\Hello.xlass");
        } catch (Exception e) {
            log.error("获取字节数组失败{}", e);
        }
        byte[] convert = this.convert(bytes);
        return defineClass(name, convert, 0, bytes.length);
    }

    private byte[] getByte4File(String path) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(path);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            int index;
            byte[] bytes = new byte[1024];
            while ((index = fileInputStream.read(bytes)) != -1){
                baos.write(bytes, 0, index);
                baos.flush();
            };
            return baos.toByteArray();
        } catch (Exception e) {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (baos != null) {
                baos.close();
            }
            log.error("获取文件字节出错path：{}。error{}", path, e.getMessage());
            return null;
        }
    }

    private byte[] convert(byte[] bytes){
        for (int i = 0; i < bytes.length; i++) {
            bytes[i]= (byte) (255-bytes[i]);
        }
        return bytes;
    }


}
