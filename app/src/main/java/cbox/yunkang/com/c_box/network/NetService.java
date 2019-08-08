package cbox.yunkang.com.c_box.network;


import cbox.yunkang.com.c_box.mvp.datamodel.CourseExplain;
import cbox.yunkang.com.c_box.mvp.datamodel.CourseTable;
import cbox.yunkang.com.c_box.mvp.datamodel.CourseTodayRanking;
import cbox.yunkang.com.c_box.mvp.datamodel.ResponsePhysical;
import java.util.Map;

import cbox.yunkang.com.c_box.mvp.datamodel.SmartCourse;
import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;
import retrofit2.http.Url;

/**
 * @author tanhaoshi
 * Created on 7/29/2019.
 */

public interface NetService {

    @Multipart
    @POST
    Observable<SmartCourse> getSmartCourseService(
            @PartMap Map<String, RequestBody> requestBodyMap,
            @Url String url
    );

    @POST
    Observable<CourseTable> getCourseTableService(
            @Url String url
    );

    @Multipart
    @POST
    Observable<CourseExplain> getCourseExplainService(
            @PartMap Map<String,RequestBody> requestBodyMap,
            @Url String url
    );

    @POST
    Observable<CourseTodayRanking> getCourseTodayRankingService(
            @Body RequestBody body,
            @Url String url
    );

    @POST
    Observable<ResponsePhysical> submitCourseFinishService(
            @Body RequestBody body,
            @Url String url
    );


    @Multipart
    @POST
    Observable<ResponseBody> getCourseTryService(
            @PartMap Map<String,RequestBody> requestBodyMap,
            @Url String url
    );
}
