import java.time.Year;

public class Employee {
    private String name;
    private String midName;
    private String lastName;
    private String position;
    private String phone;
    private Integer salary;
    private Integer birthY;
    private Integer birthM;
    private Integer birthD;
    private Gender gender;

    public enum Gender{
        MALE, FEMALE;

    }

    public int getAge() {
        return Year.now().getValue() - birthY;
    }

    public void info() {
        System.out.println("Employee{" +
                "name='" + name + '\'' +
                ", midName='" + midName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", age=" + getAge() +
                '}');
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", midName='" + midName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", birthDate=" + birthY +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMidName() {
        return midName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getBirthDate() {
        return birthY;
    }

    public void setBirthDate(Integer birthDate) {
        this.birthY = birthDate;
    }

    public Gender getGender(){
        return gender;
    }
    public void setGender(Gender gender){
        this.gender = gender;
    }

    public Employee(String name, String midName, String lastName, String phone, String position, Integer salary,
                    Integer birthY, Gender gender) {
        this.name = name;
        this.midName = midName;
        this.lastName = lastName;
        this.position = position;
        this.phone = phone;
        this.salary = salary;
        this.birthY = birthY;
        this.gender = gender;
    }
    public Employee(String name, String midName, String lastName, String phone, String position, Integer salary,
                    Integer birthY, Integer birthM, Integer birthD, Gender gender) {
        this.name = name;
        this.midName = midName;
        this.lastName = lastName;
        this.position = position;
        this.phone = phone;
        this.salary = salary;
        this.birthY = birthY;
        this.birthM = birthM;
        this.birthD = birthD;
        this.gender = gender;
    }

    public void increaseSalary(Integer amount) {
        this.salary += amount;
    }

    /**
     * @apiNote Метод сравнения даты рождения сотрудников
     * @param emp Сотрудник, с которым сравнивается дата рождения
     * @return Разница в возрасте сотрудников в днях. Положительное число - текущий сотрудник старше, отрицательное
     * число - текущий сотрудник моложе
     */
    public int compareAge(Employee emp){
        Integer curEmpAge = this.birthD + (this.birthM * 30)  + (this.birthY * 365);
        Integer anotherEmpAge = emp.birthD + (emp.birthM * 30) + (emp.birthY * 365);
        return (curEmpAge - anotherEmpAge) * (-1);
    }


}