/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import controller.CRUD_EPS;
import controller.MedicalRecordCRUDUrl;
import fachadews.MedicalRecord;
import fachadews.MedicalRecordCRUD;
import java.util.List;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.xml.ws.WebServiceRef;
import model.EPS;

/**
 *
 * @author Sebastian
 */
@WebService(serviceName = "MedicalRecordsCRUDUrlWS")
@Stateless()
public class MedicalRecordsCRUDUrlWS {
    @WebServiceRef(wsdlLocation = "META-INF/wsdl/localhost_8080/MedicalRecordCRUD/MedicalRecordCRUDWS.wsdl")
    private MedicalRecordCRUD service;

    public void createMedicalRecord(@WebParam(name = "idRecord") int idMedicalRecord, @WebParam(name = "idEPS") int idEPS) {
        EPS eps = new CRUD_EPS().readByID(idEPS);
        new MedicalRecordCRUDUrl().createMRList(idMedicalRecord,new MedicalRecord(), eps.getUrlRecords());
    }
    
    public MedicalRecord readMedicalRecord(@WebParam(name = "idRecord") int idMedicalRecord, @WebParam(name = "idEPS") int idEPS)
    {
        EPS eps = new CRUD_EPS().readByID(idEPS);
        return new MedicalRecordCRUDUrl().getMR(idMedicalRecord, eps.getUrlRecords());
    }
    
    public void updateMedicalRecord(@WebParam(name = "record") MedicalRecord mr,@WebParam(name = "idEPS") int idEPS)
    {
        EPS eps = new CRUD_EPS().readByID(idEPS);
        new MedicalRecordCRUDUrl().setMR(mr, eps.getUrlRecords());
    }
    
    public void deleteMedicalRecord(@WebParam(name = "idRecord") int idMedicalRecord, @WebParam(name = "idEPS") int idEPS)
    {
        EPS eps = new CRUD_EPS().readByID(idEPS);
        new MedicalRecordCRUDUrl().deleteMR(idMedicalRecord, eps.getUrlRecords());
    }

    public List<MedicalRecord> readAllMedicalRecord(@WebParam(name = "idEPS") int idEPS)
    {
        EPS eps = new CRUD_EPS().readByID(idEPS);
        return new MedicalRecordCRUDUrl().readAllMR(eps.getId());
    }
}
