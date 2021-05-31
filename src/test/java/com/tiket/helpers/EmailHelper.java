package com.tiket.helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tiket.dataproviders.ConfigFileReaders;
import io.mail7.sdk.api.EmailApi;
import io.mail7.sdk.models.responsemodels.InboxResponse;
import io.mail7.sdk.util.AsyncHandler;
import io.mail7.sdk.util.ErrorResponse;
import io.mail7.sdk.util.Mail7SDK.Initialize;

public class EmailHelper {

    static ConfigFileReaders configFileReader = new ConfigFileReaders();
    static EmailApi Mail7EmailAPI;
    static ObjectMapper mapper = new ObjectMapper();
    static String username = "fransdummy";
    static String domain = "franseng.mail7.io";

    public static void init(){
        Initialize.setApiKey(configFileReader.getApiKey());
        Initialize.setApiSecret(configFileReader.getApiSecret());
        Mail7EmailAPI = new EmailApi();

    }

    public static String GetEmail(){
        final String[] result = {""};
        EmailApi Mail7EmailAPI = new EmailApi();

        Mail7EmailAPI.getEmails(username, domain, new AsyncHandler<InboxResponse>() {
            @Override
            public void onSuccess(InboxResponse response) {
                try {
                    result[0] = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(response);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(ErrorResponse error) {
                System.out.println(error.getMessage());
            }
        });

        return result[0];
    }


}


