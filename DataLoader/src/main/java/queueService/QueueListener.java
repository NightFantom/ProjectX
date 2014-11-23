package queueService;
/**
 * Created by Виктор on 08.11.2014.
 */
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class QueueListener implements ServletContextListener {

    private QueueHandler queueHandler;
    private Thread queueHandlerThread;

    /**
     * Старт потока для обработки очереди
     * @param servletContextEvent
     */
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        queueHandler = new QueueHandler();
        queueHandler.setRunning(true);
        queueHandlerThread = new Thread(queueHandler,"queueHandlerThread");
        queueHandlerThread.start();
    }

    /**
     * Блокировка возможности добавление в очередь и прекращение работы потока, после того как последние данные из очереди будут изъяты
     * @param servletContextEvent
     */
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

        if(queueHandlerThread.isAlive() && queueHandler.isRunning()){
            QueueManager.getQueue().setBlockAdd(true);
            queueHandler.setRunning(false);
        }

        try {
            queueHandlerThread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }

}
