package scratches.workers.commander;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import scratches.Garage;
import scratches.Vehicle;
import scratches.workers.JSONworker;

/**
 * Класс, обновляющий состояние какого-то элемента по id
 *
 * @author slendersold
 * @version 1.1.1
 */
public class Update implements scratches.workers.commander.Two {
    /**
     * Здесь на вход идет обрабатывемая коллекция и строка, состоящая их id элемента
     * и полного пути к Json-файлу. Метод обновляет значение элемента коллекции используя значения
     * из Json-файла
     *
     * @param garage - обрабатываемая коллекция
     * @param s      - подаваемая строка
     * @see Update#act(Garage, String)
     */
    public void act(Garage garage, String s) {
        JSONworker JJ = new JSONworker();
        Gson gson = new Gson();
        boolean b = false;
        boolean ex = false;

        if (!garage.isEmpty()) {
            String[] params = s.split(" ", 2);
            if (params.length == 2) {
                try {
                    long neededID = Long.parseLong(params[0]);
                    for (Vehicle c : garage) {
                        if (c.getId() == neededID) {
                            garage.remove(c);
                            try {
                                params[1] = JJ.JSONliner(params[1]);
                                Vehicle vehicle = gson.fromJson(params[1], Vehicle.class);
                                b = true;
                                vehicle.setId(neededID);
                                dn.filtrate(vehicle);
                                wff.filtrate(vehicle);
                                garage.add(vehicle);
                                System.out.println("Машина номер " + neededID + " была проапгрэйжена");
                            } catch (JsonSyntaxException e) {
                                System.out.println("JSON syntax exception");
                                ex = true;
                            }
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Разрешены числа от 0 до " + Long.MAX_VALUE);
                }

                if (!b && !ex) {
                    System.out.println("Ничего не выполнено, все осталось в исходном положении");
                }
            } else {
                System.out.println("Неподдерживаемое число аргументов (должно быть 2). Проверьте строки на разрывы пробелами");
            }
        } else {
            System.out.println("Гараж пуст");
        }
    }
}
