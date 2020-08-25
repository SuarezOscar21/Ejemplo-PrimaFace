/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author DELL
 */
@Embeddable
public class CarrearaMateriaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "materia_idmateria")
    private int materiaIdmateria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "carrera_idcarrera")
    private int carreraIdcarrera;

    public CarrearaMateriaPK() {
    }

    public CarrearaMateriaPK(int id, int materiaIdmateria, int carreraIdcarrera) {
        this.id = id;
        this.materiaIdmateria = materiaIdmateria;
        this.carreraIdcarrera = carreraIdcarrera;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMateriaIdmateria() {
        return materiaIdmateria;
    }

    public void setMateriaIdmateria(int materiaIdmateria) {
        this.materiaIdmateria = materiaIdmateria;
    }

    public int getCarreraIdcarrera() {
        return carreraIdcarrera;
    }

    public void setCarreraIdcarrera(int carreraIdcarrera) {
        this.carreraIdcarrera = carreraIdcarrera;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) materiaIdmateria;
        hash += (int) carreraIdcarrera;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarrearaMateriaPK)) {
            return false;
        }
        CarrearaMateriaPK other = (CarrearaMateriaPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.materiaIdmateria != other.materiaIdmateria) {
            return false;
        }
        if (this.carreraIdcarrera != other.carreraIdcarrera) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.CarrearaMateriaPK[ id=" + id + ", materiaIdmateria=" + materiaIdmateria + ", carreraIdcarrera=" + carreraIdcarrera + " ]";
    }
    
}
