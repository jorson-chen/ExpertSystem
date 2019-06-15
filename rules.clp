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
    ?o <- (Order {total > 100})
    =>
    (add (new Offer "10% volume discount" (/ ?o.total 10))))

(defrule screen-lock-evaluation
    "Evaluate Security based on whether screen lock is active or not"
    (OrderItem {quantity >= 3} (price ?price))
    =>
    (add (new Offer "25% multi-item discount" (/ ?price 4))))

(defrule unknown-sources-evaluation
    "Evaluate Security based on whether installation from unknown sources is
    allowed or not"
    (CatalogItem (partNumber ?partNumber) (description /CD Writer/))
    (CatalogItem (partNumber 782321) (price ?price))
    (OrderItem (partNumber ?partNumber))
    (Customer {orderCount > 1})
    =>
    (add (new Offer "Free CD-RW disks" ?price)))

(defrule potentially-harmful-apps-evaluation
    "Evaluate Security based on whether potentially harmful apps are present
    or not"
    (OrderItem {quantity >= 3} (price ?price))
    =>
    (add (new Offer "25% multi-item discount" (/ ?price 4))))

(defrule developer-menu-evaluation
    "Evaluate Security based on whether developer menu is enabled or not"
    (OrderItem {quantity >= 3} (price ?price))
    =>
    (add (new Offer "25% multi-item discount" (/ ?price 4))))

(defrule app-with-dangerous-permissions-evaluation
    "Evaluate Security based on how many apps with dangerous permissions are
    present"
    (OrderItem {quantity >= 3} (price ?price))
    =>
    (add (new Offer "25% multi-item discount" (/ ?price 4))))

(defrule bootloader-evaluation
    "Evaluate Security based on whether bootloader is unlocked or not"
    (OrderItem {quantity >= 3} (price ?price))
    =>
    (add (new Offer "25% multi-item discount" (/ ?price 4))))

(defrule basic-integrity-evaluation
    "Evaluate Security based on basic integrity of android device"
    (OrderItem {quantity >= 3} (price ?price))
    =>
    (add (new Offer "25% multi-item discount" (/ ?price 4))))