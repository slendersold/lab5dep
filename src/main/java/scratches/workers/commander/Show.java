package scratches.workers.commander;

import scratches.Garage;
import scratches.Vehicle;

/**
 * Класс, демонстрирующий коллекцию пользователю
 *
 * @author slendersold
 * @version 1.1.1
 */
public class Show implements scratches.workers.commander.One {
    /**
     * Обрабатывемая коллекция, в которой происходит демонстрация
     *
     * @param garage - обрабатываемая коллекция
     * @see Show#act(Garage)
     */
    public void act(Garage garage) {
        if (garage.isEmpty()) {
            System.out.println("Коллекция пуста");
        } else {
            System.out.println("Начинаем показ мод");
            for (Vehicle c : garage) {
                Printer.prf(c);
            }
            System.out.println("на сегодня все");
        }
    }
}
