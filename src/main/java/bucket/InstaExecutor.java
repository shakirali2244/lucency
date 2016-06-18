package bucket;
import java.util.Date;
import java.util.concurrent.ScheduledFuture;

import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.annotation.Scheduled;

import lucency.RestHelper;



public class InstaExecutor {

    private class MessagePrinterTask implements Runnable {

        private String url;

        public MessagePrinterTask(String url) {
            this.url = url;
        }

        public void run() {
        	
        }

    }

    private TaskExecutor taskExecutor;

    public InstaExecutor(TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    public void printMessages() {
       taskExecutor.execute(new MessagePrinterTask());
    }
    
    @Scheduled(fixedDelay=5000)
    public void doSomething() {
        // something that should execute on weekdays only
    }

}