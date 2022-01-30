package com.solvd.onlinestore.utils.deadlockhomework;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Deadlock {
    public static void main(String[] args) {
        Lock participantA = new ReentrantLock();
        Lock participantB = new ReentrantLock();
        Lock participantC = new ReentrantLock();
        new Participants("Chris", participantA, participantB).start();
        new Participants("Ilissa", participantB, participantC).start();
        new Participants("Brianna", participantA, participantC).start();
    }
}
