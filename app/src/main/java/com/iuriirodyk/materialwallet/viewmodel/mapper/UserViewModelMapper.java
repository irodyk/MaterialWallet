package com.iuriirodyk.materialwallet.viewmodel.mapper;

import com.iuriirodyk.data.entity.UserEntity;
import com.iuriirodyk.domain.model.User;
import com.iuriirodyk.materialwallet.viewmodel.UserViewModel;

import javax.inject.Inject;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 28.03.2018.
 */

public class UserViewModelMapper implements Mapper<UserViewModel, User> {

    @Inject
    UserViewModelMapper(){
    }

    @Override
    public User mapFromViewModel(UserViewModel userViewModel) {
        return User.create(userViewModel.name(), userViewModel.photoPath());
    }

    @Override
    public UserViewModel mapToViewModel(User user) {
        return UserViewModel.create(user.name(), user.photoPath());
    }
}
