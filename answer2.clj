(ns answer1b)

(defn get-max-map-value [the-map]
  (def max-value 0)
  (doseq [i the-map]
    (when (< max-value (count (second i)))
      (def max-value (count (second i)))))
  max-value)

(defn less-than-purchases
  {:doc "Prints test case number (t) followed by number purchases strickly less than any previous purchases"}
  [t stocks]
  (def out-list {})
  (loop [l 0 a (first stocks) s (rest stocks)]
	  (loop [ll 0]
	    (when (< ll l)
        (when (< a (first (sort (out-list ll))))
          (def out-list (assoc out-list ll (conj (out-list ll) a))))
        (recur (inc ll))))
    (def out-list (assoc out-list l [a]))
    (when (not (empty? s))
      (recur (inc l) (first s) (rest s))))
  (str "Case #" t ": " (get-max-map-value out-list) "\n"))

(def output "")
(def T (Integer/parseInt (read-line)))
(def T (cond (< T 1) 1
             (> T 20) 20
             :else T))

(doseq [t (range 1 (+ T 1))]
	(def N (Integer/parseInt (read-line)))
	(def N (cond (< N 1) 1
	             (> N 1000) 1000
	             :else N))
  (def stocks '()) 
  (doseq [n (range 1 (+ N 1))]
		(def s (Integer/parseInt (read-line)))
		(def s (cond (< s 1) 1
		             (> s 10000) 10000
		             :else s))
    (def stocks (conj stocks s)))
  (def output (str output (less-than-purchases t (reverse stocks)))))
(println output)