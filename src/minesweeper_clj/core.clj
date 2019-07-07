(ns minesweeper-clj.core
  (:gen-class))



(defn count-mine [cell]
  (if (= cell "*")
    1
    0))



(defn add-up [left right] (+ left (count-mine right)))

(defn count-row [row]
  (reduce (fn [left right] (add-up left right)) 0 row)
  )






(defn get-mines [grid]
  [(count-mine (nth grid 0))]
  )




;(defn count-mines [grid]
;  (def list (loop [i 0]
;    (when (< i (count grid))
;      (count-mine grid i)
;    (recur (+ i 1)))
;  ))
;  (println "list is " (count list))
;  )
