package com.study.microskill.cache.java;

/**
 * @author initiald0824
 * @date 2019/6/22 20:40
 */

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author initiald0824
 * 用map实现一个简单的缓存功能
 */
public class MapCachedDemo {
    // 使用了ConcurrentHashMap，线程安全的要求
    // 使用SoftReference <Object> 作为映射值，因为软引用可以保证在抛出OutOfMemory之前，如果缺少内存，将删除引用的对象。
    /**
     * 在构造函数中，我创建了一个守护程序线程，每5秒扫描一次并清理过期的对象。
     */
    private static final int CELAN_UP_PERIOD_IN_SEC = 5;

    private static ThreadFactory threadFactory = new ThreadFactoryBuilder().
            setNameFormat("thread-pool" + "-%d").setDaemon(true).build();

    private static ExecutorService threadPool = new ThreadPoolExecutor(5,
            10, 0, TimeUnit.SECONDS, new LinkedBlockingDeque<>(),
            threadFactory, new ThreadPoolExecutor.AbortPolicy());

}
