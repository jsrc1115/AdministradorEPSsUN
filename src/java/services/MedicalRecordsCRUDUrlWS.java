/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import controller.CRUD_EPS;
import controller.MedicalRecordCRUDUrl;
import fachadews.MedicalRecord;
import javax.jws.WebService;
import javax.ejb.Stateless;
import model.EPS;

/**
 *
 * @author Sebastian
 */
@WebService(serviceName = "MedicalRecordsCRUDUrlWS")
@Stateless()
public class MedicalRecordsCRUDUrlWS {

    public void createMedicalRecord(int idMedicalRecord, int idEPS) {
        EPS eps = new CRUD_EPS().readByID(idEPS);
        new MedicalRecordCRUDUrl().createMRList(idMedicalRecord,new MedicalRecord(), eps.getUrlRecords());
    }
    
    public MedicalRecord readMedicalRecord(int idMedicalRecord, int idEPS)
    {
        EPS eps = new CRUD_EPS().readByID(idEPS);
        return new MedicalRecordCRUDUrl().getMR(idMedicalRecord, eps.getUrlRecords());
    }
    
    public void updateMedicalRecord(MedicalRecord mr,int idEPS)
    {
        EPS eps = new CRUD_EPS().readByID(idEPS);
        new MedicalRecordCRUDUrl().setMR(mr, eps.getUrlRecords());
    }
    
    public void deleteMedicalRecord(int idMedicalRecord, int idEPS)
    {
        EPS eps = new CRUD_EPS().readByID(idEPS);
        new MedicalRecordCRUDUrl().deleteMR(idMedicalRecord, eps.getUrlRecords());
    }
    
}
