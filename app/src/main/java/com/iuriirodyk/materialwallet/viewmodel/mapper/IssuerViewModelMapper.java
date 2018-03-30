package com.iuriirodyk.materialwallet.viewmodel.mapper;

import com.iuriirodyk.domain.model.Issuer;
import com.iuriirodyk.materialwallet.viewmodel.IssuerViewModel;

import javax.inject.Inject;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 28.03.2018.
 */

public class IssuerViewModelMapper implements Mapper<IssuerViewModel, Issuer> {

    @Inject IssuerViewModelMapper(){
    }

    @Override
    public Issuer mapFromViewModel(IssuerViewModel e) {
        return Issuer.create(e.issuerName(), e.logoImagePath());
    }

    @Override
    public IssuerViewModel mapToViewModel(Issuer issuer) {
        return IssuerViewModel.create(issuer.issuerName(), issuer.logoImagePath());
    }
}
