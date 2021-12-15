package com.my.oauth.controller;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.security.Principal;
import java.util.Map;

/**
 * @author kay
 * @date 2021/12/15
 */
@RestController
@RequestMapping(value = "/oauth")
@Api(value = "鉴权中心接口", tags = {"鉴权中心接口"})
public class OauthController {

    @Autowired
    TokenEndpoint tokenEndPoint;
    @ApiOperation("OAuth2认证生成token")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "client_id", value = "Oauth2客户端ID", required = true),
            @ApiImplicitParam(name = "client_secret", value = "Oauth2客户端秘钥", required = true),
            @ApiImplicitParam(name = "grant_type", value = "Oauth2模式类型", required = true),
            @ApiImplicitParam(name = "username", value = "登录用户名"),
            @ApiImplicitParam(name = "password", value = "登录密码"),
    })
    @PostMapping("/token")
    public OAuth2AccessToken token(@ApiIgnore Principal principal,
                                   @ApiIgnore @RequestParam Map<String, String> parameters) throws HttpRequestMethodNotSupportedException {

        OAuth2AccessToken oAuth2AccessToken = tokenEndPoint.postAccessToken(principal, parameters).getBody();
            return oAuth2AccessToken;
        //        Oauth2TokenVO oauth2TokenVO = new Oauth2TokenVO();
//        oauth2TokenVO.setToken(oAuth2AccessToken.getValue());
//        oauth2TokenVO.setRefreshToken(oAuth2AccessToken.getRefreshToken() == null ? "" : oAuth2AccessToken.getRefreshToken().getValue());
//        oauth2TokenVO.setExpiresIn(oAuth2AccessToken.getExpiresIn());
//        oauth2TokenVO.setTokenHead("Bearer ");
//        oauth2TokenVO.setIsDeveloper(0);
//        ComUser user = UserThreadLocal.getUser();
//        if (user != null && user.getDeveloperTypeDictKey() != null) {
//            if (user.getDeveloperTypeDictKey().equals(10002)) {
//                oauth2TokenVO.setIsDeveloper(1);
//            }
//        }
//        return ResponseResult.SUCCESS(oauth2TokenVO);
    }
}
