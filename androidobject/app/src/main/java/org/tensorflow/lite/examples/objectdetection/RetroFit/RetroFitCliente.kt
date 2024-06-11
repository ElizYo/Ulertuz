import org.tensorflow.lite.examples.objectdetection.RetroFit.ConsumirApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://ulertuzv2.duckdns.org/"

    fun getApiService(): ConsumirApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(ConsumirApi::class.java)
    }
}
