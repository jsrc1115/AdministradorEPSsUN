/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import controller.CRUD_EPS;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.ejb.Stateless;
import model.EPS;

/**
 *
 * @author Sebastian
 */
@WebService(serviceName = "CRUD_EPS_ws")
@Stateless()
public class CRUD_EPS_ws {
    
    @WebMethod(operationName = "createEPS")
    public void createEPS(int id, String name, String urlRecord, String urlAppointment)
    {        
        new CRUD_EPS().create(id, name, urlRecord, urlAppointment);
    }
    
    @WebMethod(operationName = "readOneEPS")
    public EPS readByID(int id)
    {        
        return new CRUD_EPS().readByID(new Integer(id));
    }
    
    @WebMethod(operationName = "readAllEPS")
    public List<EPS> readAll()
    {        
        return new CRUD_EPS().readAll();
    }
    
    @WebMethod(operationName = "updateEPS")
    public void updateEPS(int id, String name, String urlRecord, String urlAppointment)
    {        
        new CRUD_EPS().update(id, name, urlRecord, urlAppointment);
    }
    
    @WebMethod(operationName = "deleteEPS")
    public void deleteID(int id)
    {        
        new CRUD_EPS().delete(new Integer(id));
    }
    
    @WebMethod(operationName = "changeEPS")
    public void changeEPS(int id, EPS from, EPS to)
    {
        //new MedicalRecordAccess().changeEPS(id,from,to);
    }
    
}
