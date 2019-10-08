package org.apache.dubbo.util;

import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ProxyGeneratorUtils {
    /**
     * 把代理类的字节码写到硬盘上
     *
     * @param path 保存路径
     */
    public static void writeProxyClassToHardDisk(String path, Class clazz) {
        byte[] classFiles = ProxyGenerator.generateProxyClass("$Proxy11", new Class[]{clazz});
        try (FileOutputStream out = new FileOutputStream(path)) {
            out.write(classFiles);
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
