package scratches.workers.commander;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import scratches.Garage;
import scratches.Vehicle;
import scratches.workers.JSONworker;

/**
 * Класс, добавляющий элементы только если их значение id минимально.
 * Без интерактива
 *
 * @author slendersold
 * @version 1.1.1
 */
public class AddIfMin implements scratches.workers.commander.Two {
    JSONworker JJ = new JSONworker();
    Gson gson = new Gson();

    /**
     * Добавляет минимальных
     *
     * @param garage - обрабатываемый класс
     * @param s      - путь
     * @see AddIfMin#act(Garage, String)
     */
    public void act(Garage garage, String s) {
        s = JJ.JSONliner(s);
        if (!garage.isEmpty()) {
            try {
                Vehicle c = gson.fromJson(s, Vehicle.class);
                dn.filtrate(c);
                wff.filtrate(c);
                if (c.compareTo(garage.first()) > 0) {
                    garage.add(c);
                    System.out.println("Машина добавлена");
                } else {
                    System.out.println("Машина не добавлена");
                }
            } catch (JsonSyntaxException e) {
                System.out.println("JSON syntax exception");
            }
        } else {
            try {
                Vehicle c = gson.fromJson(s, Vehicle.class);
                dn.filtrate(c);
                wff.filtrate(c);
                garage.add(c);
                System.out.println("Коллекция была пуста, но машина добавлена");
            } catch (JsonSyntaxException e) {
                System.out.println("JSON syntax exception");
            }
        }
    }
}
