package de.birgitkratz.jpawithoutforeignkeys.repository.bidirectional;

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
class BidirectionalBestellungRepositoryTest {
    @Autowired
    BdBestellungRepository repository;

    @Autowired
    BdBestellpositionRepository bestellpositionRepository;

    @Test
    void savingBestellungBidirectional() {
        final var bestellung = new BdBestellung(1, LocalDateTime.now(), BigDecimal.TEN);
        final var savedBestellung = repository.save(bestellung);

        final var bestellposition1 = new BdBestellposition();
        bestellposition1.setName("Bestellposition 1");
        bestellposition1.setAnzahl(2);
        bestellposition1.setBestellung(savedBestellung);

        final var bestellposition2 = new BdBestellposition();
        bestellposition2.setName("Bestellposition 2");
        bestellposition2.setAnzahl(5);
        bestellposition2.setBestellung(savedBestellung);


        final var savedBestellpositionen = bestellpositionRepository.saveAll(List.of(bestellposition1, bestellposition2));

        assertThat(savedBestellpositionen)
                .hasSize(2)
                .extracting("id").doesNotContainNull();

        final var bdBestellposition = savedBestellpositionen.get(0);

        final var bdBestellId = new BdBestellId(savedBestellung.getId(), savedBestellung.getSparte());
        final var bdBestellpositionId = new BdBestellpositionId(bdBestellposition.getId(), bdBestellId);
        final var byId = bestellpositionRepository.findById(bdBestellpositionId);
        assertThat(byId)
                .isPresent();
    }

}
