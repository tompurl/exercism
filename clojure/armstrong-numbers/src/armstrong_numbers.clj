(ns armstrong-numbers)
(defn digits [n]
  (loop [n n
         coll []]
    (cond
      (and (= n 0) (empty? coll)) [0]
      (= n 0) coll
      :else
      (recur
       (long (/ n 10))
       (cons (mod n 10) coll)))))

;; Also copied, but it was too nice to pass up. I feel a little guilty but I
;; figure this is better than importing a 3rd-party package.
;; https://stackoverflow.com/a/5058544
(defn exp [x n]
  (apply * (repeat n x)))

(defn armstrong? [num]
  (let [num-list (digits num)
        digit-count (count num-list)]
    (= num
       (apply + (map #(exp %1 digit-count) num-list)))))
