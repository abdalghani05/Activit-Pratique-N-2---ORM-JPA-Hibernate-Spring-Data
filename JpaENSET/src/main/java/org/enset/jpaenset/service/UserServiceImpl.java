package org.enset.jpaenset.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.enset.jpaenset.entities.Role;
import org.enset.jpaenset.entities.User;
import org.enset.jpaenset.repositories.RoleRepository;
import org.enset.jpaenset.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private RoleRepository roleRepository;



    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User findUserByUserName(String userName) {
        return userRepository.findUserByUserName(userName);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepository.findRoleByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        User user=findUserByUserName(userName);
        Role role=findRoleByRoleName(roleName);
        if(user.getRoles()!=null){
            user.getRoles().add(role);
            role.getUsers().add(user);
        }
    }

    @Override
    public User authenticate(String userName,String password){
        User u = userRepository.findUserByUserName(userName);
        if(u==null){
            throw new RuntimeException("Bad credentials");
        }
        if(u.getPassword().equals(password)){
            return u;
        }
        throw new RuntimeException("Bad credentials");
    }
}
