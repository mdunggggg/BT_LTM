package UDP;

import java.io.*;
import java.net.*;

public class nfoJnW5v {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String host = "203.162.10.109";
        InetAddress inetAddress = InetAddress.getByName(host);
        int port = 2209;
        String MSV = "B21DCCN268";
        String code = "nfoJnW5v";
        String auth = ";" + MSV + ";" + code;

        DatagramSocket datagramSocket = new DatagramSocket();
        DatagramPacket datagramPacket = new DatagramPacket(auth.getBytes(), auth.length(), inetAddress, port);
        datagramSocket.send(datagramPacket);

        byte[] data = new byte[2024];
        datagramPacket = new DatagramPacket(data, data.length);
        datagramSocket.receive(datagramPacket);

        byte[] request = new byte[8];
        System.arraycopy(datagramPacket.getData(), 0, request, 0, 8);
        String requestID = new String(request).trim();
        System.out.println(requestID);

        ByteArrayInputStream bais = new ByteArrayInputStream(datagramPacket.getData(), 8, datagramPacket.getLength() - 8);
        ObjectInputStream ois = new ObjectInputStream(bais);
        UDP.Product product = (UDP.Product) ois.readObject();
        System.out.println(product);

        String tmpName = "";
        String[] arrayName = product.name.split("\\s+");
        tmpName = arrayName[0];
        arrayName[0] = arrayName[arrayName.length - 1];
        arrayName[arrayName.length - 1] = tmpName;
        product.name = String.join(" ", arrayName);

        int newQuantity = 0;
        int tmpQuantity = product.quantity;
        while (tmpQuantity > 0){
            newQuantity = newQuantity * 10 + tmpQuantity % 10;
            tmpQuantity /=  10;
        }
        product.quantity = newQuantity;

        System.out.println(product);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(product);
        byte[] productByte = baos.toByteArray();

        byte[] ans = new byte[8 + productByte.length];
        System.arraycopy(requestID.getBytes(), 0, ans, 0, 8);
        System.arraycopy(productByte, 0, ans, 8, productByte.length);

        datagramPacket = new DatagramPacket(ans, ans.length, inetAddress, port);
        datagramSocket.send(datagramPacket);
    }


}
