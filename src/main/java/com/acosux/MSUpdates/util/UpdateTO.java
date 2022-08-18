/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acosux.MSUpdates.util;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Usuario1
 */
@Entity
@Table(name = "act_actualizaciones", schema = "actualizaciones")
public class UpdateTO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "act_secuencial")
    private Integer actSecuencial;

    @Column(name = "act_version")
    private String actVersion;

    @Column(name = "act_titulo")
    private String actTitulo;

    @Column(name = "act_descripcion")
    private String actDescripcion;
    @Column(name = "act_video")
    private String actVideo;

    public UpdateTO() {
    }

    public UpdateTO(Integer actSecuencial, String actVersion, String actTitulo, String actDescripcion, String actVideo) {
        this.actSecuencial = actSecuencial;
        this.actVersion = actVersion;
        this.actTitulo = actTitulo;
        this.actDescripcion = actDescripcion;
        this.actVideo = actVideo;
    }

    public Integer getActSecuencial() {
        return actSecuencial;
    }

    public void setActSecuencial(Integer actSecuencial) {
        this.actSecuencial = actSecuencial;
    }

    public String getActVersion() {
        return actVersion;
    }

    public void setActVersion(String actVersion) {
        this.actVersion = actVersion;
    }

    public String getActTitulo() {
        return actTitulo;
    }

    public void setActTitulo(String actTitulo) {
        this.actTitulo = actTitulo;
    }

    public String getActDescripcion() {
        return actDescripcion;
    }

    public void setActDescripcion(String actDescripcion) {
        this.actDescripcion = actDescripcion;
    }

    public String getActVideo() {
        return actVideo;
    }

    public void setActVideo(String actVideo) {
        this.actVideo = actVideo;
    }


}
