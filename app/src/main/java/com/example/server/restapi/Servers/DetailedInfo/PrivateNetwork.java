
package com.example.server.restapi.Servers.DetailedInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PrivateNetwork {

    @SerializedName("OS-EXT-IPS-MAC:mac_addr")
    @Expose
    private String oSEXTIPSMACMacAddr;
    @SerializedName("addr")
    @Expose
    private String addr;

    public String getOSEXTIPSMACMacAddr() {
        return oSEXTIPSMACMacAddr;
    }

    public void setOSEXTIPSMACMacAddr(String oSEXTIPSMACMacAddr) {
        this.oSEXTIPSMACMacAddr = oSEXTIPSMACMacAddr;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

}
