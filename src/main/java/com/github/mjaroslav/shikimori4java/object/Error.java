package com.github.mjaroslav.shikimori4java.object;

import com.github.mjaroslav.shikimori4java.util.Utils;
import com.google.gson.annotations.SerializedName;
import lombok.ToString;

@ToString
public class Error {
    public String error;
    @SerializedName("error_description")
    public String errorDesc;
    public String state;

    public boolean isAuthError() {
        return (error != null && !error.equals("")) || (state != null && state.equals("unauthorized"));
    }

    public boolean hasError() {
        return Utils.stringNotEmpty(error) || Utils.stringNotEmpty(errorDesc);
    }
}
