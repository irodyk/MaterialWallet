package com.iuriirodyk.materialwallet.viewmodel.mapper;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 28.03.2018.
 */

interface Mapper<V, D> {

    D mapFromViewModel(V v);

    V mapToViewModel(D d);
}
