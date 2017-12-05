(ns a1.core)

(def input (clojure.string/split
            (clojure.string/trim-newline (slurp "input.txt"))
            #""))

(defn sum-numbers
  ""
  [x seq sum]
  (if (empty? seq)
    sum
    (if (= x (first seq))
      (sum-numbers x (rest seq) (+ (Integer/parseInt x) sum))
      (sum-numbers (first seq) (rest seq) sum))))

(defn sum-numbers-cycle
  ""
  [x remain seq offset sum]
  (if (empty? remain)
    (if (= x (nth (cycle seq) offset))
      (+ (Integer/parseInt x) sum)
      sum)
    (if (= x (nth (cycle seq) offset))
      (sum-numbers-cycle (first remain) (rest remain) seq (+ offset 1) (+ (Integer/parseInt x) sum))
      (sum-numbers-cycle (first remain) (rest remain) seq (+ offset 1) sum))))

(defn solution
  [x]
  (if (= (first x) (last x))
    (sum-numbers (first x) (rest x) (Integer/parseInt (first x)))
    (sum-numbers (first x) (rest x) 0)))
