package com.example.shopinglist.domain

import android.util.Log
import androidx.lifecycle.LiveData

class GetShopListUseCase(private val shopListRepository: ShopListRepository) {
    fun getShopList():LiveData<List<ShopItem>>{

        return shopListRepository.getShopList()
    }
}