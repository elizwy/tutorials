package com.elizwy.javatech.javaagent;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;
import java.util.LinkedList;
import java.util.List;

public class AgentMainDemo {

    private static String className="javaagent.DemoMain";

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

            List<Class> needRetransFormClasses = new LinkedList<>();
            Class[] loadedClass = inst.getAllLoadedClasses();
            for (int i = 0; i < loadedClass.length; i++) {
                if (loadedClass[i].getName().equals(className)) {
                    needRetransFormClasses.add(loadedClass[i]);
                }
            }
            inst.retransformClasses(needRetransFormClasses.toArray(new Class[0]));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
