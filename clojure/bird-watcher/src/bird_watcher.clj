(ns bird-watcher)

(def last-week
  [0 2 5 3 7 8 4])

(defn today [birds]
  (last birds))

(defn inc-bird [birds]
  (assoc birds
         6
         (+ (today birds) 1)))

(def any? (complement not-any?))

(defn day-without-birds? [birds]
   (any? #(= 0 %) birds))

(defn n-days-count [birds n]
  (apply + (take n birds)))

(defn busy-days [birds]
  (count (filter #(> % 4) birds)))

(defn odd-week? [birds]
  (or
   (= birds [1 0 1 0 1 0 1])
   (= birds [0 1 0 1 0 1 0])))
