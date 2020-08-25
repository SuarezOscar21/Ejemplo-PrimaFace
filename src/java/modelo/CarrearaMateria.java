/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "carreara_materia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CarrearaMateria.findAll", query = "SELECT c FROM CarrearaMateria c")
    , @NamedQuery(name = "CarrearaMateria.findById", query = "SELECT c FROM CarrearaMateria c WHERE c.carrearaMateriaPK.id = :id")
    , @NamedQuery(name = "CarrearaMateria.findByMateriaIdmateria", query = "SELECT c FROM CarrearaMateria c WHERE c.carrearaMateriaPK.materiaIdmateria = :materiaIdmateria")
    , @NamedQuery(name = "CarrearaMateria.findByCarreraIdcarrera", query = "SELECT c FROM CarrearaMateria c WHERE c.carrearaMateriaPK.carreraIdcarrera = :carreraIdcarrera")})
public class CarrearaMateria implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CarrearaMateriaPK carrearaMateriaPK;
    @JoinColumn(name = "carrera_idcarrera", referencedColumnName = "idcarrera", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Carrera carrera;
    @JoinColumn(name = "materia_idmateria", referencedColumnName = "idmateria", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Materia materia;

    public CarrearaMateria() {
    }

    public CarrearaMateria(CarrearaMateriaPK carrearaMateriaPK) {
        this.carrearaMateriaPK = carrearaMateriaPK;
    }

    public CarrearaMateria(int id, int materiaIdmateria, int carreraIdcarrera) {
        this.carrearaMateriaPK = new CarrearaMateriaPK(id, materiaIdmateria, carreraIdcarrera);
    }

    public CarrearaMateriaPK getCarrearaMateriaPK() {
        return carrearaMateriaPK;
    }

    public void setCarrearaMateriaPK(CarrearaMateriaPK carrearaMateriaPK) {
        this.carrearaMateriaPK = carrearaMateriaPK;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carrearaMateriaPK != null ? carrearaMateriaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarrearaMateria)) {
            return false;
        }
        CarrearaMateria other = (CarrearaMateria) object;
        if ((this.carrearaMateriaPK == null && other.carrearaMateriaPK != null) || (this.carrearaMateriaPK != null && !this.carrearaMateriaPK.equals(other.carrearaMateriaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.CarrearaMateria[ carrearaMateriaPK=" + carrearaMateriaPK + " ]";
    }
    
}
