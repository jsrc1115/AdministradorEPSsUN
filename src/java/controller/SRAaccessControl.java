/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Sebastian
 */
public class SRAaccessControl {
    
    private static String SRA_COMPANY_URL = "http://25.16.26.205:8080/CompanyWS/CompanyWS?wsdl";
    private static String SRA_RELATION_URL = "http://25.16.26.205:8080/CompanyPersonWS/CompanyPersonWS?wsdl";
    
    public void regCompany(String name, String password)
    {
        //TODO:
    }
    public void removeCompany(Long id)
    {
        //TODO:
    }
    public void validRelation(Long personID,Long companyID,String personPass)
    {
        //TODO:
    }
    public void regRelation(Long personID,Long companyID, String role, String passwordCompany)
    {
        //TODO:
    }
    public void remRelation(Long personID, Long companyID, String passwordCompany)
    {
        //TODO:
    }
}
