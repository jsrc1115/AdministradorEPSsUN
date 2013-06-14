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

    public void addAppointment(int idRecord, Appointment appointment, int idEPS)
    {
        EPS eps = new CRUD_EPS().readByID(idEPS);
        new AppointmentCRUDUrl().addAppointment(idRecord, appointment, eps.getUrlAppointments());
    }
    
    public void deleteAppointment(int idRecord,int idAppointment, int idEPS)
    {
        EPS eps = new CRUD_EPS().readByID(idEPS);
        new AppointmentCRUDUrl().deleteAppointment(idRecord, idAppointment, eps.getUrlAppointments());
    }
    
    public void getAppointment(int idRecord,int idAppointment, int idEPS)
    {
        EPS eps = new CRUD_EPS().readByID(idEPS);
        new AppointmentCRUDUrl().getAppointment(idRecord, idAppointment, eps.getUrlAppointments());
    }
    
}
