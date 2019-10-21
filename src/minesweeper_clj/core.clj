(ns minesweeper-clj.core
  (:gen-class))

(defn cropped-cells [row x]
  (->> (range (- x 1) ( + x 2))
       (filter #(and (> % -1) (< % (count row))))))

(defn count-around-cell [row range]
  (count (filter #(= (nth row %) "*") range)))

(defn count-row [row x]
  (count-around-cell row (cropped-cells row x)))

(defn row-below [rows y]
  (if (< y (- (count rows) 1))
    (nth rows (+ y 1)) []))

(defn row-above [rows y]
  (if (> y 0)
    (nth rows (- y 1)) []))

(defn sum-all-rows [rows x y]
  (+ (count-row (row-above rows y) x)
     (count-row (nth rows y) x)
     (count-row (row-below rows y) x)))

(defn count-pos [rows x y]
  (let [mine-present (if (= "*" (nth (nth rows y) x)) 1 0)]
    (- (sum-all-rows rows x y) mine-present)
    ))

(defn count-each-cell [rows row y]
  (->> (range 0 (count row))
       (map #(if (= "*" (nth row %))
               "*"
               (str (count-pos rows % y))))))

(defn get-mines [rows]
  (->> (range 0 (count rows))
       (map #(count-each-cell rows (nth rows %) %))))
