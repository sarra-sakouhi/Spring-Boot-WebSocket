package com.softib.spring.ws.api.repositories.user;


import org.springframework.data.jpa.repository.JpaRepository;

import com.softib.spring.ws.api.entities.user.Role;

public interface IRoleRepository extends JpaRepository<Role, Long> {

}
