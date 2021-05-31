package com.tiket.helpers;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString), Root.class); */


public class EmailDto{
    public String status;
    public List<Datum> data;

    public static class Params{
        public String a;
        public String c;
        public String d;
        public String s;
        public String t;
        public String bh;
        public String h;
        public String b;
        public String boundary;
    }

    public static class DkimSignature{
        public String value;
        public Params params;
    }

    public static class Value{
        public String address;
        public String name;
    }

    public static class From{
        public List<Value> value;
        public String html;
        public String text;
    }

    public static class ReplyTo{
        public List<Value> value;
        public String html;
        public String text;
    }

    public static class To{
        public List<Value> value;
        public String html;
        public String text;
    }

    public static class ContentType{
        public String value;
        public Params params;
    }

    public static class Headers{
        public Date date;
        @JsonProperty("dkim-filter")
        public String dkimFilter;
        @JsonProperty("dkim-signature")
        public DkimSignature dkimSignature;
        public From from;
        @JsonProperty("reply-to")
        public ReplyTo replyTo;
        public To to;
        @JsonProperty("message-id")
        public String messageId;
        public String subject;
        @JsonProperty("content-type")
        public ContentType contentType;
        public String received;
        @JsonProperty("x-google-dkim-signature")
        public String xGoogleDkimSignature;
        @JsonProperty("x-gm-message-state")
        public String xGmMessageState;
        @JsonProperty("x-google-smtp-source")
        public String xGoogleSmtpSource;
        @JsonProperty("x-received")
        public String xReceived;
        @JsonProperty("mime-version")
        public String mimeVersion;
    }

    public static class HeaderLine{
        public String key;
        public String line;
    }

    public static class ReplyTo2{
        public List<Value> value;
        public String html;
        public String text;
    }

    public static class MailSource{
        public List<Object> attachments;
        public Headers headers;
        public List<HeaderLine> headerLines;
        public String html;
        public String subject;
        public Date date;
        public To to;
        public From from;
        public String messageId;
        public ReplyTo replyTo;
        public String text;
        public String textAsHtml;
    }

    public static class Datum{
        public String _id;
        public String to_username;
        public String to_domain;
        public MailSource mail_source;
        public boolean is_deleted;
        public boolean is_read;
        public Date sender_time;
    }
}

