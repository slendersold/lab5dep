package scratches.workers.commander;

import scratches.Garage;

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
        if (!garage.isEmpty()) {
            System.out.println(garage.descendingSet());
        } else {
            System.out.println("Гараж пуст");
        }
    }
}
