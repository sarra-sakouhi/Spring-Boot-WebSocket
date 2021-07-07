package com.javatechie.spring.ws.api.repositories.user;


import org.springframework.data.jpa.repository.JpaRepository;

import com.javatechie.spring.ws.api.entities.user.Role;

public interface IRoleRepository extends JpaRepository<Role, Long> {

}
