/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.example.redis.service;

import br.com.example.redis.entity.Company;
import br.com.example.redis.repository.CompanyRepository;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 *
 * @author alber
 */
@Service
public class CompanyService {
    
    @Autowired
    private CompanyRepository companyRepository;
 
    @Cacheable(cacheNames = "Company", key="#root.method.name")
    public List<Company> findAll() {
        System.out.println("Chamando banco de dados");
        return companyRepository.findAll();
    }
    
    @Cacheable(cacheNames = "Company", key="#id")
    public Company findById(Long id) {
        System.out.println("Chamando banco de dados");
        return companyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Identifier not found: " + id));
    }
}
