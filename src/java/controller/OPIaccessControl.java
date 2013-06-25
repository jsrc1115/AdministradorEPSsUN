/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.dataejbopi.ws.ROb;
import java.util.Map;
import javax.xml.ws.BindingProvider;

/**
 *
 * @author Sebastian
 */
public class OPIaccessControl {

    private static String OPI_PERSON_URL = "http://25.16.26.205:8080/EpsWs/EpsWs?wsdl";
    private static String OPI_EPS_URL = "http://25.16.26.205:8080/PersonOpiWs/PersonOpiWs?wsdl";
    
    public ROb regPerson(Long id,Double salary, Long epsID)
    {
        return registerPerson(id, salary, epsID);
    }
    
    public ROb removePerson(Long ID)
    {
        return removeByCedule(ID);
    }
    
    public ROb regEPS(String name, Long accountNumber)
    {
        return registerEps(name, accountNumber);
    }
    
    public ROb removeEPS(Long ID)
    {
        return removeById(ID);
    }
    
    private static ROb registerPerson(java.lang.Long cedule, java.lang.Double salary, java.lang.Long epsId) {
        com.dataejbopi.ws.PersonOpiWs_Service service = new com.dataejbopi.ws.PersonOpiWs_Service();
        com.dataejbopi.ws.PersonOpiWs port = service.getPersonOpiWsPort();
        
        Map<String, Object> requestContext = ((BindingProvider) port).getRequestContext();
        requestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,OPI_PERSON_URL );
        
        return port.registerPerson(cedule, salary, epsId);
    }

    private static ROb removeByCedule(java.lang.Long cedule) {
        com.dataejbopi.ws.PersonOpiWs_Service service = new com.dataejbopi.ws.PersonOpiWs_Service();
        com.dataejbopi.ws.PersonOpiWs port = service.getPersonOpiWsPort();
        
        Map<String, Object> requestContext = ((BindingProvider) port).getRequestContext();
        requestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, OPI_PERSON_URL);
        
        return port.removeByCedule(cedule);
    }

    private static ROb registerEps(java.lang.String name, java.lang.Long accountnumber) {
        com.dataejbopi.ws.EpsWs_Service service = new com.dataejbopi.ws.EpsWs_Service();
        com.dataejbopi.ws.EpsWs port = service.getEpsWsPort();
        return port.registerEps(name, accountnumber);
    }

    private static ROb removeById(java.lang.Long id) {
        com.dataejbopi.ws.EpsWs_Service service = new com.dataejbopi.ws.EpsWs_Service();
        com.dataejbopi.ws.EpsWs port = service.getEpsWsPort();
        return port.removeById(id);
    }
    
}
