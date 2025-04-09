package game.dungeonmasters.rpg.model;

import game.dungeonmasters.rpg.enums.TipoItem;
import jakarta.persistence.*;

import javax.annotation.processing.Generated;

public class ItemMagico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoItem tipo;

    private int forca;
    private int defesa;

    private Long personagemId;
}
