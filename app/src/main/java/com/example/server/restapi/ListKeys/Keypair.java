
package com.example.server.restapi.ListKeys;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Keypair {

    @SerializedName("keypair")
    @Expose
    private Keypair_ keypair;

    public Keypair_ getKeypair() {
        return keypair;
    }

    public void setKeypair(Keypair_ keypair) {
        this.keypair = keypair;
    }

}
