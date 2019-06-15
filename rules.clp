;; First define templates for the model classes so we can use them
;; in our expert system. This doesn't create any model objects --
;; it just tells Jess to examine the classes and set up templates
;; using their properties

(import application.model.*)
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

(defrule android-version-evaluation
    "Evaluate Security based on Android Version of the app"
    ?basicInfo <- (BasicInfo {versionRELEASE > 8})
    =>
    (printout t "Latest Version !" crlf))

