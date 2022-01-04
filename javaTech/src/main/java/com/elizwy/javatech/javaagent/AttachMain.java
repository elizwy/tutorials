package com.elizwy.javatech.javaagent;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

import java.io.IOException;

public class AttachMain {
    public static void main(String[] args) throws IOException, AttachNotSupportedException, AgentLoadException, AgentInitializationException {
        VirtualMachine vm=null;
        try {
            vm=VirtualMachine.attach("15837");
            vm.loadAgent("/Users/elizwy/coding/zwy/tutorials/javaTech/target/javaTech-1.0-SNAPSHOT-jar-with-dependencies.jar");
        }finally {
            if(vm !=null){
                vm.detach();
            }
        }
    }
}
