/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acosux.MSUpdates.service;

import com.acosux.MSUpdates.util.UpdateTO;
import com.acosux.MSUpdates.util.VersionTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Trabajo
 */
@Transactional
public interface UpdateService {

    List<UpdateTO> buscarActualizacionesPorVersion(String version) throws Exception;

    List<VersionTO> listarVersiones() throws Exception;

}
