package com.example.demo.model.entity;

import jakarta.persistence.*;
import org.springframework.data.jpa.repository.EntityGraph;

import java.util.List;

@Entity
@Table(name = "brands")
@NamedEntityGraph(
        name = "brandWithModels",
        attributeNodes = @NamedAttributeNode("models")
)
public class BrandEntity extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "brand"
    )
    private List<ModelEntity> models;

    public List<ModelEntity> getModels() {
        return models;
    }

    public void setModels(List<ModelEntity> models) {
        this.models = models;
    }

    public String getName() {
        return name;
    }

    public void setName(String brand) {
        this.name = brand;
    }
}
