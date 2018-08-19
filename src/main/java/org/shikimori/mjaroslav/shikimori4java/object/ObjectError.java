package org.shikimori.mjaroslav.shikimori4java.object;

import org.shikimori.mjaroslav.shikimori4java.utils.Utils;

import com.google.gson.annotations.SerializedName;

public class ObjectError {
    @SerializedName("error")
    public String error;

    @SerializedName("error_description")
    public String errorDesc;

    @SerializedName("state")
    public String state;

    public boolean isNotAuthError() {
        return (error == null || error.equals("")) && (state == null || !state.equals("unauthorized"));
    }

    public boolean hasError() {
        return Utils.stringNotEmpty(error) || Utils.stringNotEmpty(errorDesc);
    }

    @Override
    public String toString() {
        return (Utils.stringNotEmpty(state) ? "[" + state + "] " : "")
                + (Utils.stringNotEmpty(error) ? error + ": " : "")
                + (Utils.stringNotEmpty(errorDesc) ? errorDesc : "");
    }
}
