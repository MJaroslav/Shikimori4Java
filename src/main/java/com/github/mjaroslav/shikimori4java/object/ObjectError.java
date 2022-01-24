package com.github.mjaroslav.shikimori4java.object;

import blue.endless.jankson.annotation.SerializedName;
import com.github.mjaroslav.shikimori4java.util.Utils;
import lombok.ToString;

@ToString
public class ObjectError {
    @SerializedName("error")
    public String error;

    @SerializedName("error_description")
    public String errorDesc;

    @SerializedName("state")
    public String state;

    public boolean isAuthError() {
        return (error != null && !error.equals("")) || (state != null && state.equals("unauthorized"));
    }

    public boolean hasError() {
        return Utils.stringNotEmpty(error) || Utils.stringNotEmpty(errorDesc);
    }
}
