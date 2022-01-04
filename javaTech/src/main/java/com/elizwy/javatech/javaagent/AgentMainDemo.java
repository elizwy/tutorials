package com.elizwy.javatech.javaagent;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

public class AgentMainDemo {

    public static void premain(String args, Instrumentation inst) {
        main(args, inst);
    }

    public static void agentmain(String args, Instrumentation inst) {
        main(args, inst);
    }

    private static void main(String args, Instrumentation inst) {
        try {
            System.out.println("agent exec ....");
            inst.addTransformer(new ClassFileTransformer() {
                @Override
                public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
                    //字节码修改，替换
                    System.out.println("------ byte instead -----");
                    return new byte[0];
                }
            }, true);
            Class<?> clazz = Class.forName("com.elizwy.javatech.javaagent.ReTransformDemo");
            inst.retransformClasses(clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
