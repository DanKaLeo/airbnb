/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danka.airbnb.models;

/**
 *
 * @author daniel
 */
public class ObjResponseError implements ObjResponse{
    private Boolean estado; 
    private String mensaje; 

    public ObjResponseError() {
    }

    public ObjResponseError(Boolean estado, String mensaje) {
        this.estado = estado;
        this.mensaje = mensaje;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
