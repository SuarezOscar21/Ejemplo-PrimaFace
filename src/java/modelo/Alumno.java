/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "alumno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alumno.findAll", query = "SELECT a FROM Alumno a")
    , @NamedQuery(name = "Alumno.findByIdalumno", query = "SELECT a FROM Alumno a WHERE a.idalumno = :idalumno")
    , @NamedQuery(name = "Alumno.findByAlumno", query = "SELECT a FROM Alumno a WHERE a.alumno = :alumno")})
public class Alumno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idalumno")
    private Integer idalumno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "alumno")
    private String alumno;
    @JoinColumn(name = "carrera_idcarrera", referencedColumnName = "idcarrera")
    @ManyToOne(optional = false)
    private Carrera carreraIdcarrera;

    public Alumno() {
    }

    public Alumno(Integer idalumno) {
        this.idalumno = idalumno;
    }

    public Alumno(Integer idalumno, String alumno) {
        this.idalumno = idalumno;
        this.alumno = alumno;
    }

    public Integer getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(Integer idalumno) {
        this.idalumno = idalumno;
    }

    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    public Carrera getCarreraIdcarrera() {
        return carreraIdcarrera;
    }

    public void setCarreraIdcarrera(Carrera carreraIdcarrera) {
        this.carreraIdcarrera = carreraIdcarrera;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idalumno != null ? idalumno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumno)) {
            return false;
        }
        Alumno other = (Alumno) object;
        if ((this.idalumno == null && other.idalumno != null) || (this.idalumno != null && !this.idalumno.equals(other.idalumno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Alumno[ idalumno=" + idalumno + " ]";
    }
    
}
