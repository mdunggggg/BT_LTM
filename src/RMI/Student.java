package RMI;

import java.io.Serializable;

public class Student implements Serializable {
    String id;
    String name;
    int enrollmentYear;
    String code;
    private static final long serialVersionUID = 20241130L;

    public Student() {
    }

    public Student(String id, String name, int enrollmentYear, String code) {
        this.id = id;
        this.name = name;
        this.enrollmentYear = enrollmentYear;
        this.code = code;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", enrollmentYear=" + enrollmentYear +
                ", code='" + code + '\'' +
                '}';
    }
}
