package queueService;
/**
 * Created by Виктор on 06.11.2014.
 */

import fileService.FileManager;
import form.LodedData;
import entities.DescriptionParser;
import handler.UpdateDataHandler;
import hibernateService.HibernateService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import parsers.Parser;
import parsers.ParserFactory;
import parsers.ParsingException;

/**
 * Обработчик очереди
 */
public class QueueHandler implements Runnable {

    protected final Logger LOG = LogManager.getLogger(QueueHandler.class);
    private boolean running;
    private final int SLEEP_TIME = 5000;
    private UpdateDataHandler updateData = new UpdateDataHandler();

    /**
     * проверка на дестрой
     *
     * @return
     */
    public boolean isRunning() {
        return running;
    }

    /**
     * @param running
     */
    public void setRunning(boolean running) {
        this.running = running;
    }

    /**
     * Извлечение, обработка и обновление в бд данных, пришедших из очереди
     *
     * @param queue
     */
    private void processData(Queue queue) {
        try {
            LodedData lodedData = (LodedData) queue.poll();
            DescriptionParser descriptionParser = new HibernateService<DescriptionParser>(DescriptionParser.class).getById(lodedData.getPharmacy().getId());
            if (descriptionParser == null) {
                LOG.error("Не найден парсер для аптеки с id = " + lodedData.getPharmacy().getId());
            }
            Parser parser = new ParserFactory().getParser(descriptionParser.getParser());
            //TODO: Нужно реализовать обработку исключения "Не удалось распарсить"
            try {
                updateData.updateData(parser.getRecords(lodedData.getPathToFile(), lodedData.getEncoding()), lodedData);
            } catch (ParsingException e) {
                LOG.error(e);
            }
        } catch (Exception e) {
            LOG.error("Ошибка при обработке очереди: " + e.toString(), e);
        }

    }

    /**
     * процес работы с очередью
     */
    public void process() {

        Queue<Object> queue = QueueManager.getQueue();
        LOG.info("Старт процесса обработки очереди");
        while (running) {
            if (!queue.isEmpty()) {
                processData(queue);
            } else {
                try {
                    Thread.currentThread().sleep(SLEEP_TIME);
                } catch (InterruptedException e) {
                    LOG.warn("Прерван поток обработки очереди " + e.toString());
                }
            }
        }
        if (!running && queue.isBlockingAdd()) {
            LOG.info("Ожидание заверешения обработки очереди...");
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
