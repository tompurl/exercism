(ns accumulate)

(defn accumulate [fn coll]
  (if (empty? coll)
    '()
    (cons (fn (first coll)) (accumulate fn (rest coll)))))
