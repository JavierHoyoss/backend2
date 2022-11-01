/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.hoyos.Repository;

import com.portfolio.hoyos.Entity.Banner;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RBanner extends JpaRepository<Banner,Integer>{
    public Optional<Banner> findByImg(String img);
    public boolean existsByImg(String img);
    
}
