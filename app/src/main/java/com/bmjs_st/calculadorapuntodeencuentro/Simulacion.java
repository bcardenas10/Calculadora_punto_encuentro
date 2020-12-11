package com.bmjs_st.calculadorapuntodeencuentro;

import java.io.Serializable;

import static com.bmjs_st.calculadorapuntodeencuentro.MainActivity.configUnidad;

public class Simulacion implements Serializable {

    private static int id;
    //Vehiculo 1
    private String nombreVeh1;
    private double veloVeh1; //Velocidad
    private double distRVeh1; //Distancia recorrida
    //Vehiculo 2
    private String nombreVeh2;
    private double veloVeh2;
    private double distRVeh2;
    //_______//
    private String tiempo; //Tiempo hasta el encuentro
    private double distancia; //Distancia inicial entre los 2 vehículos

    public Simulacion() {
    }

    public Simulacion(String nombreVeh1, double veloVeh1, double distRVeh1, String nombreVeh2, double veloVeh2, double distRVeh2, String tiempo, double distancia) {
        this.id = id + 1;
        this.nombreVeh1 = nombreVeh1;
        this.veloVeh1 = veloVeh1;
        this.distRVeh1 = distRVeh1;
        this.nombreVeh2 = nombreVeh2;
        this.veloVeh2 = veloVeh2;
        this.distRVeh2 = distRVeh2;
        this.tiempo = tiempo;
        this.distancia = distancia;
    }

    public static int getId() {
        return id;
    }

    public String getNombreVeh1() {
        return nombreVeh1;
    }

    public void setNombreVeh1(String nombreVeh1) {
        this.nombreVeh1 = nombreVeh1;
    }

    public double getVeloVeh1() {
        return veloVeh1;
    }

    public void setVeloVeh1(double veloVeh1) {
        this.veloVeh1 = veloVeh1;
    }

    public double getDistRVeh1() {
        return distRVeh1;
    }

    public void setDistRVeh1(double distRVeh1) {
        this.distRVeh1 = distRVeh1;
    }

    public String getNombreVeh2() {
        return nombreVeh2;
    }

    public void setNombreVeh2(String nombreVeh2) {
        this.nombreVeh2 = nombreVeh2;
    }

    public double getVeloVeh2() {
        return veloVeh2;
    }

    public void setVeloVeh2(double veloVeh2) {
        this.veloVeh2 = veloVeh2;
    }

    public double getDistRVeh2() {
        return distRVeh2;
    }

    public void setDistRVeh2(double distRVeh2) {
        this.distRVeh2 = distRVeh2;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    @Override
    public String toString() {
        String descSimu = "";
        if(configUnidad == false) { //Sistema Metrico
            String SVeloVeh1 = String.format("%.1f", veloVeh1);
            String SVeloVeh2 = String.format("%.1f", veloVeh2);
            String SdistT = String.format("%.1f", distancia);
            descSimu = nombreVeh1 + " (" + SVeloVeh1 + " KM/H) - " + nombreVeh2 + " (" + SVeloVeh2 + " KM/H)" + '\n' + "Distancia: " + SdistT + " KM   -   Tiempo: " + tiempo;
        }
        else if(configUnidad == true) { //Sistema Anglosajón
            String SVeloVeh1 = String.format("%.1f", veloVeh1*0.6214);
            String SVeloVeh2 = String.format("%.1f", veloVeh2*0.6214);
            String SdistT = String.format("%.1f", distancia*0.6214);
            descSimu = nombreVeh1 + " (" + SVeloVeh1 + " MI/H) - " + nombreVeh2 + " (" + SVeloVeh2 + " MI/H)" + '\n' + "Distancia: " + SdistT + " MI   -   Tiempo: " + tiempo;
        }
        return descSimu;
    }
}
