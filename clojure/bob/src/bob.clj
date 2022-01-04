(ns bob
  (:require [clojure.string :refer [trim]]))

(defn is-shouting? [s]
  (and
   (not-any? #(Character/isLowerCase %) s)
   (some #(Character/isLetter %) s)))

(defn is-shouting-command? [s]
  (and
   (is-shouting? s)
   (not (= (last s ) \?))))

(defn is-polite-question? [s]
  (and
   (not (is-shouting? s))
   (= (last s) \?)))

(defn is-silent? [s]
  (every? #(Character/isWhitespace %) s))

(defn is-forceful-question? [s]
  (and
   (is-shouting? s)
   (= (last s) \?)))

(defn response-for [s]
  (def trim-string (trim s))
  (cond
    (is-shouting-command? trim-string) "Whoa, chill out!"
    (is-polite-question? trim-string) "Sure."
    (is-silent? trim-string) "Fine. Be that way!"
    (is-forceful-question? trim-string) "Calm down, I know what I'm doing!"
    :else "Whatever."))

(defn test-one [my-vector]
  (count (filter #(even? %) my-vector)))

(defn test-two [my-vector]
  (->> my-vector
      (filter #(even? %))
      (count)))
