package game.dungeonmasters.rpg.model;

import game.dungeonmasters.rpg.model.enums.TipoItem;
import jakarta.persistence.*;

@Entity
public class ItemMagico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoItem tipo;

    private int forcaBonus;
    private int defesaBonus;

    private Long personagemId; // fazendo uma associação simples

//    public ItemMagico(String nome, TipoItem tipo, int forca, int defesa) {
//        this.nome = nome;
//        this.tipo = tipo;
//        this.forcaBonus = forcaBonus;
//        this.defesaBonus = defesaBonus;
//    }

    @PrePersist
    @PreUpdate
    public void validar() {
        if (forcaBonus < 0 || defesaBonus < 0 || forcaBonus > 10 || defesaBonus > 10) {
            throw new IllegalArgumentException("Força e Defesa Bônus devem estar entre 0 e 10");
        }
        if (forcaBonus == 0 && defesaBonus == 0) {
            throw new IllegalArgumentException("Item não pode ter Força Bônus e Defesa simultaneamente iguais a 0");
        }
        if (tipo == TipoItem.ARMA && defesaBonus != 0) {
            throw new IllegalArgumentException("Item do tipo ARMA deve ter Defesa Bônus igual a 0");
        }
        if (tipo == TipoItem.ARMADURA && forcaBonus != 0) {
            throw new IllegalArgumentException("Item do tipo ARMADURA deve ter Força Bônus igual a 0");
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

    public TipoItem getTipo() {
        return tipo;
    }

    public void setTipo(TipoItem tipo) {
        this.tipo = tipo;
    }

    public int getForcaBonus() {
        return forcaBonus;
    }

    public void setForcaBonus(int forcaBonus) {
        this.forcaBonus = forcaBonus;
    }

    public int getDefesaBonus() {
        return defesaBonus;
    }

    public void setDefesaBonus(int defesaBonus) {
        this.defesaBonus = defesaBonus;
    }

    public Long getPersonagemId() {
        return personagemId;
    }

//    public void setPersonagemId(Long personagemId) {
//        this.personagemId = personagemId;
//    }
}
