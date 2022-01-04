(ns cars-assemble)

(defn production-rate
  "Returns the assembly line's production rate per hour,
   taking into account its success rate"
  [speed]
  (let [raw-speed (* speed 221.0)]
      (cond
        (< speed 5) raw-speed
        (< speed 9) (* 0.9 raw-speed)
        (= speed 9) (* 0.8 raw-speed)
        (= speed 10) (* 0.77 raw-speed)
        )))

(defn working-items
  "Calculates how many working cars are produced per minute"
  [speed]
  (-> speed
      production-rate
      (/ 60)
      int))
