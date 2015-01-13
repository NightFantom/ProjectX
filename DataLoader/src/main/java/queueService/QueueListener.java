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
        System.out.println(queueHandlerThread);
        if(queueHandlerThread.isAlive() && queueHandler.isRunning()){
            QueueManager.getQueue().setBlockingAdd(true);
            queueHandler.setRunning(false);
        }
        System.out.println("Поток обработки жив: " + queueHandlerThread.isAlive());
        try {
            System.out.println("Ожидаем завершения обработки очереди");
            queueHandlerThread.join();
            System.out.println("Дождался завершения обработки очереди");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Поток обработки жив: " + queueHandlerThread.isAlive());
    }

}
