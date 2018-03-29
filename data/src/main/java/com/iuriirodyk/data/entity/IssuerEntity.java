package com.iuriirodyk.data.entity;

import com.google.auto.value.AutoValue;
import com.iuriirodyk.domain.model.Issuer;

import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 28.03.2018.
 */

@AutoValue
public abstract class IssuerEntity {

    @NonNull public abstract String issuerName();
    @Nullable public abstract String logoImagePath();

    public static IssuerEntity create(String issuerName, String logoImagePath) {
        return new AutoValue_IssuerEntity(issuerName, logoImagePath);
    }
}
