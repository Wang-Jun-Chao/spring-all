package com.example.java;

import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import java.io.IOException;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import java.net.URI;
/**
 * @author     : jialin
 * @group      : THS_JAVA_PLATFORM
 * @Date       : 2014-10-25 上午10:49:07
 * @Comments   : 用于传递源程序
 * @Version    : 1.0.0
 */
public class JavaClassObject extends SimpleJavaFileObject {
 
    protected final ByteArrayOutputStream bos =
        new ByteArrayOutputStream();
 
 
    public JavaClassObject(String name, Kind kind) {
        super(URI.create("string:///" + name.replace('.', '/')
            + kind.extension), kind);
    }
 
 
    public byte[] getBytes() {
        return bos.toByteArray();
    }
 
    @Override
    public OutputStream openOutputStream() throws IOException {
        return bos;
    }
}