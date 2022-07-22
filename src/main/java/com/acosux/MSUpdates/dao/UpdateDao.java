/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acosux.MSUpdates.dao;

import com.acosux.MSUpdates.util.UpdateTO;
import com.acosux.MSUpdates.util.ComboGenericoTO;
import com.acosux.MSUpdates.util.dao.GenericDao;
import java.util.List;

public interface UpdateDao extends GenericDao<UpdateTO, Integer> {

    public List <UpdateTO> buscarActualizacionesPorVersion(String version) throws Exception;
    
    public List <ComboGenericoTO> listarVersiones() throws Exception;

}
