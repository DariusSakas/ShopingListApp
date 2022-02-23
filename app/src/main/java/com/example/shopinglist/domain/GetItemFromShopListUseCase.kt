package com.example.shopinglist.domain

class GetItemFromShopListUseCase(private val shopListRepository: ShopListRepository) {
    fun getItemFromShopList(shopItemId: Int):ShopItem{
      return shopListRepository.getItemFromShopList(shopItemId)
    }
}