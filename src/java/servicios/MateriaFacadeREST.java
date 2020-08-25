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
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import modelo.Materia;

/**
 *
 * @author DELL
 */
@Stateless
@Path("modelo.materia")
public class MateriaFacadeREST extends AbstractFacade<Materia> {

    @PersistenceContext(unitName = "EjemploPrimaFacePU")
    private EntityManager em;

    public MateriaFacadeREST() {
        super(Materia.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Materia entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Materia entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Materia find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Materia> findAll() {
        return super.findAll();
    }
    
    @POST
    @Path("materia")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String crear(@FormParam("idmateria") Integer idmateria, @FormParam("materia") String materia) {

        Materia mate = new Materia(idmateria, materia);
        super.create(mate);
        return "se creo la materia";
    }
    @POST
    @Path("consulta")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Materia> leer(@FormParam("idmateria") Integer idmateria) {
        TypedQuery consulta = getEntityManager().createQuery(" SELECT e FROM materia e WHERE e.idmateria> :idmateria", Materia.class);
        consulta.setParameter("idmateria", idmateria);
        return consulta.getResultList();
    }
    @POST
    @Path("update")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String update(@FormParam("idmateria") Integer idmateria, @FormParam("materia") String materia) {

        Materia mate = super.find(idmateria);
        mate.setMateria(materia);
        super.edit(mate);
        return "se actualizo la materia";
    }
    
    @POST
    @Path("eliminar")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String eliminar(@FormParam("idmateria") Integer idmateria) {

        Materia mate = super.find(idmateria);
        super.remove(mate);
        return "se elimino la materia";
        
    }
    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Materia> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
