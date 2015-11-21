//
// Generated By:JAX-WS RI IBM 2.2.1-07/09/2014 01:52 PM(foreman)- (JAXB RI IBM 2.2.3-07/07/2014 12:54 PM(foreman)-)
//


package com.chase.payment;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "PaymentProcessorService", targetNamespace = "http://payment.chase.com/", wsdlLocation = "WEB-INF/wsdl/PaymentProcessorService.wsdl")
public class PaymentProcessorService
    extends Service
{

    private final static URL PAYMENTPROCESSORSERVICE_WSDL_LOCATION;
    private final static WebServiceException PAYMENTPROCESSORSERVICE_EXCEPTION;
    private final static QName PAYMENTPROCESSORSERVICE_QNAME = new QName("http://payment.chase.com/", "PaymentProcessorService");

    static {
            PAYMENTPROCESSORSERVICE_WSDL_LOCATION = com.chase.payment.PaymentProcessorService.class.getResource("/WEB-INF/wsdl/PaymentProcessorService.wsdl");
        WebServiceException e = null;
        if (PAYMENTPROCESSORSERVICE_WSDL_LOCATION == null) {
            e = new WebServiceException("Cannot find 'WEB-INF/wsdl/PaymentProcessorService.wsdl' wsdl. Place the resource correctly in the classpath.");
        }
        PAYMENTPROCESSORSERVICE_EXCEPTION = e;
    }

    public PaymentProcessorService() {
        super(__getWsdlLocation(), PAYMENTPROCESSORSERVICE_QNAME);
    }

    public PaymentProcessorService(WebServiceFeature... features) {
        super(__getWsdlLocation(), PAYMENTPROCESSORSERVICE_QNAME, features);
    }

    public PaymentProcessorService(URL wsdlLocation) {
        super(wsdlLocation, PAYMENTPROCESSORSERVICE_QNAME);
    }

    public PaymentProcessorService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, PAYMENTPROCESSORSERVICE_QNAME, features);
    }

    public PaymentProcessorService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public PaymentProcessorService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns PaymentProcessorDelegate
     */
    @WebEndpoint(name = "PaymentProcessorPort")
    public PaymentProcessorDelegate getPaymentProcessorPort() {
        return super.getPort(new QName("http://payment.chase.com/", "PaymentProcessorPort"), PaymentProcessorDelegate.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns PaymentProcessorDelegate
     */
    @WebEndpoint(name = "PaymentProcessorPort")
    public PaymentProcessorDelegate getPaymentProcessorPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://payment.chase.com/", "PaymentProcessorPort"), PaymentProcessorDelegate.class, features);
    }

    private static URL __getWsdlLocation() {
        if (PAYMENTPROCESSORSERVICE_EXCEPTION!= null) {
            throw PAYMENTPROCESSORSERVICE_EXCEPTION;
        }
        return PAYMENTPROCESSORSERVICE_WSDL_LOCATION;
    }

}