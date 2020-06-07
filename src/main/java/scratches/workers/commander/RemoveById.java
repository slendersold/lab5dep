package scratches.workers.commander;

import scratches.Garage;

/**
 * Класс, удаляющий элемент по значению id
 *
 * @author slendersold
 * @version 1.1.1
 */
public class RemoveById implements scratches.workers.commander.Two {
    /**
     * Метод удаляет элемент со значением id, поданым в строке
     *
     * @param garage - обрабатываемый класс
     * @param s      - комбинированная строка ввода
     * @see RemoveById#act(Garage, String)
     */
    public void act(Garage garage, String s) {
        try {
            long idToRemove = Long.parseLong(s);
            int prevSize = garage.size();

            if (!garage.isEmpty()) {
                garage.removeIf(c -> c.getId() == idToRemove);

                if (garage.size() != prevSize) {
                    System.out.println("Машина " + s + " была уничтожена");
                } else {
                    System.out.println("Ничего не изменилось");
                }
            } else {
                System.out.println("Коллекция пуста");
            }
        } catch (NumberFormatException e) {
            System.out.println("Разрешены числа от 0 до " + Long.MAX_VALUE);
        }
    }
}
