(ns answer3)

(defn get-max-map-value [the-map]
  (def max-value 0)
  (doseq [i the-map]
    (when (< max-value (count (second i)))
      (def max-value (count (second i)))))
  max-value)

(defn savings-streak
  {:doc "Prints test case number (t) followed by number purchases strickly less than any previous purchases"}
  [t M savings]
  (def max-value 0)
  (loop [l 0 s savings]
    (println "avg of: " (take M s))
    (when (not (empty? s))
      (recur (inc l) (rest s))))
  (str "Case #" t ": " (get-max-map-value out-list) "\n"))

(def output "")
(def T 1)
(comment def T (Integer/parseInt (read-line)))
(comment def T (cond (< T 1) 1
             (> T 20) 20
             :else T))

(doseq [t (range 1 (+ T 1))]
	(def N 10)
	(def M 4)
	(comment def N (Integer/parseInt (read-line)))
	(comment def N (cond (< N 1) 1
	             (> N 1000) 1000
	             :else N))
  (def savings '(20 -50 10 11 10 2 10 9 11 1))
  (comment def savings '()) 
  (comment doseq [n (range 1 (+ N 1))]
		(def s (Integer/parseInt (read-line)))
		(def s (cond (< s 1) 1
		             (> s 10000) 10000
		             :else s))
    (def stocks (conj stocks s)))
  (def output (str output (savings-streak t M savings))))
(println output)