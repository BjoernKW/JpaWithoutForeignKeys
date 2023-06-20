package de.birgitkratz.jpawithoutforeignkeys.repository.bidirectional;

import java.io.Serializable;
import java.util.Objects;

public class BdBestellId implements Serializable {
    private Integer id;
    private Integer sparte;

    public BdBestellId() {
    }

    public BdBestellId(Integer id, Integer sparte) {
        this.id = id;
        this.sparte = sparte;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BdBestellId that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(sparte, that.sparte);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sparte);
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
}
