(ns minesweeper-clj.core
  (:gen-class))

(defn count-mine [cell]
  (if (= cell "*")
    1
    0))


(defn count-around-cell [row range]
  (count (filter (fn [i] (= (nth row i) "*")) range)))

(defn cropped-cells [row x]
  (filter
    (fn [i]
      (and (> i -1)
           (< i (count row)))
      )
    (range (- x 1) (+ x 2))))

(defn count-row [row x]
  (count-around-cell row (cropped-cells row x)))



(defn row-above [rows y]
  (if (> y 0)
    (nth rows (- y 1)) []))

(defn row-below [rows y]
  (if (< y (- (count rows) 1))
    (nth rows (+ y 1)) []))

(defn cell-left [row x]
  (if (> x 0)
    (nth row (- x 1)) 0))

(defn count-pos [rows x y]
  (+ (count-row (row-above rows y) x)
     (count-mine (cell-left (nth rows y) x))
     (count-mine (nth (nth rows y) (+ x 1)))
     (count-row (row-below rows y) x)
     ))



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
