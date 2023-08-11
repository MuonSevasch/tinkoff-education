package com.example.education.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
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
