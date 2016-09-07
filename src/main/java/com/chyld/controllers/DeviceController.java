package com.chyld.controllers;

import com.chyld.entities.Device;
import com.chyld.entities.User;
import com.chyld.security.JwtToken;
import com.chyld.services.DeviceService;
import com.chyld.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

/**
 * Created by localadmin on 9/7/16.
 */
@RestController
@RequestMapping("/devices")
public class DeviceController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @Autowired
    private DeviceService deviceService;


    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> createDevice(@RequestBody Device device, Principal user) {
        int uid = ((JwtToken) user).getUserId();
        User u = userService.findUserById(uid);


        u.getDevices().add(device);
        device.setUser(u);

        userService.saveUser(u);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Device> getDevices(Principal user){
        int uid = ((JwtToken) user).getUserId();
        User u = userService.findUserById(uid);
        return u.getDevices();
    }

//    @RequestMapping(value = "", method = RequestMethod.PUT)
//    public Optional<Exercise> updateExercise(@RequestBody Exercise updatedExercise, Principal user) {
//        int uid = ((JwtToken) user).getUserId();
//        User u = userService.findUserById(uid);
//        Optional<Exercise> exercise = u.getExercises().stream().filter(e -> e.getId() == updatedExercise.getId()).findFirst();
//        exercise.ifPresent(e -> {
//            e.setCalories(updatedExercise.getCalories());
//            e.setType(updatedExercise.getType());
//            e.setQuantity(updatedExercise.getQuantity());
//            e.setDuration(updatedExercise.getDuration());
//            e.setUser(u);
//            userService.saveUser(u);
//        });
//
//        return exercise;
//    }
//
//    @RequestMapping(path = {"/{id}"}, method = RequestMethod.DELETE)
//    public void deleteExercise(@PathVariable int id, Principal user) {
//        int uid = ((JwtToken) user).getUserId();
//        User u = userService.findUserById(uid);
//        Optional<Exercise> exercise = u.getExercises().stream().filter(e -> e.getId() == id).findFirst();
//        exercise.ifPresent(e -> {
//            u.getExercises().remove(e);
//            userService.saveUser(u);
//            exerciseService.destroy(id);
//
//        });
//
//    }
}
