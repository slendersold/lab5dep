package scratches.workers.commander;

import scratches.Garage;

/**
 * Класс, удаляющий элемент с наименьшим значением
 *
 * @author slendersold
 * @version 1.1.1
 */
public class RemoveLower implements One {
    /**
     * Этот метод удаляет первый элемент
     *
     * @param garage - обрабатываемый класс
     * @see RemoveLower#act(Garage)
     */
    public void act(Garage garage) {
        garage.remove(garage.first());
        System.out.println("Наименьший элемент удален");
    }
}
