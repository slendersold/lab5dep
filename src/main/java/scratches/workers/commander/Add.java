package scratches.workers.commander;

import scratches.Garage;
import scratches.Vehicle;
import scratches.filters.DeNullification;
import scratches.filters.WrongFieldFilter;
import scratches.workers.JSONworker;

import java.util.NoSuchElementException;

/**
 * Класс, добавлющийновые элементы
 * добавление может быть как интерактивным, так и через json-файл
 *
 * @author slendersold
 * @version 1.1.1
 */
public class Add implements scratches.workers.commander.One, scratches.workers.commander.Two {
    private final DeNullification deNullification = new DeNullification();
    private final WrongFieldFilter wrongFieldFilter = new WrongFieldFilter();
    JSONworker JJ = new JSONworker();

    /**
     * Добавляет
     *
     * @param garage - обрабатываемый класс
     * @see AddIfMin#act(Garage, String)
     */
    public void act(Garage garage) {
        try {
            Vehicle v;
            while (true) {
                try {
                    System.out.println("Введите имя");
                    String name = "";
                    if (One.scanner.nextLine() != null) {
                        name = One.scanner.nextLine();
                    } else {
                        continue;
                    }
                    System.out.println("Введите координату X (Разрешен Double)");
                    Double X = One.scanner.nextDouble();
                    System.out.println("Введите координату Y (Разрешен Float)");
                    float Y = One.scanner.nextFloat();
                    System.out.println("Какой пробег? (Разрешен Long)");
                    Long dist = One.scanner.nextLong();
                    Vehicle w = new Vehicle(name, X, Y, dist);
                    v = w;
                    break;
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Попробуй еще раз");
                }
            }

            System.out.println("Хотите слить нам параметры вашего движка в Дж?(Y|y)");

            while (true) {
                String uselessAnswer = One.scanner.nextLine();
                if (uselessAnswer.equalsIgnoreCase("Y")) {
                    System.out.println("Ну давай тогда, пиши");
                    try {
                        v.setEnginePower(One.scanner.nextDouble());
                        break;
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Описался, с кем не бывает. Ты точно, хочешь ввести значение своего движка?(Y|y)");
                        System.out.println("Описался, с кем не бывает. Ты точно, хочешь ввести значение своего движка?(Y|y)");
                    }
                } else if (!uselessAnswer.equals("")) {
                    System.out.println("Ладно");
                    break;
                }
            }
            System.out.println("А теперь по серьезке. Что это за штука? Не хочешь - не отвечай (Y|N)");

            while (true) {
                String uselessAnswer = One.scanner.nextLine();
                if (uselessAnswer.equalsIgnoreCase("y")) {
                    System.out.println("Сюда помещается только это: CAR,SHIP,MOTORCYCLE,CHOPPER,SPACESHIP");
                    v.setType(One.scanner.nextLine());
                    break;
                } else {
                    if (uselessAnswer.equalsIgnoreCase("n")) {
                        System.out.println("Ладно");
                        break;
                    } else {
                        System.out.println("Не отвлекайся, я за тобой слежу");
                    }
                }
            }
            System.out.println("Можешь сказать, чем его кормить?(Y|N)");
            while (true) {
                String uselessAnswer = One.scanner.nextLine();
                if (uselessAnswer.equalsIgnoreCase("y")) {
                    System.out.println("Ну, ты знаешь, что делать: GASOLINE,KEROSENE,ELECTRICITY,NUCLEAR,ANTIMATTER");
                    v.setFuel(One.scanner.nextLine());
                    break;
                } else {
                    if (uselessAnswer.equalsIgnoreCase("n")) {
                        System.out.println("Окееей");
                        break;
                    } else {
                        System.out.println("Эй, еще раз!");
                    }
                }
            }
            deNullification.filtrate(v);
            wrongFieldFilter.filtrate(v);

            garage.add(v);
            System.out.println("Спасибо, можете ввести новые команды?");
        } catch (NoSuchElementException e) {
            System.out.println("Пока");
        }
    }

    /**
     * Добавляет
     *
     * @param garage - обрабатываемый класс
     * @param s      - путь
     * @see AddIfMin#act(Garage, String)
     */
    public void act(Garage garage, String s) {
        JJ.fromJSONAddVehicle(garage, s);
    }
}
