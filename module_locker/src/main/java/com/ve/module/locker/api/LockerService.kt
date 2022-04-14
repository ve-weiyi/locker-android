package com.ve.module.locker.api

import com.ve.module.locker.logic.http.model.*
import retrofit2.http.*

/**
 * @Description hello word!
 * @Author  weiyi
 * @Date 2022/4/9
 */
interface LockerService {

    companion object {
        /**
         * 服务器地址
         */
//        const val BASE_URL = "http://10.21.191.246:8084/"
        /**
         * 本地测试地址 只能填服务器的地址+端口，并且以/结尾
         */
        const val BASE_URL = "http://10.21.191.246:8084/"

        //模拟器连接地址
        //const val BASE_URL = "http://10.0.2.2:8084/"
    }
    //-----------------------【 登录 】----------------------
    /**
     * 登录
     * http://www.wanandroid.com/user/login
     * @param username
     * @param password
     */
    @POST("/locker/api/login")
    @FormUrlEncoded
    suspend fun loginLocker(
        @Field("username") username: String?,
        @Field("password") password: String?,
        @Field("code") code: String?="1234",
    ): LockerBaseBean<LoginVO>


    //-----------------------【 隐私标签 】----------------------

    /**
     * 增
     * POST 请求只有一个json格式的 @Body
     */
    @POST("/locker/api/admin/privacy/tag/add/json")
    suspend fun tagAdd(@Body privacyTag: PrivacyTag): LockerBaseBean<Any>

    /**
     * 删
     * GET、DELETE 请求参数使用 @Query
     */
    @DELETE("/locker/api/admin/privacy/tag/delete/json")
    suspend fun tagDelete(@Query("id") id: Int): LockerBaseBean<Any>

    /**
     * 改
     * POST 请求只有一个json格式的 @Body
     */
    @POST("/locker/api/admin/privacy/tag/update/json")
    suspend fun tagUpdate(@Body privacyTag: PrivacyTag): LockerBaseBean<Any>

    /**
     * 查
     * POST 请求只有一个json格式的 @Body
     */
    @GET("/locker/api/admin/privacy/tag/{id}/json")
    suspend fun tagQuery(@Path("id") id: Int): LockerBaseBean<Any>

    /**
     * 条件查
     */
    @POST("/locker/api/admin/privacy/tag/list/json")
    suspend fun tagQueryList(@Body conditionVO: ConditionVO): LockerBaseBean<MutableList<PrivacyTag>>



    //-----------------------【 隐私文件夹 】----------------------

    /**
     * 增
     * POST 请求只有一个json格式的 @Body
     */
    @POST("/locker/api/admin/privacy/folder/add/json")
    suspend fun folderAdd(@Body privacyFolder: PrivacyFolder): LockerBaseBean<Any>

    /**
     * 删
     * GET、DELETE 请求参数使用 @Query
     */
    @DELETE("/locker/api/admin/privacy/folder/delete/json")
    suspend fun folderDelete(@Query("id") id: Int): LockerBaseBean<Any>

    /**
     * 改
     * POST 请求只有一个json格式的 @Body
     */
    @POST("/locker/api/admin/privacy/folder/update/json")
    suspend fun folderUpdate(@Body privacyFolder: PrivacyFolder): LockerBaseBean<Any>

    /**
     * 查
     * POST 请求只有一个json格式的 @Body
     */
    @GET("/locker/api/admin/privacy/folder/{id}/json")
    suspend fun folderQuery(@Path("id") id: Int): LockerBaseBean<Any>

    /**
     * 条件查
     */
    @POST("/locker/api/admin/privacy/folder/list/json")
    suspend fun folderQueryList(@Body conditionVO: ConditionVO): LockerBaseBean<MutableList<PrivacyFolder>>



    //-----------------------【 隐私类型 】----------------------

    /**
     * 增
     * POST 请求只有一个json格式的 @Body
     */
    @POST("/locker/api/admin/privacy/type/add/json")
    suspend fun typeAdd(@Body privacyType: PrivacyType): LockerBaseBean<Any>

    /**
     * 删
     * GET、DELETE 请求参数使用 @Query
     */
    @DELETE("/locker/api/admin/privacy/type/delete/json")
    suspend fun typeDelete(@Query("id") id: Int): LockerBaseBean<Any>

    /**
     * 改
     * POST 请求只有一个json格式的 @Body
     */
    @POST("/locker/api/admin/privacy/type/update/json")
    suspend fun typeUpdate(@Body privacyType: PrivacyType): LockerBaseBean<Any>

    /**
     * 查
     * POST 请求只有一个json格式的 @Body
     */
    @GET("/locker/api/admin/privacy/type/{id}/json")
    suspend fun typeQuery(@Path("id") id: Int): LockerBaseBean<Any>

    /**
     * 条件查
     */
    @POST("/locker/api/admin/privacy/type/list/json")
    suspend fun typeQueryList(@Body conditionVO: ConditionVO): LockerBaseBean<MutableList<PrivacyType>>


    //-----------------------【 隐私密码信息 】----------------------
    @GET("/locker/api/user/privacy/pass/list")
    suspend fun privacyInfoPassList(): LockerBaseBean<MutableList<PrivacyDetailsPass>>

    @POST("/locker/api/user/privacy/pass/add")
    suspend fun privacyInfoPassAdd(userPrivacyInfoPassVO: UserPrivacyInfoPassVO): LockerBaseBean<Any>

    @POST("/locker/api/user/privacy/pass/delete")
    suspend fun privacyInfoPassDelete(privacyInfoPassId :Int): LockerBaseBean<Any>

    @POST("/locker/api/user/privacy/pass/update")
    suspend fun privacyInfoPassUpdate(userPrivacyInfoPassVO: UserPrivacyInfoPassVO): LockerBaseBean<Any>

    @GET("/locker/api/user/privacy/pass/info")
    suspend fun privacyInfoPassUser(): LockerBaseBean<MutableList<UserPrivacyInfoPassVO>>

    @POST("/locker/api/user/privacy/card/parsing")
    suspend fun privacyInfoPassParsing(userPrivacyInfoPassVO: UserPrivacyInfoPassVO): LockerBaseBean<Any>

    //-----------------------【 隐私卡片信息 】----------------------
    @GET("/locker/api/user/privacy/card/list")
    suspend fun privacyInfoCardList(): LockerBaseBean<MutableList<PrivacyDetailsCard>>

    @POST("/locker/api/user/privacy/card/add")
    suspend fun privacyInfoCardAdd(userPrivacyInfoCardVO: UserPrivacyInfoCardResponse): LockerBaseBean<Any>

    @POST("/locker/api/user/privacy/card/delete")
    suspend fun privacyInfoCardDelete(privacyInfoCardId :Int): LockerBaseBean<Any>

    @POST("/locker/api/user/privacy/card/update")
    suspend fun privacyInfoCardUpdate(userPrivacyInfoCardVO: UserPrivacyInfoCardResponse): LockerBaseBean<Any>

    @GET("/locker/api/user/privacy/card/info")
    suspend fun privacyInfoCardUser(): LockerBaseBean<MutableList<UserPrivacyInfoCardResponse>>

    @POST("/locker/api/user/privacy/card/parsing")
    suspend fun privacyInfoCardParsing(userPrivacyInfoCardVO: UserPrivacyInfoCardResponse): LockerBaseBean<Any>

}