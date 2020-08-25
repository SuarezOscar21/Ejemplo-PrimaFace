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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import modelo.Alumno;

/**
 *
 * @author DELL
 */
@Stateless
@Path("modelo.alumno")
public class AlumnoFacadeREST extends AbstractFacade<Alumno> {

    @PersistenceContext(unitName = "EjemploPrimaFacePU")
    private EntityManager em;

    public AlumnoFacadeREST() {
        super(Alumno.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Alumno entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Alumno entity) {
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
    public Alumno find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Alumno> findAll() {
        return super.findAll();
    }

    @POST
    @Path("hola")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Alumno> obtener() {
        return super.findAll();
    }

    @GET
    @Path("HOLA")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String mensaje(@QueryParam("nombre") String nombre) {

        return "hola:" + nombre;

    }

    @GET
    @Path("SUMA")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String sum(@QueryParam("entero1") int entero1, @QueryParam("entero2") int entero2) {
        int res = entero1 + entero2;
        return "la respuesta es:" + res;
    }

    @POST
    @Path("SUMA2")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String suma(@FormParam("N1") int N1, @FormParam("N2") int N2) {
        int res = N1 + N2;
        return "la respuesta es:" + res;
    }

    @POST
    @Path("MAYOR")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String mayor(@FormParam("num1") int num1, @FormParam("num2") int num2) {

        if (num1 > num2) {
            return "el mayor es:" + num1;
        } else {
            return "el mayor es:" + num2;
        }
    }

   

    @GET
    @Path("CHAO")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String despedida() {
        String mensaje = "chao mundo";
        return mensaje;
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
