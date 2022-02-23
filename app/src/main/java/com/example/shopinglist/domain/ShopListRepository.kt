package com.example.shopinglist.domain

import androidx.lifecycle.LiveData

interface ShopListRepository {
    fun addItemToShopList(shopItem: ShopItem)
    fun deleteItemFromShopListUseCase(shopItem: ShopItem)
    fun editItemFromShopList(shopItem: ShopItem)
    fun getItemFromShopList(shopItemId: Int):ShopItem
    fun getShopList(): LiveData<List<ShopItem>>
}