(ns minesweeper-clj.core-test
  (:require [clojure.test :refer :all]
            [minesweeper-clj.core :refer :all]))

;(deftest single-item
;  (testing "Single item"
;    (is (= ["0"] (get-mines ["."])))))
;
;(deftest single-mine
;  (testing "Single mine"
;    (is (= ["*"] (get-mines ["*"])))))

;(deftest two-cells
;  (testing "2 cells"
;    (is (= ["0" "0"] (get-mines ["." "."])))))


;(deftest test-two-rows
;  (testing "two rows"
;    (is (= 3 (count-pos [
;                          ["." "*" "*"]
;                          ["*" "." "."]] 1 1)))))

;(deftest test-around
;  (testing "test around "
;    (is (= 4 (count-pos [
;                         ["." "*" "*"]
;                         ["*" "." "*"]] 1 1)))))

;(deftest test-mine-in-the-middle
;  (testing "3 rows"
;    (is (= 6 (count-pos [
;                         ["." "*" "*"]
;                         ["*" "." "*"]
;                         ["*" "*" "."]] 1 1)))))
;
;(deftest test-dont-count-above
;(testing "dont count above"
;  (is (= 3 (count-pos [
;                       ["." "*" "*"]
;                       ["*" "." "*"]
;                       ["*" "*" "."]] 1 0)))))
;
;(deftest test-dont-count-below
;  (testing "dont count below"
;    (is (= 3 (count-pos [
;                         ["." "*" "*"]
;                         ["*" "." "*"]
;                         ["*" "." "."]] 1 2)))))

;(deftest test-dont-count-left
;(testing "left bounds"
;  (is (= 2 (count-pos [
;                       ["." "*" "*"]
;                       ["." "." "*"]
;                       ["*" "." "."]] 0 1)))))


(deftest test-count-row
  (testing "a row is summed"
    (is (= 1 (count-row ["." "*" "*"] 0)))
    (is (= 2 (count-row ["." "*" "*"] 1)))
    (is (= 2 (count-row ["." "*" "*"] 2)))
    ))


(deftest test-area-around-cell
  (testing "we get cells relevant"
    (is (= [0 1 2] (cropped-cells [0 1 2] 1)))
    (is (= [0 1] (cropped-cells [0 1 2] 0)))
    (is (= [1 2] (cropped-cells [0 1 2] 2)))))
