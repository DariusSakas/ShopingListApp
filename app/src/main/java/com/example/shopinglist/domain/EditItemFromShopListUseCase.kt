package com.example.shopinglist.domain

class EditItemFromShopListUseCase(private val shopListRepository: ShopListRepository) {
    fun editItemFromShopList(shopItem: ShopItem){
        shopListRepository.editItemFromShopList(shopItem)
    }
}