(ns log-levels
  (:require [clojure.string :as str]))

(defn tokenize
  "Split the log messages into components we care about"
  [s]
  (map #(.trim %) (str/split s #":")))

(defn message
  "Takes a string representing a log line
   and returns its message with whitespace trimmed."
  [s]
  (last (tokenize s)))

(defn log-level
  "Takes a string representing a log line
   and returns its level in lower-case."
  [s]
  (->> s
      tokenize
      first
      (re-seq #"\[(.*)\]")
      first
      last
      str/lower-case))

(defn reformat
  "Takes a string representing a log line and formats it
   with the message first and the log level in parentheses."
  [s]
  (str (message s) " (" (log-level s) ")"))
