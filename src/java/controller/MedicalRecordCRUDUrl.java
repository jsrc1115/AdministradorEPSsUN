/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.EPS;

/**
 *
 * @author Sebastian
 */
public class MedicalRecordCRUDUrl {

    public void changeEPS(int personId, EPS from, EPS to)
    {
        fachadews.MedicalRecord mr = getMR(personId, from.getUrlRecords());
        deleteMR(personId, from.getUrlRecords());
        createMRList(personId, mr, to.getUrlRecords());
    }   
    
//wsdl = new URL("http://localhost:8080/CreateMedicalRecord/CreateMedicalRecord?WSDL");

    public fachadews.ProcessResult deleteMR(java.lang.Integer arg0, String url) {
        fachadews.MedicalRecordCRUDWS port = getPort(url);
        return port.deleteMR(arg0);
    }

    public fachadews.ProcessResult createMRList(java.lang.Integer arg0, fachadews.MedicalRecord mr, String url) {
        fachadews.MedicalRecordCRUDWS port = getPort(url);
        return port.createMedRList(arg0, mr.getCitas());
    }

    public fachadews.MedicalRecord getMR(java.lang.Integer arg0, String url) {
        fachadews.MedicalRecordCRUDWS port = getPort(url);
        return port.getMR(arg0);
    }
    
    public void setMR(fachadews.MedicalRecord arg0, String url) {
        fachadews.MedicalRecordCRUDWS port = getPort(url);
        port.setMR(arg0);
    }
    
    private fachadews.MedicalRecordCRUDWS getPort(String url)
    {
        URL wsdl = null;
        try {
             wsdl = new URL(url);
        } catch (MalformedURLException ex) {
            Logger.getLogger(MedicalRecordCRUDUrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        fachadews.MedicalRecordCRUD service = new fachadews.MedicalRecordCRUD(wsdl);
        fachadews.MedicalRecordCRUDWS port = service.getMedicalRecordCRUDWSPort();
        return port;
    }

}
