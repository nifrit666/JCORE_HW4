public class Manager extends Employee {
    public Manager(String name, String midName, String lastName, String phone, String position, Integer salary,
                   Integer birthY, Integer birthM, Integer birthD, Gender gender) {
        super(name, midName, lastName, phone, position, salary, birthY, birthM, birthD, gender);
    }
    public static void increaser(Employee[] emp, Integer age, Integer increment) {
        for (int i = 0; i < emp.length; i++) {
            if (emp[i].getAge() > age && !(emp[i] instanceof Manager)) {
                emp[i].increaseSalary(increment);
            }
        }
    }
}