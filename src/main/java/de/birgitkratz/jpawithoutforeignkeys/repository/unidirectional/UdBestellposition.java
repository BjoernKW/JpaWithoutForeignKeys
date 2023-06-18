package de.birgitkratz.jpawithoutforeignkeys.repository.unidirectional;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "bestellposition")
public class UdBestellposition {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BESTELLPOSITION_ID_SEQ")
    @SequenceGenerator(name = "BESTELLPOSITION_ID_SEQ", sequenceName = "bestellposition_id_seq", allocationSize = 1)
    private Integer id;

    private String name;
    private Integer anzahl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
