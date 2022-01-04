(ns interest-is-interesting)

(defn interest-rate
  "Calculate the interest rate based upon the account balance"
  [balance]
  (cond
    (< balance 0) -3.213
    (and (>= balance 0) (< balance 1000)) 0.5
    (< balance 5000) 1.621
    :else 2.475))

(defn interest-rate-to-int
  "Generate int value of interest rate to make calculations more accurate.
  Or in other words, remove all of the numbers after the decimal."
  [interest-rate factor]
  (int (* interest-rate factor)))

(defn annual-interest
  "Calculate the annual interest amount. Use factors to remove and then add
  floating point values for accuracy."
  [balance]
  (let [mult-factor 1000
        div-factor (* 100 mult-factor)
        pos-or-negative-multiplier (if (< balance 0) -1 1)]
    (-> balance
        interest-rate
        (interest-rate-to-int mult-factor)
        (* balance)
        (* pos-or-negative-multiplier)
        (/ div-factor))))

(defn annual-balance-update
  "Calculate the new balance based on the year-end balance plus interest"
  [balance]
  (+ (annual-interest balance) balance))

(defn amount-to-donate
  "Multiply your balance time the tax free percentage and multiply by 2"
  [balance tax-free-percentage]
  (if (> balance 0)
    (-> balance
        (* tax-free-percentage)
        (/ 100)
        (* 2)
        int)
    0))
