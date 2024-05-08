(ns toy-robot-simulation.commande-manager
  (:require [clojure.string :as str]))

(defn parse [command]
  (if (str/blank? command)
    (throw (Exception. (str "wrong command : " command)))
    ())

  (let [splitted-command (str/split command #" ")]
      (if (contains? #{"PLACE", "MOVE", "LEFT", "RIGHT", "REPORT"} (first splitted-command))

       (if (and (= "PLACE" (first splitted-command)) (<= 4 (count splitted-command)))
         {
          :x (Integer/parseInt (get splitted-command 1)) 
          :y (Integer/parseInt (get splitted-command 2)) 
          :direction (get splitted-command 3)
          }
         (throw (Exception. (str "wrong command : " command))))
         
       (throw (Exception. (str "wrong command : " command)))))
 )