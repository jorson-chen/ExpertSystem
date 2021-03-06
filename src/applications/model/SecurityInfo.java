package applications.model;

/*
 * SecurityInfo.java
 *
 * Version: 1.0
 *
 * Revisions:
 */
public class SecurityInfo {

    private int screenLock;
    private int unknownSources;
    private int potentiallyHarmfulApplications;
    private int developerMenu;
    private int basicIntegrityTest;
    private int androidCompatibilityTest;
    private int androidOSVersion;
    private int noOfAppsWithUnsafePermission;

    public int getScreenLock() {
        return screenLock;
    }

    public void setScreenLock(int screenLock) {
        this.screenLock = screenLock;
    }

    public int getUnknownSources() {
        return unknownSources;
    }

    public void setUnknownSources(int unknownSources) {
        this.unknownSources = unknownSources;
    }

    public int getPotentiallyHarmfulApplications() {
        return potentiallyHarmfulApplications;
    }

    public void setPotentiallyHarmfulApplications(int potentiallyHarmfulApplications) {
        this.potentiallyHarmfulApplications = potentiallyHarmfulApplications;
    }

    public int getDeveloperMenu() {
        return developerMenu;
    }

    public void setDeveloperMenu(int developerMenu) {
        this.developerMenu = developerMenu;
    }

    public int getBasicIntegrityTest() {
        return basicIntegrityTest;
    }

    public void setBasicIntegrityTest(int basicIntegrityTest) {
        this.basicIntegrityTest = basicIntegrityTest;
    }

    public int getAndroidCompatibilityTest() {
        return androidCompatibilityTest;
    }

    public void setAndroidCompatibilityTest(int androidCompatibilityTest) {
        this.androidCompatibilityTest = androidCompatibilityTest;
    }

    public int getAndroidOSVersion() {
        return androidOSVersion;
    }

    public void setAndroidOSVersion(int androidOSVersion) {
        this.androidOSVersion = androidOSVersion;
    }

    public int getNoOfAppsWithUnsafePermission() {
        return noOfAppsWithUnsafePermission;
    }

    public void setNoOfAppsWithUnsafePermission(int noOfAppsWithUnsafePermission) {
        this.noOfAppsWithUnsafePermission = noOfAppsWithUnsafePermission;
    }
}
