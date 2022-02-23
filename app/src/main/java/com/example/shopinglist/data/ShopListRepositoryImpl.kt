package com.example.shopinglist.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shopinglist.domain.ShopItem
import com.example.shopinglist.domain.ShopListRepository

object ShopListRepositoryImpl: ShopListRepository{

    private val shopList = mutableListOf<ShopItem>()
    private val shopListLD = MutableLiveData<List<ShopItem>>()

    private var autoIncrementId = 0

    init{
        for (i in 0 until 10){
            val item = ShopItem("Name $i", i, true)
            addItemToShopList(item)
        }
    }

    override fun addItemToShopList(shopItem: ShopItem) {
        if(shopItem.id == ShopItem.UNDEFINED_ID){
            shopItem.id =  autoIncrementId++
        }
        shopList.add(shopItem)
        updateList()
    }

    override fun deleteItemFromShopListUseCase(shopItem: ShopItem) {
        shopList.remove(shopItem)
        updateList()
    }

    override fun editItemFromShopList(shopItem: ShopItem) {
        val oldElement = getItemFromShopList(shopItem.id)
        shopList.remove(oldElement)
        addItemToShopList(shopItem)
    }

    override fun getItemFromShopList(shopItemId: Int): ShopItem {
        return shopList.find{it.id == shopItemId} ?:
        throw RuntimeException("Element with id $shopItemId not found")
    }

    override fun getShopList(): LiveData<List<ShopItem>> {
        updateList()
        return shopListLD
    }

    private fun updateList(){
        shopListLD.value = shopList.toList()
    }
}