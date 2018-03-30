package com.iuriirodyk.materialwallet.viewmodel;

import android.os.Bundle;

import com.google.auto.value.AutoValue;

import io.reactivex.annotations.NonNull;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 30.03.2018.
 */

@AutoValue
public abstract class IssuerViewModel {

    @NonNull public abstract String issuerName();
    @NonNull public abstract String logoImagePath();

    public static IssuerViewModel create(String issuerName, String logoImagePath) {
        return new AutoValue_IssuerViewModel(issuerName, logoImagePath);
    }

    public Bundle toExtras(){
        Bundle b = new Bundle();
        b.putString("issuerName", issuerName());
        b.putString("logoPath", logoImagePath());
        return b;
    }

    public static IssuerViewModel fromExtras(Bundle b){
        return create(b.getString("issuerName"), b.getString("logoPath"));
    }
}
