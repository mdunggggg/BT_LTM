package TCP;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Wl3vbd6x {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("203.162.10.109", 2209);
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

        String MSV = "B21DCCN268";
        String code = "Wl3vbd6x";
        oos.writeObject(MSV + ";" + code);

        Student student = (TCP.Student) ois.readObject();
        System.out.println(student);

        student.setGpaLetter(convert(student.getGpa()));
        System.out.println(student);
        oos.writeObject(student);
    }

    public static String convert(float diem) {
        if(diem < 1.0) return "F";
        if(diem < 2.0) return "D";
        if(diem < 3.0) return "C";
        if(diem < 3.7) return "B";
        return "A";
    }
}
