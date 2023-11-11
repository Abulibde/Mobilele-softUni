package com.example.demo.model.dto;

import com.example.demo.model.enums.EngineEnum;
import com.example.demo.model.enums.Transmission;
import com.example.demo.model.validation.YearNotInTheFuture;
import jakarta.validation.constraints.*;

public class CreateOfferDTO {
        @NotEmpty
        @Size(min = 5, max = 512)
        String description;

        @Positive
        @NotNull
        Long modelId;

        @NotNull
        EngineEnum engine;

        @NotNull
        Transmission transmission;

        @NotEmpty
        String imageUrl;

        @Positive
        @NotNull
        Integer mileage;

        @Positive
        @NotNull
        Integer price;

        @YearNotInTheFuture(message = "Future years are not allowed")
        @NotNull(message = "Year must be provided")
        @Min(1930)
        Integer year;

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public Long getModelId() {
                return modelId;
        }

        public void setModelId(Long modelId) {
                this.modelId = modelId;
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

        public String getImageUrl() {
                return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
        }

        public Integer getMileage() {
                return mileage;
        }

        public void setMileage(Integer mileage) {
                this.mileage = mileage;
        }

        public Integer getPrice() {
                return price;
        }

        public void setPrice(Integer price) {
                this.price = price;
        }

        public Integer getYear() {
                return year;
        }

        public void setYear(Integer year) {
                this.year = year;
        }
}
