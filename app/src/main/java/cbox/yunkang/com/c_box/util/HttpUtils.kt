package cbox.yunkang.com.c_box.util

import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.MediaType
import okhttp3.RequestBody

object HttpUtils {

    fun generateRequestBody(map: HashMap<String,String>) : HashMap<String,RequestBody>{
        var hashMap = HashMap<String,RequestBody>()

        for(key:String in map.keys){
            if(map.get(key)==null){""}else{map.get(key)}
            var requestBody = RequestBody.create(MediaType.parse("multipart/form-data"),
                    if(map.get(key)==null){""}else{map.get(key)})
            hashMap.put(key, requestBody)
        }

        return hashMap
    }

    fun <T> transformSchedules(): ObservableTransformer<T,T> =
          ObservableTransformer {
              it.subscribeOn(Schedulers.io())
              .unsubscribeOn(Schedulers.io())
                      .observeOn(AndroidSchedulers.mainThread())
          }

}