(ns pangram
    (:require [clojure.string :as str]))

(def pattern
  #"[\W_0-9]")

(defn pangram? [word]
  (= (seq "abcdefghijklmnopqrstuvwxyz")
     (-> word
          str/lower-case
          (str/replace pattern "")
          sort
          distinct)))
