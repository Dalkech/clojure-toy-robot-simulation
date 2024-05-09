(ns toy-robot-simulation.map 
  (:require [toy-robot-simulation.global-constant :refer [CARDINALS
                                                          MAX_EXCLUDED
                                                          MIN_EXCLUDED]]))

(defn- positionInMapBounds[x y] 
   (and (< x MAX_EXCLUDED)
        (> x MIN_EXCLUDED)
        (< y MAX_EXCLUDED)
        (> y MIN_EXCLUDED)
   )
)

(defn- directionIsCorrect [direction]
  (contains? CARDINALS direction)
  )

(defn positionIsValid [x y direction] 
  (and (positionInMapBounds x y ) 
       (directionIsCorrect direction))
  )
