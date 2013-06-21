/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.SingleDAO;
import java.util.List;
import model.EPS;

/**
 *
 * @author Sebastian
 */
public class CRUD_EPS {
    
    private String pre = "http://";
    private String posRecord = "/MedicalRecordCRUD/MedicalRecordCRUDWS?WSDL";
    private String posAppointment = "/AppointmentCRUDWS/AppointmentCRUDWS?WSDL";
    
    public void create(Integer id, String name, String IP)
    {
        String urlRecord = pre+IP+posRecord;
        String urlAppointment = pre+IP+posAppointment;
        EPS eps = new EPS(id, name, urlRecord,urlAppointment);
        SingleDAO.getInstance().getEpsDAO().save(eps);
    }
    public List<EPS> readAll()
    {
        return SingleDAO.getInstance().getEpsDAO().findAll();
    }
    public EPS readByID(Integer id)
    {
        return SingleDAO.getInstance().getEpsDAO().get(id);
    }
    public void update(Integer id, String name, String urlRecord, String urlAppointment)
    {
        EPS eps = new EPS(id, name, urlRecord,urlAppointment);
        SingleDAO.getInstance().getEpsDAO().save(eps);
    }
    public void delete(Integer id)
    {
        SingleDAO.getInstance().getEpsDAO().deleteById(id);
    }
}
