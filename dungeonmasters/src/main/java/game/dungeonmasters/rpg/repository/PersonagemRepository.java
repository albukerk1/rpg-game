package game.dungeonmasters.rpg.repository;

import game.dungeonmasters.rpg.model.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonagemRepository extends JpaRepository<Personagem, Long> {
}
