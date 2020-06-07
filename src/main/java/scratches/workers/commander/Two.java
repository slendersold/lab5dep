package scratches.workers.commander;

import scratches.Garage;
import scratches.filters.DeNullification;

import java.util.Scanner;

/**
 * Интерфейс действия для двуаргументных команд
 *
 * @author slendersold
 * @version 1.1.1
 */
public interface Two {
    /**
     * Поле сканнера
     */
    Scanner scanner = new Scanner(System.in);
    /**
     * Поле денуллификатора
     */
    DeNullification dn = new DeNullification();
    /**
     * Поле исправителя
     */
    scratches.filters.WrongFieldFilter wff = new scratches.filters.WrongFieldFilter();

    /**
     * Метод, в котором будет происходить вся магия
     *
     * @param garage - обрабатываемая коллекция
     * @param s      - подаваемая строка
     * @see Two#act(Garage, String)
     */
    void act(Garage garage, String s);
}
