/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acosux.MSUpdates.controller;

import com.acosux.MSUpdates.util.UpdateTO;
import com.acosux.MSUpdates.util.ComboGenericoTO;
import com.acosux.MSUpdates.util.RespuestaWebTO;
import com.acosux.MSUpdates.util.UtilsJSON;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.acosux.MSUpdates.service.UpdateService;

/**
 *
 * @author Tabango
 */
@RestController
@RequestMapping("/actualizacion/")
public class UpdateController {

    @Autowired
    UpdateService actualizacionService;

    @RequestMapping(value = "/buscarActualizacionesPorVersion")
    public RespuestaWebTO buscarActualizacionesPorVersion(@RequestBody String json) {
        System.out.println("ENTRO");
        RespuestaWebTO resp = new RespuestaWebTO();
         Map<String, Object> map = UtilsJSON.jsonToMap(json);
         String version = UtilsJSON.jsonToObjeto(String.class, map.get("version"));
        resp.setEstadoOperacion(RespuestaWebTO.EstadoOperacionEnum.ADVERTENCIA.getValor());
        try {
        List <UpdateTO> respues = actualizacionService.buscarActualizacionesPorVersion(version);
            resp.setEstadoOperacion(RespuestaWebTO.EstadoOperacionEnum.EXITO.getValor());
            resp.setExtraInfo(respues);
        } catch (Exception e) {
            resp.setEstadoOperacion(RespuestaWebTO.EstadoOperacionEnum.ERROR.getValor());
            resp.setOperacionMensaje(e.getMessage());
        }
        return resp;
    }
    
     @RequestMapping(value = "/listarVersiones", method = {RequestMethod.GET})
    public RespuestaWebTO SisActualizacionesTO() {
        RespuestaWebTO resp = new RespuestaWebTO();
        resp.setEstadoOperacion(RespuestaWebTO.EstadoOperacionEnum.ADVERTENCIA.getValor());
        try {
            List <ComboGenericoTO> respues = actualizacionService.listarVersiones();
            resp.setEstadoOperacion(RespuestaWebTO.EstadoOperacionEnum.EXITO.getValor());
            resp.setExtraInfo(respues);
        } catch (Exception e) {
            resp.setEstadoOperacion(RespuestaWebTO.EstadoOperacionEnum.ERROR.getValor());
            resp.setOperacionMensaje(e.getMessage());
        }
        return resp;
    }

}
