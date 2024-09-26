package com.metasoft.restyle.platform.iam.interfaces.rest.transform;

import com.metasoft.restyle.platform.iam.domain.model.commands.SignUpCommand;
import com.metasoft.restyle.platform.iam.domain.model.entities.Role;
import com.metasoft.restyle.platform.iam.interfaces.rest.resources.SignUpResource;

import java.util.ArrayList;
import java.util.List;

public class SignUpCommandFromResourceAssembler {
    public static SignUpCommand toCommandFromResource(SignUpResource resource) {
        List<Role> roles = resource.roles() != null
                ? resource.roles().stream().map(name -> Role.toRoleFromName(name)).toList()
                : new ArrayList<>();
        System.out.print("Roles:");
        if (!roles.isEmpty()) {
            System.out.println(roles.get(0).getName().name());
        }
        return new SignUpCommand(resource.username(), resource.password(), roles, resource.email(), resource.firstName(), resource.paternalSurname(), resource.maternalSurname(), resource.description(), resource.phone(), resource.image());
    }
}