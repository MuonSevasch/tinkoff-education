package com.tinkoff.education.domain;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "client_cars")
@Data
@Entity
public class ClientCar {
    @EmbeddedId
    private ClientCarId id;

    @ManyToOne
    @MapsId("clientId")
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @MapsId("carId")
    @JoinColumn(name = "car_id")
    private Car car;

}