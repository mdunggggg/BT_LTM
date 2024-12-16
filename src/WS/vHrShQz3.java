package WS;

public class vHrShQz3 {
    public static void main(String[] args) {
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        String studentCode = "B21DCCN268";
        String qCode = "vHrShQz3";
        ProductY productY = port.requestProductY(studentCode, qCode);
        float price = productY.getPrice() * (1 + productY.getTaxRate() / 100) * (1 - productY.getDiscount() / 100);
        productY.setFinalPrice(price);
        port.submitProductY(studentCode, qCode, productY);
    }
}
