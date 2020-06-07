package scratches.workers;

import scratches.Garage;
import scratches.workers.commander.*;

import java.io.*;
import java.util.NoSuchElementException;

/**
 * Класс, призванный работать с командами команд
 *
 * @author slendersold
 * @version 1.1.1
 */
public class Executioner {
    /**
     * Метод, внутри которого происходит обработка скрипта
     *
     * @param garage   обрабатываемая коллекция
     * @param s        передаваемый скрипт
     * @param argument аргумент коммандной строки
     * @see Executioner#process(Garage, String, String)
     */
    public static void process(Garage garage, String s, String argument) {
        String line;
        Add add = new Add();
        AddIfMax addIfMax = new AddIfMax();
        AddIfMin addIfMin = new AddIfMin();
        FilterStartsWithName filterStartsWithName = new FilterStartsWithName();
        Help help = new Help();
        Info info = new Info();
        PrintDescending printDescending = new PrintDescending();
        PrintFieldDescendingEnginePower printFieldDescendingEnginePower = new PrintFieldDescendingEnginePower();
        RemoveById removeById = new RemoveById();
        RemoveLower removeLower = new RemoveLower();
        Save save = new Save();
        Show show = new Show();
        Update update = new Update();

        try {
            File file = new File(s);
            FileReader fr = new FileReader(file);
            BufferedReader istream = new BufferedReader(fr);

            outer:
            while (true) {
                line = istream.readLine();
                if (line == null) break;
                System.out.println(line);
                String[] input_ar = line.split(" ");
                switch (input_ar[0]) {
                    case "help": {
                        help.act();
                        break;
                    }
                    case "info": {
                        info.act(garage);
                        break;
                    }
                    case "show": {
                        show.act(garage);
                        break;
                    }
                    case "add": {
                        if (input_ar.length != 1) {
                            add.act(garage, input_ar[1]);
                        } else {
                            add.act(garage);
                        }
                        break;
                    }
                    case "update": {
                        if (input_ar.length != 1) {
                            update.act(garage, input_ar[1]);
                        } else {
                            System.out.println("Вы не ввели аргумент команды, вас вернуло в меню ввода команды");
                        }
                        break;
                    }
                    case "remove_by_id": {
                        if (input_ar.length != 1) {
                            removeById.act(garage, input_ar[1]);
                        } else {
                            System.out.println("Вы не ввели аргумент команды, вас вернуло в меню ввода команды");
                        }
                        break;
                    }
                    case "clear": {
                        garage.clear();
                        break;
                    }
                    case "save": {
                        save.act(garage, argument);
                        break;
                    }
                    case "execute_script": {
                        if (input_ar.length != 1) {
                            if (CycleBreaker.checkScripts(input_ar[1])) {
                                process(garage, input_ar[1], argument);
                            } else {
                                System.out.println("Образовался цикл. Подрубаю протоколы уклонения");
                            }
                        } else {
                            System.out.println("Вы не ввели аргумент команды, вас вернуло в меню ввода команды");
                        }
                        break;
                    }
                    case "exit": {
                        break outer;
                    }
                    case "add_if_max": {
                        if (input_ar.length != 1) {
                            addIfMax.act(garage, input_ar[1]);
                        } else {
                            System.out.println("Вы не ввели аргумент команды, вас вернуло в меню ввода команды");
                        }
                        break;
                    }
                    case "add_if_min": {
                        if (input_ar.length != 1) {
                            addIfMin.act(garage, input_ar[1]);
                        } else {
                            System.out.println("Вы не ввели аргумент команды, вас вернуло в меню ввода команды");
                        }
                        break;
                    }
                    case "remove_lower": {
                        removeLower.act(garage);
                        break;
                    }
                    case "filter_starts_with_name": {
                        if (input_ar.length != 1) {
                            filterStartsWithName.act(garage, input_ar[1]);
                        } else {
                            System.out.println("Вы не ввели аргумент команды, вас вернуло в меню ввода команды");
                        }
                        break;
                    }
                    case "print_descending": {
                        printDescending.act(garage);
                        break;
                    }
                    case "print_field_ascending_engine_power": {
                        printFieldDescendingEnginePower.act(garage);
                        break;
                    }
                    default: {
                        System.out.println("СЛЫЫЫЫЫЫЫЫШЬ!");
                        System.out.println("Введи команду из списка в help.");
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Не могу найти файл(");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchElementException e) {
            CycleBreaker.executionNullificator();
            System.out.println("Пока");
            System.exit(0);
        }

        CycleBreaker.executionNullificator();
    }
}

