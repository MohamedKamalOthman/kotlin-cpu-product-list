package com.example.myapplication

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

/**
 * Interface for product api
 * @see retrofit2.http.GET
 * @see Product
 * @see ProductsApi
 */
interface ProductApiService {
    @GET("/")
    suspend fun getProducts(): List<Product>
}

/**
 * Data class for product
 * @param name name of the product
 * @param image image of the product
 * @param description description of the product
 */
data class Product(val name: String, val image: String, val description: String)

/**
 * Object for product api
 * @see retrofit2.Retrofit
 * @see Moshi
 */
object ProductsApi {
    // TODO: Replace with your own IP address
    private val BASE_URL = "https://71e0-41-33-183-2.eu.ngrok.io/"

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()

    val retrofitService: ProductApiService by lazy {
        retrofit.create(ProductApiService::class.java)
    }
}
