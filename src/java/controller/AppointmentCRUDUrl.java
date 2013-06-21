/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import fachadews.Appointment;
import fachadews.ProcessResult;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.ws.BindingProvider;

/**
 *
 * @author Sebastian
 */
public class AppointmentCRUDUrl {

    public ProcessResult addAppointment(java.lang.Integer arg0, fachadews.Appointment arg1, String url) {
        fachadews.AppointmentCRUDWS port = getPort(url);
        return port.addAppointment(arg0, arg1);
    }

    public ProcessResult deleteAppointment(java.lang.Integer arg0, java.lang.Integer arg1, String url) {
        fachadews.AppointmentCRUDWS port = getPort(url);
        return port.deleteAppointment(arg0, arg1);
    }

    public Appointment getAppointment(java.lang.Integer arg0, java.lang.Integer arg1, String url) {
        fachadews.AppointmentCRUDWS port = getPort(url);
        return port.getAppointment(arg0, arg1);
    }
    
    private fachadews.AppointmentCRUDWS getPort(String url)
    {
        
        fachadews.AppointmentCRUDWS_Service service = new fachadews.AppointmentCRUDWS_Service();
        fachadews.AppointmentCRUDWS port = service.getAppointmentCRUDWSPort();
        
        Map<String, Object> requestContext = ((BindingProvider) port).getRequestContext();
        requestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);
        
        return port;
    }
}
