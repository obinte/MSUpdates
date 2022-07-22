/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acosux.MSUpdates.service;

import com.acosux.MSUpdates.util.UpdateTO;
import com.acosux.MSUpdates.util.ComboGenericoTO;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Trabajo
 */
@Transactional
public interface UpdateService {

    public List <UpdateTO>  buscarActualizacionesPorVersion(String version) throws Exception;
    
    public List <ComboGenericoTO>  listarVersiones() throws Exception;

}
