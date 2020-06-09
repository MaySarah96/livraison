package com.tn.flow.livreurapp.model;

import com.google.gson.annotations.SerializedName;

public class Livraison {

        @SerializedName("id_livra")
     Integer idLivra;
    @SerializedName("frais_livra")
    Integer fraisLivra;

    @SerializedName("dest_livra")
    String destLivra;

    @SerializedName("etat_livra")
    String etatLivra;

    public Livraison(Integer idLivra, Integer fraisLivra, String destLivra, String etatLivra) {
        this.idLivra = idLivra;
        this.fraisLivra = fraisLivra;
        this.destLivra = destLivra;
        this.etatLivra = etatLivra;
    }

    public Integer getIdLivra() {
        return idLivra;
    }

    public void setIdLivra(Integer idLivra) {
        this.idLivra = idLivra;
    }

    public Integer getFraisLivra() {
        return fraisLivra;
    }

    public void setFraisLivra(Integer fraisLivra) {
        this.fraisLivra = fraisLivra;
    }

    public String getDestLivra() {
        return destLivra;
    }

    public void setDestLivra(String destLivra) {
        this.destLivra = destLivra;
    }

    public String getEtatLivra() {
        return etatLivra;
    }

    public void setEtatLivra(String etatLivra) {
        this.etatLivra = etatLivra;
    }
}
