package scratches;

import com.google.gson.JsonSyntaxException;
import scratches.workers.Assistant;
import scratches.workers.JSONworker;

import java.io.File;

/**
 * Main-класс и по совместительству мой швейцар в гараже
 *
 * @author slendersold
 * @version 1.1.1
 */
class App {
    public static void main(String[] args) throws JsonSyntaxException {

        /**Инструмент для работы с JSON*/
        JSONworker JJ = new JSONworker();
        /**Экземпляр коллекции*/
        Garage garage = new Garage();
        try {
            File jsonFile = new File(args[0]);
            if (!jsonFile.exists()) {
                System.out.println("Файл не существует");
                System.exit(0);
            }
            if (!jsonFile.isFile()) {
                System.out.println("Это не файл");
                System.exit(0);
            }
            if (!jsonFile.canRead() || !jsonFile.canWrite()) {
                System.out.println("Файл вне доступа");
                System.exit(0);
            }
            if (!args[0].endsWith(".json")) {
                System.out.println("Это не json-файл");
                System.exit(0);
            }

            garage = JJ.fromJSON(args[0]);


        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("-Я аргумента коммандной строки не чувствую. \n" +
                    "-У тебя его и НЕТ!");
            System.exit(0);
        }
        System.out.println("Сейчас вы начнете работу с командами. Рекомендуем для начала ввести \"help\"");
        Assistant.process(garage, args[0]);

    }
}
