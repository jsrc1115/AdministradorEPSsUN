/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import controller.CRUD_EPS;
import controller.MedicalRecordCRUDUrl;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.ejb.Stateless;
import javax.jws.WebParam;
import model.EPS;

/**
 *
 * @author Sebastian
 */
@WebService(serviceName = "CRUD_EPS_ws")
@Stateless()
public class CRUD_EPS_ws {
    
    @WebMethod(operationName = "createEPS")
    public void createEPS(@WebParam(name = "idEPS") int id, @WebParam(name = "nombreEPS") String name, @WebParam(name = "IPandPort") String IP)
    {        
        new CRUD_EPS().create(id, name, IP);
    }
    
    @WebMethod(operationName = "readOneEPS")
    public EPS readByID(@WebParam(name = "idEPS") int id)
    {        
        return new CRUD_EPS().readByID(new Integer(id));
    }
    
    @WebMethod(operationName = "readAllEPS")
    public List<EPS> readAll()
    {        
        return new CRUD_EPS().readAll();
    }
    
    @WebMethod(operationName = "updateEPS")
    public void updateEPS(@WebParam(name = "idEPS") int id, @WebParam(name = "nombreEPS") String name, @WebParam(name = "urlMedicalRecord") String urlRecord, @WebParam(name = "urlAppointment") String urlAppointment)
    {        
        new CRUD_EPS().update(id, name, urlRecord, urlAppointment);
    }
    
    @WebMethod(operationName = "deleteEPS")
    public void deleteID(@WebParam(name = "idEPS") int id)
    {        
        new CRUD_EPS().delete(new Integer(id));
    }
    
    @WebMethod(operationName = "changeEPS")
    public void changeEPS(@WebParam(name = "idRecord") int idRecord, @WebParam(name = "fromEPS") EPS from, @WebParam(name = "toEPS") EPS to)
    {
        new MedicalRecordCRUDUrl().changeEPS(idRecord,from,to);
    }
    
}
