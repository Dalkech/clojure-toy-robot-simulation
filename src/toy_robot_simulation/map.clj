(ns toy-robot-simulation.map)

(defn- positionInMapBounds[x y] 
 (let [max 5 minExcluded -1] 
   (and (<= x max)
        (> x minExcluded)
        (<= y max)
        (> y minExcluded)
   )
  )
)

(defn- directionIsCorrect [direction]
  (contains? #{"NORTH" "WEST" "SOUTH" "EAST"} direction)
  )

(defn positionIsValid [x y direction] 
  (and (positionInMapBounds x y ) 
       (directionIsCorrect direction))
  )
