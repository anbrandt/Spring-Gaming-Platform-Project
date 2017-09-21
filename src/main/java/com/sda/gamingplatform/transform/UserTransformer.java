package com.sda.gamingplatform.transform;

import com.sda.gamingplatform.dto.UserDto;
import com.sda.gamingplatform.entities.UserRole;
import org.springframework.stereotype.Component;

/**
 * Created by RENT on 2017-09-21.
 */
@Component
public class UserTransformer {

   public UserDto transformFromUserRole(UserRole userRole) {
        return new UserDto(userRole.getUsername(),userRole.getUser_role_id());
    }
}
