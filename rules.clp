;; First define templates for the model classes so we can use them
;; in our expert system. This doesn't create any model objects --
;; it just tells Jess to examine the classes and set up templates
;; using their properties

(import applications.model.*)
(deftemplate PhoneInfo         (declare (from-class PhoneInfo)))
(deftemplate BasicInfo         (declare (from-class BasicInfo)))
(deftemplate SensorInfo        (declare (from-class SensorInfo)))
(deftemplate AppInfo           (declare (from-class AppInfo)))
(deftemplate SecurityInfo      (declare (from-class SecurityInfo)))

;; Now define the security rules themselves. Each rule matches a set
;; of conditions and then creates an result object to represent a
;; bonus of some kind given to a customer. The rules assume that
;; there will be just one Order, its OrderItems, and its Customer in
;; working memory, along with all the CatalogItems.


(defrule android-version-evaluation-3
    "Evaluate Security based on Android Version of the app"
    (BasicInfo { versionRELEASE > 8})
     =>
    (add (new EvaluationResult "version" 3 )))

(defrule android-version-evaluation-2
    "Evaluate Security based on Android Version of the app"
    (BasicInfo { versionRELEASE > 6 && versionRELEASE < 9})
     =>
    (add (new EvaluationResult "version" 2 )))

(defrule android-version-evaluation-1
    "Evaluate Security based on Android Version of the app"
    (BasicInfo { versionRELEASE > 5 && versionRELEASE < 7})
     =>
    (add (new EvaluationResult "version" 1 )))

(defrule screen-lock-evaluation-T
    "Evaluate Security based on whether screen lock is active or not"
    (SecurityInfo {screenLock == TRUE})
    =>
    (add (new EvaluationResult "screenLock" 5)))

(defrule screen-lock-evaluation-F
    "Evaluate Security based on whether screen lock is active or not"
    (SecurityInfo {screenLock == FALSE})
    =>
    (add (new EvaluationResult "screenLock" 0)))

(defrule unknown-sources-evaluation-F
    "Evaluate Security based on whether installation from unknown sources is
         allowed or not"
    (SecurityInfo {unknownSources == FALSE})
    =>
    (add (new EvaluationResult "unknownSources" 10)))

(defrule unknown-sources-evaluation-T
    "Evaluate Security based on whether installation from unknown sources is
         allowed or not"
    (SecurityInfo {unknownSources == TRUE})
    =>
    (add (new EvaluationResult "unknownSources" -10)))

(defrule potentially-harmful-apps-evaluation-F
    "Evaluate Security based on whether potentially harmful apps are present
        or not"
    (SecurityInfo {potentiallyHarmfulApplications == FALSE})
    =>
    (add (new EvaluationResult "potentiallyHarmfulApplications" 5)))

(defrule potentially-harmful-apps-evaluation-T
    "Evaluate Security based on whether potentially harmful apps are present
        or not"
    (SecurityInfo {potentiallyHarmfulApplications == TRUE})
    =>
    (add (new EvaluationResult "potentiallyHarmfulApplications" 0)))

(defrule developer-menu-evaluation-F
    "Evaluate Security based on whether developer menu is enabled or not"
    (SecurityInfo {developerMenu == FALSE})
    =>
    (add (new EvaluationResult "developerMenu" 1)))

(defrule developer-menu-evaluation-T
    "Evaluate Security based on whether developer menu is enabled or not"
    (SecurityInfo {developerMenu == TRUE})
    =>
    (add (new EvaluationResult "developerMenu" 0)))

(defrule bootloader-evaluation-U
    "Evaluate Security based on whether bootloader is unlocked or not"
    (BasicInfo {BOOTLOADER == "UNKNOWN"})
    =>
    (add (new EvaluationResult "BOOTLOADER" -2)))

(defrule bootloader-evaluation
    "Evaluate Security based on whether bootloader is unlocked or not"
    (BasicInfo {BOOTLOADER != "UNKNOWN"})
    =>
    (add (new EvaluationResult "BOOTLOADER" 5)))

(defrule basic-integrity-evaluation-T
    "EEvaluate Security based on whether basic integrity is valid or not"
    (SecurityInfo {basicIntegrityTest == TRUE})
    =>
    (add (new EvaluationResult "basicIntegrityTest" 10)))

(defrule basic-integrity-evaluation-F
    "EEvaluate Security based on whether basic integrity is valid or not"
    (SecurityInfo {basicIntegrityTest == FALSE})
    =>
    (add (new EvaluationResult "basicIntegrityTest" 0)))