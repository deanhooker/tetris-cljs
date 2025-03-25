(ns tetris
  (:require
   [board :as b]
   [reagent.core :as r]
   [reagent.dom :as rd]))

(defn cell->html
  [cell]
  [:span {:display "inline-block"
          :width "100px"
          :height "100px"
          :background-color "red"} cell])

(defn row->html
  [row]
  (vec (cons :div
             (map cell->html row))))

(defn render-board
  [board]
  (->> board
       (map row->html)
       (cons :div)
       (into [])))

(defn ^:dev/after-load init []
  (rd/render
   (render-board b/empty-board)
   (.-body js/document)))
