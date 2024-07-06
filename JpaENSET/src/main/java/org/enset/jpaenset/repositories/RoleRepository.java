package org.enset.jpaenset.repositories;

import org.enset.jpaenset.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findRoleByRoleName(String roleName);
}
