
package com.example.server.restapi.Servers.DetailedInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Private {

    @SerializedName("OS-EXT-IPS-MAC:mac_addr")
    @Expose
    private String oSEXTIPSMACMacAddr;
    @SerializedName("version")
    @Expose
    private Integer version;
    @SerializedName("addr")
    @Expose
    private String addr;
    @SerializedName("OS-EXT-IPS:type")
    @Expose
    private String oSEXTIPSType;

    public String getOSEXTIPSMACMacAddr() {
        return oSEXTIPSMACMacAddr;
    }

    public void setOSEXTIPSMACMacAddr(String oSEXTIPSMACMacAddr) {
        this.oSEXTIPSMACMacAddr = oSEXTIPSMACMacAddr;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getOSEXTIPSType() {
        return oSEXTIPSType;
    }

    public void setOSEXTIPSType(String oSEXTIPSType) {
        this.oSEXTIPSType = oSEXTIPSType;
    }

}
