(ns rera.core
  (:require [reagent.core :as reagent]
            [cljsjs.radium]))

(enable-console-print!)

(def Radium js/Radium)

(def styles {:base {:color "#fff"
                    ":hover" {:background "#0A8DFF"}}
             :primary {:background "#0074D9"}
             :warning {:background "#FF4136"}})

(defn button
  [data]
  (let [kind (keyword (:kind data))]
    [:button
     {:style (clj->js [(:base styles)
                       (kind styles)])}
     (:children data)]))

(def btn (Radium. (reagent/reactify-component button)))

(def rbtn (reagent/adapt-react-class btn))

(defn hello-world
  []
  [:div
   [rbtn {:kind :primary} "Hello Primary"]
   [rbtn {:kind :warning} "Hello Warning"]])

(reagent/render-component
 [hello-world]
 (. js/document (getElementById "app")))


(defn on-js-reload
  []
  )
