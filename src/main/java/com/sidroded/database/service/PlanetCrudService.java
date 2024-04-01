package com.sidroded.database.service;

import com.sidroded.database.dao.PlanetDao;
import com.sidroded.database.entity.Planet;

public class PlanetCrudService {
    private final PlanetDao planetDao = new PlanetDao();

    public void savePlanet(Planet planet) {
        planetDao.save(planet);
    }

    public Planet findPlanetById(String id) {
        return planetDao.findById(id);
    }

    public void updatePlanet(Planet planet) {
        planetDao.update(planet);
    }

    public void deletePlanet(Planet planet) {
        planetDao.delete(planet);
    }
}
