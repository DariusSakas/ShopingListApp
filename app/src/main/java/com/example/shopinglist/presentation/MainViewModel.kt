package com.example.shopinglist.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shopinglist.data.ShopListRepositoryImpl
import com.example.shopinglist.domain.DeleteItemFromShopListUseCase
import com.example.shopinglist.domain.EditItemFromShopListUseCase
import com.example.shopinglist.domain.GetShopListUseCase
import com.example.shopinglist.domain.ShopItem

class MainViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteItemFromShopListUseCase = DeleteItemFromShopListUseCase(repository)
    private val editItemFromShopListUseCase = EditItemFromShopListUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteItem(shopItem: ShopItem){
        deleteItemFromShopListUseCase.deleteItemFromShopListUseCase(shopItem)
    }

    fun editItem(shopItem: ShopItem){
        shopItem.enabled = !shopItem.enabled
        editItemFromShopListUseCase.editItemFromShopList(shopItem)
    }
}