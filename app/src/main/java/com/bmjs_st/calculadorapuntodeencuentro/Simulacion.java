package com.bmjs_st.calculadorapuntodeencuentro;

import java.sql.Timestamp;

public class Simulacion {

    private int id;
    //Vehiculo 1
    private String nombreVeh1;
    private float veloVeh1; //Velocidad
    private float distRVeh1; //Distancia recorrida
    //Vehiculo 2
    private String nombreVeh2;
    private float veloVeh2;
    private float distRVeh2;
    //_______//
    private Timestamp tiempo; //Tiempo hasta el encuentro
    private float distancia; //Distancia inicial entre los 2 vehículos

    public Simulacion() {
    }

    public Simulacion(int id, String nombreVeh1, float veloVeh1, float distRVeh1, String nombreVeh2, float veloVeh2, float distRVeh2, Timestamp tiempo, float distancia) {
        this.id = id;
        this.nombreVeh1 = nombreVeh1;
        this.veloVeh1 = veloVeh1;
        this.distRVeh1 = distRVeh1;
        this.nombreVeh2 = nombreVeh2;
        this.veloVeh2 = veloVeh2;
        this.distRVeh2 = distRVeh2;
        this.tiempo = tiempo;
        this.distancia = distancia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreVeh1() {
        return nombreVeh1;
    }

    public void setNombreVeh1(String nombreVeh1) {
        this.nombreVeh1 = nombreVeh1;
    }

    public float getVeloVeh1() {
        return veloVeh1;
    }

    public void setVeloVeh1(float veloVeh1) {
        this.veloVeh1 = veloVeh1;
    }

    public float getDistRVeh1() {
        return distRVeh1;
    }

    public void setDistRVeh1(float distRVeh1) {
        this.distRVeh1 = distRVeh1;
    }

    public String getNombreVeh2() {
        return nombreVeh2;
    }

    public void setNombreVeh2(String nombreVeh2) {
        this.nombreVeh2 = nombreVeh2;
    }

    public float getVeloVeh2() {
        return veloVeh2;
    }

    public void setVeloVeh2(float veloVeh2) {
        this.veloVeh2 = veloVeh2;
    }

    public float getDistRVeh2() {
        return distRVeh2;
    }

    public void setDistRVeh2(float distRVeh2) {
        this.distRVeh2 = distRVeh2;
    }

    public Timestamp getTiempo() {
        return tiempo;
    }

    public void setTiempo(Timestamp tiempo) {
        this.tiempo = tiempo;
    }

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }
}
