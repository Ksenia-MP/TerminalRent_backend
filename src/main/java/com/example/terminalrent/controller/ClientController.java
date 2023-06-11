package com.example.terminalrent.controller;

import com.example.terminalrent.dto.ClientPojo;
import com.example.terminalrent.dto.TerminalPojo;
import com.example.terminalrent.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/clients")
@AllArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping
    public List<ClientPojo> findAll() {return clientService.findAll(); }

    @GetMapping("/{id}")
    public ClientPojo findById(@PathVariable long id) { return clientService.findById(id); }

    @PostMapping
    public ClientPojo createClient(@RequestBody ClientPojo pojo) { return clientService.create(pojo); }

    @PutMapping
    public ClientPojo updateClient(@RequestBody ClientPojo pojo) { return clientService.update(pojo); }

    @DeleteMapping
    public boolean deleteClient(@RequestParam long id) { return clientService.delete(id); }


}
