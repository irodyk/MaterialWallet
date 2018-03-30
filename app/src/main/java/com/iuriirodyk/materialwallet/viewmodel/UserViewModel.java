package com.iuriirodyk.materialwallet.viewmodel;

import com.google.auto.value.AutoValue;

import io.reactivex.annotations.NonNull;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 30.03.2018.
 */

@AutoValue
public abstract class UserViewModel {

    @NonNull
    public abstract String name();
    @NonNull public abstract String photoPath();

    public static UserViewModel create(String name, String photoPath) {
        return new AutoValue_UserViewModel(name, photoPath);
    }
}
