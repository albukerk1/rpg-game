package game.dungeonmasters.rpg.model;
import game.dungeonmasters.rpg.model.enums.ClassePersonagem;
import jakarta.persistence.*;

@Entity
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

//    public Personagem(String nome, String nomeAventureiro, ClassePersonagem classe , int level, int forcaBase, int defesaBase) {
//        this.nome = nome;
//        this.nomeAventureiro = nomeAventureiro;
//        this.classe = classe;
//        this.level = level;
//        this.forcaBase = forcaBase;
//        this.defesaBase = defesaBase;
//    }

    @PrePersist
    @PreUpdate
    public void validar() {
        if (forcaBase < 0 || defesaBase < 0 || forcaBase + defesaBase > 10) {
            throw new IllegalArgumentException("A soma de Força e Defesa base deve ser no máximo 10");
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeAventureiro() {
        return nomeAventureiro;
    }

    public void setNomeAventureiro(String nomeAventureiro) {
        this.nomeAventureiro = nomeAventureiro;
    }

    public ClassePersonagem getClasse() {
        return classe;
    }

    public void setClasse(ClassePersonagem classe) {
        this.classe = classe;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getForcaBase() {
        return forcaBase;
    }

    public void setForcaBase(int forcaBase) {
        this.forcaBase = forcaBase;
    }

    public int getDefesaBase() {
        return defesaBase;
    }

    public void setDefesaBase(int defesaBase) {
        this.defesaBase = defesaBase;
    }
}
