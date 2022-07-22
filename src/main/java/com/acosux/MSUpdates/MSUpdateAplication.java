/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acosux.MSUpdates;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

/**
 *
 * @author Tabango
 */
@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class MSUpdateAplication {

    public static void main(String[] args) {
        SpringApplication.run(MSUpdateAplication.class, args);
    }

}
