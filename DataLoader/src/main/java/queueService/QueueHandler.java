package queueService;

import form.ParseRecord;
import form.Record;
import handler.DataHandler;
import parsers.ParserTXT;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Виктор on 06.11.2014.
 */
public class QueueHandler implements Runnable {

    private boolean running;
    private final int SLEEP_TIME = 5000;
    private ParserTXT parserTXT = new ParserTXT();
    private DataHandler dataHandler = new DataHandler();

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    private void processData(Queue queue){
        Record record = (Record) queue.poll(); //Достаем данные
        List<ParseRecord> linkedList = parserTXT.getRecords(record.getPathToFile()); //Парсим файл
        dataHandler.handData(record.getLogin(),linkedList); //Обработка полученного листа (поиск конкретных записей и их обновление в бд)
    }

    public void process() {

        Queue<Object> queue = QueueManager.getQueue();
        while (running) {
            while (!queue.isEmpty()) {
                processData(queue);     //Обработка очереди если она не пуста
            }
            try {
                Thread.currentThread().sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                System.out.println(e);
            }

        }
        if (!running && queue.isBlockAdd()) {
            while (!queue.isEmpty()) {
                processData(queue);
            }
        }

    }

    public void run() {
        process();
    }


}
