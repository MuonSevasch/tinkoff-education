package com.example.education.repositories;

import com.example.education.domain.Car;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class CarRepository {
    private EntityManagerFactory entityManagerFactory;

    public CarRepository() {
        entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
    }

    public void close() {
        entityManagerFactory.close();
    }

    public void createCar(Car car) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(car);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public Car getCarById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.find(Car.class, id);
        } finally {
            entityManager.close();
        }
    }

    public void updateCar(Car car) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            entityManager.merge(car);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public void deleteCar(Car car) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            entityManager.remove(entityManager.contains(car) ? car : entityManager.merge(car));
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public List<Car> getAllCars() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            TypedQuery<Car> query = entityManager.createQuery("SELECT c FROM Car c", Car.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }
}
