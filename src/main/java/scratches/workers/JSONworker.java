package scratches.workers;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import scratches.Garage;
import scratches.Vehicle;
import scratches.filters.DeNullification;
import scratches.filters.WrongFieldFilter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

/**
 * Класс, призванный работать с json-файлами
 *
 * @author slendersold
 * @version 1.1.1
 */
public class JSONworker {
    /**
     * Поле обрабатываемой коллекции
     */
    private final Garage garage = new Garage();
    /**
     * Поле Gson
     */
    private final Gson gson = new Gson();

    /**
     * Поле денуллификатора
     */
    private final DeNullification dn = new DeNullification();
    /**
     * Поле проверщика
     */
    private final WrongFieldFilter wff = new WrongFieldFilter();

    /**
     * Безопасно распаковывает json, передавая интересующее значение
     *
     * @param jsonPath - полный путь к json-файлу
     * @return возвращает коллекцию
     */
    public Garage fromJSON(String jsonPath) {
        DeNullification dn = new DeNullification();
        WrongFieldFilter wff = new WrongFieldFilter();
        File jsonFile = new File(jsonPath);
        String line;
        StringBuilder data = new StringBuilder();
        int counter;

        if (!jsonFile.exists()) {
            System.out.println("Файл не существует");
            System.exit(0);
        }
        if (!jsonFile.isFile()) {
            System.out.println("Это не файл");
            System.exit(0);
        }
        if (!jsonFile.canRead()) {
            System.out.println("Файл вне доступа");
            System.exit(0);
        }
        if (!jsonPath.endsWith(".json")) {
            System.out.println("Это не json-файл");
            System.exit(0);
        }


        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(jsonPath), StandardCharsets.UTF_8));

            while ((line = br.readLine()) != null) {
                data.append(line);
            }

            Garage newVehicle = gson.fromJson(data.toString(), Garage.class);

            for (Vehicle c : newVehicle) {
                if (!garage.contains(c)) {
                    dn.filtrate(c);
                    wff.filtrate(c);
                    garage.add(c);
                }
            }


        } catch (JsonSyntaxException e) {
            System.out.println("JSON syntax error. Программа скоро отключится");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Какая-то ошибка возникла в момент чтения файла");
            System.exit(0);
        }
        garage.setAuthDateTime(LocalDateTime.now());
        counter = garage.size();
        System.out.println("JSON успешно загружен. " + counter + " новых машинок было добавлено в гараж");

        return garage;
    }

    /**
     * Добавляет в коллекцию ТС из json-файла
     *
     * @param garage   - обрабатываемая коллекция
     * @param jsonPath - путь к реке
     */
    public void fromJSONAddVehicle(Garage garage, String jsonPath) {
        File jsonFile = new File(jsonPath);
        String line;
        StringBuilder data = new StringBuilder();

        if (!jsonFile.exists()) {
            System.out.println("Файл не существует");
            System.exit(0);
        }
        if (!jsonFile.isFile()) {
            System.out.println("Это не файл");
            System.exit(0);
        }
        if (!jsonFile.canRead()) {
            System.out.println("Файл вне доступа");
            System.exit(0);
        }
        if (!jsonPath.endsWith(".json")) {
            System.out.println("Это не json-файл");
            System.exit(0);
        }


        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(jsonPath), StandardCharsets.UTF_8));

            while ((line = br.readLine()) != null) {
                data.append(line);
            }

            Vehicle c = gson.fromJson(data.toString(), Vehicle.class);

            if (!garage.contains(c)) {
                dn.filtrate(c);
                wff.filtrate(c);
                garage.add(c);
            }


        } catch (JsonSyntaxException e) {
            System.out.println("JSON syntax error. Программа скоро отключится");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Какая-то ошибка возникла в момент чтения файла");
            System.exit(0);
        }
        System.out.println("JSON успешно загружен.");
    }

    /**
     * Безопасно извлекает содержимое json-файла для дальнейших манипуляций
     *
     * @param jsonPath - полный путь к json-файлу
     * @return возвращает строку
     */
    public String JSONliner(String jsonPath) {
        File jsonFile = new File(jsonPath);
        String line;


        if (!jsonFile.exists()) {
            System.out.println("Файл не существует");
            System.exit(0);
        }
        if (!jsonFile.isFile()) {
            System.out.println("Это не файл");
            System.exit(0);
        }
        if (!jsonFile.canRead()) {
            System.out.println("Файл вне доступа");
            System.exit(0);
        }
        if (!jsonPath.endsWith(".json")) {
            System.out.println("Это не json-файл");
            System.exit(0);
        }

        StringBuilder data = new StringBuilder(jsonPath);

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(jsonPath), StandardCharsets.UTF_8));
            data = new StringBuilder();
            while ((line = br.readLine()) != null) {
                data.append(line);
            }
        } catch (JsonSyntaxException e) {
            System.out.println("JSON syntax error. Программа скоро отключится");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Какая-то ошибка возникла в момент чтения файла");
            System.exit(0);
        }

        return data.toString();
    }

}
