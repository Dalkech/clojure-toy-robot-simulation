(ns toy-robot-simulation.commands.place
  (:require [toy-robot-simulation.global-constant :refer [DIRECTION_KEY X_KEY
                                                          Y_KEY]]
            [toy-robot-simulation.map :refer [positionIsValid]]))

(defn execute [x y direction toy-robot-coordonate]
  (let [intx (Integer. x)
        inty (Integer. y)]
    (when
     (and (empty? toy-robot-coordonate)
          (positionIsValid intx inty direction))
      { X_KEY intx Y_KEY inty DIRECTION_KEY direction }))
  )


