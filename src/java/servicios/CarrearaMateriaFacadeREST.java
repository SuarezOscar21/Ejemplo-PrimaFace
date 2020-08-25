/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;
import modelo.CarrearaMateria;
import modelo.CarrearaMateriaPK;

/**
 *
 * @author DELL
 */
@Stateless
@Path("modelo.carrearamateria")
public class CarrearaMateriaFacadeREST extends AbstractFacade<CarrearaMateria> {

    @PersistenceContext(unitName = "EjemploPrimaFacePU")
    private EntityManager em;

    private CarrearaMateriaPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;id=idValue;materiaIdmateria=materiaIdmateriaValue;carreraIdcarrera=carreraIdcarreraValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        modelo.CarrearaMateriaPK key = new modelo.CarrearaMateriaPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> id = map.get("id");
        if (id != null && !id.isEmpty()) {
            key.setId(new java.lang.Integer(id.get(0)));
        }
        java.util.List<String> materiaIdmateria = map.get("materiaIdmateria");
        if (materiaIdmateria != null && !materiaIdmateria.isEmpty()) {
            key.setMateriaIdmateria(new java.lang.Integer(materiaIdmateria.get(0)));
        }
        java.util.List<String> carreraIdcarrera = map.get("carreraIdcarrera");
        if (carreraIdcarrera != null && !carreraIdcarrera.isEmpty()) {
            key.setCarreraIdcarrera(new java.lang.Integer(carreraIdcarrera.get(0)));
        }
        return key;
    }

    public CarrearaMateriaFacadeREST() {
        super(CarrearaMateria.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(CarrearaMateria entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, CarrearaMateria entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        modelo.CarrearaMateriaPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public CarrearaMateria find(@PathParam("id") PathSegment id) {
        modelo.CarrearaMateriaPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<CarrearaMateria> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<CarrearaMateria> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
