package scratches.workers;

import scratches.Garage;
import scratches.workers.commander.*;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Класс, призванный работать с командами
 *
 * @author slendersold
 * @version 1.1.1
 */
public class Assistant {
    /**
     * Метод, внутри которого происходит обработка команд пользователя
     *
     * @param garage   обрабатываемая коллекция
     * @param argument аргумент коммандной строки
     * @see Assistant#process(Garage, String)
     */
    public static void process(Garage garage, String argument) {
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
        Scanner scanner = new Scanner(System.in);

        outer:
        while (true) {
            try {
                String command = scanner.nextLine();
                String[] input_ar = command.split(" ");
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
                                scratches.workers.Executioner.process(garage, input_ar[1], argument);
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
            } catch (NoSuchElementException e) {
                System.out.println("Пока");
                System.exit(0);
            }
        }
    }
}
