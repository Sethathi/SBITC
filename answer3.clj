(ns answer3)
     
(defn savings-streak
  {:doc "Prints test case number (t) followed by start day to end day of highest average of days greater than M"}
  [t M savings]
  (def max-index 0)
  (def max-index-plus 0)
  (def max-value 0)
  (loop [l 0 s savings]
    (loop [i 0]
	    (comment println "avg of:" (take (+ M i) s) "=" (float (/ (reduce + (take (+ M i) s)) (+ M i))))
	    (when (<= max-value (float (/ (reduce + (take (+ M i) s)) (+ M i))))
	      (def max-index l)
	      (def max-index-plus i)
	      (def max-value (float (/ (reduce + (take (+ M i) s)) (+ M i)))))
	    (when (< (+ M i) (count s))
	      (recur (inc i))))
    (when (< M (count s))
      (recur (inc l) (rest s))))
  (str "Case #" t ": "
       ( + max-index 1) " " (str (+ max-index (+ M max-index-plus)) "\n")))

(def output "")
(def T (Integer/parseInt (read-line)))
(def T (cond (< T 1) 1
             (> T 10) 10
             :else T))

(doseq [t (range 1 (+ T 1))]
	(def MN (seq (.split #" " (read-line))))
	(def M (Integer/parseInt (second MN)))
	(def N (Integer/parseInt (first MN)))
	(def N (cond (< N 1) 1
	             (> N 1000) 1000
	             :else N))
	(def M (cond (< M 1) 1
	             (> M N) N
	             :else M))
  (def savings '())
  (doseq [n (range 1 (+ N 1))]
		(def s (Integer/parseInt (read-line)))
		(def s (cond (< s -10000) -10000
		             (> s 10000) 10000
		             :else s))
    (def savings (conj savings s)))
  (def output (str output (savings-streak t M (reverse savings)))))
(println output)