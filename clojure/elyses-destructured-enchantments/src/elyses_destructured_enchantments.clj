(ns elyses-destructured-enchantments)

(defn first-card
  "Returns the first card from deck."
  [deck]
  (let [[card-one] deck]
    card-one))

(defn second-card
  "Returns the second card from deck."
  [deck]
  (let [[_ card-two] deck]
    card-two))

(defn swap-top-two-cards
  "Returns the deck with first two items reversed."
  [deck]
  (let [[card-one card-two & remaining] deck]
    (concat [(second-card deck) (first-card deck)] remaining)))

(defn discard-top-card
  "Returns a vector containing the first card and
   a vector of the remaining cards in the deck."
  [deck]
  (let [[card-one & remaining] deck]
    [card-one remaining]))

(def face-cards
  ["jack" "queen" "king"])

(defn insert-face-cards
  "Returns the deck with face cards between its head and tail."
  [deck]
  (let [[card-one & remaining] deck]
    (concat card-one face-cards remaining)
    )
  )
