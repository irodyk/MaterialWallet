package com.iuriirodyk.data.repository.datasource;

import com.iuriirodyk.data.entity.CardEntity;
import com.iuriirodyk.data.entity.IssuerEntity;
import com.iuriirodyk.data.entity.TransactionEntity;
import com.iuriirodyk.data.entity.UserEntity;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 29.03.2018.
 */

final class Mock {

    static UserEntity userEntity(){
        return UserEntity.create(Mock.USERNAME, PHOTO_THUMBNAIL_PATH, PHOTO_PATH);
    }

    static CardEntity cardEntity1(){
        IssuerEntity issuerEntity = IssuerEntity.create(ISSUER_NAME[0], ISSUER_IMG[0]);
        return CardEntity.create(
                HOLDER[0], PAN[0], EXPIRY[0], issuerEntity, CARD_IMG_PATH[0],
                BALANCE_TOTAL[0], BALANCE_AVLBL[0], BALANCE_BLOCKED[0], CARD_CURRENCY[0]
        );
    }

    static CardEntity cardEntity2(){
        IssuerEntity issuerEntity = IssuerEntity.create(ISSUER_NAME[0], ISSUER_IMG[0]);
        return CardEntity.create(
                HOLDER[0], PAN[0], EXPIRY[0], issuerEntity, CARD_IMG_PATH[0],
                BALANCE_TOTAL[0], BALANCE_AVLBL[0], BALANCE_BLOCKED[0], CARD_CURRENCY[0]
        );
    }

    static CardEntity cardEntity3(){
        IssuerEntity issuerEntity = IssuerEntity.create(ISSUER_NAME[0], ISSUER_IMG[0]);
        return CardEntity.create(
                HOLDER[0], PAN[0], EXPIRY[0], issuerEntity, CARD_IMG_PATH[0],
                BALANCE_TOTAL[0], BALANCE_AVLBL[0], BALANCE_BLOCKED[0], CARD_CURRENCY[0]
        );
    }

    static TransactionEntity[] transactionEntities(){
        return new TransactionEntity[]{
                transactionEntity1(),
                transactionEntity2(),
                transactionEntity3(),
                transactionEntity4(),
                transactionEntity5(),
                transactionEntity6(),
                transactionEntity7(),
                transactionEntity7(),
                transactionEntity8(),
                transactionEntity9(),
                transactionEntity10()
        };
    }

    static TransactionEntity transactionEntity1(){
        return TransactionEntity.create(TRANS_ID[0], TYPE[0], MERCHANT[0], AMOUNT[0], CARD_CURRENCY[0],
                BALANCE_AFTER[0], DATE[0], CARD_ENTITIES[0]);
    }

    static TransactionEntity transactionEntity2(){
        return TransactionEntity.create(TRANS_ID[1], TYPE[1], MERCHANT[1], AMOUNT[1], TRANS_CURRENCY[1],
                BALANCE_AFTER[1], DATE[1], CARD_ENTITIES[1]);
    }

    static TransactionEntity transactionEntity3(){
        return TransactionEntity.create(TRANS_ID[2], TYPE[2], MERCHANT[2], AMOUNT[2], TRANS_CURRENCY[2],
                BALANCE_AFTER[2], DATE[2], CARD_ENTITIES[2]);
    }

    static TransactionEntity transactionEntity4(){
        return TransactionEntity.create(TRANS_ID[3], TYPE[3], MERCHANT[3], AMOUNT[3], TRANS_CURRENCY[3],
                BALANCE_AFTER[3], DATE[3], CARD_ENTITIES[3]);
    }

    static TransactionEntity transactionEntity5(){
        return TransactionEntity.create(TRANS_ID[4], TYPE[4], MERCHANT[4], AMOUNT[4], TRANS_CURRENCY[4],
                BALANCE_AFTER[4], DATE[4], CARD_ENTITIES[4]);
    }

    static TransactionEntity transactionEntity6(){
        return TransactionEntity.create(TRANS_ID[5], TYPE[5], MERCHANT[5], AMOUNT[5], TRANS_CURRENCY[5],
                BALANCE_AFTER[5], DATE[5], CARD_ENTITIES[5]);
    }

    static TransactionEntity transactionEntity7(){
        return TransactionEntity.create(TRANS_ID[6], TYPE[6], MERCHANT[6], AMOUNT[6], TRANS_CURRENCY[6],
                BALANCE_AFTER[6], DATE[6], CARD_ENTITIES[6]);
    }

    static TransactionEntity transactionEntity8(){
        return TransactionEntity.create(TRANS_ID[7], TYPE[7], MERCHANT[7], AMOUNT[7], TRANS_CURRENCY[7],
                BALANCE_AFTER[7], DATE[7], CARD_ENTITIES[7]);
    }

    static TransactionEntity transactionEntity9(){
        return TransactionEntity.create(TRANS_ID[8], TYPE[8], MERCHANT[8], AMOUNT[8], TRANS_CURRENCY[8],
                BALANCE_AFTER[8], DATE[8], CARD_ENTITIES[8]);
    }

    static TransactionEntity transactionEntity10(){
        return TransactionEntity.create(TRANS_ID[9], TYPE[9], MERCHANT[9], AMOUNT[9], TRANS_CURRENCY[9],
                BALANCE_AFTER[9], DATE[9], CARD_ENTITIES[9]);
    }

    //User
    private static final String USERNAME = "Iurii Rodyk";
    private static final String PHOTO_THUMBNAIL_PATH = "file:///android_asset/raw/user/user_photo_thumbnail.png";
    private static final String PHOTO_PATH = "file:///android_asset/raw/user/user_photo.png";

    //Cards
    private static final String[] HOLDER = {
            "Iurii Rodyk",
            "Iurii Rodyk",
            "Iurii Rodyk"
    };
    private static final String[] PAN = {
            "4752445500012548",
            "475455042219933",
            "4855443500012651"
    };
    private static final String[] EXPIRY = {
            "11/20",
            "04/19",
            "12/18"
    };
    private static final String[] ISSUER_NAME = {
            "Commonwealth Credit Union",
            "Alpha Bank",
            "TSB"
    };
    private static final String[] ISSUER_IMG = {
            "file:///android_asset/raw/issuer/issuer_1.png",
            "file:///android_asset/raw/issuer/issuer_2.png",
            "file:///android_asset/raw/issuer/issuer_3.png"
    };
    private static final String[] BALANCE_TOTAL = {
            "3400.35",
            "2200.00",
            "159.00"
    };
    private static final String[] BALANCE_AVLBL = {
            "3146.09",
            "2000.00",
            "44.00"
    };
    private static final String[] BALANCE_BLOCKED = {
            "254.26",
            "200.00",
            "115.00"
    };
    private static final String[] CARD_CURRENCY = {
            "GBP",
            "USD",
            "EUR"
    };
    private static final String[] CARD_IMG_PATH = {
            "file:///android_asset/raw/card/card_1.png",
            "file:///android_asset/raw/card/card_2.png",
            "file:///android_asset/raw/card/card_3.png"
    };



    //Transactions
    private static final String[] TYPE = {
            "Outgoing",
            "Incoming",
            "Outgoing",
            "Outgoing",
            "Incoming",
            "Outgoing",
            "Outgoing",
            "Outgoing",
            "Incoming",
            "Outgoing",
    };
    private static final String[] TRANS_ID = {
            "100041",
            "100042",
            "100043",
            "100044",
            "100045",
            "100046",
            "100047",
            "100048",
            "100049",
            "100050",
    };
    private static final String[] MERCHANT = {
            "McDonald's",
            "Burger King",
            "Domino's Pizza",
            "4 Seasons Hotel",
            "Okko petrol station",
            "Aliexpress",
            "Domino's pizza",
            "Aliexpress",
            "Uber taxi",
            "McDonald's",
    };
    private static final String[] AMOUNT = {
            "11.02",
            "4000.00",
            "10.00",
            "122.00",
            "220.00",
            "15.50",
            "25.20",
            "87.35",
            "760.00",
            "18.40"
    };
    private static final String[] BALANCE_AFTER = {
            "1154.00",
            "1533.34",
            "140.00",
            "2456.43",
            "344.43",
            "1154.00",
            "1533.34",
            "140.00",
            "2456.43",
            "344.43",
    };
    private static final String[] TRANS_CURRENCY = {
            "GDP",
            "GDP",
            "GDP",
            "GDP",
            "GDP",
            "GDP",
            "GDP",
            "EUR",
            "EUR",
            "EUR",
    };
    private static final String[] DATE = {
            "12.03.2018",
            "13.03.2018",
            "13.03.2018",
            "15.03.2018",
            "15.03.2018",
            "15.03.2018",
            "19.03.2018",
            "19.03.2018",
            "19.03.2018",
    };
    private static final CardEntity[] CARD_ENTITIES = {
            cardEntity1(),
            cardEntity1(),
            cardEntity1(),
            cardEntity1(),
            cardEntity3(),
            cardEntity3(),
            cardEntity2(),
            cardEntity2(),
            cardEntity2(),
            cardEntity1()
    };
}
