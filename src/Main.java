import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Employee ivan = new Employee("Иван", "Игоревич",
                "Овчинников", "8(700)000-11-22",
                "Разработчик", 50000, 1985, Employee.Gender.MALE);
        Employee andrey = new Employee("Андрей", "Викторович",
                "Безруков", "8(705)111-22-33",
                "Техник-монтажник", 52000, 1973, Employee.Gender.MALE);
        Employee evgeniy = new Employee("Евгений", "Викторович",
                "Зилотов", "8(777)222-33-44",
                "Проект менеджер", 40000, 1963, Employee.Gender.MALE);
        Employee natalia = new Employee("Наталья", "Павловна",
                "Зикер", "8(701)333-44-55",
                "Главный разработчик", 90000, 1990, Employee.Gender.FEMALE);
        Employee tatiana = new Employee("Татьяна", "Сергеевна",
                "Касаткина", "8(702)444-55-66",
                "Бухгалтер", 50000, 1983, Employee.Gender.FEMALE);
        Employee alexei = new Manager("Алексей", "Владимирович",
                "Бабиков", "8(777)777-66-00", "Менеджер", 250000, 1987, 5,
                30, Employee.Gender.MALE);
        Employee[] employees = new Employee[6];
        employees[0] = ivan;
        employees[1] = andrey;
        employees[2] = evgeniy;
        employees[3] = natalia;
        employees[4] = tatiana;
        employees[5] = alexei;
        int[] salBeforeIncrease = {ivan.getSalary(), andrey.getSalary(), evgeniy.getSalary(), natalia.getSalary(),
                tatiana.getSalary(), alexei.getSalary()};
//        System.out.println("Зарплаты до повышения" + Arrays.toString(salBeforeIncrease));

        Manager.increaser(employees, 45, 5000);

        int[] salAfterIncrease = {ivan.getSalary(), andrey.getSalary(), evgeniy.getSalary(), natalia.getSalary(),
                tatiana.getSalary(), alexei.getSalary()};
//        System.out.println("Зарплаты после повышения" + Arrays.toString(salAfterIncrease));

        Employee emp1 = new Employee("Роман", "Владимирович",
                "Кузьмин", "8(708)222-33-44",
                "Разработчик", 80000, 1986, 3, 25, Employee.Gender.MALE);
        Employee emp2 = new Employee("Николай", "Евгеньевич",
                "Артемов", "8(705)555-22-55",
                "Менеджер", 200000, 1985, 12, 18, Employee.Gender.MALE);
//        System.out.println(emp1.compareAge(emp2));
//        System.out.println(emp2.compareAge(emp1));

        celebrate(employees);


    }
    enum Holidays{NONE, NEW_YEAR, WOMEN_DAY, DEFENDER_DAY}
    static Holidays today = declareHoliday();
    private static void celebrate (Employee[] employees){
        for (int i = 0; i < employees.length; i++){
            switch (today) {
                case NEW_YEAR:
                    System.out.println("Поздравляем с Новым годом, " + employees[i].getName());
                    break;
                case WOMEN_DAY:
                    if (employees[i].getGender().equals(Employee.Gender.FEMALE)){
                        System.out.println("Поздравляем с 8 марта, " + employees[i].getName());
                    }
                    break;
                case DEFENDER_DAY:
                    if (employees[i].getGender().equals(Employee.Gender.MALE)) {
                        System.out.println("Поздравляем с Днем защитника Отечества, " + employees[i].getName());
                    }
                    break;
                default:
                    System.out.println("Хорошего дня, " + employees[i].getName());
            }
        }
    }

    private static Holidays declareHoliday(){
        Date dateNow = new Date();
        if(dateNow.getDate() == 1 && dateNow.getMonth() == Calendar.JANUARY){
            today = Holidays.NEW_YEAR;
        } else if (dateNow.getDate() == 23 && dateNow.getMonth() == Calendar.FEBRUARY) {
            today = Holidays.DEFENDER_DAY;
        } else if (dateNow.getDate() == 8 && dateNow.getMonth() == Calendar.MARCH) {
            today = Holidays.WOMEN_DAY;
        } else {
            today = Holidays.NONE;
        }
        return today;
    }
}