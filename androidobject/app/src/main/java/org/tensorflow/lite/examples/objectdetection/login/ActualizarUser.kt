import com.google.gson.annotations.SerializedName

data class JsonRequestParams(
    @SerializedName("params") val params: RequestParams
)

data class RequestParams(
    @SerializedName("model") val model: String,
    @SerializedName("modelo") val modelo: String,
    @SerializedName("id") val id: Int,
    @SerializedName("vals") val vals: Vals,
    @SerializedName("va") val va: Va,
    @SerializedName("db") val db: String,
    @SerializedName("login") val login: String,
    @SerializedName("password") val password: String? = null
)



data class Vals(
    @SerializedName("name") val name: String,
    @SerializedName("login") val login  : String,
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String? = null
)



data class Va(
    @SerializedName("image_1920") val image1024: String
)




