package queueService;
/**
 * Created by Виктор on 06.11.2014.
 */
import form.LodedData;
import forms.DescriptionParser;
import handler.UpdateData;
import hibernateService.HibernateService;
import parsers.ParserFactory;

/**
 * Обработчик очереди
 */
public class QueueHandler implements Runnable {

    private boolean running;
    private final int SLEEP_TIME = 5000;
    private UpdateData updateData = new UpdateData();
    /**
     * проверка на дестрой из лисенера
     * @return
     */
    public boolean isRunning() {
        return running;
    }

    /**
     *
     * @param running
     */
    public void setRunning(boolean running) {
        this.running = running;
    }

    /**
     * извлечение,обработка и обновление в бд данных пришедших из очереди
     * @param queue
     */
    private void processData(Queue queue){
        LodedData lodedData = (LodedData) queue.poll();
        DescriptionParser descriptionParser = new HibernateService<DescriptionParser>(DescriptionParser.class).getById(lodedData.pharmacy.getId());
        updateData.updateData( new ParserFactory().getParser(descriptionParser.getParser()).getRecords(lodedData.getPathToFile()),lodedData);
    }

    /**
     * процес работы с очередью
     */
    public void process() {

        Queue<Object> queue = QueueManager.getQueue();
        while (running) {
            if (!queue.isEmpty()) {
                processData(queue);
            }else{
                try {
                    Thread.currentThread().sleep(SLEEP_TIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        if (!running && queue.isBlockAdd()) {
            while (!queue.isEmpty()) {
                processData(queue);
            }
        }
    }

    /**
     * старт процесса работы с очередью
     */
    public void run() {
        process();
    }
}
