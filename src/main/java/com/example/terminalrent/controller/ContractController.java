package com.example.terminalrent.controller;

import com.example.terminalrent.dto.ContractPojo;
import com.example.terminalrent.service.ClientService;
import com.example.terminalrent.service.ContractService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/contracts")
@AllArgsConstructor
public class ContractController {
    private final ContractService contractService;
    private final ClientService clientService;

    @GetMapping
    public List<ContractPojo> findAll() { return contractService.findAll(); }

    @GetMapping("/{id}")
    public ContractPojo findById(@PathVariable long id) { return contractService.findById(id); }

    @PostMapping
    public ContractPojo createContract(@RequestBody ContractPojo pojo) {
        return contractService.create(pojo);
    }

    @PutMapping
    public ContractPojo updateContract(@RequestBody ContractPojo pojo) {
        return contractService.update(pojo);
    }

    @DeleteMapping
    public boolean deleteContract(@RequestParam long id) { return contractService.delete(id); }
}
