package com.lucasrech.heroquestbackend.area;

import com.lucasrech.heroquestbackend.task.TaskEntity;
import com.lucasrech.heroquestbackend.user.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
public class AreaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String shortDescription;

    @OneToMany(mappedBy = "area")
    private List<TaskEntity> tasks;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    public AreaEntity(String name, String shortDescription) {
        this.name = name;
        this.shortDescription = shortDescription;
    }

    public AreaEntity() {
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AreaEntity that = (AreaEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(shortDescription, that.shortDescription) && Objects.equals(tasks, that.tasks) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, shortDescription, tasks, user);
    }

    @Override
    public String toString() {
        return "AreaEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", tasks=" + tasks +
                ", user=" + user +
                '}';
    }
}
