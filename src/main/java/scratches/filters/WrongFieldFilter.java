package scratches.filters;

import scratches.Vehicle;

/**
 * Класс-наследник интерфейса Filter.
 * Осуществляет обработку полей, на которые должны быть наложены ограничения
 *
 * @author slendersold
 * @version 1.1.1
 */
public class WrongFieldFilter implements Filter {

    /**
     * Главный метод данного класса, где произходит вся магия
     *
     * @param vehicle - Агрегат
     * @see WrongFieldFilter#filtrate(Vehicle)
     */
    public void filtrate(Vehicle vehicle) {
        if (vehicle.getName().equals(" ")) {
            System.out.println("Имени нет. Назначаю серийный номер");
            vehicle.setName("vehicle" + vehicle.getId());
        }

        try {
            if (vehicle.getEnginePower() <= 0) {
                System.out.println("Не правильное значение Мощности двигателя. Надеюсь, ты мел ввиду \"1\", ибо я уже исправил");
                vehicle.setEnginePower(1.0);
            }
        } catch (NullPointerException e) {
        }

        try {
            if (vehicle.getDistanceTravelled() <= 0) {
                System.out.println("Не правильное значение пройденного пути. Ты в каком измерении живешь? Не важно, назначено стандартное для этого мира значение");
                vehicle.setDistanceTravelled(1L);
            }
        } catch (NullPointerException e) {
        }


        if (vehicle.getCoordinates().getX() < -379) {
            System.out.println("Боженька сказал, что по иксу меньше -379 двигаться нельзя");
            vehicle.getCoordinates().setX(-379d);
        }

        if (vehicle.getId() < 0) {
            System.out.println("ID только положительный");
            vehicle.setId(vehicle.getName().hashCode());
        }
    }
}
