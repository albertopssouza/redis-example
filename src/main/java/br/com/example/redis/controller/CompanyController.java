/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.example.redis.controller;

import br.com.example.redis.entity.Company;
import br.com.example.redis.service.CompanyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alber
 */
@RestController
@RequestMapping("/company")
public class CompanyController {
    
    @Autowired
    private CompanyService service;
    
    @GetMapping
    public ResponseEntity<List<Company>> findAll() {
        List<Company> list = service.findAll();
        
        return ResponseEntity.ok(list);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Company> findById(@PathVariable Long id) {
        Company company = service.findById(id);
        
        return ResponseEntity.ok(company);
    }
}
