package de.birgitkratz.jpawithoutforeignkeys.repository.bidirectional;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "bestellung")
public class BdBestellung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime bestelldatum;
    private BigDecimal bestellwert;

    @OneToMany(mappedBy = "bestellung")
    private List<BdBestellposition> bestellpositionen;

    public BdBestellung() {
    }

    public BdBestellung(LocalDateTime bestelldatum, BigDecimal bestellwert) {
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

    public List<BdBestellposition> getBestellpositionen() {
        return bestellpositionen;
    }

    public void setBestellpositionen(List<BdBestellposition> bestellpositionen) {
        this.bestellpositionen = bestellpositionen;
    }
}
