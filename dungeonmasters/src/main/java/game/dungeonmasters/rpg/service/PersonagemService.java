package game.dungeonmasters.rpg.service;

import game.dungeonmasters.rpg.model.ItemMagico;
import game.dungeonmasters.rpg.model.Personagem;
import game.dungeonmasters.rpg.repository.ItemMagicoRepository;
import game.dungeonmasters.rpg.repository.PersonagemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonagemService {
    
    private final PersonagemRepository personagemRepo;
    private final ItemMagicoRepository itemRepo;

    public PersonagemService(PersonagemRepository personagemRepo, ItemMagicoRepository itemRepo) {
        this.personagemRepo = personagemRepo;
        this.itemRepo = itemRepo;
    }
    
    public Personagem salvar(Personagem personagem){
        return personagemRepo.save(personagem);
    }
    
    public List<Personagem> listar() {
        return personagemRepo.findAll();
    }
    
    public Personagem buscarPorId(Long id) {
        return personagemRepo.findById(id).orElse(null);
    }
    
    public void remover(Long id) {
        personagemRepo.deleteById(id);
    }

    public int getForcaTotal(Long personagemId) {
        Personagem p = buscarPorId(personagemId);
        int total = p.getForcaBase();
        for (ItemMagico item : itemRepo.findByPersonagemId(personagemId)) {
            total += item.getForcaBonus();
        }
        return total;
    }

    public int getDefesaTotal(Long personagemId) {
        Personagem p = buscarPorId(personagemId);
        int total = p.getDefesaBase();
        for (ItemMagico item : itemRepo.findByPersonagemId(personagemId)) {
            total += item.getDefesaBonus();
        }
        return total;
    }

    public ItemMagico buscarAmuleto(Long personagemId) {
        for (ItemMagico item : itemRepo.findByPersonagemId(personagemId)) {
            if (item.getTipo().name().equals("AMULETO")) {
                return item;
            }
        }
        return null;
    }

    public Personagem atualizarNomeAventureiro(Long id, String novoNome) {
        Personagem personagem = buscarPorId(id);
        personagem.setNomeAventureiro(novoNome);
        return personagemRepo.save(personagem);
    }

}
