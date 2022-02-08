package com.elizwy.javatech.concurrent;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

@Slf4j
public class ObjectHeader {
    // -XX:+UseBiasedLocking
    public static void main(String[] args) throws InterruptedException {
        ObjectHeader header = new ObjectHeader();
        log.debug(ClassLayout.parseInstance(header).toPrintable());
        synchronized (header){
            log.debug("锁对象");
            log.debug(ClassLayout.parseInstance(header).toPrintable());
        }

        Thread.sleep(5000);
        ObjectHeader header2 = new ObjectHeader();
        log.debug(ClassLayout.parseInstance(header2).toPrintable());
        synchronized (header2){
            log.debug("锁对象");
            log.debug(ClassLayout.parseInstance(header2).toPrintable());
        }
    }
}
