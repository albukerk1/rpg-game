package game.dungeonmasters.rpg.repository;

import game.dungeonmasters.rpg.model.ItemMagico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemMagicoRepository extends JpaRepository<ItemMagico, Long> {
    List<ItemMagico> findByPersonagemId(Long personagemId);
}