package de.birgitkratz.jpawithoutforeignkeys.repository.bidirectional;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@IdClass(BdBestellId.class)
@Table(name = "bestellung")
public class BdBestellung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Id
    private Integer sparte;

    private LocalDateTime bestelldatum;
    private BigDecimal bestellwert;

    @OneToMany(mappedBy = "bestellung")
    private List<BdBestellposition> bestellpositionen;

    public BdBestellung() {
    }

    public BdBestellung(Integer sparte, LocalDateTime bestelldatum, BigDecimal bestellwert) {
        this.sparte = sparte;
        this.bestelldatum = bestelldatum;
        this.bestellwert = bestellwert;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSparte() {
        return sparte;
    }

    public void setSparte(Integer sparte) {
        this.sparte = sparte;
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
