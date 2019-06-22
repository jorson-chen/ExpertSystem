package applications.model;

/*
 * Row.java
 *
 * Version: 1.0
 *
 * Revisions:
 */
public class Row {

    private int versionRELEASE; //
    private int screenLock; //
    private int unknownSources; //
    private int potentiallyHarmfulApplications; //
    private int developerMenu; //
    private int BOOTLOADER; //
    private int basicIntegrityTest; //
    private int noOfAppsWithUnsafePermission; //
    private int securityScore;

    public int getVersionRELEASE() {
        return versionRELEASE;
    }

    public void setVersionRELEASE(int versionRELEASE) {
        this.versionRELEASE = versionRELEASE;
    }

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

    public int getBOOTLOADER() {
        return BOOTLOADER;
    }

    public void setBOOTLOADER(int BOOTLOADER) {
        this.BOOTLOADER = BOOTLOADER;
    }

    public int getBasicIntegrityTest() {
        return basicIntegrityTest;
    }

    public void setBasicIntegrityTest(int basicIntegrityTest) {
        this.basicIntegrityTest = basicIntegrityTest;
    }

    public int getNoOfAppsWithUnsafePermission() {
        return noOfAppsWithUnsafePermission;
    }

    public void setNoOfAppsWithUnsafePermission(int noOfAppsWithUnsafePermission) {
        this.noOfAppsWithUnsafePermission = noOfAppsWithUnsafePermission;
    }

    public int getSecurityScore() {
        return securityScore;
    }

    public void setSecurityScore(int securityScore) {
        this.securityScore = securityScore;
    }
}
