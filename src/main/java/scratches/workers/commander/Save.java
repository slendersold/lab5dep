package scratches.workers.commander;

import com.google.gson.Gson;
import scratches.Garage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Класс, сохраняющий коллекцию в исходный Json-файл,
 * поданый через аргумент командной строки
 *
 * @author slendersold
 * @version 1.1.1
 */
public class Save implements Two {
    Gson gson = new Gson();

    /**
     * Здесь на вход идет обрабатывемая коллекция и строка, состоящая их id элемента
     * и полного пути к Json-файлу. Метод обновляет значение элемента коллекции используя значения
     * из Json-файла
     *
     * @param garage - обрабатываемый класс
     * @param s      - комбинированная строка ввода
     * @see Save#act(Garage, String)
     */
    public void act(Garage garage, String s) {
        BufferedWriter bw = null;
        FileWriter fw = null;
        String strCollection;
        boolean flag = true;

        File file = new File(s);

        try {
            strCollection = gson.toJson(garage);

            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            bw.write(strCollection);
            System.out.println("Сохранение завершено");

        } catch (IOException e) {
            System.out.println("С этим файлом что-то не так. Стандартные методы JavaIO не могут с ним справиться");
        } catch (OutOfMemoryError e) {
            System.out.println("Коллекция слишком большая");
        } catch (SecurityException e) {
            System.out.println("Невозможно создать файл в данной директории");
        } catch (NullPointerException e) {
            System.out.println("Ошибка на Миллион!");
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                System.out.println("Error while closing the BufferedWriter");
            }
        }
    }
}
