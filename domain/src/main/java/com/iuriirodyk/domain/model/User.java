package com.iuriirodyk.domain.model;

import com.google.auto.value.AutoValue;

import io.reactivex.annotations.NonNull;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 27.03.2018.
 */

@AutoValue
public abstract class User {

    @NonNull public abstract String name();
    @NonNull public abstract String photoPath();

    public static User create(String name, String photoPath) {
        return new AutoValue_User(name, photoPath);
    }
}
