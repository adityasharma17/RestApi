
package com.example.server.restapi.Servers.DetailedInfo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Server {

    @SerializedName("addresses")
    @Expose
    private Addresses addresses;
    @SerializedName("image")
    @Expose
    private Image image;
    @SerializedName("OS-EXT-STS:vm_state")
    @Expose
    private String oSEXTSTSVmState;
    @SerializedName("OS-EXT-SRV-ATTR:instance_name")
    @Expose
    private String oSEXTSRVATTRInstanceName;
    @SerializedName("OS-SRV-USG:launched_at")
    @Expose
    private String oSSRVUSGLaunchedAt;
    @SerializedName("flavor")
    @Expose
    private Flavor flavor;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("security_groups")
    @Expose
    private List<SecurityGroup> securityGroups = null;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("OS-EXT-STS:power_state")
    @Expose
    private Integer oSEXTSTSPowerState;
    @SerializedName("OS-EXT-AZ:availability_zone")
    @Expose
    private String oSEXTAZAvailabilityZone;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("updated")
    @Expose
    private String updated;
    @SerializedName("hostId")
    @Expose
    private String hostId;
    @SerializedName("key_name")
    @Expose
    private String keyName;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("tenant_id")
    @Expose
    private String tenantId;

    public Addresses getAddresses() {
        return addresses;
    }

    public void setAddresses(Addresses addresses) {
        this.addresses = addresses;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getOSEXTSTSVmState() {
        return oSEXTSTSVmState;
    }

    public void setOSEXTSTSVmState(String oSEXTSTSVmState) {
        this.oSEXTSTSVmState = oSEXTSTSVmState;
    }

    public String getOSEXTSRVATTRInstanceName() {
        return oSEXTSRVATTRInstanceName;
    }

    public void setOSEXTSRVATTRInstanceName(String oSEXTSRVATTRInstanceName) {
        this.oSEXTSRVATTRInstanceName = oSEXTSRVATTRInstanceName;
    }

    public String getOSSRVUSGLaunchedAt() {
        return oSSRVUSGLaunchedAt;
    }

    public void setOSSRVUSGLaunchedAt(String oSSRVUSGLaunchedAt) {
        this.oSSRVUSGLaunchedAt = oSSRVUSGLaunchedAt;
    }

    public Flavor getFlavor() {
        return flavor;
    }

    public void setFlavor(Flavor flavor) {
        this.flavor = flavor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<SecurityGroup> getSecurityGroups() {
        return securityGroups;
    }

    public void setSecurityGroups(List<SecurityGroup> securityGroups) {
        this.securityGroups = securityGroups;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getOSEXTSTSPowerState() {
        return oSEXTSTSPowerState;
    }

    public void setOSEXTSTSPowerState(Integer oSEXTSTSPowerState) {
        this.oSEXTSTSPowerState = oSEXTSTSPowerState;
    }

    public String getOSEXTAZAvailabilityZone() {
        return oSEXTAZAvailabilityZone;
    }

    public void setOSEXTAZAvailabilityZone(String oSEXTAZAvailabilityZone) {
        this.oSEXTAZAvailabilityZone = oSEXTAZAvailabilityZone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getHostId() {
        return hostId;
    }

    public void setHostId(String hostId) {
        this.hostId = hostId;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

}
