(ns toy-robot-simulation.map 
  (:require [toy-robot-simulation.global-constant :refer [CARDINALS
                                                          DIRECTION_KEY
                                                          MAX_EXCLUDED
                                                          MIN_EXCLUDED X_KEY
                                                          Y_KEY]]))

(defn- positionInMapBounds?[x y] 
   (and (< x MAX_EXCLUDED)
        (> x MIN_EXCLUDED)
        (< y MAX_EXCLUDED)
        (> y MIN_EXCLUDED)
   )
)

(defn- directionIsCorrect? [direction]
  (contains? CARDINALS direction)
  )

(defn positionIsValid? [x y direction] 
  (and (positionInMapBounds? x y ) 
       (directionIsCorrect? direction))
  )

(defn coordinatesAreValid? [coordinates]
  (positionIsValid? (X_KEY coordinates) (Y_KEY coordinates) (DIRECTION_KEY coordinates) 
  )
)