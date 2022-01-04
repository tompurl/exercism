(ns tracks-on-tracks-on-tracks)

(defn new-list
  "Creates an empty list of languages to practice."
  []
  '())

(defn add-language
  "Adds a language to the list."
  [lang lang-list]
  (conj lang-list lang))

(defn first-language
  "Returns the first language on the list."
  [lang-list]
  (first lang-list))

(defn remove-language
  "Removes the the first language added to the list."
  [lang-list]
  (rest lang-list))

(defn count-languages
  "Returns the total number of languages on the list."
  [lang-list]
  (count lang-list))

(defn learning-list
  "Creates an empty list, adds Clojure and Lisp, removes Lisp, adds
  Java and JavaScript, then finally returns a count of the total number
  of languages."
  []
  (count-languages
   (->> (remove-language
         (->> (new-list)
              (add-language "Clojure")
              (add-language "Lisp")))
        (add-language "Java")
        (add-language "JavaScript"))))

(defn learning-list-threaded
  []
  (count-languages
   (add-language "JavaScript"
                 (add-language "Java"
                               (remove-language
                                (add-language "Lisp"
                                              (add-language "Clojure" (new-list))))))))

(defn learning-list-two
  "Creates an empty list, adds Clojure and Lisp, removes Lisp, adds
  Java and JavaScript, then finally returns a count of the total number
  of languages."
  []
  (->> (new-list)
       (add-language "Clojure")
       (add-language "Lisp")
       remove-language
       (add-language "Java")
       (add-language "JavaScript")
       count-languages))

(defn learning-list-two-threaded
  []
  (count-languages
   (add-language "JavaScript"
                 (add-language "Java"
                               (remove-language
                                (add-language "Lisp"
                                              (add-language "Clojure" (new-list))))))))
