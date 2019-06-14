package applications.model;

/*
 * SecurityInfo.java
 *
 * Version: 1.0
 *
 * Revisions:
 */
public class SecurityInfo {

    private boolean screenLock;
    private boolean unknownSources;
    private boolean potentiallyHarmfulApplications;
    private boolean developerMenu;
    private boolean basicIntegrityTest;
    private boolean androidCompatibilityTest;
    private int androidOSVersion;

    public boolean isScreenLock() {
        return screenLock;
    }

    public void setScreenLock(boolean screenLock) {
        this.screenLock = screenLock;
    }

    public boolean isUnknownSources() {
        return unknownSources;
    }

    public void setUnknownSources(boolean unknownSources) {
        this.unknownSources = unknownSources;
    }

    public boolean isPotentiallyHarmfulApplications() {
        return potentiallyHarmfulApplications;
    }

    public void setPotentiallyHarmfulApplications(boolean potentiallyHarmfulApplications) {
        this.potentiallyHarmfulApplications = potentiallyHarmfulApplications;
    }

    public boolean isDeveloperMenu() {
        return developerMenu;
    }

    public void setDeveloperMenu(boolean developerMenu) {
        this.developerMenu = developerMenu;
    }

    public boolean isBasicIntegrityTest() {
        return basicIntegrityTest;
    }

    public void setBasicIntegrityTest(boolean basicIntegrityTest) {
        this.basicIntegrityTest = basicIntegrityTest;
    }

    public boolean isAndroidCompatibilityTest() {
        return androidCompatibilityTest;
    }

    public void setAndroidCompatibilityTest(boolean androidCompatibilityTest) {
        this.androidCompatibilityTest = androidCompatibilityTest;
    }

    public int getAndroidOSVersion() {
        return androidOSVersion;
    }

    public void setAndroidOSVersion(int androidOSVersion) {
        this.androidOSVersion = androidOSVersion;
    }
}
