package scratches.workers.commander;

import scratches.Garage;
import scratches.filters.DeNullification;

import java.util.Scanner;

/**
 * Интерфейс действия для одноаргументных команд
 *
 * @author slendersold
 * @version 1.1.1
 */
public interface One {
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
     * @see One#act(Garage)
     */
    void act(Garage garage);
}
