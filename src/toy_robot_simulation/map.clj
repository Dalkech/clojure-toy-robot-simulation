(ns toy-robot-simulation.map 
  (:require [toy-robot-simulation.global-constant :refer [CARDINALS
                                                          DIRECTION_KEY
                                                          MAX_EXCLUDED
                                                          MIN_EXCLUDED X_KEY
                                                          Y_KEY]]))
(defn- position-in-bounds?[x y] 
   (and (< x MAX_EXCLUDED)
        (> x MIN_EXCLUDED)
        (< y MAX_EXCLUDED)
        (> y MIN_EXCLUDED)
   ))

(defn- direction-is-correct? [direction]
  (contains? CARDINALS direction))

(defn position-is-valid? [x y direction] 
  (and (position-in-bounds? x y ) 
       (direction-is-correct? direction)))

(defn coordinates-are-valid? [coordinates]
  (position-is-valid? (X_KEY coordinates) (Y_KEY coordinates) (DIRECTION_KEY coordinates) 
  ))
