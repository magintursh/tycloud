package org.typroject.tycloud.api.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService userDetailsService;


    private String privateKey = "-----BEGIN RSA PRIVATE KEY-----\n" +
            "MIIEowIBAAKCAQEAx2ayqA70PNlIM3rfcIORwROJ3j80S9XKBFghv0Xb7P78OeTh" +
            "HKq4iHMLrRl+pD6syZOmUQq0xHAkCfNTV3bFKRUF3xzs+x0dTrU2Bn2ERzAcJBzH" +
            "DSxyA73wvDVkyjJuzlOsMNJ5LVJJ3FGVyblyCcYo2QbIPQxaGc0o6Q5G7uOijVz0" +
            "tEatbgRwgc8GdfolnWrUMwOYZz8Mb51GhYYzx7eYlf82S4VBtw1lp/MYN4iI2o+N" +
            "Ir7643k2IMsaIi23u+yfv7XxmH+iCVWxw/AgYE+paNI/LQEogieU3/MT/Jy1suq6" +
            "Qm5BwmIQOFSYPikvctLMpSlvSHvPxkCK/oqSjwIDAQABAoIBADbW37uooTM67sh5" +
            "uonPJX7cSMZ+y3svyOd49Y8NP3bmiafCcsbXjPi56zQoFtRFCHBH0y3mq+B6lu7F" +
            "pN4hJAgwZ/T8l5BYaX8EB1+xlXeem56y62uMFa9Bxbt9U8LoK+FC0dB7kigMwZN+" +
            "PJvGDL7zaLiHTPq9Mup1qhKugoOgSrr0KJpA4QZBjgM+I7//cbfB+yI0InGYmXX5" +
            "Or4PHyK2VHxU2H+zjiCmCfG+fZitJpiL6zAueV7YhAh9vNhnzeYNFqR0qpMzIsSg" +
            "lj9VmD2+2hOkqQ2/bBbp+AcQIrF4pShivePK4WfSY+MGzLB3mknBj45W4DKW2cxw" +
            "fovYaIECgYEA8fwyjgcHtdvD2cm+F+tV2d8/ZiXHuDm/0xrdROwVMvN4rMGwGJ7P" +
            "Ewg2p0iubnit1Nf+Z9y8LZe9VXRE2QZD4+HufRDMQ8dm2mSMPYFwFaYGY14VQP16" +
            "J9oAb+uutRUTTR7WGH4RMyVpsfsshvRphvHrmZNJ8ff3grstBWZfLDkCgYEA0vMg" +
            "lCZZvH93owk//MV0b1G3t59BCVe5BCyaC362d/87hhiUW/2ray+hwci1DH+jmtFU" +
            "wcrRAvcrTdq+w7Em+4md083/2ZCW7xNMMnilNCdhXWncg6mOIoqGJqTXCYxcbpYD" +
            "f7Mx6zyswQROIuka+X/wf4quFTZIW4prMu0tRQcCgYAJnWe01Pqtcyn5AVcYRDWJ" +
            "DqHKQT4KR+EjVjHshyTgfWQSGTASCl1X+D+TrgOgSBNAHcTyA4dGmHzhZFlH9kPE" +
            "TjnXpk83cjjX/J7F4tq9QXeHgzl895Ve9/6Ec+zhLREzQ0JmfrvYOGhWthAy3ItE" +
            "3V/rHjsV7jBbdWx4hnTJoQKBgQCHGilSWOF+BRElPMZbaEazCN4l3vvzNNiM4Nfj" +
            "5sqMPc3siw9xfxxrMH1js9yoXZL1k326A+ArCwwT97XXdTznOnL3dOaYe67+/Rf+" +
            "9x+vME1+W09cj5o1awyR8V67gcatGKyy+5xL8Xcew1gbqbmZ86Oeu73UXgingBY5" +
            "7obgvwKBgCqJbVDcjyvifD1oiGp0blGoH7n8o5ehnSKudgdcN3MptOkxS1dGUbP+" +
            "gH/jm5jTL/tAkybMig7xDnhRXgBLqUcwtaffS5iiZ5D+oHQ69GxYGSZr848NPNrb" +
            "bZThD+Q86JSlwYStgS8hqh5ArFRYCp8yDnI4agsJN4+f8FDlR+h+" +
            "-----END RSA PRIVATE KEY-----";
    private String publicKey = "-----BEGIN PUBLIC KEY-----" +
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAx2ayqA70PNlIM3rfcIOR" +
            "wROJ3j80S9XKBFghv0Xb7P78OeThHKq4iHMLrRl+pD6syZOmUQq0xHAkCfNTV3bF" +
            "KRUF3xzs+x0dTrU2Bn2ERzAcJBzHDSxyA73wvDVkyjJuzlOsMNJ5LVJJ3FGVybly" +
            "CcYo2QbIPQxaGc0o6Q5G7uOijVz0tEatbgRwgc8GdfolnWrUMwOYZz8Mb51GhYYz" +
            "x7eYlf82S4VBtw1lp/MYN4iI2o+NIr7643k2IMsaIi23u+yfv7XxmH+iCVWxw/Ag" +
            "YE+paNI/LQEogieU3/MT/Jy1suq6Qm5BwmIQOFSYPikvctLMpSlvSHvPxkCK/oqS" +
            "jwIDAQAB\n" +
            "-----END PUBLIC KEY-----";


    @Override
    public void configure(final AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String secret = passwordEncoder.encode("secret");
        clients.inMemory() // 使用in-memory存储
                .withClient("client") // client_id
                .secret(secret) // client_secret
                //.autoApprove(true)　　　／／如果为true　则不会跳转到授权页面，而是直接同意授权返回code
                .authorizedGrantTypes("authorization_code","refresh_token") // 该client允许的授权类型
                .scopes("app"); // 允许的授权范围
    }

    @Override
    public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

        endpoints.authenticationManager(authenticationManager).userDetailsService(userDetailsService)
                .accessTokenConverter(accessTokenConverter())
                .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST); //支持GET  POST  请求获取token;
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter() {
            @Override
            public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
                String userName = authentication.getUserAuthentication().getName();
                final Map<String, Object> additionalInformation = new HashMap<String, Object>();
                additionalInformation.put("user_name", userName);
                ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInformation);
                OAuth2AccessToken token = super.enhance(accessToken, authentication);
                return token;
            }
        };
        converter.setSigningKey(privateKey);
        converter.setVerifierKey(publicKey);
        //converter.setSigningKey("bcrypt");
      /*  KeyPair keyPair = new KeyStoreKeyFactory(new ClassPathResource("kevin_key.jks"), "Msl1011308431".toCharArray())
                .getKeyPair("kevin_key");
        converter.setKeyPair(keyPair);*/
        return converter;
    }
}