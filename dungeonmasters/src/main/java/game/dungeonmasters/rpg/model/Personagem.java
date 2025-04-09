package game.dungeonmasters.rpg.model;
import game.dungeonmasters.rpg.enums.ClassePersonagem;
import jakarta.persistence.*;

public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String nomeAventureiro;

    @Enumerated(EnumType.STRING)
    private ClassePersonagem classe;

    private int level;
    private int forcaBase;
    private int defesaBase;


}
