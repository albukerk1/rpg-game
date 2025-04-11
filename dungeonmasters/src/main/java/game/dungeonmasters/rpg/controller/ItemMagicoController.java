package game.dungeonmasters.rpg.controller;

import game.dungeonmasters.rpg.model.ItemMagico;
import game.dungeonmasters.rpg.service.ItemMagicoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens")
public class ItemMagicoController {

    private final ItemMagicoService service;

    public ItemMagicoController(ItemMagicoService service) {
        this.service = service;
    }

    @Operation(summary = "Cria um item mágico")
    @PostMapping
    public ItemMagico criar(@RequestBody ItemMagico item) {
        return service.salvar(item);
    }

    @Operation(summary = "Exibe todos os itens mágicos")
    @GetMapping
    public List<ItemMagico> listar() {
        return service.listar();
    }

    @Operation(summary = "Busca um item mágico por ID")
    @GetMapping("/{id}")
    public ItemMagico buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @Operation(summary = "Exibe itens mágicos equipados pelo personagem do ID buscado")
    @GetMapping("/personagem/{id}")
    public List<ItemMagico> listarPorPersonagem(@PathVariable Long id) {
        return service.listarPorPersonagem(id);
    }

    @Operation(summary = "Deleta um item mágico pelo ID")
    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        service.remover(id);
    }







}
