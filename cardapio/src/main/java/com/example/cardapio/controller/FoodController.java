package com.example.cardapio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cardapio.dtos.FoodRequestDTO;
import com.example.cardapio.dtos.FoodResponseDTO;
import com.example.cardapio.entities.Food;
import com.example.cardapio.repositories.FoodRepository;

@RestController
@RequestMapping("food")
public class FoodController {
    
    // FoodService foodService;

    @Autowired
    private FoodRepository repository;

    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data) {
        repository.save(new Food(data));
    }

    @GetMapping
    public List<FoodResponseDTO> getAllFoods() {
        List<FoodResponseDTO> list = repository.findAll().stream().map(FoodResponseDTO::new).toList();
        return list;
    }
}
