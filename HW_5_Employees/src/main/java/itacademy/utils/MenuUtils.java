package itacademy.utils;

import itacademy.api.IEmployeeDao;
import itacademy.menu.Menu;
import itacademy.menu.MenuItem;

public class MenuUtils {

    public static Menu getGlobalMenu() {
        Menu menu = new Menu();
        menu.addItem(new MenuItem("Добавить сотрудника", 1));
        menu.addItem(new MenuItem("Изменить информацию о сотруднике", 2));
        menu.addItem(new MenuItem("Удалить сотрудника", 3));
        menu.addItem(new MenuItem("Показать всех сотрудников", 4));
        menu.addItem(new MenuItem("Найти сотрудников по отделу", 5));
        menu.addItem(new MenuItem("Найти сотрудников по зарплате", 6));
        menu.addItem(new MenuItem("Показать информацию о сотруднике", 7));
        menu.addItem(new MenuItem("Выйти из программы", 0));

        return menu;
    }

    public static Menu getSortedMenu() {
        Menu menu = new Menu();

        menu.addItem(new MenuItem("Сортировать по фамилии", 1));
        menu.addItem(new MenuItem("Сортировать по зарплате", 2));
        menu.addItem(new MenuItem("Без сортировки", 0));

        return menu;
    }

    /**
     * Метод формирует меню для перехода по страницам. Если текущая страница - первая,
     * то возможно лишь перейти на следующую страницу и выйти из режима просмотра.
     * Если текущая страница - последняя, то возможно лишь перейти на предыдущую страницу
     * или выйти из режима просмотра.
     *
     * @param dao объект IEmployeeDao, результаты запросов которого
     * необходимо просматривать постранично
     *
     * @return меню для перехода по страницам
     */
    public static Menu getPagesMenu(IEmployeeDao dao) {
        Menu menu = new Menu();

        MenuItem next = new MenuItem("Следующая страница", 1);
        MenuItem previous = new MenuItem("Предыдущая страница", 2);

        if (dao.getCurrentPage() < dao.getTotalPages()) {
            menu.addItem(next);
        }
        if (dao.getCurrentPage() > 0) {
            menu.addItem(previous);
        }


        menu.addItem(new MenuItem("Вернуться в меню", 0));

        return menu;
    }

    /**
     * Метод для работы с постраничным просмотром информации. Переключает текущую страницу вперед, назад
     * или сбрасывает текущую страницу к первой и входит из режима просмотра
     *
     * @param dao объект IEmployeeDao, результаты запросов которого
     * необходимо просматривать постранично
     * @param choice выбор пользователя в меню постраничного просмотра
     *
     * @return true - если мы переключаемся межу страницами, false - если мы выходим из режима просмотра
     */
    public static boolean handlePagesMenu(IEmployeeDao dao, int choice) {
        if (choice == 1) {
            dao.nextPage();
        } else if (choice == 2) {
            dao.previousPage();
        }
        else {
            dao.setCurrentPage(0);
            dao.notSorted();
            return false;
        }

        return true;
    }

    /**
     * Метод для обработки меню сортировки результатов
     *
     * @param dao объект IEmployeeDao, результаты запросов которого
     * необходимо сортировать
     * @param choice вариант сортировки. 1 - сортировать по фамилии, 2 - сортировать по зарплате, 0 - не сортировать
     */
    public static void handleSortedMenu(IEmployeeDao dao, int choice) {
        dao.notSorted();
        switch (choice) {
            case 1: {
                dao.sortByLastName();
                break;
            }
            case 2: {
                dao.sortBySalary();
                break;
            }
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException("Такого варианта нет!");
            }
        }
    }
}
