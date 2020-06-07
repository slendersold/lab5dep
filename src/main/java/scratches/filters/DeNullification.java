package scratches.filters;

import scratches.Coordinates;
import scratches.Vehicle;

/**
 * Класс-наследник интерфейса Filter.
 * Осуществляет обработку полей, обязательных для заполнения
 *
 * @author slendersold
 * @version 1.1.1
 */
public class DeNullification implements Filter {

    /**
     * Главный метод данного класса, где произходит вся магия
     *
     * @param vehicle - Агрегат
     * @see DeNullification#filtrate(Vehicle)
     */
    public void filtrate(Vehicle vehicle) {
        if (vehicle.getName() == null || vehicle.getName().equals("")) {
            System.out.println("Поле, обязательное к заполнению (Имя) пусто. Вы будете стерты! Шутка, Ха---Ха...");

            vehicle.setName("id" + vehicle.getId());
        }

        if (vehicle.getCoordinates() == null) {
            System.out.println("Пространство не определено. Возвращаюсь в начальную точку");

            vehicle.setCoordinates(new Coordinates(100d, 100f));
        }

        if (vehicle.getCoordinates().getX() == null) {
            System.out.println("Широта не определена. Возможно, я где-то на экваторе (координата Х обнуляется)");

            vehicle.getCoordinates().setX(100d);
        }

        if (Double.valueOf(vehicle.getCoordinates().getY()) == null) {
            System.out.println("Долгота не определена. Наблюдаю трансгрессию в Гринвич (Координата Y обнуляется)");

            vehicle.getCoordinates().setY(100f);
        }
    }
}
