package com.example.terminalrent.controller;

import com.example.terminalrent.dto.CommunicationPojo;
import com.example.terminalrent.jpa.CommunicationRepository;
import com.example.terminalrent.service.CommunicationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/communications")
@AllArgsConstructor
public class CommunicationController {
    private final CommunicationService communicationService;

    @GetMapping
    public List<CommunicationPojo> findAll() { return communicationService.findAll(); }

    @GetMapping("/{id}")
    public CommunicationPojo findById(@PathVariable long id) { return communicationService.findById(id); }

    @PostMapping
    public CommunicationPojo createCommunication(@RequestBody CommunicationPojo pojo) { return communicationService.create(pojo); }

    @PutMapping
    public CommunicationPojo updateCommunication(@RequestBody CommunicationPojo pojo) { return communicationService.update(pojo); }

    @DeleteMapping
    public boolean deleteCommunication(@RequestParam long id) { return  communicationService.delete(id); }
}
