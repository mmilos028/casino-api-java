package api.casino.controller;

import java.security.Principal;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller
public class TokenController {

    //@Resource(name = "tokenServices")
    private ConsumerTokenServices tokenServices;

    //@Resource(name = "tokenStore")
    private TokenStore tokenStore;

    /*
    @RequestMapping(method = RequestMethod.POST, value = "/oauth/token")
    @ResponseBody
    public OAuth2AccessToken getAccessToken(OAuth2Authentication auth){

        OAuth2AuthorizeRequest authorizeRequest =
                OAuth2AuthorizeRequest
                        .withClientRegistrationId(clientRegistrationName)
                        .principal(clientId)
                        .build();

        OAuth2AuthorizedClient authorizedClient =
                this.authorizedClientManager
                        .authorize(authorizeRequest);

        OAuth2AccessToken accessToken = tokenStore.getAccessToken(auth);

        return accessToken.

        //select token_id, token from oauth_access_token where token_id = ?
        //tokenStore.readAccessToken(param);

        //select token_id, authentication from oauth_access_token where token_id = ?
        //tokenStore.getAccessToken(principal)

        //select token_id, token from oauth_access_token where client_id = ?
        //Collection<OAuth2AccessToken> tokens = tokenStore.findTokensByClientId("fooClientIdPassword");
        //Collection<OAuth2AccessToken> tokens = tokenStore.findTokensByClientIdAndUserName("fooClientIdPassword", "secret");
        //return Optional.ofNullable(tokens).orElse(Collections.emptyList()).stream().map(OAuth2AccessToken::getValue).collect(Collectors.toList());
    }*/

    @RequestMapping(method = RequestMethod.POST, value = "/oauth/token/revokeById/{tokenId}")
    @ResponseBody
    public void revokeToken(HttpServletRequest request, @PathVariable String tokenId) {
        tokenServices.revokeToken(tokenId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/tokens")
    @ResponseBody
    public List<String> getTokens() {
        Collection<OAuth2AccessToken> tokens = tokenStore.findTokensByClientId("sampleClientId");
        return Optional.ofNullable(tokens).orElse(Collections.emptyList()).stream().map(OAuth2AccessToken::getValue).collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/tokens/revokeRefreshToken/{tokenId:.*}")
    @ResponseBody
    public String revokeRefreshToken(@PathVariable String tokenId) {
        if (tokenStore instanceof JdbcTokenStore) {
            ((JdbcTokenStore) tokenStore).removeRefreshToken(tokenId);
        }
        return tokenId;
    }


    //This method will be used to check if the user has a valid token to access the resource
    @RequestMapping("/validateUser")
    public Principal user(Principal user) {
        return user;
    }

}