/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mudanzas.test.persistence;

import co.edu.uniandes.csw.mudanzas.entities.DireccionEntity;
import co.edu.uniandes.csw.mudanzas.entities.VehiculoEntity;
import co.edu.uniandes.csw.mudanzas.persistence.VehiculoPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author estudiante
 */
@RunWith(Arquillian.class)
public class VehiculoPersistenceTest 
{
    PodamFactory factory = new PodamFactoryImpl();
    /**
     * Inyección de la persistencia del vehiculo
     */
     @Inject
    private VehiculoPersistence VPersistence;
    /**
     * Inyección de la persistencia del dia
     */ 
     @Inject
     private DireccionEntity dEntity;
    
    /**
     * Contexto de Persistencia que se va a utilizar para acceder a la Base de
     * datos por fuera de los métodos que se están probando.
     */
    @PersistenceContext
    private EntityManager em;
    
     /**
     * Variable para martcar las transacciones del em anterior cuando se
     * crean/borran datos para las pruebas.
     */
    @Inject
    UserTransaction utx;
    
    /**
     * Lista que tiene los datos de prueba.
     */
    private List<VehiculoEntity> data = new ArrayList<VehiculoEntity>();

  
    
    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Editorial, el descriptor de la
     * base de datos y el archivo beans.xml para resolver la inyección de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(VehiculoEntity.class.getPackage())
                .addPackage(VehiculoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Configuración inicial de la prueba.
     */
    @Before
    public void configTest() {
        try {
            utx.begin();
            em.joinTransaction();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
    /**
     * Crea datos aleatorios de entidades, los cuales los mete en la base de datos
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {

            VehiculoEntity entity = factory.manufacturePojo(VehiculoEntity.class);

            em.persist(entity);

            data.add(entity);
        }
    }
    private void clearData() 
    {
        em.createQuery("delete from VehiculoEntity").executeUpdate();
    }
    /**
     * verificación de las reglas de negocio del vehiculo con un test
     */
    @Test
    public void createVehiculoTest()
    {
        VehiculoEntity newEntity = factory.manufacturePojo(VehiculoEntity.class);
        VehiculoEntity result = VPersistence.create(newEntity);
        Assert.assertNotNull(result);

        VehiculoEntity entity = em.find(VehiculoEntity.class, result.getId());

        Assert.assertEquals(newEntity.getId(), entity.getId());
    }
    
    /**
     * verificación la eliminación de un vehiculo con un test
     */
      @Test
    public void deleteVehiculoTest() {
        VehiculoEntity entidad = data.get(0);
        VPersistence.delete(entidad.getId());
        VehiculoEntity borrado = em.find(VehiculoEntity.class, entidad.getId());
        Assert.assertNull(borrado);
    }
    /**
     * verificación la actualización de un vehiculo con un test
     */
    @Test
    public void updateVehiculoTest() {
        VehiculoEntity entidad = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        VehiculoEntity cambiada = factory.manufacturePojo(VehiculoEntity.class);

        cambiada.setId(entidad.getId());

        VPersistence.update(cambiada);

        VehiculoEntity encontrada = em.find(VehiculoEntity.class, entidad.getId());

        Assert.assertEquals(cambiada.getNumeroConductores(), encontrada.getNumeroConductores());
        Assert.assertEquals(cambiada.getId(), encontrada.getId());
        Assert.assertEquals(cambiada.getMarca(), encontrada.getMarca());
        Assert.assertEquals(cambiada.getColor(), encontrada.getColor());
        Assert.assertEquals(cambiada.getPlaca(), encontrada.getPlaca());
    }
     /**
     * verificación la obtención de un vehiculo con un test
     */
     @Test
    public void getVehiculoTest() {
        VehiculoEntity entidad = data.get(0);
        VehiculoEntity nuevo = VPersistence.find(entidad.getId());
        Assert.assertNotNull(nuevo);
        Assert.assertEquals(entidad.getNumeroConductores(), nuevo.getNumeroConductores());
        Assert.assertEquals(entidad.getId(), nuevo.getId());
        Assert.assertEquals(entidad.getMarca(), nuevo.getMarca());
        Assert.assertEquals(entidad.getColor(), nuevo.getColor());
        Assert.assertEquals(entidad.getPlaca(), nuevo.getPlaca());
    }
    /**
     * Busca un vehiculo por su placa
     */
    @Test
    public void buscarVehiculoPorPlacaTest() {
        VehiculoEntity entidad = data.get(0);
        VehiculoEntity nuevo = VPersistence.findByPlaca(entidad.getPlaca());
        Assert.assertNotNull(nuevo);
        Assert.assertEquals(entidad.getPlaca(), nuevo.getPlaca());
        Assert.assertEquals(entidad.getProveedor().getLogin(), nuevo.getProveedor().getLogin());
        nuevo = VPersistence.findByPlaca(null);
        Assert.assertNull(nuevo);
    }

//    @Test
//    public void buscarVehiculoPorAgenda() {
//        VehiculoEntity entidad = data.get(0);
//        VehiculoEntity nuevo = VPersistence.findByDia(entidad.getAgenda().getId(),entidad.getPlaca());
//        Assert.assertNotNull(nuevo);
//        Assert.assertEquals(entidad.getAgenda().getId(), nuevo.getAgenda().getId());
//      //  nuevo = VPersistence.findByDia(null);
//     //   Assert.assertNull(nuevo);
//    }
//    

    
     @Test
    public void getVehiculosTest() {
        List<VehiculoEntity> lista = VPersistence.findAll();
        Assert.assertEquals(data.size(), lista.size());

        for (VehiculoEntity enLista : lista) {
            boolean loEncontre = false;
            for (VehiculoEntity enData : data) {
                if (enLista.getId().equals(enData.getId()));
                loEncontre = true;
            }
            Assert.assertTrue(loEncontre);
        }

    }
      
    

    
}
