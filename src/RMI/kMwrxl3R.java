package RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Arrays;

public class kMwrxl3R {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        ObjectService objectService = (ObjectService) Naming.lookup("rmi://203.162.10.109/RMIObjectService");
        String studentCode = "B21DCCN268";
        String code = "kMwrxl3R";
        Student student = (Student) objectService.requestObject(studentCode, code);
        System.out.println(student);

        String ma = "";
        int tmpEnroll = student.enrollmentYear;
        int count = 2;
        while (count > 0){
            ma += tmpEnroll % 10;
            tmpEnroll /= 10;
            count--;
        }
        ma = "B" + new StringBuilder(ma).reverse().toString();
        String[] names = student.name.split("\\s+");
        for (int i = 0 ; i < names.length; ++i) {
            names[i] = names[i].substring(0, 1).toUpperCase() + names[i].substring(1).toLowerCase();
        }
        String name = String.join(" ", names);
        System.out.println(name);
        ma += names[names.length - 1].toUpperCase();
        ma += "_";
        for(int i = 0; i < names.length - 1; ++i) {
            ma += names[i].charAt(0);
        }
        System.out.println(ma);
        student.name = name;
        student.code = ma;
        System.out.println(student);
        objectService.submitObject(studentCode, code, student);

    }
}
