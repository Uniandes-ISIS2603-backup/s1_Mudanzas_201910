/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mudanzas.resources;

import co.edu.uniandes.csw.mudanzas.dtos.SubastaDTO;
import java.util.List;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author Daniel Machado
 */
public class SubastasProveedorResource {
    
    private static final Logger LOGGER = Logger.getLogger(SubastasProveedorResource.class.getName());
    
     /**
     * Busca y devuelve todas las subastas que existen en el proveedor.
     *
     * @param login del proveedor que se esta buscando.
     * @return JSONArray {@link SubastaDTO} - Las subastas encontradas en el
     * proveedor. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<SubastaDTO> getSubastas(@PathParam("login") String login)
    {
        return null;
    }
    
     /**
     * Busca la subasta con el idSubasta asociado dentro del proveedor con el login asociado.
     *
     * @param login del proveedor que se esta buscando.
     * @param idSubasta Identificador de la subasta que se esta buscando. Este debe
     * ser una cadena de dígitos.
     * @return JSON {@link SubastaDTO} - La Subasta buscada
     */
    @GET
    @Path("{idSubasta: \\d+}")
    public SubastaDTO getSubasta(@PathParam("login") String login, @PathParam("idSubasta") Long idSubasta)
    {
        return null;
    }
    
        /**
     * Guarda una subasta dentro de un usuario con la informacion que recibe el
     * la URL. Se devuelve la subasta que se guarda en el usuario.
     *
     * @param login del proveedor que se esta
     * actualizando.
     * @param idSubasta Identificador de la subasta que se desea guardar. Este debe
     * ser una cadena de dígitos.
     * @return JSON {@link SubastaDTO} - La subasta guardada en el proveedor.
     */
    @POST
    @Path("{idSubasta: \\d+}")
    public SubastaDTO crearSubasta(@PathParam("login") String login,@PathParam("idSubasta") Long idSubasta)
    {
        return null;
    }
    
     /**
     * Remplaza una instancia de Subasta asociada a una instancia del Proveedor
     *
     * @param login del proveedor que se esta
     * remplazando.
     * @param idSubasta Identificador de la subasta que se desea actualizar. Este debe
     * ser una cadena de dígitos.
     * @return JSON {@link SubastaDTO} - La Subasta Actualizada
     */
    @PUT
    @Path("{idSubasta: \\d+}")
    public SubastaDTO cambiarSubasta(@PathParam("login") String login, @PathParam("idSubasta") Long idSubasta){
        return null;
    }
}
