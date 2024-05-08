(ns toy-robot-simulation.map)

(defn positionIsValid [x y] 
  (and (<= x 5)
       (> x -1)
       (<= y 5)
       (> y -1))
  )