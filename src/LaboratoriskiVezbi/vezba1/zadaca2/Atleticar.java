package LaboratoriskiVezbi.vezba1.zadaca2;

public class Atleticar {
    private String name;
    private String gender;
    private int age;
    private double time;
    private String country;

    public Atleticar() {
    }

    public Atleticar(String name, String gender, int age, double time, String country) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.time = time;
        this.country = country;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public double getTime() {
        return time;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return name + "\n" + time + "\n" + country;
    }
}
