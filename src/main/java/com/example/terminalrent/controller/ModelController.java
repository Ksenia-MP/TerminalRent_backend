package com.example.terminalrent.controller;

import com.example.terminalrent.dto.ModelPojo;
import com.example.terminalrent.service.ModelService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelController {
    private final ModelService modelService;

    @GetMapping
    public List<ModelPojo> findAll() { return modelService.findAll(); }

    @GetMapping("/{id}")
    public ModelPojo findById(@PathVariable long id) { return modelService.findById(id); }

    @PostMapping
    public ModelPojo createModel(@RequestBody ModelPojo pojo) { return modelService.create(pojo); }

    @PutMapping
    public ModelPojo updateModel(@RequestBody ModelPojo pojo) { return modelService.update(pojo); }

    @DeleteMapping
    public boolean deleteModel(@RequestParam long id) { return modelService.delete(id); }

}
