package game.dungeonmasters.rpg.service;

import game.dungeonmasters.rpg.model.Personagem;
import game.dungeonmasters.rpg.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonagemService {

    @Autowired private PersonagemRepository repo;

    public Personagem criar(Personagem p) {
    }

}
