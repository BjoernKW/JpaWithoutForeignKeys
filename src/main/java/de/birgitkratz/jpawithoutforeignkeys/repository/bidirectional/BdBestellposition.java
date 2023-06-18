package de.birgitkratz.jpawithoutforeignkeys.repository.bidirectional;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@IdClass(BdBestellpositionId.class)
@Table(name = "bestellposition")
public class BdBestellposition {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BESTELLPOSITION_ID_SEQ")
    @SequenceGenerator(name = "BESTELLPOSITION_ID_SEQ", sequenceName = "bestellposition_id_seq", allocationSize = 1)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @Id
    @JoinColumn(name = "bestellung_id", referencedColumnName = "id")
    private BdBestellung bestellung;

    private String name;
    private Integer anzahl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BdBestellung getBestellung() {
        return bestellung;
    }

    public void setBestellung(BdBestellung bestellung) {
        this.bestellung = bestellung;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(Integer anzahl) {
        this.anzahl = anzahl;
    }
}
