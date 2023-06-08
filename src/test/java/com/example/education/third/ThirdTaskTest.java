package com.example.education.third;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.Test;

public class ThirdTaskTest {

    @Test
    public void test() {
        // Создание массива клиентов
        List<Client> clients = new ArrayList<>();
        clients.add(new Client(1, "John", 25, Arrays.asList(
            new Phone("123456789", PhoneType.MOBILE),
            new Phone("987654321", PhoneType.LANDLINE)
        )));
        clients.add(new Client(2, "Alice", 30, Arrays.asList(
            new Phone("111111111", PhoneType.MOBILE),
            new Phone("222222222", PhoneType.LANDLINE)
        )));
        clients.add(new Client(3, "Bob", 35, Collections.emptyList()));

        // Рассчитать суммарный возраст для определенного имени
        String targetName = "Alice";
        int totalAge = clients.stream()
            .filter(client -> client.getName().equals(targetName))
            .mapToInt(Client::getAge)
            .sum();
        System.out.println("Total age for " + targetName + ": " + totalAge);

        // Получить Set с именами клиентов в порядке упоминания
        Set<String> nameSet = clients.stream()
            .map(Client::getName)
            .collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println("Name set: " + nameSet);

        // Проверить, есть ли клиенты с возрастом больше заданного числа
        int targetAge = 30;
        boolean hasClientsWithAgeGreaterThanTarget = clients.stream()
            .anyMatch(client -> client.getAge() > targetAge);
        System.out.println(
            "Has clients with age greater than " + targetAge + ": " + hasClientsWithAgeGreaterThanTarget);

        // Преобразовать массив в Map с уникальным идентификатором в качестве ключа и именем в качестве значения
        Map<Integer, String> idToNameMap = clients.stream()
            .collect(Collectors.toMap(Client::getId, Client::getName, (prev, next) -> prev, LinkedHashMap::new));
        System.out.println("ID to Name map: " + idToNameMap);

        // Преобразовать массив в Map с возрастом в качестве ключа и коллекцией клиентов с таким возрастом в качестве
        // значения
        Map<Integer, List<Client>> ageToClientsMap = clients.stream()
            .collect(Collectors.groupingBy(Client::getAge));
        System.out.println("Age to Clients map: " + ageToClientsMap);

        // Получить строку, содержащую все телефоны клиентов через запятую
        String allPhones = clients.stream()
            .flatMap(client -> client.getPhones().stream())
            .map(Phone::getNumber)
            .collect(Collectors.joining(", "));
        System.out.println("All phones: " + allPhones);

        // Найти самого возрастного клиента, который пользуется стационарным телефоном
        Optional<Client> oldestClientWithLandline = clients.stream()
            .filter(client -> client.getPhones().stream()
                .anyMatch(phone -> phone.getType() == PhoneType.LANDLINE))
            .max(Comparator.comparingInt(Client::getAge));
        oldestClientWithLandline.ifPresent(client ->
                                               System.out.println("Oldest client with landline: " + client.getName()));
    }
}