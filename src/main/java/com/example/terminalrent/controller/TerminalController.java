package com.example.terminalrent.controller;

import com.example.terminalrent.dto.TerminalPojo;
import com.example.terminalrent.service.TerminalService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/terminals")
@AllArgsConstructor
public class TerminalController {
    private final TerminalService terminalService;

    @GetMapping
    public List<TerminalPojo> findAll() { return terminalService.findAll(); }

    @GetMapping("/{id}")
    public TerminalPojo findById(@PathVariable long id) { return terminalService.findById(id); }

    @GetMapping("/model")
    public List<TerminalPojo> findByModel(@RequestParam long id) { return  terminalService.findByModel(id); }

    @PostMapping
    public TerminalPojo create(@RequestBody TerminalPojo pojo) {
        return terminalService.create(pojo);
    }

    @PutMapping
    public TerminalPojo update(@RequestBody TerminalPojo pojo) {
        return terminalService.update(pojo);
    }

    @DeleteMapping
    public boolean delete(@RequestParam long id) {
        return terminalService.delete(id);
    }
}
