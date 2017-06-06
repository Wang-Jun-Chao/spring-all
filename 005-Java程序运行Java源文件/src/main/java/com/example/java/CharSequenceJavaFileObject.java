package com.example.java;

import javax.tools.SimpleJavaFileObject;
import java.net.URI;

/**
 * @author : jialin
 * @group : THS_JAVA_PLATFORM
 * @Date : 2014-10-25 上午10:57:54
 * @Comments : 用于传递源程序
 * @Version : 1.0.0
 */
public class CharSequenceJavaFileObject extends SimpleJavaFileObject {

    private CharSequence content;


    public CharSequenceJavaFileObject(String className,            CharSequence content) {
        super(URI.create("string:///" + className.replace('.', '/')
                + Kind.SOURCE.extension), Kind.SOURCE);
        this.content = content;
    }

    @Override
    public CharSequence getCharContent(
            boolean ignoreEncodingErrors) {
        return content;
    }
}