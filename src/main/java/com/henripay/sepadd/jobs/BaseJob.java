package com.henripay.sepadd.jobs;

import com.henripay.sepadd.service.JobProperties;
import org.springframework.stereotype.Service;

@Service
public class BaseJob {
    protected volatile boolean isPaused = false;
    protected volatile boolean isCancelled = false;


    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    protected volatile boolean isCompleted= false;
    private JobProperties jobProperties;

    public void pause() {
        isPaused = true;
    }

    public void resume() {
        isPaused = false;
    }

    public void cancel() {
        isCancelled = true;
    }
}
