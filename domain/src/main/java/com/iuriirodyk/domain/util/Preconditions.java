package com.iuriirodyk.domain.util;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 27.03.2018.
 */

public final class Preconditions {

    private Preconditions() {}

    public static <T> T checkNotNull(T reference) {
        if (reference == null) {
            throw new NullPointerException();
        }
        return reference;
    }
}
