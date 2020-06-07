package scratches.workers.commander;

import scratches.Garage;

/**
 * Класс, прдоставляющий информацию
 *
 * @author slendersold
 * @version 1.1.1
 */
public class Info implements scratches.workers.commander.One {
    /**
     * Предоставляет информацию о коллекции
     *
     * @param garage - обрабатываемый класс
     * @see Info#act(Garage)
     */
    public void act(Garage garage) {
        if (garage.isEmpty()) {
            System.out.println(
                    "                                           ```..........```                                         \n" +
                            "                                       ``..-:::////////:::--.``                                     \n" +
                            "                                     `..-:/++ooo++////++++//::-.``                                  \n" +
                            "                                  ``.-:/+oso+/////////:::::/+/::-.``                                \n" +
                            "                                 `.-:/+oso++++/-..````..-::--://::-.``                              \n" +
                            "                              ``..-:+oso++++:`            .-:--://:--.``                            \n" +
                            "                           ``..--:/osso+o+/`                .-:--//:---.```                         \n" +
                            "                    ````..---::/+osssoo++/                   `-::-::::---..`````                    \n" +
                            "            ````.---:::/+++++ooossosysoo/  `                  `..::---:::------....`````            \n" +
                            "         ```.....-:://+oo+ooossyyyssso++:---..````````````````...-:-:-:::::------...``````          \n" +
                            "                   `````....------:::::-:::::::::::::::------------......````````                   \n" +
                            "                                        ` `                                                         \n" +
                            "                                      ./o/o/`              .-:/-`                                   \n" +
                            "                                      `-/o+/+:.`        `.:::/:.                                    \n" +
                            "                                       `-:+o+////:----::::///-.                                     \n" +
                            "                                         `-:/+++++//////+/:-.`                                      \n" +
                            "                                           ``.-::////::--.`                                         \n" +
                            "                                                ``````                                              \n" +
                            "                                                пустота                                             \n");
        } else {
            System.out.println("Размер: " + garage.size() + "\n" +
                    "Дата постройки: " + garage.getAuthDateTime() + "\n" +
                    "Тип Вашего гаража: " + garage.getClass().getSimpleName());
        }
    }
}
