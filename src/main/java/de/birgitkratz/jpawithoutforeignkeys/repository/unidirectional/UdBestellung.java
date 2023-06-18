package de.birgitkratz.jpawithoutforeignkeys.repository.unidirectional;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "bestellung")
public class UdBestellung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime bestelldatum;
    private BigDecimal bestellwert;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name="bestellung_id",
            referencedColumnName="id",
            nullable=false)
    private List<UdBestellposition> bestellpositionen;

    public UdBestellung() {
    }

    public UdBestellung(LocalDateTime bestelldatum, BigDecimal bestellwert) {
        this.bestelldatum = bestelldatum;
        this.bestellwert = bestellwert;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getBestelldatum() {
        return bestelldatum;
    }

    public void setBestelldatum(LocalDateTime bestelldatum) {
        this.bestelldatum = bestelldatum;
    }

    public BigDecimal getBestellwert() {
        return bestellwert;
    }

    public void setBestellwert(BigDecimal bestellwert) {
        this.bestellwert = bestellwert;
    }

    public List<UdBestellposition> getBestellpositionen() {
        return bestellpositionen;
    }

    public void setBestellpositionen(List<UdBestellposition> bestellpositionen) {
        this.bestellpositionen = bestellpositionen;
    }
}
