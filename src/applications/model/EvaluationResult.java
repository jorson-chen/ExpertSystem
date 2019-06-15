package applications.model;

/*
 * EvaluationResult.java
 *
 * Version: 1.0
 *
 * Revisions:
 */
public class EvaluationResult {

    private int version;
    private int screenlock;
    private int unknownSources;
    private int potentiallyHarmfulApps;
    private int developerMenu;
    private int appsWithDangerousPermissions;
    private int unlockedBootloader;
    private int basicIntegrityTest;
    private String verdict;

    public EvaluationResult(int version, int screenlock, int unknownSources, int potentiallyHarmfulApps, int developerMenu, int appsWithDangerousPermissions, int unlockedBootloader, int basicIntegrityTest) {
        this.version = version;
        this.screenlock = screenlock;
        this.unknownSources = unknownSources;
        this.potentiallyHarmfulApps = potentiallyHarmfulApps;
        this.developerMenu = developerMenu;
        this.appsWithDangerousPermissions = appsWithDangerousPermissions;
        this.unlockedBootloader = unlockedBootloader;
        this.basicIntegrityTest = basicIntegrityTest;
    }
}
