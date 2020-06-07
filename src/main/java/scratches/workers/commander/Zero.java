package scratches.workers.commander;

import scratches.filters.DeNullification;

import java.util.Scanner;

/**
 * Интерфейс действия для безаргументных комманд
 *
 * @author slendersold
 * @version 1.1.1
 */
public interface Zero {
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
     * @see Zero#act()
     */
    void act();
}
