(ns pig-latin
  (:require [clojure.string :as str]))

(def vowel-pattern #"^([aeiou]{1}|yt|xr).*$")
(def consonant-pattern #"^(ch|squ|qu|thr|th|sch|[bcdfghjklmnpqrstvwxyz]{1}).*$")

(defn remove-prefix [word prefix]
  (.substring word (count prefix) (count word)))

(defn translate-word [word]
  (cond
    (re-matches vowel-pattern word) (str/join [word "ay"])
    :else
    (let [prefix (last (re-matches consonant-pattern word))]
      (str/join
       [(remove-prefix word prefix) prefix "ay"]))))

(defn translate [phrase]
  (str/join " " (map translate-word (str/split phrase #" "))))
