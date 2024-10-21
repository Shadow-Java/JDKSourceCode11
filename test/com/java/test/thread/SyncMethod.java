package com.java.test.thread;

/**
 * @author shadow
 * @create 2024-04-24 05:39
 **/
public class SyncMethod {

    public int i;

    /**
     * public synchronized void syncTask();
     *     descriptor: ()V
     *     flags: (0x0021) ACC_PUBLIC, ACC_SYNCHRONIZED
     *     Code:
     *       stack=3, locals=1, args_size=1
     *          0: aload_0
     *          1: dup
     *          2: getfield      #2                  // Field i:I
     *          5: iconst_1
     *          6: iadd
     *          7: putfield      #2                  // Field i:I
     *         10: return
     *       LineNumberTable:
     *         line 12: 0
     *         line 13: 10
     *       LocalVariableTable:
     *         Start  Length  Slot  Name   Signature
     *             0      11     0  this   Lcom/java/test/thread/SyncMethod;
     */
    public synchronized void syncTask() {
        i++;
    }

}
