
package com.example.server.restapi.Servers.DetailedInfo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Server {

    @SerializedName("OS-EXT-STS:task_state")
    @Expose
    private Object oSEXTSTSTaskState;
    @SerializedName("addresses")
    @Expose
    private Addresses addresses;
    @SerializedName("links")
    @Expose
    private List<Link> links = null;
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
    @SerializedName("OS-DCF:diskConfig")
    @Expose
    private String oSDCFDiskConfig;
    @SerializedName("accessIPv4")
    @Expose
    private String accessIPv4;
    @SerializedName("accessIPv6")
    @Expose
    private String accessIPv6;
    @SerializedName("OS-EXT-STS:power_state")
    @Expose
    private Integer oSEXTSTSPowerState;
    @SerializedName("OS-EXT-AZ:availability_zone")
    @Expose
    private String oSEXTAZAvailabilityZone;
    @SerializedName("config_drive")
    @Expose
    private String configDrive;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("updated")
    @Expose
    private String updated;
    @SerializedName("hostId")
    @Expose
    private String hostId;
    @SerializedName("OS-EXT-SRV-ATTR:host")
    @Expose
    private String oSEXTSRVATTRHost;
    @SerializedName("OS-SRV-USG:terminated_at")
    @Expose
    private Object oSSRVUSGTerminatedAt;
    @SerializedName("key_name")
    @Expose
    private String keyName;
    @SerializedName("OS-EXT-SRV-ATTR:hypervisor_hostname")
    @Expose
    private String oSEXTSRVATTRHypervisorHostname;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("tenant_id")
    @Expose
    private String tenantId;
    @SerializedName("os-extended-volumes:volumes_attached")
    @Expose
    private List<Object> osExtendedVolumesVolumesAttached = null;
    @SerializedName("metadata")
    @Expose
    private Metadata metadata;

    public Object getOSEXTSTSTaskState() {
        return oSEXTSTSTaskState;
    }

    public void setOSEXTSTSTaskState(Object oSEXTSTSTaskState) {
        this.oSEXTSTSTaskState = oSEXTSTSTaskState;
    }

    public Addresses getAddresses() {
        return addresses;
    }

    public void setAddresses(Addresses addresses) {
        this.addresses = addresses;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
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

    public String getOSDCFDiskConfig() {
        return oSDCFDiskConfig;
    }

    public void setOSDCFDiskConfig(String oSDCFDiskConfig) {
        this.oSDCFDiskConfig = oSDCFDiskConfig;
    }

    public String getAccessIPv4() {
        return accessIPv4;
    }

    public void setAccessIPv4(String accessIPv4) {
        this.accessIPv4 = accessIPv4;
    }

    public String getAccessIPv6() {
        return accessIPv6;
    }

    public void setAccessIPv6(String accessIPv6) {
        this.accessIPv6 = accessIPv6;
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

    public String getConfigDrive() {
        return configDrive;
    }

    public void setConfigDrive(String configDrive) {
        this.configDrive = configDrive;
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

    public String getOSEXTSRVATTRHost() {
        return oSEXTSRVATTRHost;
    }

    public void setOSEXTSRVATTRHost(String oSEXTSRVATTRHost) {
        this.oSEXTSRVATTRHost = oSEXTSRVATTRHost;
    }

    public Object getOSSRVUSGTerminatedAt() {
        return oSSRVUSGTerminatedAt;
    }

    public void setOSSRVUSGTerminatedAt(Object oSSRVUSGTerminatedAt) {
        this.oSSRVUSGTerminatedAt = oSSRVUSGTerminatedAt;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getOSEXTSRVATTRHypervisorHostname() {
        return oSEXTSRVATTRHypervisorHostname;
    }

    public void setOSEXTSRVATTRHypervisorHostname(String oSEXTSRVATTRHypervisorHostname) {
        this.oSEXTSRVATTRHypervisorHostname = oSEXTSRVATTRHypervisorHostname;
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

    public List<Object> getOsExtendedVolumesVolumesAttached() {
        return osExtendedVolumesVolumesAttached;
    }

    public void setOsExtendedVolumesVolumesAttached(List<Object> osExtendedVolumesVolumesAttached) {
        this.osExtendedVolumesVolumesAttached = osExtendedVolumesVolumesAttached;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

}
