package com.iuriirodyk.data.entity;

import com.google.auto.value.AutoValue;

import io.reactivex.annotations.NonNull;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 28.03.2018.
 */

@AutoValue
public abstract class UserEntity {

    @NonNull public abstract String name();
    @NonNull public abstract String photoThumbnailPath();
    @NonNull public abstract String photoPath();

    public static UserEntity create(String name, String photoThumbnailPath, String photoPath) {
        return new AutoValue_UserEntity(name, photoThumbnailPath, photoPath);
    }
}
