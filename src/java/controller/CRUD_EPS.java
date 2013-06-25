/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.SingleDAO;
import com.dataejbsra.ws.ROb;
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
    private String posFinancial = "/registerEPSBankAccount/RegisterEPSBankAccount?WSDL";
    
    public void create(Integer id, String name, String IP,String password)
    {
        String urlRecord = pre+IP+posRecord;
        String urlAppointment = pre+IP+posAppointment;
        String urlFinancial = pre+IP+posFinancial;
        EPS eps = new EPS(id, name, urlRecord,urlAppointment,urlFinancial);
        SingleDAO.getInstance().getEpsDAO().save(eps);
        
        //REGISTRADURIAAAAAAAAAAA
        new SRAaccessControl().regCompany(name, password);
        //
    }
    public List<EPS> readAll()
    {
        return SingleDAO.getInstance().getEpsDAO().findAll();
    }
    public EPS readByID(Integer id)
    {
        return SingleDAO.getInstance().getEpsDAO().get(id);
    }
    public void update(Integer id, String name, String urlRecord, String urlAppointment, String urlFinancial)
    {
        EPS eps = new EPS(id, name, urlRecord,urlAppointment,urlFinancial);
        SingleDAO.getInstance().getEpsDAO().save(eps);
    }
    public void delete(Integer id)
    {
        SingleDAO.getInstance().getEpsDAO().deleteById(id);
    }
    
}
