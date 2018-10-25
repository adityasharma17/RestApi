
package com.example.server.restapi.Servers.DetailedInfo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Addresses {

    @SerializedName("private")
    @Expose
    private List<Private> _private = null;

    public List<Private> getPrivate() {
        return _private;
    }

    public void setPrivate(List<Private> _private) {
        this._private = _private;
    }

}
