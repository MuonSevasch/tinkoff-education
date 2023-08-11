package com.example.education.resource;

import com.example.education.domain.Car;
import com.example.education.repositories.CarRepository;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

@WebServlet("/api/cars/*")
public class CarServlet extends HttpServlet {
    private CarRepository carRepository;

    @Override
    public void init() {
        carRepository = new CarRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestPath = request.getPathInfo();

        if (requestPath == null || requestPath.equals("/")) {
            List<Car> cars = carRepository.getAllCars();
            JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
            for (Car car : cars) {
                jsonArrayBuilder.add(Json.createObjectBuilder()
                                         .add("id", car.getId())
                                         .add("model", car.getModel())
                                         .add("license_plate", car.getLicensePlate())
                                         .build());
            }
            JsonArray jsonArray = jsonArrayBuilder.build();

            response.setContentType("application/json");
            response.getWriter().write(jsonArray.toString());
        } else {
            Long id = Long.parseLong(requestPath.substring(1));
            Car car = carRepository.getCarById(id);
            if (car != null) {
                JsonObject jsonObject = Json.createObjectBuilder()
                    .add("id", car.getId())
                    .add("model", car.getModel())
                    .add("license_plate", car.getLicensePlate())
                    .build();

                response.setContentType("application/json");
                response.getWriter().write(jsonObject.toString());
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JsonReader reader = Json.createReader(new InputStreamReader(request.getInputStream()));
        JsonObject jsonCar = reader.readObject();
        reader.close();

        Car car = new Car();
        car.setLicensePlate(jsonCar.getString("license_plate"));
        car.setModel(jsonCar.getString("model"));

        carRepository.createCar(car);

        response.setStatus(HttpServletResponse.SC_CREATED);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JsonReader reader = Json.createReader(new InputStreamReader(request.getInputStream()));
        JsonObject jsonCar = reader.readObject();
        reader.close();

        Long id = Long.parseLong(request.getPathInfo().substring(1));
        Car car = carRepository.getCarById(id);

        if (car != null) {
            car.setLicensePlate(jsonCar.getString("license_plate"));
            car.setModel(jsonCar.getString("model"));

            carRepository.updateCar(car);

            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) {
        Long id = Long.parseLong(request.getPathInfo().substring(1));
        Car car = carRepository.getCarById(id);
        carRepository.deleteCar(car);
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

    @Override
    public void destroy() {
        carRepository.close();
    }
}