(ns toy-robot-simulation.commands.place
  (:require [toy-robot-simulation.map :refer [positionIsValid]] ))

(defn execute [x y direction toy-robot-coordonate]
  (let [intx (Integer. x)
        inty (Integer. y)]

    (when
     (and (= {} toy-robot-coordonate)
          (positionIsValid intx inty direction))
      {:x intx
       :y inty
       :direction direction}))
  )


