(ns minesweeper-clj.core-test
  (:require [clojure.test :refer :all]
            [minesweeper-clj.core :refer :all]))

(deftest single-item
  (testing "Single item"
    (is (= ["0"] (get-mines ["."])))))

(deftest single-mine
  (testing "Single mine"
    (is (= ["*"] (get-mines ["*"])))))

;(deftest two-cells
;  (testing "2 cells"
;    (is (= "*" (get-mines ["*" "."])))))


