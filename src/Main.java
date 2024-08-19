import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Employee ivan = new Employee("Ivan", "Igorevich",
                "Ovchinnikov", "8(495)000-11-22",
                "developer", 50000, 1985, Employee.Gender.MALE);
        Employee andrey = new Employee("Andrey", "Viktorovich",
                "Bezrukov", "8(495)111-22-33",
                "fitter", 52000, 1973, Employee.Gender.MALE);
        Employee evgeniy = new Employee("Evgeniy", "Viktorovich",
                "Delfinov", "8(495)222-33-44",
                "project manager", 40000, 1963, Employee.Gender.MALE);
        Employee natalia = new Employee("Natalia", "Pavlovna",
                "Keks", "8(495)333-44-55",
                "senior developer", 90000, 1990, Employee.Gender.FEMALE);
        Employee tatiana = new Employee("Tatiana", "Sergeevna",
                "Krasotkina", "8(495)444-55-66",
                "accountant", 50000, 1983, Employee.Gender.FEMALE);
        Employee alexei = new Manager("Alexei", "Vladimirovich",
                "Bobylev", "8(495)777-66-00", "manager", 250000, 1987, 5,
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

        Employee emp1 = new Employee("Roman", "Vladimirovich",
                "Kuzmich", "8(495)222-33-44",
                "developer", 80000, 1986, 3, 25, Employee.Gender.MALE);
        Employee emp2 = new Employee("Nikolay", "Evgenievich",
                "Artemov", "8(495)555-22-55",
                "manager", 200000, 1985, 12, 18, Employee.Gender.MALE);
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
                        System.out.println("Поздравляем с Днем защитника Откчества, " + employees[i].getName());
                    }
                    break;
                default:
                    System.out.println("Какой чудесный день, " + employees[i].getName());
            }
        }
    }

    private static Holidays declareHoliday(){
        Date dateNow = new Date();
        if(dateNow.getDate() == 1 && dateNow.getMonth() == 1){
            today = Holidays.NEW_YEAR;
        } else if (dateNow.getDate() == 23 && dateNow.getMonth() == 2) {
            today = Holidays.DEFENDER_DAY;
        } else if (dateNow.getDate() == 8 && dateNow.getMonth() == 3) {
            today = Holidays.WOMEN_DAY;
        } else {
            today = Holidays.NONE;
        }
        return today;
    }
}