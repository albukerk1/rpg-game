package game.dungeonmasters.rpg.service;

import game.dungeonmasters.rpg.model.ItemMagico;
import game.dungeonmasters.rpg.model.enums.TipoItem;
import game.dungeonmasters.rpg.repository.ItemMagicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemMagicoService {

    private final ItemMagicoRepository itemRepo;

    public ItemMagicoService(ItemMagicoRepository itemRepo) {
        this.itemRepo = itemRepo;
    }

    public ItemMagico salvar(ItemMagico item) {
        if (item.getTipo() == TipoItem.AMULETO) {
            List<ItemMagico> itensDoPersonagem = itemRepo.findByPersonagemId(item.getPersonagemId());
            boolean jaTemAmuleto = false;
            for (ItemMagico i : itensDoPersonagem) {
                if (i.getTipo() == TipoItem.AMULETO) {
                    jaTemAmuleto = true;
                    break;
                }
            }
            if (jaTemAmuleto) {
                throw new IllegalArgumentException("O personagem já possui um amuleto (máx. 1)");
            }
        }
        return itemRepo.save(item);
    }

    public List<ItemMagico> listar() {
        return itemRepo.findAll();
    }

    public List<ItemMagico> listarPorPersonagem(Long personagemId) {
        return itemRepo.findByPersonagemId(personagemId);
    }

    public void remover(Long id) {
        itemRepo.deleteById(id);
    }

    public ItemMagico buscarPorId(Long id) {
        return itemRepo.findById(id).orElse(null);
    }
}
