package com.example.proyecto_coinmate.catalog

class CoinProvider {
    companion object {
        val listaCoins = listOf<Coins>(
            Coins("España", "2003", "2 euros", "null"),
            Coins("España", "1999", "1 euro", "null"),
            Coins("España", "1999", "50 céntimos", "null"),
            Coins("España", "2001", "20 céntimos", "null"),
            Coins("España", "2003", "10 céntimos", "null"),
            Coins("España", "1999", "5 céntimos", "null"),
            Coins("España", "2002", "2 céntimos", "null"),
            Coins("España", "1999", "1 céntimo", "null"),
        )
    }
}