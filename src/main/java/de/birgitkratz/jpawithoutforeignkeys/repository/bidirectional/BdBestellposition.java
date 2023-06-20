package de.birgitkratz.jpawithoutforeignkeys.repository.bidirectional;

import jakarta.persistence.*;

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
    @JoinColumns( {
            @JoinColumn(name = "bestellung_id", referencedColumnName = "id"),
            @JoinColumn(name = "bestellung_sparte", referencedColumnName = "sparte")
    })
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
