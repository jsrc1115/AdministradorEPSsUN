/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;
import java.net.UnknownHostException;
import model.EPS;

/**
 *
 * @author Sebastian
 */
public class SingleDAO {
    private Mongo mongo = null;
    private Morphia morphia = null;
    private String dbName = "ADM_EPS";

    //Specific DAO's
    private EPS_DAO epsDAO;
        
    private static SingleDAO m_this;
    
    private SingleDAO() {
        
        try {
            mongo = new Mongo("localhost", 27017);
        } catch(UnknownHostException e){
            e.printStackTrace();
        }
        
        morphia = new Morphia();
        morphia.map(EPS.class);
        
        epsDAO = new EPS_DAO(mongo, morphia, dbName);
    }
    
    public synchronized static SingleDAO getInstance() {
		while (m_this == null) {
			m_this = new SingleDAO();
		}
		return m_this;
    }

    public EPS_DAO getEpsDAO() {
        return epsDAO;
    }
}
