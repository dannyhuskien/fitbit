package com.chyld.services;

import com.chyld.entities.Device;
import com.chyld.entities.Run;
import com.chyld.entities.User;
import com.chyld.repositories.IRunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by localadmin on 9/7/16.
 */
@Service
public class RunService {

    private IRunRepository repository;

    @Autowired
    public void setRepository(IRunRepository repository) {
        this.repository = repository;
    }

    public void destroy(int id) {
        this.repository.delete(id);
    }

    public Run findByDevice(Device d) {
        return repository.findOneByDeviceAndStopTimeIsNull(d);
    }

    public Run saveRun(Run run) {
        return repository.save(run);
    }
}
