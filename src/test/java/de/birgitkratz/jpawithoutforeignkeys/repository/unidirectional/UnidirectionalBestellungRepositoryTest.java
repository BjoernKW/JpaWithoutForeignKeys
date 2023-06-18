package de.birgitkratz.jpawithoutforeignkeys.repository.unidirectional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest()
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UnidirectionalBestellungRepositoryTest {

    @Autowired
    UdBestellungRepository repository;

    @Test
    void savingBestellungUnidirectional() {
        final var bestellung = new UdBestellung(LocalDateTime.now(), BigDecimal.TEN);

        final var bestellposition1 = new UdBestellposition();
        bestellposition1.setName("Bestellposition 1");
        bestellposition1.setAnzahl(2);

        final var bestellposition2 = new UdBestellposition();
        bestellposition2.setName("Bestellposition 2");
        bestellposition2.setAnzahl(5);

        bestellung.setBestellpositionen(List.of(bestellposition1, bestellposition2));

        final var saved = repository.save(bestellung);

        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getBestellpositionen()).extracting("id").doesNotContainNull();
    }
}