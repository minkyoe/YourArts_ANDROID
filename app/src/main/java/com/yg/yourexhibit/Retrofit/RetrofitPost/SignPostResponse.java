package com.yg.yourexhibit.Retrofit.RetrofitPost;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by 2yg on 2017. 10. 23..
 */

@Data
@AllArgsConstructor
public class SignPostResponse {
    boolean status;
    String message;
    SignPostResult result;
}
