(ns answer1a)

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
  (println (str "Case #" t ": " p)))

(doseq [t (range 1 (+ (Integer/parseInt (read-line)) 1))]
  (prime-count t (Integer/parseInt (read-line))))