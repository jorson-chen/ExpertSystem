package applications.model;

/*
 * AppInfo.java
 *
 * Version: 1.0
 *
 * Revisions:
 */
public class AppInfo {

    private String packagename;
    private String[] permissions;
    private String[] permissionsGranted;
    private String[] signatures;
    private int allowedInstalls;
    private int canReqInstalls;

    public String getPackagename() {
        return packagename;
    }

    public void setPackagename(String packagename) {
        this.packagename = packagename;
    }

    public String[] getPermissions() {
        return permissions;
    }

    public void setPermissions(String[] permissions) {
        this.permissions = permissions;
    }

    public String[] getPermissionsGranted() {
        return permissionsGranted;
    }

    public void setPermissionsGranted(String[] permissionsGranted) {
        this.permissionsGranted = permissionsGranted;
    }

    public String[] getSignatures() {
        return signatures;
    }

    public void setSignatures(String[] signatures) {
        this.signatures = signatures;
    }

    public int getAllowedInstalls() {
        return allowedInstalls;
    }

    public void setAllowedInstalls(int allowedInstalls) {
        this.allowedInstalls = allowedInstalls;
    }

    public int getCanReqInstalls() {
        return canReqInstalls;
    }

    public void setCanReqInstalls(int canReqInstalls) {
        this.canReqInstalls = canReqInstalls;
    }
}
