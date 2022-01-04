(ns anagram
  (:require [clojure.string :as str]))


(defn is-anagram? [word-1 word-2]
  "Case-sensitive comparison of two words to see if they contain the same letters"
  (and
   (not (= word-1 word-2))
   (= (sort word-1) (sort word-2))))

(defn anagrams-for [word prospect-list]
  (let [l-word (str/lower-case word)]
    (filter #(is-anagram? l-word (str/lower-case %)) prospect-list)))
