/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.google.code.morphia.Morphia;
import com.google.code.morphia.dao.BasicDAO;
import com.mongodb.Mongo;
import java.util.List;
import model.EPS;

/**
 *
 * @author Sebastian
 */
public class EPS_DAO extends BasicDAO<EPS, Integer>{
    public EPS_DAO(Mongo mongo,Morphia morphia,String dbName){
        super(mongo,morphia,dbName);
    }
    public List<EPS> findAll()
    {
        return ds.find(EPS.class).asList();
    }
    
}
