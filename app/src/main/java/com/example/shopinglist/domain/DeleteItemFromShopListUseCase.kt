package com.example.shopinglist.domain

class DeleteItemFromShopListUseCase (private val shopListRepository: ShopListRepository){
    fun deleteItemFromShopListUseCase(shopItem: ShopItem){
        shopListRepository.deleteItemFromShopListUseCase(shopItem)
    }
}