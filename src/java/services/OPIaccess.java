/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import controller.OPIaccessControl;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.jws.Oneway;

/**
 *
 * @author Sebastian
 */
@WebService(serviceName = "OPIaccess")
@Stateless()
public class OPIaccess {

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
    @WebMethod(operationName = "registerPerson")
    public void registerPerson(@WebParam(name = "id") Long id, @WebParam(name = "salary") Double salary, @WebParam(name = "epsID") Long epsID) {
        new OPIaccessControl().regPerson(id, salary, epsID);
    }
    /**
     * Web service operation
     */
    @WebMethod(operationName = "removePerson")
    @Oneway
    public void removePerson(@WebParam(name = "ID") Long ID) {
        new OPIaccessControl().removePerson(ID);
    }
    /**
     * Web service operation
     */
    @WebMethod(operationName = "registerEPS")
    @Oneway
    public void registerEPS(@WebParam(name = "name") String name, @WebParam(name = "password") Long accountNumber) {
        new OPIaccessControl().regEPS(name, accountNumber);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "removeEPS")
    @Oneway
    public void removeEPS(@WebParam(name = "ID") Long ID) {
        new OPIaccessControl().removeEPS(ID);
    }
    
    
}
