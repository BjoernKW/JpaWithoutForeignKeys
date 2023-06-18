package de.birgitkratz.jpawithoutforeignkeys.repository.bidirectional;

import java.io.Serializable;
import java.util.Objects;

public class BdBestellpositionId implements Serializable {
    private Integer id;
    private Integer bestellung;

    public BdBestellpositionId() {
    }

    public BdBestellpositionId(Integer id, Integer bestellung) {
        this.id = id;
        this.bestellung = bestellung;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BdBestellpositionId that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(bestellung, that.bestellung);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bestellung);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBestellung() {
        return bestellung;
    }

    public void setBestellung(Integer bestellung) {
        this.bestellung = bestellung;
    }
}
