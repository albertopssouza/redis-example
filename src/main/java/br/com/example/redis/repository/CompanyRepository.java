/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.example.redis.repository;

import br.com.example.redis.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author alber
 */
public interface CompanyRepository extends JpaRepository<Company, Long> {
    
}
