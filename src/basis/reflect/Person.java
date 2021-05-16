package basis.reflect;

public class Person {
    public String name;
    int age;
    protected String address;
    private String sex;

    public Person() {
    }

    Person(String name) {
        this.name = name;
    }

    protected Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Person(String name, int age, String address, String sex) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    int getAge() {
        return age;
    }

    void setAge(int age) {
        this.age = age;
    }

    protected String getAddress() {
        return address;
    }

    protected void setAddress(String address) {
        this.address = address;
    }

    private String getSex() {
        return sex;
    }

    private void setSex(String sex) {
        System.out.println("setSex() 方法被调用");
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
