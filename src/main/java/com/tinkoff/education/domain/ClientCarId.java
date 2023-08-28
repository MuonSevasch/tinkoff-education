package com.tinkoff.education.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Embeddable
public class ClientCarId implements Serializable {
    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "car_id")
    private Long carId;

}
