package com.example.proyecto_coinmate.catalog

class CoinProvider {
    companion object {
        val listaCoins = mutableListOf<Coins>(
            Coins("200ES2003","España", "2003", "2 euros", "https://www.ecb.europa.eu/euro/coins/common/shared/img/es/Spain_2Euro_2003.jpg", false),
            Coins("100ES1999","España", "1999", "1 euro", "https://www.ecb.europa.eu/euro/coins/common/shared/img/es/Spain_1Euro_1999.jpg", false),
            Coins("50ES1999","España", "1999", "50 céntimos", "https://www.ecb.europa.eu/euro/coins/common/shared/img/es/Spain_50cent_1999.jpg", false),
            Coins("20ES2001","España", "2001", "20 céntimos", "https://www.ecb.europa.eu/euro/coins/common/shared/img/es/Spain_20cent_2001.jpg", false),
            Coins("10ES2003","España", "2003", "10 céntimos", "https://www.ecb.europa.eu/euro/coins/common/shared/img/es/Spain_10cent_2003.jpg", false),
            Coins("5ES1999","España", "1999", "5 céntimos", "https://www.ecb.europa.eu/euro/coins/common/shared/img/es/Spain_5cent_1999.jpg", false),
            Coins("2ES2002","España", "2002", "2 céntimos", "https://www.ecb.europa.eu/euro/coins/common/shared/img/es/Spain_2cent_2002.jpg", false),
            Coins("1ES1999","España", "1999", "1 céntimo", "https://www.ecb.europa.eu/euro/coins/common/shared/img/es/Spain_1cent_1999.jpg", false),
        )
    }
}