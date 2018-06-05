package com.carstore.pojo;
// Generated Jun 5, 2018 6:27:59 PM by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Samochod generated by hbm2java
 */
@Entity
@Table(name="samochod"
    ,catalog="carstore"
)
public class Samochod  implements java.io.Serializable {


     private Short samochodId;
     private Kategorie kategorie;
     private Double cena;
     private String kolor;
     private String marka;
     private Float pojemnoscSilnika;
     private String producent;
     private Date rokProdukcji;
     private String nrSeryjny;
     private Set<Faktura> fakturas = new HashSet<Faktura>(0);

    public Samochod() {
    }

	
    public Samochod(Kategorie kategorie) {
        this.kategorie = kategorie;
    }
    public Samochod(Kategorie kategorie, Double cena, String kolor, String marka, Float pojemnoscSilnika, String producent, Date rokProdukcji, String nrSeryjny, Set<Faktura> fakturas) {
       this.kategorie = kategorie;
       this.cena = cena;
       this.kolor = kolor;
       this.marka = marka;
       this.pojemnoscSilnika = pojemnoscSilnika;
       this.producent = producent;
       this.rokProdukcji = rokProdukcji;
       this.nrSeryjny = nrSeryjny;
       this.fakturas = fakturas;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="samochodID", unique=true, nullable=false)
    public Short getSamochodId() {
        return this.samochodId;
    }
    
    public void setSamochodId(Short samochodId) {
        this.samochodId = samochodId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="kategorieID", nullable=false)
    public Kategorie getKategorie() {
        return this.kategorie;
    }
    
    public void setKategorie(Kategorie kategorie) {
        this.kategorie = kategorie;
    }

    
    @Column(name="cena", precision=22, scale=0)
    public Double getCena() {
        return this.cena;
    }
    
    public void setCena(Double cena) {
        this.cena = cena;
    }

    
    @Column(name="kolor", length=50)
    public String getKolor() {
        return this.kolor;
    }
    
    public void setKolor(String kolor) {
        this.kolor = kolor;
    }

    
    @Column(name="marka", length=50)
    public String getMarka() {
        return this.marka;
    }
    
    public void setMarka(String marka) {
        this.marka = marka;
    }

    
    @Column(name="pojemnosc_silnika", precision=12, scale=0)
    public Float getPojemnoscSilnika() {
        return this.pojemnoscSilnika;
    }
    
    public void setPojemnoscSilnika(Float pojemnoscSilnika) {
        this.pojemnoscSilnika = pojemnoscSilnika;
    }

    
    @Column(name="producent", length=50)
    public String getProducent() {
        return this.producent;
    }
    
    public void setProducent(String producent) {
        this.producent = producent;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="rok_produkcji", length=10)
    public Date getRokProdukcji() {
        return this.rokProdukcji;
    }
    
    public void setRokProdukcji(Date rokProdukcji) {
        this.rokProdukcji = rokProdukcji;
    }

    
    @Column(name="nr_seryjny", length=50)
    public String getNrSeryjny() {
        return this.nrSeryjny;
    }
    
    public void setNrSeryjny(String nrSeryjny) {
        this.nrSeryjny = nrSeryjny;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="samochod")
    public Set<Faktura> getFakturas() {
        return this.fakturas;
    }
    
    public void setFakturas(Set<Faktura> fakturas) {
        this.fakturas = fakturas;
    }




}

