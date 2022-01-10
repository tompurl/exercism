(ns say)

(def num-map
  [{:num 0 :word "zero"}
   {:num 1 :word "one"}
   {:num 2 :word "two"}
   {:num 3 :word "three"}
   {:num 4 :word "four"}
   {:num 5 :word "five"}
   {:num 6 :word "six"}
   {:num 7 :word "seven"}
   {:num 8 :word "eight"}
   {:num 9 :word "nine"}
   {:num 10 :word "ten"}
   {:num 11 :word "eleven"}
   {:num 12 :word "twelve"}
   {:num 13 :word "thirteen"}
   {:num 14 :word "fourteen"}
   {:num 15 :word "fifteen"}
   {:num 16 :word "sixteen"}
   {:num 17 :word "seventeen"}
   {:num 18 :word "eighteen"}
   {:num 19 :word "nineteen"}
   {:num 20 :word "twenty"}
   {:num 30 :word "thirty"}
   {:num 40 :word "forty"}
   {:num 50 :word "fifty"}
   {:num 60 :word "sixty"}
   {:num 70 :word "seventy"}
   {:num 80 :word "eighty"}
   {:num 90 :word "ninety"}
   {:num 100 :word "hundred"}])

(defn split-num [num]
  (loop [num num
         div 100
         coll []]
    (cond
      (= 0 num) coll
      :else
      (let [lmost-digit (int (/ num div))]
        (recur
         (- num (* lmost-digit div))
         (/ div 10)
         (conj coll lmost-digit)
         )))))

(defn get-multiplier-of-ten [num]
  (int (/ num 10)))

(defn get-word [num]
  (:word (first(filter #(= (:num %) num) num-map))))

(defn number [num]
  (cond
    (> num 20) (let [multiplier-of-ten (* (get-multiplier-of-ten num) 10)
                     remainder (- num multiplier-of-ten)]
                 (apply str [(get-word multiplier-of-ten) "-" (get-word remainder)]))
    :else
    (get-word num)))
