(ns toy-robot-simulation.commands.place
  (:require [toy-robot-simulation.global-constant :refer [DIRECTION_KEY X_KEY
                                                          Y_KEY]]
            [toy-robot-simulation.map :refer [position-is-valid?]]))

(defn execute [x y direction coordinates]
  (let [intx (Integer. x)
        inty (Integer. y)]
    (when
     (and (empty? coordinates)
          (position-is-valid? intx inty direction))
      { X_KEY intx Y_KEY inty DIRECTION_KEY direction }))
  )