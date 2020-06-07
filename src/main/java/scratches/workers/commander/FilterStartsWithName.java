package scratches.workers.commander;

import scratches.Garage;
import scratches.Vehicle;

/**
 * Класс, печатающий все элементы, содержащие введенную подстроку
 *
 * @author slendersold
 * @version 1.1.1
 */
public class FilterStartsWithName implements scratches.workers.commander.Two {
    /**
     * Находит совпадения
     *
     * @param garage - обрабатываемый класс
     * @param s      - подстрока для поиска
     * @see FilterStartsWithName#act(Garage, String)
     */
    public void act(Garage garage, String s) {
        boolean flag = true;
        if (!garage.isEmpty()) {
            for (Vehicle c : garage) {
                if (c.getName().startsWith(s)) {
                    System.out.println(c.getId() + " " + c.getName());
                    flag = false;
                }
            }
            if (flag) {
                System.out.println("Совпаданий не найдено");
            }
        } else {
            System.out.println("Гараж пуст");
        }
    }
}
