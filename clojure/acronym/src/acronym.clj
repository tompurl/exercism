(ns acronym
  (:require [clojure.string :as str]))


(defn split-camel-case [my-str]
  (str/replace my-str #"([a-z])([A-Z])" "$1 $2"))

(defn split-kebab-case [my-str]
  (str/replace my-str #"-" " "))

(defn fancy-split-str [my-str]
  "Split a string based on spaces, camel and kebab case"
  (-> my-str
      split-camel-case
      split-kebab-case
      (str/split #" ")))

(defn acronym [long-ass-title]
  (str/join
   (map #(.toUpperCase (str (first %)))
        (fancy-split-str long-ass-title))))
