package com.iuriirodyk.materialwallet.di.scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 28.03.2018.
 */

@Scope
@Retention(RUNTIME)
public @interface PerActivity {}
