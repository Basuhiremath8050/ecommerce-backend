package com.ecommerce.userservice.dto;

import com.ecommerce.userservice.model.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleUpdateRequest {
    private Role role;
}
