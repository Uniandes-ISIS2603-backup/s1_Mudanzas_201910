/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mudanzas.resources;

import co.edu.uniandes.csw.mudanzas.dtos.TarjetaDeCreditoDTO;
import co.edu.uniandes.csw.mudanzas.dtos.UsuarioDTO;
import java.util.List;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Clase que implementa el recurso "usuarios/{login}/tarjetas"
 * @author Luis Miguel
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TarjetasUsuarioResource {
    
    private static final Logger LOGGER = Logger.getLogger(TarjetasUsuarioResource.class.getName());

    /**
     * Busca y devuelve todas las tarjetas que existen en el usuario.
     *
     * @param login del usuario que se esta buscando.
     * @return JSONArray {@link TarjetaDeCreditoDTO} - Las tarjetas encontradas en el
     * usuario. Si no hay ninguno retorna una lista vacía.
     * @return retornaria para pruebas el login de quien se quieren las tarjetas. 
     */
    @GET
    public String getTarjetas(@PathParam("login") String login)
    {
        return login;
    }
    
    /**
     * Busca la tarjeta con el idTarjeta asociado dentro del usuario con el login asociado.
     *
     * @param login del usuario que se esta buscando.
     * @param idTarjeta Identificador de la tarjeta que se esta buscando. Este debe
     * ser una cadena de dígitos.
     * @return JSON {@link TarjetaDeCreditoDTO} - La Tarjeta buscada
     */
    @GET
    @Path("{idTarjeta: \\d+}")
    public TarjetaDeCreditoDTO getTarjeta(@PathParam("login") String login, @PathParam("idTarjeta") Long idTarjeta)
    {
        UsuarioDTO usr = new UsuarioDTO();
        usr.setLogin(login);
        usr.setNombre("Luis Miguel");
        usr.setApellido("Gomez Londono");
        usr.setCiudadDeOrigen("Manizales");
        usr.setCorreoElectronico("lm.gomezl@uniandes.edu.co");
        usr.setPassword("123456");
                
        TarjetaDeCreditoDTO tarjeta = new TarjetaDeCreditoDTO();
        tarjeta.setIdTarjeta(idTarjeta);
        tarjeta.setTitularCuenta(usr);
        tarjeta.setCodigoSeguridad(000);
        tarjeta.setFechaVencimiento("01/01/2020");
        tarjeta.setNombreTarjeta(usr.getNombre());
        tarjeta.setNumeroSerial(123456789);
        return tarjeta;
    }
    
    /**
     * Guarda una tarjeta dentro de un usuario con la informacion que recibe el
     * la URL. Se devuelve la tarjeta que se guarda en el usuario.
     *
     * @param login del usuario que se esta
     * actualizando.
     * @param idTarjeta Identificador de la tarjeta que se desea guardar. Este debe
     * ser una cadena de dígitos.
     * @return JSON {@link TarjetaDeCreditoDTO} - La tarjeta guardada en el usuario.
     */
    @POST
    @Path("{idTarjeta: \\d+}")
    public TarjetaDeCreditoDTO crearTarjeta(@PathParam("login") String login,@PathParam("idTarjeta") Long idTarjeta)
    {
        UsuarioDTO usr = new UsuarioDTO();
        usr.setLogin(login);
        usr.setNombre("Luis Miguel");
        usr.setApellido("Gomez Londono");
        usr.setCiudadDeOrigen("Manizales");
        usr.setCorreoElectronico("lm.gomezl@uniandes.edu.co");
        usr.setPassword("123456");
                
        TarjetaDeCreditoDTO tarjeta = new TarjetaDeCreditoDTO();
        tarjeta.setIdTarjeta(idTarjeta);
        tarjeta.setTitularCuenta(usr);
        tarjeta.setCodigoSeguridad(000);
        tarjeta.setFechaVencimiento("01/01/2020");
        tarjeta.setNombreTarjeta(usr.getNombre());
        tarjeta.setNumeroSerial(123456789);
        return tarjeta;
    }
    
    /**
     * Remplaza una instancia de Tarjeta de Credito asociada a una instancia del Usuario
     *
     * @param login del usuario que se esta
     * remplazando.
     * @param idTarjeta Identificador de la tarjeta que se desea actualizar. Este debe
     * ser una cadena de dígitos.
     * @return JSON {@link TarjetaDeCreditoDTO} - La Tarjeta de Credito Actualizada
     */
    @PUT
    @Path("{idTarjeta: \\d+}")
    public TarjetaDeCreditoDTO cambiarTarjeta(@PathParam("login") String login, @PathParam("idTarjeta") Long idTarjeta){
        UsuarioDTO usr = new UsuarioDTO();
        usr.setLogin(login);
        usr.setNombre("Luis Miguel");
        usr.setApellido("Gomez Londono");
        usr.setCiudadDeOrigen("Manizales");
        usr.setCorreoElectronico("lm.gomezl@uniandes.edu.co");
        usr.setPassword("123456");
                
        TarjetaDeCreditoDTO tarjeta = new TarjetaDeCreditoDTO();
        tarjeta.setIdTarjeta(idTarjeta);
        tarjeta.setTitularCuenta(usr);
        tarjeta.setCodigoSeguridad(000);
        tarjeta.setFechaVencimiento("01/01/2020");
        tarjeta.setNombreTarjeta(usr.getNombre());
        tarjeta.setNumeroSerial(123456789);
        return tarjeta;
    }
    
}