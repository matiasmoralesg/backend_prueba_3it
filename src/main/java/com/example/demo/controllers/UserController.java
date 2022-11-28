package com.example.demo.controllers;

import com.example.demo.entity.User;
import com.example.demo.entity.dto.ResultsDTO;
import com.example.demo.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {"http://localhost:4200", "*"})
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @PostMapping("/add")
    public ResponseEntity<Map<String, Object>> save(@Valid @RequestBody User user) {

        Map<String, Object> response = new HashMap<>();
        User userNew = null;
        boolean exist = iUserService.existsByEmail(user.getEmail());

        if (exist) {
            response.put("mensaje", "El email ya se encuentra registrado");
            return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
        }

        userNew = iUserService.saveVote(user);

        response.put("mensaje", "El Usuario ha sido ingresado con éxito!");
        response.put("cliente", userNew);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/results")
    public List<ResultsDTO> getResult() {
        List<User> getUsers = iUserService.findAll();

        List<ResultsDTO> resultsDTOList = new ArrayList<>();
        ResultsDTO resultsDTO = new ResultsDTO();
        long rockCount = getUsers.stream().filter(f -> f.getMusicStyle().getId() == 1).count();
        long metalCount = getUsers.stream().filter(f -> f.getMusicStyle().getId() == 2).count();
        long jazzCount = getUsers.stream().filter(f -> f.getMusicStyle().getId() == 3).count();
        long bluesCount = getUsers.stream().filter(f -> f.getMusicStyle().getId() == 4).count();
        long clasicoCount = getUsers.stream().filter(f -> f.getMusicStyle().getId() == 5).count();

        resultsDTO.setRockCount(rockCount);
        resultsDTO.setMetalCount(metalCount);
        resultsDTO.setJazzCount(jazzCount);
        resultsDTO.setBluesCount(bluesCount);
        resultsDTO.setClasicoCount(clasicoCount);
        resultsDTOList.add(resultsDTO);

        return resultsDTOList;
    }

}
