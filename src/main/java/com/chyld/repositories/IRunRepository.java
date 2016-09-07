package com.chyld.repositories;

import com.chyld.entities.Device;
import com.chyld.entities.Run;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by localadmin on 9/7/16.
 */
public interface IRunRepository extends PagingAndSortingRepository<Run, Integer> {
    public Run findById(int id);

    Run findOneByDeviceAndStopTimeIsNull(Device d);

}
