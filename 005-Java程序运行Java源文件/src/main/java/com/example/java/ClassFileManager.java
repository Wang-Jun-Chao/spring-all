package com.example.java;

import javax.tools.FileObject;
import javax.tools.ForwardingJavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import java.io.IOException;

/**
 * @author : jialin
 * @group : THS_JAVA_PLATFORM
 * @Date : 2014-10-25 上午10:59:34
 * @Comments : 类文件管理器
 * @Version : 1.0.0
 */
public class ClassFileManager extends ForwardingJavaFileManager {
    public JavaClassObject getJavaClassObject() {
        return javaClassObject;
    }

    private JavaClassObject javaClassObject;


    public ClassFileManager(StandardJavaFileManager standardManager) {
        super(standardManager);
    }


    @Override
    public JavaFileObject getJavaFileForOutput(Location location, String className,
            JavaFileObject.Kind kind, FileObject sibling) throws IOException {
        javaClassObject = new JavaClassObject(className, kind);
        return javaClassObject;
    }
}