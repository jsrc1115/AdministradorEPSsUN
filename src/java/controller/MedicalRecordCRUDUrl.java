/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import fachadews.ProcessResult;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.ws.BindingProvider;
import model.EPS;

/**
 *
 * @author Sebastian
 */
public class MedicalRecordCRUDUrl {

    public void changeEPS(int personId, EPS from, EPS to) {
        fachadews.MedicalRecord mr = getMR(personId, from.getUrlRecords());
        deleteMR(personId, from.getUrlRecords());
        createMRList(personId, mr, to.getUrlRecords());
    }

    public fachadews.ProcessResult deleteMR(java.lang.Integer arg0, String url) {
        fachadews.MedicalRecordCRUDWS port = getPort(url);
        return port.deleteMR(arg0);
    }

    public fachadews.ProcessResult createMRList(java.lang.Integer arg0, fachadews.MedicalRecord mr, String url) {
        fachadews.MedicalRecordCRUDWS port = getPort(url);
        return port.createMRList(arg0, mr.getCitas());
    }

    public fachadews.MedicalRecord getMR(java.lang.Integer arg0, String url) {
        fachadews.MedicalRecordCRUDWS port = getPort(url);
        return port.getMR(arg0);
    }

    public void setMR(fachadews.MedicalRecord arg0, String url) {
        fachadews.MedicalRecordCRUDWS port = getPort(url);
        port.setMR(arg0);
    }

    private fachadews.MedicalRecordCRUDWS getPort(String url) {
        fachadews.MedicalRecordCRUD service = new fachadews.MedicalRecordCRUD();
        fachadews.MedicalRecordCRUDWS port = service.getMedicalRecordCRUDWSPort();

        Map<String, Object> requestContext = ((BindingProvider) port).getRequestContext();
        requestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);

        return port;
    }

    public java.util.List<fachadews.MedicalRecord> readAllMR(java.lang.Integer arg0) {
        fachadews.MedicalRecordCRUD service = new fachadews.MedicalRecordCRUD();
        fachadews.MedicalRecordCRUDWS port = service.getMedicalRecordCRUDWSPort();
        return port.readAllMR(arg0);
    }
}
