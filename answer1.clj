(ns answer1)

(defn prime?
  {:doc "Returns a number one greater than x"}
  [n]
  (let [r (int (Math/sqrt n))]
    (loop [d 2]
      (cond (= n 1) false
            (> d r) true
            (zero? (rem n d)) false
            :else (recur (inc d))))))

(defn prime-count
  {:doc "Prints test case number (t) followed by number of primes for n"}
  [t n]
  (def p 0)
  (doseq [i (range 1 (+ n 1))]
    (when (prime? i)
      (def p (inc p))))
  (str "Case #" t ": " p "\n"))


(def output "")
(def T (Integer/parseInt (read-line)))
(def T (cond (< T 1) 1
             (> T 20) 20
             :else T))
(doseq [t (range 1 (+ T 1))]
	(def N (Integer/parseInt (read-line)))
	(def N (cond (< N 1) 1
	             (> N 10000) 10000
	             :else N))
  (def output (str output (prime-count t N))))
(print output)