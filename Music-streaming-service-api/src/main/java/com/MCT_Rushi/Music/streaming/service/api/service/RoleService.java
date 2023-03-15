package com.MCT_Rushi.Music.streaming.service.api.service;

import com.MCT_Rushi.Music.streaming.service.api.interfaces.IRoleServiceInterface;
import com.MCT_Rushi.Music.streaming.service.api.model.Role;
import com.MCT_Rushi.Music.streaming.service.api.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleServiceInterface {
    @Autowired
    private IRoleRepository iRoleRepository;
    @Override
    public Role addROle(Role role) {
        return iRoleRepository.save(role);
    }
}
