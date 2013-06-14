/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.SingleDAO;
import com.google.code.morphia.Key;
import java.util.List;
import model.EPS;

/**
 *
 * @author Sebastian
 */
public class CRUD_EPS {
    public void create(Integer id, String name, String urlRecord,String urlAppointment)
    {
        EPS eps = new EPS(id, name, urlRecord,urlAppointment);
        System.out.println(eps);
        Key<EPS> key = SingleDAO.getInstance().getEpsDAO().save(eps);                
        System.out.println(key);
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
