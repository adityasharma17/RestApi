
package com.example.server.restapi.ListKeys;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListKeys {

    @SerializedName("keypairs")
    @Expose
    private List<Keypair> keypairs = null;

    public List<Keypair> getKeypairs() {
        return keypairs;
    }

    public void setKeypairs(List<Keypair> keypairs) {
        this.keypairs = keypairs;
    }

}
