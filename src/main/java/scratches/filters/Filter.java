package scratches.filters;

import scratches.Vehicle;

/**
 * Интерфейс для обработки неправильно заполненных полей
 *
 * @author slendersold
 * @version 1.1.1
 */
public interface Filter {
    /**
     * универсальный метод для наследников интерфейса Filter.
     * В нем должны обрабатываться поля.
     *
     * @param vehicle - Агрегат
     * @see Filter#filtrate(Vehicle)
     */
    void filtrate(Vehicle vehicle);
}
