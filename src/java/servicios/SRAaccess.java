/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import controller.SRAaccessControl;
import java.io.Serializable;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.jws.Oneway;

/**
 *
 * @author Sebastian
 */
@WebService(serviceName = "SRAaccess")
@Stateless()
public class SRAaccess implements Serializable{

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "registerCompany")
    @Oneway
    public void registerCompany(@WebParam(name = "name") String name, @WebParam(name = "password") String password) {
        new SRAaccessControl().regCompany(name, password);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "removeCompany")
    @Oneway
    public void removeCompany(@WebParam(name = "ID") Long ID) {
        new SRAaccessControl().removeCompany(ID);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "validRelation")
    @Oneway
    public void validRelation(@WebParam(name = "personID") Long personID, @WebParam(name = "companyID") Long companyID, @WebParam(name = "personPassword") String personPassword) {
        new SRAaccessControl().validRelation(personID, companyID, personPassword);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "registerRelation")
    @Oneway
    public void registerRelation(@WebParam(name = "personID") Long personID, @WebParam(name = "companyID") Long companyID, @WebParam(name = "rolPerson") String rolPerson, @WebParam(name = "passwordCompany") String passwordCompany) {
        new SRAaccessControl().regRelation(personID, companyID, rolPerson, passwordCompany);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "removeRelation")
    @Oneway
    public void removeRelation(@WebParam(name = "personID") Long personID, @WebParam(name = "companyID") Long companyID, @WebParam(name = "passwordCompany") String passwordCompany) {
        new SRAaccessControl().remRelation(personID, companyID, passwordCompany);
    }
}
