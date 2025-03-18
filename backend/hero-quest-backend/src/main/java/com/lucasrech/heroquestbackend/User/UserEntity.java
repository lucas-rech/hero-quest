package com.lucasrech.heroquestbackend.User;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;


//TODO: Verificar se é necessário adicionar a anotação @Table com o nome da tabela
//TODO: Identificar se fica melhor criptografar a senha na entidade ou no service
@Setter
@Getter
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    @Column(nullable = false, name = "name")
    private String name;

    @Column(nullable = false, unique = true, name = "email")
    private String email;

    @Column(nullable = false, name = "password")
    private String password;

    @Column(nullable = false, name = "xp")
    private Long xp;

    @Column(nullable = false, name = "level")
    private Integer level;

    public UserEntity( String name, String email, String password, Long xp, Integer level) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.xp = xp;
        this.level = level;
    }

    public UserEntity() {
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(email, that.email) && Objects.equals(password, that.password) && Objects.equals(xp, that.xp) && Objects.equals(level, that.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password, xp, level);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", xp=" + xp +
                ", level=" + level +
                '}';
    }
}
