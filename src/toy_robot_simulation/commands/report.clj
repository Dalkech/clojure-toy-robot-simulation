(ns toy-robot-simulation.commands.report
  (:require [toy-robot-simulation.global-constant :refer [DIRECTION_KEY X_KEY
                                                          Y_KEY]]))

(defn execute [coordinates]
  (when (seq coordinates)
    (str (X_KEY coordinates) 
         \space (Y_KEY coordinates) 
         \space (DIRECTION_KEY coordinates))))

