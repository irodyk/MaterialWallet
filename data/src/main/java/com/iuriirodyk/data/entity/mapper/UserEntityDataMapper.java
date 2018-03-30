package com.iuriirodyk.data.entity.mapper;

import com.iuriirodyk.data.entity.UserEntity;
import com.iuriirodyk.domain.model.User;

import javax.inject.Inject;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 28.03.2018.
 */

public class UserEntityDataMapper implements Mapper<UserEntity, User> {

    @Inject UserEntityDataMapper(){
    }

    @Override
    public User mapFromEntity(UserEntity entity) {
        return User.create(entity.name(), entity.photoPath());
    }

    @Override
    public UserEntity mapToEntity(User user) {
        return UserEntity.create(user.name(), user.photoPath());
    }
}
