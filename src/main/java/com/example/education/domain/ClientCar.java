package com.example.education.domain;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "client_cars")
@Data
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