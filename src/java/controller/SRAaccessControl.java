/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.dataejbsra.ws.ROb;

/**
 *
 * @author Sebastian
 */
public class SRAaccessControl {
    
    private static String SRA_COMPANY_URL = "http://25.21.174.183:8080/CompanyWS/CompanyWS?wsdl";
    private static String SRA_RELATION_URL = "http://25.21.174.183:8080/CompanyPersonWS/CompanyPersonWS?wsdl";
    
    public void regCompany(String name, String password)
    {
        registerCompany(name, password);
    }
    public void removeCompany(Long id)
    {
        removeById(id);
    }
    public void validRelation(Long personID,Long companyID,String personPass)
    {
        validateRelation(personID, companyID, personPass);
    }
    public void regRelation(Long personID,Long companyID, String role, String passwordCompany)
    {
        registerRelation(personID, companyID, role, passwordCompany);
    }
    public void remRelation(Long personID, Long companyID, String passwordCompany)
    {
        removeRelation(personID, companyID, passwordCompany);
    }

    private static ROb registerCompany(java.lang.String name, java.lang.String password) {
        com.dataejbsra.ws.CompanyWs_Service service = new com.dataejbsra.ws.CompanyWs_Service();
        com.dataejbsra.ws.CompanyWs port = service.getCompanyWsPort();
        ROb r = port.registerCompany(name, password);
        System.out.println(r);
        return r;
    }

    private static ROb removeById(java.lang.Long id) {
        com.dataejbsra.ws.CompanyWs_Service service = new com.dataejbsra.ws.CompanyWs_Service();
        com.dataejbsra.ws.CompanyWs port = service.getCompanyWsPort();
        return port.removeById(id);
    }

    private static ROb registerRelation(java.lang.Long personCedule, java.lang.Long companyId, java.lang.String rolPerson, java.lang.String passwordCompany) {
        com.dataejbsra.ws.CompanyPersonWs_Service service = new com.dataejbsra.ws.CompanyPersonWs_Service();
        com.dataejbsra.ws.CompanyPersonWs port = service.getCompanyPersonWsPort();
        return port.registerRelation(personCedule, companyId, rolPerson, passwordCompany);
    }

    private static ROb removeRelation(java.lang.Long personCedule, java.lang.Long companyId, java.lang.String passwordCompany) {
        com.dataejbsra.ws.CompanyPersonWs_Service service = new com.dataejbsra.ws.CompanyPersonWs_Service();
        com.dataejbsra.ws.CompanyPersonWs port = service.getCompanyPersonWsPort();
        return port.removeRelation(personCedule, companyId, passwordCompany);
    }

    private static ROb validateRelation(java.lang.Long personCedule, java.lang.Long companyId, java.lang.String personPassword) {
        com.dataejbsra.ws.CompanyPersonWs_Service service = new com.dataejbsra.ws.CompanyPersonWs_Service();
        com.dataejbsra.ws.CompanyPersonWs port = service.getCompanyPersonWsPort();
        return port.validateRelation(personCedule, companyId, personPassword);
    }
}
