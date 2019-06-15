package applications.model;

/*
 * PhoneInfo.java
 *
 * Version: 1.0
 *
 * Revisions:
 */
public class PhoneInfo {
    BasicInfo basicInfo;
    SensorInfo[] sensorInfo;
    AppInfo[] appInfo;
    SecurityInfo securityInfo;

    public BasicInfo getBasicInfo() {
        return basicInfo;
    }

    public void setBasicInfo(BasicInfo basicInfo) {
        this.basicInfo = basicInfo;
    }

    public SensorInfo[] getSensorInfo() {
        return sensorInfo;
    }

    public void setSensorInfo(SensorInfo[] sensorInfo) {
        this.sensorInfo = sensorInfo;
    }

    public AppInfo[] getAppInfo() {
        return appInfo;
    }

    public void setAppInfo(AppInfo[] appInfo) {
        this.appInfo = appInfo;
    }

    public SecurityInfo getSecurityInfo() {
        return securityInfo;
    }

    public void setSecurityInfo(SecurityInfo securityInfo) {
        this.securityInfo = securityInfo;
    }
}
