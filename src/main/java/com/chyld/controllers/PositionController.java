package com.chyld.controllers;

import com.chyld.entities.Device;
import com.chyld.entities.Position;
import com.chyld.entities.Run;
import com.chyld.services.DeviceService;
import com.chyld.services.RunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

/**
 * Created by localadmin on 9/7/16.
 */
@RestController
@RequestMapping("/positions")
public class PositionController {

    @Autowired
    private RunService runService;
    @Autowired
    private DeviceService deviceService;

    @RequestMapping(value = "/{serialnumber}", method = RequestMethod.POST)
    public void startDevice(@PathVariable String serialnumber) {
        Device d = deviceService.findBySerial(serialnumber);
        if (runService.findByDevice(d) == null){ return ;}

        Run r = runService.findByDevice(d);
        Position p = new Position();
        p.setAltitude(120.5f);
        p.setLatitude(42.5f);
        p.setLongitude(87.5f);
        Calendar cal = Calendar.getInstance();
        p.setCurrentTime(cal.getTime());
        p.setRun(r);
        r.getPositions().add(p);



        runService.saveRun(r);
    }
}
