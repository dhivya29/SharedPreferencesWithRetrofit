package com.example.dhiviya.dhivya;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class Json implements Serializable {
    @SerializedName("Item")
    public Item Item;

    public static class Content {
        @SerializedName("Name")
        public String Name;
        @SerializedName("URL")
        public String URL;
    }

    public static class Item {
        @SerializedName("Content")
        public List<Content> Content;
    }

}