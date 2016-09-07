package com.chyld.services;

import com.chyld.entities.Device;
import com.chyld.repositories.IDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by localadmin on 9/7/16.
 */
@Service
public class DeviceService {

    private IDeviceRepository repository;

    @Autowired
    public void setRepository(IDeviceRepository repository) {
        this.repository = repository;
    }

    public void destroy(int id) {
        this.repository.delete(id);
    }

    public Device findById(Integer id) {
        return repository.findOne(id);
    }

    public Device findBySerial(String serial) {
        return repository.findOneBySerial(serial);
    }
}
