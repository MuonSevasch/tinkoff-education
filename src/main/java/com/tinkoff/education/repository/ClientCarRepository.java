package com.tinkoff.education.repository;

import com.tinkoff.education.domain.ClientCar;
import com.tinkoff.education.domain.ClientCarId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientCarRepository extends JpaRepository<ClientCar, ClientCarId> {
}
