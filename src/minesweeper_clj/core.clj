(ns minesweeper-clj.core
  (:gen-class))

(defn get-mines [grid]
  (if (= (nth grid 0) "*")
    "*"
    "0"))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
