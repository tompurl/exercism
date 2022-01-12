(ns say)

(def single-digits
  [{:num 0 :word "zero"}
   {:num 1 :word "one"}
   {:num 2 :word "two"}
   {:num 3 :word "three"}
   {:num 4 :word "four"}
   {:num 5 :word "five"}
   {:num 6 :word "six"}
   {:num 7 :word "seven"}
   {:num 8 :word "eight"}
   {:num 9 :word "nine"}])

(def teens
  [{:num 10 :word "ten"}
   {:num 11 :word "eleven"}
   {:num 12 :word "twelve"}
   {:num 13 :word "thirteen"}
   {:num 14 :word "fourteen"}
   {:num 15 :word "fifteen"}
   {:num 16 :word "sixteen"}
   {:num 17 :word "seventeen"}
   {:num 18 :word "eighteen"}
   {:num 19 :word "nineteen"}])

(def multiples-of-ten
  [{:num 20 :word "twenty"}
   {:num 30 :word "thirty"}
   {:num 40 :word "forty"}
   {:num 50 :word "fifty"}
   {:num 60 :word "sixty"}
   {:num 70 :word "seventy"}
   {:num 80 :word "eighty"}
   {:num 90 :word "ninety"}
   {:num 100 :word "hundred"}
   {:num 1000 :word "thousand"}
   {:num 1000000 :word "million"}
   {:num 1000000000 :word "billion"}])

(defn get-word [num num-map]
  (:word (first(filter #(= (:num %) num) num-map))))

(defn get-one-or-two-digit-number [num]
  (let [tens-num (* (int (/ num 10)) 10)
        remainder (mod num 10)]
    (cond
      (= tens-num 0) (get-word num single-digits) ;; < 10
      (< tens-num 20) (get-word num teens) ;; < 20
      :else
      (if
          (> remainder 0) (apply str [(get-word tens-num multiples-of-ten) "-" (get-word remainder single-digits)])
          (get-word tens-num multiples-of-ten)))))

(defn get-three-digit-number [num]
  (let [hundred-phrase (apply str [(get-word (int (/ num 100)) single-digits) " hundred"])
        remainder (mod num 100)]
    (if
        (> remainder 0) (apply str [hundred-phrase " " (get-one-or-two-digit-number remainder)])
        hundred-phrase)))

(defn get-small-number [num]
  "Return the string value of a number less than 1000"
  (if (and (>= num 0) (< num 100))
    (get-one-or-two-digit-number num)
    (get-three-digit-number num)))

(defn number [num]
  ;;; TODO Only works for numbers < 1000000
  (loop [num num
         multiplier 1
         phrase ""]
    (cond
      (and (>= num 0) (< num 1000)) (clojure.string/trim (apply str
                                                                [(get-small-number num)
                                                                 " "
                                                                 (get-word multiplier multiples-of-ten)
                                                                 " "
                                                                 phrase]))
      :else
      (recur
       (int (/ num 1000))
       (* 1000 multiplier)
       (if (= (mod num 1000) 0)
         (apply str [phrase (get-word multiplier multiples-of-ten)])
         (apply str [phrase (get-small-number (mod num 1000)) " " (get-word multiplier multiples-of-ten)])))
      )
    )
  )

;; num     multiplier    phrase
;; ------- ------------- -----------
;; 1000000 1             ""
;; 1000    1000
;;
