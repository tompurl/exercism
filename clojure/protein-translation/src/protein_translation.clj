(ns protein-translation)

(def codon-protein-map
  [{:codon "AUG" :protein "Methionine"}
   {:codon "UUU" :protein "Phenylalanine"}
   {:codon "UUC" :protein "Phenylalanine"}
   {:codon "UUA" :protein "Leucine"}
   {:codon "UUG" :protein "Leucine"}
   {:codon "UCU" :protein "Serine"}
   {:codon "UCC" :protein "Serine"}
   {:codon "UCA" :protein "Serine"}
   {:codon "UCG" :protein "Serine"}
   {:codon "UAU" :protein "Tyrosine"}
   {:codon "UAC" :protein "Tyrosine"}
   {:codon "UGU" :protein "Cysteine"}
   {:codon "UGC" :protein "Cysteine"}
   {:codon "UGG" :protein "Tryptophan"}
   {:codon "UAA" :protein "STOP"}
   {:codon "UAG" :protein "STOP"}
   {:codon "UGA" :protein "STOP"}])

(defn first-three-as-str [rna-string]
  (apply str (take 3 rna-string)))

(defn remaining-as-str [rna-string]
  (apply str (drop 3 rna-string)))

(defn translate-codon [codon-str]
  (:protein (first (filter #(= codon-str (:codon %1)) codon-protein-map))))

(defn translate-rna [rna-string]
  (loop [rna-string rna-string
         acc []]
    (cond
      (= (last acc) "STOP") (take (- (count acc) 1) acc)
      (empty? rna-string) acc
      :else (recur
             (remaining-as-str rna-string)
             (conj acc (translate-codon (first-three-as-str rna-string)))))))
