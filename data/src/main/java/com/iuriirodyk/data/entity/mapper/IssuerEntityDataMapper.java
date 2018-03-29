package com.iuriirodyk.data.entity.mapper;

import com.iuriirodyk.data.entity.IssuerEntity;
import com.iuriirodyk.domain.model.Issuer;

import javax.inject.Inject;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 28.03.2018.
 */

public class IssuerEntityDataMapper implements Mapper<IssuerEntity, Issuer> {

    @Inject IssuerEntityDataMapper(){
    }

    @Override
    public Issuer mapFromEntity(IssuerEntity e) {
        return Issuer.create(e.issuerName(), e.logoImagePath());
    }

    @Override
    public IssuerEntity mapToEntity(Issuer issuer) {
        return IssuerEntity.create(issuer.issuerName(), issuer.logoImagePath());
    }
}
