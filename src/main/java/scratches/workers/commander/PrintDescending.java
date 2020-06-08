package scratches.workers.commander;

import scratches.Garage;
import scratches.Vehicle;

/**
 * Класс, печающий всю коллекцию в убывающем порядке
 *
 * @author slendersold
 * @version 1.1.1
 */
public class PrintDescending implements scratches.workers.commander.One {
    /**
     * Печатает
     *
     * @param garage - обрабатываемый класс
     * @see PrintDescending#act(Garage)
     */
    public void act(Garage garage) {
        if (garage.isEmpty()) {
            System.out.println("Коллекция пуста");
        } else {
            System.out.println("Начинаем показ мод");
            for (Vehicle c : garage.descendingSet()) {
                Printer.prf(c);
            }
            System.out.println("на сегодня все");
        }
    }
}
