/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.1.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.cmpe202.hotels.api;

import com.cmpe202.hotels.model.AccountInfo;
import com.cmpe202.hotels.model.UserInfo;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-03-22T20:24:30.862902-07:00[America/Los_Angeles]")
@Api(value = "login", description = "the login API")
public interface LoginApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /login : It authenticates a login attempt. Related account is returned.
     * create a new account
     *
     * @param userInfo username and password is requested. (optional)
     * @return authentication is successful and related account is returned. (status code 200)
     *         or invalid input, object invalid (status code 400)
     *         or an existing item already exists (status code 409)
     */
    @ApiOperation(value = "It authenticates a login attempt. Related account is returned.", nickname = "login", notes = "create a new account", response = AccountInfo.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "authentication is successful and related account is returned.", response = AccountInfo.class),
        @ApiResponse(code = 400, message = "invalid input, object invalid"),
        @ApiResponse(code = 409, message = "an existing item already exists") })
    @PostMapping(
        value = "/login",
        produces = "application/json",
        consumes = "application/json"
    )
    default ResponseEntity<AccountInfo> login(@ApiParam(value = "username and password is requested."  )   @RequestBody(required = false) UserInfo userInfo) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"accountId\" : \"d290f1ee-6c54-4b01-90e6-d701748f0851\", \"password\" : \"password\", \"rewardsPoint\" : 230, \"username\" : \"Any acceptable Username\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
