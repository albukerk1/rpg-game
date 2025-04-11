package game.dungeonmasters.rpg.controller;

import game.dungeonmasters.rpg.model.ItemMagico;
import game.dungeonmasters.rpg.model.Personagem;
import game.dungeonmasters.rpg.service.PersonagemService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personagens")
public class PersonagemController {

    private final PersonagemService service;

    public PersonagemController(PersonagemService service) {
        this.service = service;
    }

    @Operation(summary = "Cria um personagem")
    @PostMapping
    public Personagem criar(@RequestBody Personagem p) {
        return service.salvar(p);
    }

    @Operation(summary = "Lista todos os personsagens criados")
    @GetMapping
    public List<Personagem> listar() {
        return service.listar();
    }

    @Operation(summary = "Busca um personagem pelo ID")
    @GetMapping("/{id}")
    public Personagem buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @Operation(summary = "Deleta um personagem pelo ID")
    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        service.remover(id);
    }

    @Operation(summary = "Atualiza o nome de aventureiro")
    @PutMapping("/{id}/nome-aventureiro")
    public Personagem atualizarNome(@PathVariable Long id, @RequestParam String nome) {
        return service.atualizarNomeAventureiro(id, nome);
    }

    @Operation(summary = "Exibe a forca total de um personagem pelo ID")
    @GetMapping("/{id}/forca-total")
    public int forcaTotal(@PathVariable Long id) {
        return service.getForcaTotal(id);
    }

    @Operation(summary = "Exibe a defesa total de um personagem pelo ID")
    @GetMapping("/{id}/defesa-total")
    public int defesaTotal(@PathVariable Long id) {
        return service.getDefesaTotal(id);
    }

    @Operation(summary = "Exibe o amuleto equipado pelo personagem buscado pelo ID")
    @GetMapping("/{id}/amuleto")
    public ItemMagico amuleto(@PathVariable Long id) {
        return service.buscarAmuleto(id);
    }

}
