
package medianews;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "CharacterService", targetNamespace = "http://medianews.vn/", wsdlLocation = "http://203.162.10.109:8080/JNPWS/CharacterService?wsdl")
public class CharacterService_Service
    extends Service
{

    private final static URL CHARACTERSERVICE_WSDL_LOCATION;
    private final static WebServiceException CHARACTERSERVICE_EXCEPTION;
    private final static QName CHARACTERSERVICE_QNAME = new QName("http://medianews.vn/", "CharacterService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://203.162.10.109:8080/JNPWS/CharacterService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CHARACTERSERVICE_WSDL_LOCATION = url;
        CHARACTERSERVICE_EXCEPTION = e;
    }

    public CharacterService_Service() {
        super(__getWsdlLocation(), CHARACTERSERVICE_QNAME);
    }

    public CharacterService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), CHARACTERSERVICE_QNAME, features);
    }

    public CharacterService_Service(URL wsdlLocation) {
        super(wsdlLocation, CHARACTERSERVICE_QNAME);
    }

    public CharacterService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CHARACTERSERVICE_QNAME, features);
    }

    public CharacterService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CharacterService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CharacterService
     */
    @WebEndpoint(name = "CharacterServicePort")
    public CharacterService getCharacterServicePort() {
        return super.getPort(new QName("http://medianews.vn/", "CharacterServicePort"), CharacterService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CharacterService
     */
    @WebEndpoint(name = "CharacterServicePort")
    public CharacterService getCharacterServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://medianews.vn/", "CharacterServicePort"), CharacterService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CHARACTERSERVICE_EXCEPTION!= null) {
            throw CHARACTERSERVICE_EXCEPTION;
        }
        return CHARACTERSERVICE_WSDL_LOCATION;
    }

}
