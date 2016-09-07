package com.chyld.repositories;

import com.chyld.entities.Device;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by localadmin on 9/7/16.
 */
public interface IDeviceRepository extends PagingAndSortingRepository<Device, Integer> {
    public Device findById(int id);

    Device findOneBySerial(String serial);

}
