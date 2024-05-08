(ns toy-robot-simulation.commands.place
  (:require [toy-robot-simulation.map :refer [positionIsValid]])
  )

(defn execute [x y direction] 
  (let [intx (Integer. x)
        inty (Integer. y)] 
    
    (if (positionIsValid intx inty direction)
       {
        :x intx
        :y inty
        :direction direction
        }
      nil
      )
    )
  )
