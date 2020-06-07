package scratches.workers.commander;

import scratches.Garage;
import scratches.Vehicle;

/**
 * Класс, печатающий пару значений id-мощность двигателя в порядке убывания мощности двигателя
 *
 * @author slendersold
 * @version 1.1.1
 */
public class PrintFieldDescendingEnginePower implements One {
    /**
     * Печатает
     *
     * @param garage - обрабатываемый класс
     * @see PrintFieldDescendingEnginePower#act(Garage)
     */
    public void act(Garage garage) {
        if (!garage.isEmpty()) {
            for (Vehicle c : garage) {
                System.out.println(c.getId() + " " + c.getEnginePower());
            }
        } else {
            System.out.println("Гараж пуст");
        }
    }
}
