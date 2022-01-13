(ns isogram)

(defn pre-format [phrase]
  "Remove approved special charsr and make everything lcase"
  (-> phrase
      (clojure.string/replace #"[\s-]" "")
      clojure.string/lower-case))

(defn isogram? [phrase]
  (loop [phrase-seq (seq (pre-format phrase))
         found-chars []]
    (let [[first-char & rest] phrase-seq]
        (cond
          (nil? first-char) true
          (some #{first-char} found-chars) false
          :else
          (recur rest (cons first-char found-chars))))))
