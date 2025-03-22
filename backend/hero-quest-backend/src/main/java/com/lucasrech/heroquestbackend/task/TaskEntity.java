package com.lucasrech.heroquestbackend.task;

import com.lucasrech.heroquestbackend.area.AreaEntity;
import com.lucasrech.heroquestbackend.task.enums.Status;
import com.lucasrech.heroquestbackend.user.UserEntity;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;


//TODO: Verificar se é necessário criar relacionamento com Usuário
@Setter
@Getter
@Entity
@Table(name = "tasks")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100, name = "title")
    private String title;

    @Column(length = 1000, name = "description")
    private String description;

    @Column(nullable = false, name = "xp")
    private Long xp;

    @Column(nullable = false, name = "level")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(nullable = false, name = "created")
    private LocalDateTime created;

    @Column(name = "updated")
    private LocalDateTime updated;

    @Column(name = "concluded")
    private LocalDateTime concluded;

    @ManyToOne
    @JoinColumn(name = "area_id", nullable = false)
    private AreaEntity area;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;


    public TaskEntity(String title, String description, Long xp, Status status, LocalDateTime created, LocalDateTime updated, LocalDateTime concluded) {
        this.title = title;
        this.description = description;
        this.xp = xp;
        this.status = status;
        this.created = created;
        this.updated = updated;
        this.concluded = concluded;
    }

    public TaskEntity() {
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TaskEntity that = (TaskEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(xp, that.xp) && status == that.status && Objects.equals(created, that.created) && Objects.equals(updated, that.updated) && Objects.equals(concluded, that.concluded);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, xp, status, created, updated, concluded);
    }

    @Override
    public String toString() {
        return "TaskEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", xp=" + xp +
                ", status=" + status +
                ", created=" + created +
                ", updated=" + updated +
                ", concluded=" + concluded +
                '}';
    }
}
