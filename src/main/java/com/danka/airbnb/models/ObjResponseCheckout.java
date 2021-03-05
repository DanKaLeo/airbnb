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
public class ObjResponseCheckout implements ObjResponse{
    private Boolean estado; 
    private String mensaje;
    private Long estadia;
    private Double totalNoches;
    private Double totalDescuento;
    private Double totalFinal;

    public ObjResponseCheckout() {
    }

    public ObjResponseCheckout(Boolean estado, String mensaje, Long estadia, Double totalNoches, Double totalDescuento, Double totalFinal) {
        this.estado = estado;
        this.mensaje = mensaje;
        this.estadia = estadia;
        this.totalNoches = totalNoches;
        this.totalDescuento = totalDescuento;
        this.totalFinal = totalFinal;
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

    public Long getEstadia() {
        return estadia;
    }

    public void setEstadia(Long estadia) {
        this.estadia = estadia;
    }

    public Double getTotalNoches() {
        return totalNoches;
    }

    public void setTotalNoches(Double totalNoches) {
        this.totalNoches = totalNoches;
    }

    public Double getTotalDescuento() {
        return totalDescuento;
    }

    public void setTotalDescuento(Double totalDescuento) {
        this.totalDescuento = totalDescuento;
    }

    public Double getTotalFinal() {
        return totalFinal;
    }

    public void setTotalFinal(Double totalFinal) {
        this.totalFinal = totalFinal;
    }
    
}
