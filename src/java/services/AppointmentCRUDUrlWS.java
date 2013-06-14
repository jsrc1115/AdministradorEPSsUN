/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import controller.AppointmentCRUDUrl;
import controller.CRUD_EPS;
import fachadews.Appointment;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import model.EPS;

/**
 *
 * @author Sebastian
 */
@WebService(serviceName = "AppointmentCRUDUrlWS")
@Stateless()
public class AppointmentCRUDUrlWS {

    @WebMethod(operationName = "addAppoinment")
    public void addAppointment(@WebParam(name = "idRecord") int idRecord, @WebParam(name = "appointment") Appointment appointment, @WebParam(name = "idEPS") int idEPS)
    {
        EPS eps = new CRUD_EPS().readByID(idEPS);
        new AppointmentCRUDUrl().addAppointment(idRecord, appointment, eps.getUrlAppointments());
    }
    
    @WebMethod(operationName = "deleteAppoinment")
    public void deleteAppointment(@WebParam(name = "idRecord") int idRecord,@WebParam(name = "idAppointment") int idAppointment, @WebParam(name = "idEPS") int idEPS)
    {
        EPS eps = new CRUD_EPS().readByID(idEPS);
        new AppointmentCRUDUrl().deleteAppointment(idRecord, idAppointment, eps.getUrlAppointments());
    }
    @WebMethod(operationName = "getAppointment")
    public void getAppointment(@WebParam(name = "idRecord") int idRecord,@WebParam(name = "idAppointment") int idAppointment, @WebParam(name = "idEPS") int idEPS)
    {
        EPS eps = new CRUD_EPS().readByID(idEPS);
        new AppointmentCRUDUrl().getAppointment(idRecord, idAppointment, eps.getUrlAppointments());
    }
    
}
