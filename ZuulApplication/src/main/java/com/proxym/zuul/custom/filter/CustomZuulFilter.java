package com.proxym.zuul.custom.filter;

/**
 * @author Anis OURAJINI
 */
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.proxym.zuul.custom.feign.client.Auth0ManagementFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Component
@RefreshScope
@RestController
public class CustomZuulFilter extends ZuulFilter {

    @Autowired
    Auth0ManagementFeignClient auth0ManagementFeignClient;


    @Override
    public Object run() {

        RequestContext ctx = RequestContext.getCurrentContext();
        String token = ((HttpServletRequest) ctx.getRequest()).getHeader("token");
        String url = ((HttpServletRequest) ctx.getRequest()).getRequestURI();

        if (!url.contains("/Application/token")) {
            try {
                auth0ManagementFeignClient.verifySignatureFeign(token);
            } catch (Exception e) {
                //System.out.println("UNAUTHORIZED");
                ctx.set("401 UNAUTHORIZED");

            }

            if (!auth0ManagementFeignClient.verifyExpirationFeign(token))
                ctx.set("401 UNAUTHORIZED");

        }
        //System.out.println("Signature = "+auth0ManagementFeignClient.verifySignatureFeign(token));
        // System.out.println("verify ="+auth0ManagementFeignClient.verifySignature(token));

        return null;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }
}

