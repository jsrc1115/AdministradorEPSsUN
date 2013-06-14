/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
/**
 *
 * @author Sebastian
 */
@Entity
public class EPS {
    @Id
    private Integer id;
    private String name;
    private String urlRecords;
    private String urlAppointments;

    public EPS() {
    }

    public EPS(Integer id, String name, String urlRecord, String urlAppointment) {
        this.id = id;
        this.name = name;
        this.urlRecords = urlRecord;
        urlAppointments = urlAppointment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlRecords() {
        return urlRecords;
    }

    public void setUrlRecords(String url) {
        this.urlRecords = url;
    }

    public String getUrlAppointments() {
        return urlAppointments;
    }

    public void setUrlAppointments(String urlAppointments) {
        this.urlAppointments = urlAppointments;
    }
    
    
    
}
