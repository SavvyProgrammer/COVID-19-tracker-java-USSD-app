package app.utilities;

import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicRun {

    private AtomicBoolean run = new AtomicBoolean();

    public void setRun(Runnable task) {
        if (run.get())
            return;
        if (run.compareAndSet(false, true))
            task.run();
    }
}
