package com.debugduckdesign.com.gitlabmr;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;

public class GptApiClient {

    volatile private String apiKey;

    public GptApiClient(String apiKey) {
        this.apiKey = apiKey;
    }

    public String query(String prompt) throws URISyntaxException, IOException {
        String stubsApiBaseUri = "http://localhost:7819/RTCP/rest/stubs/";
        String domain = "default";
        String environment = "addNumbers";
        String stubName = "1+1=2";


        CloseableHttpClient client = HttpClients.createDefault();

        URIBuilder builder = new URIBuilder(stubsApiBaseUri);
        builder.addParameter("domain", domain);
        builder.addParameter("env", environment);
        builder.addParameter("stub", stubName);
        String listStubsUri = builder.build().toString();
        HttpGet getStubMethod = new HttpGet(listStubsUri);
        HttpResponse getStubResponse = client.execute(getStubMethod);
        String responseBody = EntityUtils
                .toString(getStubResponse.getEntity());
        return responseBody;

    }

}
