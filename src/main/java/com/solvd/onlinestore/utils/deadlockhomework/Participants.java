package com.solvd.onlinestore.utils.deadlockhomework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.locks.Lock;

public class Participants extends Thread {
    private final Lock firstTimers;
    private final Lock secondTimers;
    private static int numberOfPeopleParticipating = 2500;


    private static final Logger logger = LogManager.getLogger(Participants.class);


    public Participants(String name, Lock firstTimers, Lock secondTimers) {
        this.setName(name);
        this.firstTimers = firstTimers;
        this.secondTimers = secondTimers;
    }


    public void run() {
        while (numberOfPeopleParticipating > 0) {
            firstTimers.lock();
            secondTimers.lock();
        }

        if (numberOfPeopleParticipating > 0) {
            numberOfPeopleParticipating--;
            logger.info(this.getName() + "someone dropped out of the race" + numberOfPeopleParticipating);
        }
        secondTimers.unlock();
        firstTimers.unlock();
    }
}
