/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acosux.MSUpdates.service;

import com.acosux.MSUpdates.util.UpdateTO;
import com.acosux.MSUpdates.util.ComboGenericoTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.acosux.MSUpdates.dao.UpdateDao;

/**
 *
 * @author Trabajo
 */
@Service
public class UpdateServiceImpl implements UpdateService {

    @Autowired
    private UpdateDao actualizacionDao;

    @Override
    public List <UpdateTO>  buscarActualizacionesPorVersion(String version) throws Exception {
        return actualizacionDao.buscarActualizacionesPorVersion(version);
    }

   @Override
    public List <ComboGenericoTO>  listarVersiones() throws Exception {
        return actualizacionDao.listarVersiones();
    }

}
