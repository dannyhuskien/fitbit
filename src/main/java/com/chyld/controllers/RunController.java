package com.chyld.controllers;

import com.chyld.entities.Device;
import com.chyld.entities.Run;
import com.chyld.services.DeviceService;
import com.chyld.services.RunService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.security.Principal;

import java.util.Calendar;

@RestController
@RequestMapping("/runs")
public class RunController {

    @Autowired
    public void setRunService(RunService runService) {
        this.runService = runService;
    }
    @Autowired
    private RunService runService;
    @Autowired
    private DeviceService deviceService;

    @RequestMapping(value = "/{serialnumber}/start", method = RequestMethod.POST)
    public void startDevice(@PathVariable String serialnumber) {
        Device d = deviceService.findBySerial(serialnumber);
        if (runService.findByDevice(d) != null){ return ;}

        Run r = new Run();
        r.setDevice(d);
        runService.saveRun(r);
    }

    @RequestMapping(value = "/{serialnumber}/stop", method = RequestMethod.POST)
    public void stopDevice(@PathVariable String serialnumber) {
        Device d = deviceService.findBySerial(serialnumber);
        if (runService.findByDevice(d) == null){ return ;}

        Run r = runService.findByDevice(d);
        Calendar cal = Calendar.getInstance();
        r.setStopTime(cal.getTime());
        r.setDevice(d);
        runService.saveRun(r);
    }
}
