package scratches.workers;

import java.util.ArrayList;

/**
 * Класс-дополнение к Executioner.
 * Предотвращает зацикливание при исполнении скрипта
 *
 * @author slendersold
 * @version 1.1.1
 */
public class CycleBreaker {
    /**
     * Поле пройденных скриптов
     */
    private final static ArrayList<String> executeList = new ArrayList<>();

    /**
     * проверяет скрипты
     *
     * @param name - проверяемый скрипт
     * @return возвращает boolean
     */
    public static boolean checkScripts(String name) {
        executeList.add(" ");
        for (String string : executeList) {
            if (name.equals(string)) {
                return false;
            }
        }
        executeList.add(name);
        return true;
    }

    /**
     * Чистит за собой executeList
     */
    public static void executionNullificator() {
        executeList.clear();
    }
}
