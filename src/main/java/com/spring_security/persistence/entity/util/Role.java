package com.spring_security.persistence.entity.util;

import lombok.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor

public enum Role {

    ROLE_ADMINISTRATOR(Arrays.asList(
            RolePermission.READ_ALL_PRODUCTS,
            RolePermission.READ_ONE_PRODUCT,
            RolePermission.CREATE_ONE_PRODUCT,
            RolePermission.DISABLE_ONE_PRODUCT,
            RolePermission.UPDATE_ONE_PRODUCT,

            RolePermission.READ_ALL_CATEGORIES,
            RolePermission.READ_ONE_CATEGORY,
            RolePermission.CREATE_ONE_CATEGORY,
            RolePermission.DISABLE_ONE_CATEGORY,
            RolePermission.UPDATE_ONE_CATEGORY,

            RolePermission.READ_MY_PROFILE


    )),
    ROLE_ASSISTANT_ADMINISTRATOR(Arrays.asList(
            RolePermission.READ_ALL_PRODUCTS,
            RolePermission.READ_ONE_PRODUCT,
            RolePermission.UPDATE_ONE_PRODUCT,

            RolePermission.READ_ALL_CATEGORIES,
            RolePermission.READ_ONE_CATEGORY,
            RolePermission.UPDATE_ONE_CATEGORY,

            RolePermission.READ_MY_PROFILE

    )),
    ROLE_CUSTOMER(Collections.singletonList(RolePermission.READ_MY_PROFILE));


    private List<RolePermission> permissionList;

}
