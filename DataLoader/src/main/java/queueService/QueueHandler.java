package queueService;
/**
 * Created by Виктор on 06.11.2014.
 */
import form.LodedData;
import forms.DescriptionParser;
import handler.UpdateDataHandler;
import hibernateService.HibernateService;
import parsers.Parser;
import parsers.ParserFactory;
import parsers.ParsingException;

/**
 * Обработчик очереди
 */
public class QueueHandler implements Runnable {

    private boolean running;
    private final int SLEEP_TIME = 5000;
    private UpdateDataHandler updateData = new UpdateDataHandler();
    /**
     * проверка на дестрой
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
     * Извлечение, обработка и обновление в бд данных, пришедших из очереди
     * @param queue
     */
    private void processData(Queue queue){
        try{
            LodedData lodedData = (LodedData) queue.poll();
            DescriptionParser descriptionParser = new HibernateService<DescriptionParser>(DescriptionParser.class).getById(lodedData.pharmacy.getId());
            if(descriptionParser == null){
                throw new Exception("Не найден парсер для аптеки с id = " + lodedData.getPharmacy().getId());
            }
            Parser parser = new ParserFactory().getParser(descriptionParser.getParser());
            //TODO: Нужно реализовать обработку исключения "Не удалось распарсить"
            try {
                updateData.updateData(parser.getRecords(lodedData.getPathToFile()), lodedData);
            }catch (ParsingException e){
                throw new Exception(e);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

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
        if (!running && queue.isBlockingAdd()) {
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
