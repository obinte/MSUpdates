/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acosux.MSUpdates.dao;

import com.acosux.MSUpdates.util.UpdateTO;
import com.acosux.MSUpdates.util.VersionTO;
import com.acosux.MSUpdates.util.dao.GenericDaoImpl;
import com.acosux.MSUpdates.util.dao.GenericSQLDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Trabajo
 */
@Repository
public class UpdateDaoImpl extends GenericDaoImpl<UpdateTO, Integer> implements UpdateDao {

    @Autowired
    private GenericSQLDao genericSQLDao;

    @Override
    public List<UpdateTO> buscarActualizacionesPorVersion(String version) throws Exception {
        String sql = "SELECT * FROM actualizaciones.act_actualizaciones WHERE act_version='" + version + "'";
        return genericSQLDao.obtenerPorSql(sql, UpdateTO.class);
    }

    @Override
    public List<VersionTO> listarVersiones() throws Exception {
        String sql = "SELECT DISTINCT act_version FROM actualizaciones.act_actualizaciones ORDER BY act_version DESC";
        return genericSQLDao.obtenerPorSql(sql, VersionTO.class);
    }

}
