/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mudanzas.ejb;

import co.edu.uniandes.csw.mudanzas.entities.SubastaEntity;
import co.edu.uniandes.csw.mudanzas.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.mudanzas.persistence.SubastaPersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Andres Gonzalez
 */
@Stateless
public class SubastaLogic {
    @Inject
    private SubastaPersistence persistence;
    
    
    public SubastaEntity createSubasta(SubastaEntity subEntity) throws Exception
    {
        if(persistence.find(subEntity.getId())!=null)
        {
           throw new BusinessLogicException("la subasta con id: "+ subEntity.getId()+ "ya existe");
        }
        return persistence.create(subEntity);
    }
    
}
