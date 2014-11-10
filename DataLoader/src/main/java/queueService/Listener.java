package queueService;
/**
 * Created by Виктор on 08.11.2014.
 */
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Listener implements ServletContextListener {

    private QueueHandler queueHandler;
    private Thread queueHandlerThread;

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        queueHandler = new QueueHandler();
        queueHandler.setRunning(true);
        queueHandlerThread = new Thread(queueHandler,"queueHandlerThread");
        queueHandlerThread.start();
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

        if(queueHandlerThread.isAlive() && queueHandler.isRunning()){
            QueueManager.getQueue().setBlockAdd(true);
            queueHandler.setRunning(false);
        }

        try {
            queueHandlerThread.join();
        }catch (InterruptedException e){
            System.out.println(e);
        }

    }

}
