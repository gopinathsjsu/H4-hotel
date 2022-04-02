package com.cmpe202.hotels.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-03-22T20:24:30.862902-07:00[America/Los_Angeles]")
@Controller
@RequestMapping("${openapi.simpleRewardsAccount.base-path:/v1}")
public class SignupApiController implements SignupApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public SignupApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
