package com.example.demo.model.entity;

import com.example.demo.model.enums.EngineEnum;
import com.example.demo.model.enums.Transmission;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.annotations.JdbcTypeCode;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.UUID;


@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity {

    @NotNull
    @JdbcTypeCode(Types.VARCHAR)
    private UUID uuid;

    @NotEmpty
    private String description;

    @NotNull
    @ManyToOne
    private ModelEntity model;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EngineEnum engine;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Transmission transmission;

    @NotEmpty
    private String imgUrl;

    @Positive
    private long mileage;

    @NotNull
    private BigDecimal price;

    @Min(1930)
    private int year;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ModelEntity getModel() {
        return model;
    }

    public void setModel(ModelEntity model) {
        this.model = model;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public void setEngine(EngineEnum engine) {
        this.engine = engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public long getMileage() {
        return mileage;
    }

    public void setMileage(long mileage) {
        this.mileage = mileage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
