package com.iuriirodyk.data.entity.mapper;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 28.03.2018.
 */

interface Mapper<E, D> {

    D mapFromEntity(E e);

    E mapToEntity(D d);
}
